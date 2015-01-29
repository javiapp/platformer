package com.solizj.platformer.controller;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.solizj.platformer.model.InputControl;
import com.solizj.platformer.model.SpriteSheet;

/**
 * [46]  Organize all input controls we make and handle user input
 */
public class InputController {
    private static SpriteSheet spriteSheet;
    private static InputControl left;

    public static void initializeControler(){
        spriteSheet = new SpriteSheet("img/touch-controls.png",80,80);
        left = new InputControl(new Vector2(0,0), spriteSheet.spriteFrames[0],"left");
    }
    public static void draw(Batch spriteBatch){
        spriteBatch.begin();
        left.draw(spriteBatch);
        spriteBatch.end();
    }
}
