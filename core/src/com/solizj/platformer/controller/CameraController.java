package com.solizj.platformer.controller;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraController {
    public static OrthographicCamera camera;
    //[52] second camera for on-screen buttons
    public static OrthographicCamera inputCamera;

    //[53] Determine Unit scale on screen
    public static float widthScale;
    public static float heightScale;

    public static void initializedController(){
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();
        camera = new OrthographicCamera(14f,14f *(height / width));

        //inputCamera is the second camera for on screen buttons
        inputCamera = new OrthographicCamera(14f,14f *(height/width));
        inputCamera.position.set(inputCamera.viewportWidth / 2f, inputCamera.viewportHeight / 2f, 0);
        inputCamera.update();

         }

    public static void update(){
        camera.position.set(PlayerController.player.position.x,PlayerController.player.position.y,0); // Follow player
        camera.update();
    }

    public static void resize(int width, int height){
        camera.viewportWidth = 14f;
        camera.viewportHeight = 14f * height/width;
        camera.update();

        inputCamera.viewportWidth = 14f;
        inputCamera.viewportHeight = 14f * height/width;
        //set positionu using resized coordinates
        inputCamera.position.set(inputCamera.viewportWidth / 2f, inputCamera.viewportHeight / 2f, 0);
        inputCamera.update();

        //[53] scale the camera for the input buttons
        widthScale = Gdx.graphics.getWidth() / inputCamera.viewportWidth * LevelController.UNIT_SCALE;
        heightScale = Gdx.graphics.getHeight() / inputCamera.viewportHeight  * LevelController.UNIT_SCALE;

    }
}
