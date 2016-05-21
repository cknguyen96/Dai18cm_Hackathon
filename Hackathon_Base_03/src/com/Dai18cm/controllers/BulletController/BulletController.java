package com.Dai18cm.controllers.BulletController;

import com.Dai18cm.Utils;
import com.Dai18cm.controllers.Colliable;
import com.Dai18cm.controllers.CollisionPool;
import com.Dai18cm.controllers.Dung.DungBulletController;
import com.Dai18cm.controllers.Dung.DungController;
import com.Dai18cm.controllers.SingleController;
import com.Dai18cm.models.*;
import com.Dai18cm.views.GameDrawer;

/**
 * Created by Admin on 5/21/2016.
 */
public class BulletController extends SingleController implements Colliable {

    public static final int SPEED = 8;

    public BulletController(Bullet gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        gameVector.dy = -SPEED;
        CollisionPool.getInst().add(this);
    }

    public BulletController(Bullet gameObject, GameDrawer gameDrawer, GameVector gameVector) {
        super(gameObject, gameDrawer);
        this.gameVector = gameVector;
        CollisionPool.getInst().add(this);
    }

    @Override
    public void run() {
        super.run();
        if (!GameConfig.getInst().isInScreen(this.gameObject.getRect())) {
            this.gameObject.setAlive(false);
        }
    }

    @Override
    public void onCollide(Colliable c) {
        /* TODO Tru mau cua Boss va keu a */
        if (c instanceof DungController) {
            Dung dung = (Dung) c.getGameObject();
            dung.decreaseHP();
            if(dung.getHp()<=0){
                dung.setAlive(false);
                Status.increaseScore(20);
            }
            gameObject.setAlive(false);
            Utils.playSound("resources/BOSS/dung/as.wav", false);
            this.gameObject.setAlive(false);
        }
        else if(c instanceof DungBulletController) {
            c.getGameObject().setAlive(false);
            this.gameObject.setAlive(false);
        }
    }
}
