package com.Dai18cm.controllers;

import com.Dai18cm.models.GameVector;
import com.Dai18cm.models.Sperm;
import com.Dai18cm.models.Status;
import com.Dai18cm.views.AnimationDrawer;
import com.Dai18cm.views.GameDrawer;

/**
 * Created by nhoxkem96 on 21/05/2016.
 */
public class SpermController extends SingleController implements Colliable {

    public SpermController(Sperm gameObject, GameDrawer gameDrawer, GameVector gameVecto) {
        super(gameObject, gameDrawer, gameVecto);
        CollisionPool.getInst().add(this);
    }



    public static SpermController create(int x , int y){
        Sperm sperm = new Sperm(x , y, Sperm.WIDTH_DEFAULT , Sperm.HEIGHT_DEFAULT);
        GameVector gameVector = new GameVector(0 , Sperm.SPEED_DEFAULT);
        AnimationDrawer animationDrawer = null;
        animationDrawer = new AnimationDrawer(
                new String[]{
                        "resources/sperm/sperm0.png",
                        "resources/sperm/sperm1.png",
                        "resources/sperm/sperm2.png",
                        "resources/sperm/sperm3.png",
                        "resources/sperm/sperm4.png",
                        "resources/sperm/sperm5.png",
                        "resources/sperm/sperm6.png",
                        "resources/sperm/sperm7.png"
                }
        );
        return new SpermController(sperm , animationDrawer , gameVector);
    }

    @Override
    public void setPause(boolean pause) {
        super.setPause(pause);
    }

    @Override
    public void run() {
        super.run();
    }

    @Override
    public void onCollide(Colliable c) {
        if(c instanceof PlayerController){
            Status.decreaseHP();
            Status.decreaseHP();

            this.gameObject.setAlive(false);
        }
    }
}
