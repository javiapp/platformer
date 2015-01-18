package com.solizj.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Player {
    public Vector2 position;
    public Animation animation;
    public SpriteSheet spriteSheet;
    private float stateTime;

    public Player() {
        position = new Vector2(2,1);
        spriteSheet = new SpriteSheet();
        animation = spriteSheet.createAnimation();
        stateTime = 0f;

    }



    public void draw(Batch spriteBatch){
        spriteBatch.draw(animation.getKeyFrame(stateTime,true), position.x, position.y, 70*(1/70f), 100*(1/70f));

    }

    public void update(float deltaTime){
        position.x += deltaTime;
        stateTime += deltaTime;
    }
}
