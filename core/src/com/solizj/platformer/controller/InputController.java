package com.solizj.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
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
        Gdx.input.setInputProcessor(createInputAdapter());
    }

    public static void draw(Batch spriteBatch){
        spriteBatch.begin();
        left.draw(spriteBatch);
        spriteBatch.end();
    }

    // return an input adapter so lib.gdx can use it to register input
    private static InputAdapter createInputAdapter(){ //Anonymous classes enable you to make your code more concise. They enable you to declare and instantiate a class at the same time. They are like local classes except that they do not have a name. Use them if you need to use a local class only once.
        return new InputAdapter(){
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                System.out.println("Touch Down");
                return true;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                System.out.println("Touch Up");
                return true;
            }
        };
    }
}
