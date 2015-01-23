package com.solizj.platformer.controller;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraController {
    public static OrthographicCamera camera;


    public static void initializedController(){
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();
        camera = new OrthographicCamera(14f,14f *(height / width));
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
    }

    public static void update(){
        camera.update();
    }

    public static void resize(int width, int height){
        camera.viewportWidth = 14f;
        camera.viewportHeight = 14f * height/width;
        camera.update();
    }
}
