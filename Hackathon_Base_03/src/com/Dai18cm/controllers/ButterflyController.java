package com.Dai18cm.controllers;

import com.Dai18cm.models.Butterfly;
import com.Dai18cm.models.GameVector;
import com.Dai18cm.models.Gift;
import com.Dai18cm.models.Sperm;
import com.Dai18cm.views.AnimationDrawer;
import com.Dai18cm.views.GameDrawer;

/**
 * Created by Admin on 5/21/2016.
 */
public class ButterflyController extends SingleController {
    public ButterflyController(Butterfly gameObject, GameDrawer gameDrawer, GameVector gameVecto) {
        super(gameObject, gameDrawer, gameVecto);
    }

    public static ButterflyController create(int x , int y){
        Butterfly butterfly = new Butterfly(x , y, Butterfly.WIDTH_DEFAULT , Butterfly.HEIGHT_DEFAULT);
        GameVector gameVector = new GameVector(- Butterfly.SPEED_DEFAULT , 0);
        AnimationDrawer animationDrawer = null;
        animationDrawer = new AnimationDrawer(
                new String[]{
                        "resources/butterfly/butterfly1.png",
                        "resources/butterfly/butterfly2.png",
                        "resources/butterfly/butterfly3.png",
                        "resources/butterfly/butterfly4.png",
                        "resources/butterfly/butterfly5.png",
                        "resources/butterfly/butterfly6.png",
                        "resources/butterfly/butterfly7.png",
                        "resources/butterfly/butterfly8.png",
                        "resources/butterfly/butterfly9.png",

                }
        );
        return new ButterflyController(butterfly , animationDrawer , gameVector);
    }

    @Override
    public void setPause(boolean pause) {
        super.setPause(pause);
    }

    @Override
    public void run() {
        super.run();
    }

}
