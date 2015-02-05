package com.solizj.platformer.model;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.solizj.platformer.controller.LevelController;

import java.util.HashMap;

public class Player extends Sprite{ // [33] extends Sprite

    public Player(Vector2 position, int width, int height, String sheetPath) {
        super(position, width, height, sheetPath);

        //create body definition to set type and position in world
        BodyDef bodyDefinition = new BodyDef();
        bodyDefinition.type = BodyDef.BodyType.DynamicBody;
        bodyDefinition.position.set(position);

        //create it in game world
        physicsBody = LevelController.gameWorld.createBody(bodyDefinition);
        physicsBody.setUserData(this);

        //create its shape
        PolygonShape rectangleShape = new PolygonShape();
        rectangleShape.setAsBox(this.width/2f,this.height/2f,new Vector2(this.width/2f,this.height/2f),0);
        //[55] create new smaller rectangle shape for player's feet
        PolygonShape sensorShape = new PolygonShape();
        sensorShape.setAsBox(this.width/4,this.height/32,new Vector2(this.width/2,0),0f);

        //create properties of the shape
        FixtureDef fixtureDefinition = new FixtureDef();
        fixtureDefinition.shape =  rectangleShape;
        //[55] create fixture for smaller foot rectangle
        FixtureDef  fixtureDefinitionSensor = new FixtureDef(); // create definition
        fixtureDefinitionSensor.shape = sensorShape; // attach to shape

        fixtureDefinitionSensor.isSensor = true;// Sensor shapes don't register collisions
        // (attach these properties to the player) ie. attach fixture to player body
        physicsBody.createFixture(fixtureDefinition); // rectangle
        physicsBody.createFixture(fixtureDefinitionSensor); //foot sensor
        rectangleShape.dispose();
        sensorShape.dispose(); //foot sensor




        animations.put("walkRight", spriteSheet.createAnimation(9,10, 0.25f));
        animations.put("walkLeft", spriteSheet.flipAnimation(animations.get("walkRight"), true, false));
        animations.put("stand", spriteSheet.createAnimation(0,0, 0.25f));
        animations.put("climb", spriteSheet.createAnimation(1, 2, 0.25f));
        animations.put("duckRight", spriteSheet.createAnimation(3,3, 0.25f));
        animations.put("duckLeft", spriteSheet.flipAnimation(animations.get("duckRight"), true, false));
        animations.put("hitRight", spriteSheet.createAnimation(4,4, 0.25f));
        animations.put("hitLeft", spriteSheet.flipAnimation(animations.get("hitRight"), true, false));
        animations.put("jumpRight", spriteSheet.createAnimation(5,5, 0.25f));
        animations.put("jumpLeft", spriteSheet.flipAnimation(animations.get("jumpRight"), true, false));
        animations.put("idleRight", spriteSheet.createAnimation(6, 6, 0.25f));
        animations.put("idleLeft", spriteSheet.flipAnimation(animations.get("idleRight"), true, false));
        animations.put("swimRight", spriteSheet.createAnimation(7,8, 0.25f));
        animations.put("swimLeft", spriteSheet.flipAnimation(animations.get("swimRight"), true, false));
        animations.put("walkRight", spriteSheet.createAnimation(9,10, 0.25f));
        animations.put("walkLeft", spriteSheet.flipAnimation(animations.get("walkRight"), true, false));



        currentAnimation = "climb";

    }

    public void draw(Batch spriteBatch){
        super.draw(spriteBatch);
    }

    public void update(float deltaTime){
        super.update(deltaTime);
    }
}
