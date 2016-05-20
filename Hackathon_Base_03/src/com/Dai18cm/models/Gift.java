package com.Dai18cm.models;

/**
 * Created by Admin on 5/16/2016.
 */
public class Gift extends GameObject {

    public static final int WIDTH_DEFAULT = 30;
    public static final int HEIGHT_DEFAULT = 30;
    public static final int SPEED_DEFAULT = 5;
    private GiftType giftType = GiftType.NONE;
    private int durationTime = 0; //thoi gian ton tai buff

    public Gift(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public Gift(int x, int y, int width, int height, int speed, int durationTime) {
        this(x, y, width, height);
        this.durationTime = durationTime;
    }

    public GiftType getGiftType() {
        return giftType;
    }

    public void setGiftType(GiftType giftType) {
        this.giftType = giftType;
    }
    //DUng ham nay` de decrease DurationTime cua Gift
    public void decreaseDurationTime(){
        if(this.durationTime <= 0){
            this.durationTime = 0;
            return;
        }else{
            this.durationTime -= GameConfig.DEFAULT_THREAD_DELAY;
        }
    }

    public int getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(int durationTime) {
        this.durationTime = durationTime;
    }
}
