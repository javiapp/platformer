package com.solizj.platformer.model;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.solizj.platformer.controller.PlayerController;

//[54] Do more things when Collisions Happen // implement where you can access gameWorld (ie in LevelController)
public class CollisionListener implements  ContactListener{ // 4 required methods to be of type ContactListener
    @Override
    public void beginContact(Contact contact) {
        // [55] Get Fixtures from contact
        Fixture fixtureA = contact.getFixtureA(); // Don't know what shape is in Fixture A or B
        Fixture fixtureB = contact.getFixtureB();

        // [56] Determine if a contact has a sensor (check both fixtures for if sensor)
        boolean sensorA = fixtureA.isSensor();
        boolean sensorB = fixtureB.isSensor();

        if(sensorA || sensorB){  // if one is a sensor then he's on the ground
            PlayerController.grounded = true;
        }


    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
