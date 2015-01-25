package com.solizj.platformer.model;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.solizj.platformer.controller.LevelController;

public class Bodies { // [39] New "factory" class to create bodies in Box2d

    public static void createBody(MapObject mapObject){
        String bodyType = mapObject.getProperties().get("type").toString();

        if(bodyType.equalsIgnoreCase("solid")){ // if solid create box2d body
            // get rectangle object found in tile map
            RectangleMapObject rectangleObject = (RectangleMapObject)mapObject;

            // create box2d body based on that information
            BodyDef bodyDefinition = new BodyDef();
            bodyDefinition.type = BodyDef.BodyType.StaticBody;
            bodyDefinition.position.set(rectangleObject.getRectangle().x* LevelController.UNIT_SCALE,rectangleObject.getRectangle().y*LevelController.UNIT_SCALE);

            // create the body in our gameworld
            Body physicsBody = LevelController.gameWorld.createBody(bodyDefinition);
            PolygonShape rectangleShape = new PolygonShape();
            rectangleShape.setAsBox(rectangleObject.getRectangle().width * LevelController.UNIT_SCALE / 2f, rectangleObject.getRectangle().height * LevelController.UNIT_SCALE  /2f, new Vector2(rectangleObject.getRectangle().width * LevelController.UNIT_SCALE / 2f, rectangleObject.getRectangle().height * LevelController.UNIT_SCALE  /2f),0f);

            // how shape created on screen
            FixtureDef fixtureDefinition = new FixtureDef();
            fixtureDefinition.shape = rectangleShape;

            // attach shape to our body
            physicsBody.createFixture(fixtureDefinition);
            rectangleShape.dispose();
        }
    }
}