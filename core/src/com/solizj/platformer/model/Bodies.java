package com.solizj.platformer.model;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.solizj.platformer.controller.LevelController;

public class Bodies { // [39] New "factory" class to create bodies in Box2d

    public static void createBody(MapObject mapObject){
        String bodyType = mapObject.getProperties().get("type").toString();

        if(bodyType.equalsIgnoreCase("ground")){ // if solid create box2d body
            // get rectangle object found in tile map //[43(52)] Change to polyline
            PolylineMapObject polylineObject = (PolylineMapObject)mapObject;//This is OK CHECK TILED

            // create box2d body based on that information
            BodyDef bodyDefinition = new BodyDef();
            bodyDefinition.type = BodyDef.BodyType.StaticBody;
            bodyDefinition.position.set(polylineObject.getPolyline().getX()* LevelController.UNIT_SCALE,polylineObject.getPolyline().getY()*LevelController.UNIT_SCALE);

            // create the body in our gameworld
            Body physicsBody = LevelController.gameWorld.createBody(bodyDefinition);
            ChainShape chainShape = new ChainShape();
            // [44(53)] Must create the chain shape before you can attach it to the fixture definition
            float[] transformedVerticies = new float[polylineObject.getPolyline().getVertices().length];

            for(int index = 0 ; index< transformedVerticies.length; index++){
                transformedVerticies[index] = polylineObject.getPolyline().getVertices()[index] * LevelController.UNIT_SCALE;
            }
                        chainShape.createChain(transformedVerticies);

            // how shape created on screen
            FixtureDef fixtureDefinition = new FixtureDef();
            fixtureDefinition.shape = chainShape;

            // attach shape to our body
            physicsBody.createFixture(fixtureDefinition);
            chainShape.dispose();
        }
/*        else if (bodyType.equalsIgnoreCase("slope")){
            PolygonMapObject polygonObject = (PolygonMapObject)mapObject;

            //create body def
            BodyDef bodyDefinition = new BodyDef();
            bodyDefinition.type = BodyDef.BodyType.StaticBody;
            bodyDefinition.position.set(polygonObject.getPolygon    ().getX()*LevelController.UNIT_SCALE, polygonObject.getPolygon().getY()*LevelController.UNIT_SCALE);

            //create physics body
            Body physicsBody = LevelController.gameWorld.createBody(bodyDefinition);
            PolygonShape slopeShape = new PolygonShape();

            // Transform Verticies in level map to game scale
            float [] transformedVerticies = new float[6]; // 6 verticies = 3 points 2 coordinates per point (x,y)

            for(int index=0; index < transformedVerticies.length; index++){
                transformedVerticies[index] = polygonObject.getPolygon().getVertices()[index] * LevelController.UNIT_SCALE;
            }

            //create shape
            slopeShape.set(transformedVerticies);

            //Create Fixture
            FixtureDef fixtureDefinition = new FixtureDef();
            fixtureDefinition.shape = slopeShape;

            // attach shape (fixture) to physics body
            physicsBody.createFixture(fixtureDefinition);
            slopeShape.dispose();
        }*/

    }
}
