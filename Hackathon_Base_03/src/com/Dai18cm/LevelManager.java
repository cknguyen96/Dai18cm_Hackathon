package com.Dai18cm;

import com.Dai18cm.controllers.EnemyControllerManager;
import com.Dai18cm.controllers.LevelType;
import com.Dai18cm.models.Status;
import com.Dai18cm.models.SunFlower;

/**
 * Created by Admin on 5/20/2016.
 */
public class LevelManager {
    public static void changeLevel(){
        if(Status.getScore() >= 0 && Status.getScore() < 25){
            SunFlower.levelType = LevelType.LEVEL_0;
            EnemyControllerManager.getInst().levelChange(LevelType.LEVEL_0);
        }
        if(Status.getScore() >= 25 && Status.getScore() < 50){
            SunFlower.levelType = LevelType.LEVEL_1;
            EnemyControllerManager.getInst().levelChange(LevelType.LEVEL_1);
        }
        if(Status.getScore() >= 50 && Status.getScore() < 75){
            SunFlower.levelType = LevelType.LEVEL_2;
            EnemyControllerManager.getInst().levelChange(LevelType.LEVEL_2);
        }
        if(Status.getScore() >= 75 ){
            SunFlower.levelType = LevelType.LEVEL_3;
            EnemyControllerManager.getInst().levelChange(LevelType.LEVEL_3);
        }
    }
}
