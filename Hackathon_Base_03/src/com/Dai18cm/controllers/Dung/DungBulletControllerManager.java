package com.Dai18cm.controllers.Dung;

import com.Dai18cm.controllers.ControllerManager;

/**
 * Created by nhoxkem96 on 21/05/2016.
 */
public class DungBulletControllerManager extends ControllerManager {
    DungBulletControllerManager(){

    }

    private static DungBulletControllerManager inst;
    public static DungBulletControllerManager getInst () {
        if(inst == null) {
            inst = new DungBulletControllerManager();
        }
        return inst;
    }
}
