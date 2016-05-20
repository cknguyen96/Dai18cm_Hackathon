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
/*TODO doi qua to => shit doing... */
    @Override
    public void run() {
        if(PAUSE == false) {
            super.run();
            count_redGift++;
            count_blueGift++;
            if (GameConfig.getInst().durationInSeconds(count_redGift) > 10) {
                count_redGift = 0;
                int x = rand.nextInt(GameConfig.DEFAULT_SCREEN_WIDTH / 2 - 20 - 60) + 40;  //random x //tru` di vien cua so
                /*TODO dang sua cho GIFT la SHIT*/
                GiftController giftController = GiftController.create(GiftType.SHIT_INCREASE_LEVEL_SF, x, 0);
                this.singleControllerVector.add(giftController);
            }
            if (GameConfig.getInst().durationInSeconds(count_blueGift) > 15) {
                count_blueGift = 0;
                int x = rand.nextInt(GameConfig.DEFAULT_SCREEN_WIDTH / 2 - 60) + 40;  //random x
                /*TODO dang sua cho GIFT la STONE */
                GiftController giftController = GiftController.create(GiftType.STONE_DECREASE_LEVEL_SF, x, 0);
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
