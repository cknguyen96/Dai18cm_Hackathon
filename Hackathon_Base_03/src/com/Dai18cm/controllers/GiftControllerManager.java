package com.Dai18cm.controllers;

import com.Dai18cm.gamescene.PlayGameScene;
import com.Dai18cm.models.GameConfig;
import com.Dai18cm.models.Gift;
import com.Dai18cm.models.GiftType;

import java.util.Random;

/**
 * Created by Admin on 5/16/2016.
 */
public class GiftControllerManager extends ControllerManager {

    Random rand = new Random();
    int count = 0;
    int count_bullet = 0;
    int typeGift ; // random ra loai qua
    public boolean PAUSE = false;
/*TODO doi qua to => shit doing... */
    @Override
    public void run() {
        if(PAUSE == false) {
            super.run();
            count++;
            count_bullet++;
            if ((GameConfig.getInst().durationInSeconds(count_bullet)>5 && PlayGameScene.isInLevel3 == true)){
                count_bullet = 0;
                int x = rand.nextInt(GameConfig.DEFAULT_SCREEN_WIDTH / 2 - 20 - 60) + 40;  //random x //tru` di vien cua so
                GiftController giftController = GiftController.create(GiftType.ABLE_TO_SHOT, x, 0);
                this.singleControllerVector.add(giftController);
            }
            if(GameConfig.getInst().durationInSeconds(count) > 6){
                count = 0;
                typeGift = rand.nextInt(4)+1;
            }
            if (typeGift == 1) {
                typeGift = 0;
                int x = rand.nextInt(GameConfig.DEFAULT_SCREEN_WIDTH / 2 - 20 - 60) + 40;  //random x //tru` di vien cua so
                GiftController giftController = GiftController.create(GiftType.SHIT_INCREASE_LEVEL_SF, x, 0);
                this.singleControllerVector.add(giftController);
            }
            if (typeGift == 2) {
                typeGift = 0;
                int x = rand.nextInt(GameConfig.DEFAULT_SCREEN_WIDTH / 2 - 60) + 40;  //random x
                GiftController giftController = GiftController.create(GiftType.STONE_DECREASE_LEVEL_SF, x, 0);
                this.singleControllerVector.add(giftController);

            }
            if (typeGift == 3) {
                typeGift = 0;
                int x = rand.nextInt(GameConfig.DEFAULT_SCREEN_WIDTH / 2 - 60) + 40;  //random x
                GiftController giftController = GiftController.create(GiftType.SLOW_ENEMY, x, 0);
                this.singleControllerVector.add(giftController);

            }
            if(typeGift == 4){
                typeGift = 0;
                int x = rand.nextInt(GameConfig.DEFAULT_SCREEN_WIDTH / 2 - 60) + 40;  //random x
                GiftController giftController = GiftController.create(GiftType.HEART_INCRE_HP, x, 0);
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
