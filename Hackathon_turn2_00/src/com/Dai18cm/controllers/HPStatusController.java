package com.Dai18cm.controllers;

import com.Dai18cm.Utils;
import com.Dai18cm.models.GameConfig;
import com.Dai18cm.models.GameObject;
import com.Dai18cm.models.GameVector;
import com.Dai18cm.models.Status;
import com.Dai18cm.views.GameDrawer;

import java.awt.*;

/**
 * Created by Admin on 5/21/2016.
 */
public class HPStatusController extends SingleController {
    public static final int DEFAULT_HEART_SIZE = 25; //Heart la hinh vuong
    public static final int DEFAULT_HEART_LOCATION_Y = 40;
    public HPStatusController(){

    }
    public HPStatusController(GameObject gameObject, GameDrawer gameDrawer, GameVector gameVecto) {
        super(gameObject, gameDrawer, gameVecto);
    }

    public HPStatusController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
    }

    @Override
    public void paint(Graphics g) {
        for(int i = 1; i <= Status.getHp(); i++){
            Image image = Utils.loadImage("resources/Fairy_moe/heart.png");
            g.drawImage(image, GameConfig.DEFAULT_SCREEN_GAME - (35 * i),
                    DEFAULT_HEART_LOCATION_Y,
                    DEFAULT_HEART_SIZE,
                    DEFAULT_HEART_SIZE,
                    null
            );
        }
//        super.paint(g);
    }
}
