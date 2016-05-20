package com.Dai18cm.views;

import com.Dai18cm.models.GameObject;
import com.Dai18cm.models.SunFlower;
import sun.security.provider.Sun;

import java.awt.*;

/**
 * Created by Admin on 5/20/2016.
 */
public class SunFlowerDrawer extends GameDrawer {
    GameDrawer mamDrawer;
    GameDrawer flower1Drawer;
    GameDrawer flower2Drawer;
    GameDrawer flower3Drawer;

    public SunFlowerDrawer(GameDrawer mamDrawer, GameDrawer flower1Drawer, GameDrawer flower2Drawer, GameDrawer flower3Drawer){
        this.mamDrawer = mamDrawer;
        this.flower1Drawer = flower1Drawer;
        this.flower2Drawer = flower2Drawer;
        this.flower3Drawer = flower3Drawer;
    }

    @Override
    public void paint(GameObject gameObject, Graphics g) {
        SunFlower sunFlower = (SunFlower) gameObject;
        switch (sunFlower.levelType){
            case LEVEL_0:
                mamDrawer.paint(gameObject, g);
                break;
            case LEVEL_1:
                flower1Drawer.paint(gameObject, g);
                break;
            case LEVEL_2:
                flower2Drawer.paint(gameObject, g);
                break;
            case LEVEL_3:
                flower3Drawer.paint(gameObject, g);
                break;
        }
    }
}
