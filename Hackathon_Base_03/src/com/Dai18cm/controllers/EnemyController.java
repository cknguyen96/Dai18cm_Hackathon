package com.Dai18cm.controllers;

import com.Dai18cm.Utils;
import com.Dai18cm.models.*;
import com.Dai18cm.views.AnimationDrawer;
import com.Dai18cm.views.GameDrawer;

import java.awt.*;

/**
 * Created by Admin on 5/16/2016.
 */
public class EnemyController extends SingleController implements Colliable{

    public static int level_speed = Enemy.DEFAULT_SPEED;
    private static boolean isInBuff = false;
    public EnemyController(Enemy gameObject, GameDrawer gameDrawer, GameVector gameVecto) {
        super(gameObject, gameDrawer, gameVecto);
        CollisionPool.getInst().add(this);
    }

    public EnemyController(Enemy gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollisionPool.getInst().add(this);
    }
    public void setIsInBuff(boolean isInBuff) {
        EnemyController.isInBuff = isInBuff;
    }
    /*TODO lam` hieu ung cho enemy */

    @Override
    public void setPause(boolean pause) {
        super.setPause(pause);
    }

    @Override
    public void run() {
        super.run();
        if(!GameConfig.getInst().isInScreen(this.gameObject.getRect())) {
            this.gameObject.setAlive(false);
            Status.decreaseHP();
        }
        if(isInBuff == false){
            gameVector = new GameVector(0, level_speed);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    public static EnemyController create(int x, int y){
        EnemyController enemyController = null;
        GameVector gameVector = null;
        /*TODO lam hieu ung cho enemy */
        Enemy enemy = new Enemy(x, y,
                Enemy.DEFAULT_WIDTH,
                Enemy.DEFAULT_HEIGHT
        );

        if(isInBuff == false){
            gameVector = new GameVector(0, level_speed);
        } else{
            enemy.setSpeed(level_speed - 2);
            System.out.println(enemy.getSpeed());
            gameVector = new GameVector(0, enemy.getSpeed());
        }
        System.out.println(gameVector.dy);
        AnimationDrawer animationDrawer = new AnimationDrawer(
                new String[] {
                        "resources/water/water1.png",
                        "resources/water/water2.png",
                        "resources/water/water3.png",
                        "resources/water/water4.png",
                }
        );
        enemyController = new EnemyController(enemy, animationDrawer, gameVector);
        return enemyController;
    }

    @Override
    public void onCollide(Colliable c) {
        if(c instanceof PlayerController){
            Utils.playSound("resources/water.wav", false);
            this.getGameObject().setAlive(false);
            Status.increaseScore();
        }
    }
}
