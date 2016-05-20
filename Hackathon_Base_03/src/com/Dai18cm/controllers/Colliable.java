package com.Dai18cm.controllers;

import com.Dai18cm.models.GameObject;

/**
 * Created by Admin on 5/16/2016.
 */
public interface Colliable {
    void onCollide(Colliable c);
    GameObject getGameObject();
}
