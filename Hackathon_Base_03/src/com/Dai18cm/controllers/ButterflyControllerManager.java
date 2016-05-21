package com.Dai18cm.controllers;

import com.Dai18cm.models.GameConfig;

import java.util.Random;

/**
 * Created by Admin on 5/21/2016.
 */
public class ButterflyControllerManager extends ControllerManager {
    Random rand = new Random();
    public boolean PAUSE = false;
    int count = 0;

    public void run() {
        if(PAUSE == false) {
            super.run();
            count++;
            if (GameConfig.getInst().durationInSeconds(count) > 4) {
                count = 0;
                int y = rand.nextInt(GameConfig.DEFAULT_SCREEN_HEIGHT  - 300) + 100;  //random x //tru` di vien cua so
                ButterflyController butterflyController = ButterflyController.create(GameConfig.DEFAULT_SCREEN_WIDTH - 30 , y);
                this.singleControllerVector.add(butterflyController);
            }
        }
    }

    private static ButterflyControllerManager inst;
    public static ButterflyControllerManager getInst() {
        if(inst == null) {
            inst = new ButterflyControllerManager();
        }
        return inst;
    }
    public static void setNULL(){
        inst = null;
    }
}
