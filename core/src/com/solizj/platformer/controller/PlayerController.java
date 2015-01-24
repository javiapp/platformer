package com.solizj.platformer.controller;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.solizj.platformer.model.Player;

public class PlayerController {
    public static Player player;

    public static void initializeController(){
        player = new Player(new Vector2(2,10),70,100);
    }

    public static void update(float deltaTime){
        player.update(deltaTime);

    }

    public static void draw(Batch spriteBatch){ // [34]
        player.draw(spriteBatch);
    }
}
