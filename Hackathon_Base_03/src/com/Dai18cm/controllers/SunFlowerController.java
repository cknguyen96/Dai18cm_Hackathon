package com.Dai18cm.controllers;

import com.Dai18cm.models.GameObject;
import com.Dai18cm.models.GameVector;
import com.Dai18cm.models.Status;
import com.Dai18cm.models.SunFlower;
import com.Dai18cm.views.AnimationDrawer;
import com.Dai18cm.views.GameDrawer;
import com.Dai18cm.views.SunFlowerDrawer;
import sun.security.provider.Sun;

import java.awt.*;

/**
 * Created by Admin on 5/19/2016.
 */
public class SunFlowerController extends SingleController {
    public SunFlowerController(GameObject gameObject, GameDrawer gameDrawer, GameVector gameVecto) {
        super(gameObject, gameDrawer, gameVecto);
    }

    public SunFlowerController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
    }
    private static SunFlowerController inst;
    public static SunFlowerController getInst(){
        SunFlowerController sunFlowerController = null;
        if (inst == null) {
            SunFlower sunFlower = new SunFlower(450, 170, 300 , 400);
            AnimationDrawer mamAnimationDrawer = new AnimationDrawer(
                    new String[]{
                            "resources/flower/flower/flo0/mam0.png",
                            "resources/flower/flower/flo0/mam1.png",
                            "resources/flower/flower/flo0/mam2.png",
                            "resources/flower/flower/flo0/mam3.png",
                            "resources/flower/flower/flo0/mam4.png",
                            "resources/flower/flower/flo0/mam5.png"
                    }
            );
            AnimationDrawer flower1AnimationDrawer = new AnimationDrawer(
                    new String[]{
                            "resources/flower/flower/flo1/flower0.png",
                            "resources/flower/flower/flo1/flower1.png",
                            "resources/flower/flower/flo1/flower2.png",
                            "resources/flower/flower/flo1/flower3.png",
                            "resources/flower/flower/flo1/flower4.png",
                            "resources/flower/flower/flo1/flower5.png"
                    }
            );
            AnimationDrawer flower2AnimationDrawer = new AnimationDrawer(
                    new String[]{
                            "resources/flower/flower/flo2/flower0.png",
                            "resources/flower/flower/flo2/flower1.png",
                            "resources/flower/flower/flo2/flower2.png",
                            "resources/flower/flower/flo2/flower3.png",
                            "resources/flower/flower/flo2/flower4.png",
                            "resources/flower/flower/flo2/flower5.png"
                    }
            );
            AnimationDrawer flower3AnimationDrawer = new AnimationDrawer(
                    new String[]{
                            "resources/flower/flower/flo3/flower0.png",
                            "resources/flower/flower/flo3/flower1.png",
                            "resources/flower/flower/flo3/flower2.png",
                            "resources/flower/flower/flo3/flower3.png",
                            "resources/flower/flower/flo3/flower4.png",
                            "resources/flower/flower/flo3/flower5.png"
                    }
            );
            sunFlowerController = new SunFlowerController(sunFlower,
                    new SunFlowerDrawer(mamAnimationDrawer, flower1AnimationDrawer, flower2AnimationDrawer, flower3AnimationDrawer));
        }
        return sunFlowerController;
    }
    public void setNULL(){
        inst = null;
    }
    @Override
    public void run() {
        super.run();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}
