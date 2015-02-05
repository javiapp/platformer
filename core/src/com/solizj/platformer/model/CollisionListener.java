package com.solizj.platformer.model;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

//[54] Do more things when Collisions Happen // implement where you can access gameWorld (ie in LevelController)
public class CollisionListener implements  ContactListener{ // 4 required methods to be of type ContactListener
    @Override
    public void beginContact(Contact contact) {
        System.out.println("Begin Contact");
    }

    @Override
    public void endContact(Contact contact) {
        System.out.println("End Contact");
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
