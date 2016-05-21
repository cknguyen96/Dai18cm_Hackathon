package com.Dai18cm.controllers.Dung;

import com.Dai18cm.Utils;
import com.Dai18cm.controllers.Colliable;
import com.Dai18cm.controllers.CollisionPool;
import com.Dai18cm.controllers.SingleController;
import com.Dai18cm.models.Dung;
import com.Dai18cm.models.DungBullet;
import com.Dai18cm.models.GameConfig;
import com.Dai18cm.models.GameVector;
import com.Dai18cm.views.AnimationDrawer;
import com.Dai18cm.views.GameDrawer;
import com.Dai18cm.views.ImageDrawer;

import java.awt.*;

/**
 * Created by nhoxkem96 on 21/05/2016.
 */
public class DungController extends SingleController implements Colliable {

    private int count = 0; //time per shot
    public boolean PAUSE = false;
    private DungBulletControllerManager dungBulletControllerManager;
    public DungController(Dung gameObject,
                                GameDrawer gameDrawer) {
        super(gameObject, gameDrawer );
        this.gameVector  = new GameVector(2 , 0);  //den giua quay lai
        dungBulletControllerManager = new DungBulletControllerManager();
        CollisionPool.getInst().add(this);
    }

    public static void setNULL(){
        inst = null;
    }
    private static DungController inst;
    public static DungController getInst(){
        DungController dungController = null;
        if(inst == null){
            Dung dung = new Dung(200 , 10 , 100 ,100);
            ImageDrawer imageDrawer = new ImageDrawer("resources/BOSS/dung/dung.png");
            dungController = new DungController(dung , imageDrawer);
        }
        return dungController;
    }


    @Override
    public void run() {
//        System.out.println(((Dung)this.gameObject).getHp());
        if(this.getGameObject().getNextRect(this.gameVector).getX() >= GameConfig.DEFAULT_SCREEN_GAME - Dung.DEFAULT_WIDTH) (this.getGameVector()).dx = -2;
        if(this.getGameObject().getNextRect(this.gameVector).getX() <= 0) this.gameVector.dx = 2;
        super.run();
        this.dungBulletControllerManager.run();
        count++;
        if(GameConfig.getInst().durationInSeconds(count) >= 2) {
            count = 0;
            DungBullet enemyBullet = new DungBullet(
                    gameObject.getX() + gameObject.getWidth() / 2 - DungBullet.WIDTH/2,
                    gameObject.getY() + gameObject.getHeight(),
                    DungBullet.WIDTH,
                    DungBullet.HEIGHT
            );
            ImageDrawer imageDrawer = new ImageDrawer("resources/BOSS/egg11.png");
            DungBulletController enemyBulletController = new DungBulletController(
                    enemyBullet,
                    imageDrawer
            );
            this.dungBulletControllerManager.add(enemyBulletController);
        }

    }

    @Override
    public void paint(Graphics g) {
        if(this.gameObject.isAlive()){
            super.paint(g);
            this.dungBulletControllerManager.paint(g);
        }
    }

    @Override
    public void onCollide(Colliable c) {

    }
}
