package com.solizj.platformer.model;
/**
 * To create input controls
 */
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.solizj.platformer.controller.LevelController;

public class InputControl {

    public String action;
    public Vector2 position;


    private TextureRegion textureRegion;
    private float width;
    private float heigth;

    public  InputControl(Vector2 position, TextureRegion textureRegion, String action){
        this.textureRegion = textureRegion;
        this.position = position;
        this.action = action;

        width = textureRegion.getRegionWidth();
        heigth = textureRegion.getRegionHeight();

    }
    public void draw(Batch spriteBatch){
        spriteBatch.draw(textureRegion, position.x, position.y, width * LevelController.UNIT_SCALE, heigth* LevelController.UNIT_SCALE);
    }


}
