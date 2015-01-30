package com.solizj.platformer.model;
/**
 * To create input controls
 */
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.solizj.platformer.controller.CameraController;
import com.solizj.platformer.controller.LevelController;

import javax.management.relation.RoleUnresolvedList;

public class InputControl {

    public String action;
    public Vector2 position;


    private TextureRegion textureRegion;
    private float width;
    private float height;

    public  InputControl(Vector2 position, TextureRegion textureRegion, String action){
        this.textureRegion = textureRegion;
        this.position = position;
        this.action = action;

        width = textureRegion.getRegionWidth();
        height = textureRegion.getRegionHeight();

    }
    public void draw(Batch spriteBatch){
        spriteBatch.draw(textureRegion, position.x, position.y, width * LevelController.UNIT_SCALE, height* LevelController.UNIT_SCALE);
    }

    // [53] rectangle for button on screen
    public Rectangle getBoundingBox(){
        return new Rectangle(position.x / LevelController.UNIT_SCALE* CameraController.widthScale,
                position.y / LevelController.UNIT_SCALE*CameraController.heightScale,
                width * CameraController.widthScale,
                height * CameraController.heightScale);


    }
}
