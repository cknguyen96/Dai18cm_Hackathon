package com.Dai18cm.controllers;

import com.Dai18cm.models.GameObject;
import com.Dai18cm.models.GameVector;
import com.Dai18cm.models.Gift;
import com.Dai18cm.views.AnimationDrawer;
import com.Dai18cm.views.GameDrawer;

import java.awt.*;

/**
 * Created by Admin on 5/16/2016.
 */
public class SingleController implements Controller {
    protected GameObject gameObject;
    protected GameDrawer gameDrawer;
    protected GameVector gameVector;
    protected static boolean pause = false;

    public SingleController(){

    }

    public SingleController(GameObject gameObject, GameDrawer gameDrawer, GameVector gameVecto) {
        this.gameObject = gameObject;
        this.gameDrawer = gameDrawer;
        this.gameVector = gameVecto;
    }

    public SingleController(GameObject gameObject, GameDrawer gameDrawer){
        this.gameObject = gameObject;
        this.gameDrawer = gameDrawer;
        this.gameVector = new GameVector();
    }

//GETTER & SETTER
    public GameObject getGameObject() {
        return gameObject;
    }

    public void setGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    public GameVector getGameVector() {
        return gameVector;
    }

    public void setGameVector(GameVector gameVector) {
        this.gameVector = gameVector;
    }

    public void setPause(boolean pause){
        this.pause = pause;
    }

    @Override
    public void paint(Graphics g) {
        this.gameDrawer.paint(this.gameObject, g);
    }

    @Override
    public void run() {
        if(pause == false){
            this.gameObject.move(this.gameVector);
        }
    }
}
