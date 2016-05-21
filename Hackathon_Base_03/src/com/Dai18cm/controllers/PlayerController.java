package com.Dai18cm.controllers;

import com.Dai18cm.LevelManager;
import com.Dai18cm.controllers.BulletController.BulletController;
import com.Dai18cm.controllers.BulletController.BulletControllerManager;
import com.Dai18cm.models.*;
import com.Dai18cm.views.AnimationDrawer;
import com.Dai18cm.views.GameDrawer;
import com.Dai18cm.views.ImageDrawer;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Admin on 5/16/2016.
 */
public class PlayerController extends SingleController implements Colliable{

    private boolean inBuff = false;
    public final int MAX_BULLET_COUNT = 3;
    public static int AMOUNT_OF_BULLET = 0;
    public static boolean ableToShot = false;
    private BulletControllerManager bulletControllerManager;


    public Vector<GiftController> giftControllerVector = new Vector<GiftController>();
    protected PlayerController(Player gameObject, GameDrawer gameDrawer, GameVector gameVecto) {
        super(gameObject, gameDrawer, gameVecto);
        bulletControllerManager = new BulletControllerManager();
        CollisionPool.getInst().add(this);
    }

    protected PlayerController(Player gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        bulletControllerManager = new BulletControllerManager();
        CollisionPool.getInst().add(this);
    }

    public void move(PlayerDirection playerDirection) {
        switch (playerDirection) {
            case NONE:
                break;
            case LEFT:
                this.gameVector.dx = - Player.DEFAULT_SPEED;
                break;
            case RIGHT:
                this.gameVector.dx = Player.DEFAULT_SPEED;
                break;
            case STOP_X:
                this.gameVector.dx = 0;
                break;
        }

    }

    private static PlayerController inst;
    public static PlayerController getInst() {
        PlayerController playerController = null;
        if (inst == null) {
            Player player = new Player(200, 510, Player.DEFAULT_WIDTH , Player.DEFAULT_HEIGHT);
            ImageDrawer imageDrawer = new ImageDrawer("resources/Fairy_moe/moe_norm_resize.png");
            playerController = new PlayerController(player, imageDrawer);
        }
        return playerController;
    }
    public void setNULL(){
        inst = null;
    }

    public void shot(){
        if (bulletControllerManager.size() < MAX_BULLET_COUNT) {
            Bullet bullet = new Bullet(
                    gameObject.getX() + gameObject.getWidth() / 2 - Bullet.DEFAULT_WIDTH / 2,
                    gameObject.getY(),
                    Bullet.DEFAULT_WIDTH,
                    Bullet.DEFAULT_HEIGHT
            );
//            ImageDrawer imageDrawer = new ImageDrawer("resources/bullet/bullet.png");
            AnimationDrawer animationDrawer = new AnimationDrawer(
                    new String[]{
                            "resources/BOSS/sperm/sperm0.png",
                            "resources/BOSS/sperm/sperm1.png",
                            "resources/BOSS/sperm/sperm2.png",
                            "resources/BOSS/sperm/sperm3.png",
                            "resources/BOSS/sperm/sperm4.png",
                            "resources/BOSS/sperm/sperm5.png",
                            "resources/BOSS/sperm/sperm6.png",
                            "resources/BOSS/sperm/sperm7.png",
                            "resources/BOSS/sperm/sperm8.png"
                    }
            );
            BulletController bulletController = new BulletController(
                    bullet,
                    animationDrawer
            );

            this.bulletControllerManager.add(bulletController);
        }
    }

    @Override
    public void setPause(boolean pause) {
        super.setPause(pause);
    }

    public void isInBuff(GiftType giftType){
        switch (giftType){
            case NONE:
                break;
            case BIGGER_PLAYER:
                ((Player)this.gameObject).setWidth(Player.DEFAULT_WIDTH + 40);
                this.inBuff = true;
                break;
            case SLOW_ENEMY:
                EnemyControllerManager.getInst().slowAll();
                this.inBuff = true;
                break;
            case SHIT_INCREASE_LEVEL_SF:
                LevelManager.increaseLevel();
                this.inBuff = true;
                break;
            case STONE_DECREASE_LEVEL_SF:
                LevelManager.decreaseLevel();
                this.inBuff = true;
                break;
            case HEART_INCRE_HP:
                Status.increaseHP();
                this.inBuff = true;
                break;
            case ABLE_TO_SHOT:
                /* TODO add effect shot*/
                ableToShot = true;
                this.inBuff = true;
                break;
        }
    }

    public void outBuff(){
        Iterator<GiftController> iterator = giftControllerVector.iterator();
        while (iterator.hasNext()) {
            GiftController giftController = iterator.next();

            ((Gift)giftController.getGameObject()).decreaseDurationTime();

//            System.out.println(((Gift) giftController.getGameObject()).getDurationTime());
            if(AMOUNT_OF_BULLET == 0){
                ableToShot = false;
//                inBuff = false;
            }
            if(((Gift)giftController.getGameObject()).getDurationTime() <= 0){
                switch (((Gift)giftController.getGameObject()).getGiftType()){
                    case NONE:
                        break;
                    case BIGGER_PLAYER:
                        ((Player)this.gameObject).setWidth(Player.DEFAULT_WIDTH);
                        ((Player)this.gameObject).setHeight(Player.DEFAULT_HEIGHT);
                        break;
                    case SLOW_ENEMY:
                        EnemyControllerManager.getInst().reset();
                        break;
                    case SHIT_INCREASE_LEVEL_SF:
                        break;
                    case STONE_DECREASE_LEVEL_SF:
                        break;
                    case HEART_INCRE_HP:
                        break;
                    case ABLE_TO_SHOT:
                        break;
                }
                this.inBuff = false;
                iterator.remove();
            }
        }
    }
    @Override
    public void run() {
//        if(pause == false) {
            Rectangle rectangle = this.gameObject.getNextRect(this.gameVector);
            if (GameConfig.getInst().isInScreen(rectangle) && this.getGameObject().isAlive() == true) {
                if (this.inBuff == true) outBuff();
                super.run();
                bulletControllerManager.run();
            }
//        }
    }

    public void paint(Graphics g) {
        if(inBuff == false){
            ImageDrawer imageDrawer = null;
            imageDrawer = new ImageDrawer("resources/Fairy_moe/moe_norm_resize.png");
            this.gameDrawer = imageDrawer;
        }
        else {
            ImageDrawer imageDrawer = null;
            imageDrawer = new ImageDrawer("resources/Fairy_moe/moe_happy_resize.png");
            this.gameDrawer = imageDrawer;
        }
        super.paint(g);
        bulletControllerManager.paint(g);
    }

    @Override
    public void onCollide(Colliable c) {
        if(c instanceof GiftController){
            this.giftControllerVector.add((GiftController)c);
        }
    }
}
