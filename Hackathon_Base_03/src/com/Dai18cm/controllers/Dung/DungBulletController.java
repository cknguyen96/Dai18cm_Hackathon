package com.Dai18cm.controllers.Dung;

import com.Dai18cm.controllers.Colliable;
import com.Dai18cm.controllers.CollisionPool;
import com.Dai18cm.controllers.PlayerController;
import com.Dai18cm.controllers.SingleController;
import com.Dai18cm.models.DungBullet;
import com.Dai18cm.models.GameConfig;
import com.Dai18cm.models.Status;
import com.Dai18cm.views.GameDrawer;

/**
 * Created by nhoxkem96 on 21/05/2016.
 */
public class DungBulletController extends SingleController implements Colliable {

    public DungBulletController(DungBullet gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = 5;
        CollisionPool.getInst().add(this);
    }

    @Override
    public void onCollide(Colliable c) {
        if(c instanceof PlayerController){
            Status.decreaseHP();
            this.gameObject.setAlive(false);
        }
    }

    @Override
    public void run() {
        super.run();
        if(!GameConfig.getInst().isInScreen(this.gameObject.getRect())){
            this.gameObject.setAlive(false);
        }
    }
}
