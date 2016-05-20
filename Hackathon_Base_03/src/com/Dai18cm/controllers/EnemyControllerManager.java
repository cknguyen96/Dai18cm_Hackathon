package com.Dai18cm.controllers;

import com.Dai18cm.models.Enemy;
import com.Dai18cm.models.GameConfig;

import java.util.Random;

/**
 * Created by Admin on 5/16/2016.
 */
public class EnemyControllerManager extends ControllerManager {
    private int count = 0;                  //Dem khi nao > n thi sperm ra doi
    Random rand = new Random();
    private static int SPEED_RANDOM = 1000;
    private static int SPACE_RANDOM = 100;
    private int TIME_PER_ENEMY_APPEAR = rand.nextInt(SPEED_RANDOM) + SPACE_RANDOM;
    public boolean PAUSE = false;

    public EnemyControllerManager(){
        super();
    }

    public static void setNULL(){
        inst = null;
    }

    public void levelChange(LevelType levelType) {
        switch (levelType){
            case LEVEL_0:
                SPEED_RANDOM = 1200;
                SPACE_RANDOM = 120;
                EnemyController.level_speed = 4;
                break;
            case LEVEL_1:
                SPEED_RANDOM = 1000;
                SPACE_RANDOM = 100;
                EnemyController.level_speed = 6;
                break;
            case LEVEL_2:
                SPEED_RANDOM = 900;
                SPACE_RANDOM = 90;
                EnemyController.level_speed = 8;
                break;
            case LEVEL_3:
                SPEED_RANDOM = 700;
                SPACE_RANDOM = 70;
                EnemyController.level_speed = 10;
                break;
        }
    }
    /*TODO Effect cua tat ca enemy*/
    @Override
    public void run() {
        if(PAUSE == false) {
            super.run();
            count++;
            if (GameConfig.getInst().durationInMiliSeconds(count) > TIME_PER_ENEMY_APPEAR) {
                count = 0;                                                          //Gan lai count
                TIME_PER_ENEMY_APPEAR = rand.nextInt(SPEED_RANDOM) + SPACE_RANDOM;                                         //Sinh thoi diem ngau nhien #
                int random_X =
                        rand.nextInt(((GameConfig.DEFAULT_SCREEN_WIDTH / 2) - 20 - Enemy.DEFAULT_WIDTH - 5)) + 1;// Random vi tri X cua Sperm //Tru vi tri vien
                this.singleControllerVector.add(EnemyController.create(random_X, 6));
            }
        }
    }

    public void slowAll(){
        for(SingleController singleController : this.singleControllerVector){
            ((EnemyController)singleController).setIsInBuff(true);
        }
    }

    public void reset(){
        for(SingleController singleController : this.singleControllerVector){
            ((EnemyController)singleController).setIsInBuff(false);
        }
    }

    private static EnemyControllerManager inst;
    public static EnemyControllerManager getInst() {
        if(inst == null) {
            inst = new EnemyControllerManager();
        }
        return inst;
    }

}
