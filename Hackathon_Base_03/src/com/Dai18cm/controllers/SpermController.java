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
                        "resources/BOSS/worm/worm1.png",
                        "resources/BOSS/worm/worm2.png",
                        "resources/BOSS/worm/worm3.png",
                        "resources/BOSS/worm/worm4.png",
                        "resources/BOSS/worm/worm5.png",
                        "resources/BOSS/worm/worm6.png",
                        "resources/BOSS/worm/worm7.png",
                        "resources/BOSS/worm/worm8.png",

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
