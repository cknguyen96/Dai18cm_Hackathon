package com.Dai18cm.controllers;

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
                gift.setDurationTime(2000);
                animationDrawer = new AnimationDrawer(
                        new String[] {
                                "resources/giftblue/giftblue1.png",
                                "resources/giftblue/giftblue2.png",
                                "resources/giftblue/giftblue3.png",
                                "resources/giftblue/giftblue4.png",
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
        super.run();
    }

    @Override
    public void onCollide(Colliable c) {
        if(c instanceof PlayerController){
            switch (((Gift)this.gameObject).getGiftType()){
                case NONE:
                    break;
                case BIGGER_PLAYER:
                    ((PlayerController)c).isInBuff(GiftType.BIGGER_PLAYER);
                    break;
                case SLOW_ENEMY:
                    ((PlayerController)c).isInBuff(GiftType.SLOW_ENEMY);
                    break;
            }
            this.gameObject.setAlive(false);
        }
    }
}
