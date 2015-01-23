package com.solizj.platformer.controller;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.solizj.platformer.model.Level;
import com.solizj.platformer.model.Player;
import com.solizj.platformer.model.Sprite;

public class LevelController {
    public static final float UNIT_SCALE = 1/70f;

    public static Level level;
    public static OrthogonalTiledMapRenderer renderer;
    public static Batch spriteBatch;

    public static World gameWorld; // static because want only 1 instance
    private static Array<Body> worldBodies;

    private static  Box2DDebugRenderer debugRenderer;


    public static void initializeController(){
        level = new Level("map/level01.tmx");
        renderer = new OrthogonalTiledMapRenderer(level.map,UNIT_SCALE);
        gameWorld = new World(new Vector2(0,-10), true);
        worldBodies = new Array<Body>();
        debugRenderer = new Box2DDebugRenderer();

        spriteBatch = renderer.getSpriteBatch();

    }


    public static void draw(){
        spriteBatch.begin();
        PlayerController.draw(spriteBatch);
        spriteBatch.end();
        debugRenderer.render(gameWorld,CameraController.camera.combined);
    }


    public static void update(float deltaTime){
        renderer.setView(CameraController.camera);
        renderer.render();
        PlayerController.update(deltaTime);
        updateWorldBodies();
        gameWorld.step(1/60f, 1, 1);
    }

    private static void updateWorldBodies(){
        worldBodies.clear();
        gameWorld.getBodies(worldBodies);

        for(Body body : worldBodies){
            Sprite spriteBody = (Sprite)body.getUserData();
            spriteBody.position = body.getPosition();
        }
    }
}
