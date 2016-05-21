package com.Dai18cm.controllers;

import com.Dai18cm.models.GameConfig;

import java.util.Random;

/**
 * Created by nhoxkem96 on 21/05/2016.
 */
public class SpermControllerManager extends ControllerManager {
    Random rand = new Random();
    public boolean PAUSE = false;
    int count = 0;

    public void run() {
        if(PAUSE == false) {
            super.run();
            count++;
            if (GameConfig.getInst().durationInSeconds(count) > 8) {
                count = 0;
                int x = rand.nextInt(GameConfig.DEFAULT_SCREEN_WIDTH / 2 - 20 - 60) + 40;  //random x //tru` di vien cua so
                SpermController spermController = SpermController.create(x, 0);
                this.singleControllerVector.add(spermController);
            }
        }
    }

    private static SpermControllerManager inst;
    public static SpermControllerManager getInst() {
        if(inst == null) {
            inst = new SpermControllerManager();
        }
        return inst;
    }
    public static void setNULL(){
        inst = null;
    }
}
