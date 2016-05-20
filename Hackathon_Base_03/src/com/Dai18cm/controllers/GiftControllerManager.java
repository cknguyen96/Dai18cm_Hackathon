package com.Dai18cm.controllers;

import com.Dai18cm.models.GameConfig;
import com.Dai18cm.models.GiftType;

import java.util.Random;

/**
 * Created by Admin on 5/16/2016.
 */
public class GiftControllerManager extends ControllerManager {

    Random rand = new Random();
    int count_redGift = 0;
    int count_blueGift = 0;
    public boolean PAUSE = false;

    @Override
    public void run() {
        if(PAUSE == false) {
            super.run();
            count_redGift++;
            count_blueGift++;
            if (GameConfig.getInst().durationInSeconds(count_redGift) > 6) {
                count_redGift = 0;
                int x = rand.nextInt(GameConfig.DEFAULT_SCREEN_WIDTH / 2 - 20 - 60) + 40;  //random x //tru` di vien cua so
                GiftController giftController = GiftController.create(GiftType.BIGGER_PLAYER, x, 0);
                this.singleControllerVector.add(giftController);
            }
            if (GameConfig.getInst().durationInSeconds(count_blueGift) > 10) {
                count_blueGift = 0;
                int x = rand.nextInt(GameConfig.DEFAULT_SCREEN_WIDTH / 2 - 60) + 40;  //random x
                GiftController giftController = GiftController.create(GiftType.SLOW_ENEMY, x, 0);
                this.singleControllerVector.add(giftController);

            }
        }
    }

    private static GiftControllerManager inst;
    public static GiftControllerManager getInst() {
        if(inst == null) {
            inst = new GiftControllerManager();
        }
        return inst;
    }
    public static void setNULL(){
        inst = null;
    }
}
