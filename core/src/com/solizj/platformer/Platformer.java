package com.solizj.platformer;

import com.badlogic.gdx.Game;
import com.solizj.platformer.view.GameScreen;


public class Platformer extends Game {
    @Override
    public void create() {
        setScreen(new GameScreen());

    }
}
