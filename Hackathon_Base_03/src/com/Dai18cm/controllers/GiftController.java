package com.Dai18cm.controllers;

import com.Dai18cm.Utils;
import com.Dai18cm.models.GameConfig;
import com.Dai18cm.models.GameVector;
import com.Dai18cm.models.Gift;
import com.Dai18cm.models.GiftType;
import com.Dai18cm.views.AnimationDrawer;
import com.Dai18cm.views.GameDrawer;

/**
 * Created by Admin on 5/16/2016.
 */
public class GiftController extends SingleController implements Colliable{
    public GiftController(Gift gameObject, GameDrawer gameDrawer, GameVector gameVecto) {
        super(gameObject, gameDrawer, gameVecto);
        CollisionPool.getInst().add(this);
    }

    public GiftController(Gift gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollisionPool.getInst().add(this);
    }


    public static GiftController create(GiftType giftType, int x , int y){
        Gift gift = new Gift(x , y, Gift.WIDTH_DEFAULT , Gift.HEIGHT_DEFAULT);
        GameVector gameVector = new GameVector(0 , Gift.SPEED_DEFAULT);
        AnimationDrawer animationDrawer = null;
        switch (giftType){
//            case NONE:
//                break;
            case BIGGER_PLAYER:
                gift.setGiftType(GiftType.BIGGER_PLAYER);
                gift.setDurationTime(3000);
                animationDrawer = new AnimationDrawer(
                        new String[]{
                                "resources/GiftRed/Giftbox_Idle1.png",
                                "resources/GiftRed/Giftbox_Idle2.png",
                                "resources/GiftRed/Giftbox_Idle3.png",
                                "resources/GiftRed/Giftbox_Idle4.png",
                                "resources/GiftRed/Giftbox_Walk1.png"
                        }
                );
                break;
            case SLOW_ENEMY:
                gift.setGiftType(GiftType.SLOW_ENEMY);
                gift.setDurationTime(3000);
                animationDrawer = new AnimationDrawer(
                        new String[] {
                                "resources/giftblue/giftblue1.png",
                                "resources/giftblue/giftblue2.png",
                                "resources/giftblue/giftblue3.png",
                                "resources/giftblue/giftblue4.png",
                        }
                );
                break;
            case SHIT_INCREASE_LEVEL_SF:
                gift.setGiftType(GiftType.SHIT_INCREASE_LEVEL_SF);
                gift.setDurationTime(1);
                animationDrawer = new AnimationDrawer(
                        new String[] {
                                "resources/shit.png",
                        }
                );
                break;
            case STONE_DECREASE_LEVEL_SF:
                gift.setGiftType(GiftType.STONE_DECREASE_LEVEL_SF);
                gift.setDurationTime(1);
                animationDrawer = new AnimationDrawer(
                        new String[] {
                                "resources/stone.png",
                        }
                );
                break;
            case HEART_INCRE_HP:
                gift.setGiftType(GiftType.HEART_INCRE_HP);
                gift.setDurationTime(1);
                animationDrawer = new AnimationDrawer(
                        new String[]{
                                "resources/Desktop/heart.png",
                        }
                );
                break;
            case ABLE_TO_SHOT:
                gift.setGiftType(GiftType.ABLE_TO_SHOT);
                //Duration can tinh lai
                gift.setDurationTime(100000);
                animationDrawer = new AnimationDrawer(
                        new String[]{
                                "resources/bullet/bullet.png",
                        }
                );
                break;
        }
        return new GiftController(gift , animationDrawer , gameVector);
    }

    @Override
    public void setPause(boolean pause) {
        super.setPause(pause);
    }

    @Override
    public void run() {
//        if(!GameConfig.getInst().isInScreen(this.gameObject.getRect())) {
//            this.gameObject.setAlive(false);
////            Status.decreaseHP();
//        }
        super.run();
    }

    @Override
    public void onCollide(Colliable c) {
        if(c instanceof PlayerController){
            switch (((Gift)this.gameObject).getGiftType()){
                case NONE:
                    break;
                case BIGGER_PLAYER:
                    Utils.playSound("resources/gift.wav" , false);
                    ((PlayerController)c).isInBuff(GiftType.BIGGER_PLAYER);
                    break;
                case SLOW_ENEMY:
                    Utils.playSound("resources/gift.wav" , false);
                    ((PlayerController)c).isInBuff(GiftType.SLOW_ENEMY);
                    break;
                case SHIT_INCREASE_LEVEL_SF:
                    Utils.playSound("resources/shit.wav", false);
                    ((PlayerController)c).isInBuff(GiftType.SHIT_INCREASE_LEVEL_SF);
                    break;
                case STONE_DECREASE_LEVEL_SF:
                    Utils.playSound("resources/stone.wav", false);
                    ((PlayerController)c).isInBuff(GiftType.STONE_DECREASE_LEVEL_SF);
                    break;
                case HEART_INCRE_HP:
                    ((PlayerController)c).isInBuff(GiftType.HEART_INCRE_HP);
                    break;
                case ABLE_TO_SHOT:
                    ((PlayerController)c).isInBuff(GiftType.ABLE_TO_SHOT);
                    PlayerController.AMOUNT_OF_BULLET ++;
                    break;
            }
            this.gameObject.setAlive(false);
        }
    }
}
