package com.solizj.platformer.model;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.solizj.platformer.controller.LevelController;

import java.util.HashMap;

public class Sprite { // [33]
    public Body physicsBody;// [35]
    public Vector2 position;
    public SpriteSheet spriteSheet;
    public float width;
    public float height;
    public String currentAnimation;
    private float stateTime;
    protected HashMap<String,Animation> animations;

    public Sprite(Vector2 position, int width, int height){
        this.position = position;
        this.width = width * LevelController.UNIT_SCALE;
        this.height = height * LevelController.UNIT_SCALE;
        spriteSheet = new SpriteSheet("img/aliens.png", width, height);
        animations = new HashMap<String, Animation>();
        stateTime = 0f;
    }

    public void draw(Batch spriteBatch){
        spriteBatch.draw(animations.get(currentAnimation).getKeyFrame(stateTime, true), position.x, position.y, width, height); // Unit Scale is 70 pixels per game unit
    }

    public void update(float deltaTime){
        stateTime += deltaTime;
    }
}
