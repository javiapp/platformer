package com.solizj.platformer.model;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpriteSheet {
    public Texture spriteSheet;
    public TextureRegion[] spriteFrames;
    public Animation animation;



    public SpriteSheet(){

        spriteSheet = new Texture(Gdx.files.internal("img/aliens.png"));

        TextureRegion[][] spriteSheetFrames = TextureRegion.split(spriteSheet, 70, 100);

        int counter = 0;

        for (int row = 0; row < spriteSheetFrames.length; row++){
            for (int column = 0; column < spriteSheetFrames[row].length; column++){
                counter++;
            }
        }

        spriteFrames = new TextureRegion[counter];

        counter = 0;
        for(TextureRegion[] row : spriteSheetFrames){
            for(TextureRegion sprite : row){
                spriteFrames[counter++] = sprite;
            }

        }

    }
    public Animation createAnimation(){
        TextureRegion[] animationFrames = new TextureRegion[2];
        animationFrames[0] = spriteFrames[9];
        animationFrames[1] = spriteFrames[10];
        animation = new Animation(0.4f, animationFrames);
        return animation;

    }

}



