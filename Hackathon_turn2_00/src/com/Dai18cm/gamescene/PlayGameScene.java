package com.Dai18cm.gamescene;

import com.Dai18cm.LevelManager;
import com.Dai18cm.Utils;
import com.Dai18cm.controllers.*;
import com.Dai18cm.models.GameConfig;
import com.Dai18cm.models.Player;
import com.Dai18cm.models.Status;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Admin on 5/16/2016.
 */
public class PlayGameScene extends GameScene {
    public boolean pause = false;
    private PlayerController playerController;
    Image backgoundImage;
    private Vector<Controller> controllerVect;
    private GameConfig gameConfig;
    private CollisionPool collisionPool;
    private SunFlowerController sunFlowerController;
    private HPStatusController hpStatusController;

    public PlayGameScene(){

        collisionPool = CollisionPool.getInst();
        gameConfig = GameConfig.getInst();
        controllerVect = new Vector<Controller>();
        hpStatusController = new HPStatusController();
        this.playerController = PlayerController.getInst();
        this.sunFlowerController = SunFlowerController.getInst();
        controllerVect.add(EnemyControllerManager.getInst());
        controllerVect.add(GiftControllerManager.getInst());
        controllerVect.add(this.sunFlowerController);
        controllerVect.add(this.playerController);

        this.backgoundImage = Utils.loadImage("resources/background_game.png");
    }

    public void resetPlayGameScene(){
        Status.resetHP();
        Status.resetScore();
        EnemyControllerManager.setNULL();
        GiftControllerManager.setNULL();
        //this.playerController.setNULL();
        collisionPool.reset();
    }

    @Override
    public void run(Point mousePoint) {
        collisionPool.run();
        onMouse(mousePoint);
        Iterator<Controller> iterator = controllerVect.iterator();
        while(iterator.hasNext()) {
            Controller c = iterator.next();
            c.run();
        }


        LevelManager.changeLevel();



        if(Status.getHp() <= 0){
            resetPlayGameScene();
            //playerController.getGameObject().setAlive(false);
            EnemyControllerManager.getInst().levelChange(LevelType.LEVEL_1);
            changeGameScene(GameSceneType.GAME_OVER);

        }
        if(this.pause == true){
            this.playerController.setPause(true);
            EnemyControllerManager.getInst().PAUSE = true;
            GiftControllerManager.getInst().PAUSE = true;
        }else {
            this.playerController.setPause(false);
            EnemyControllerManager.getInst().PAUSE = false;
            GiftControllerManager.getInst().PAUSE = false;
        }
    }

    @Override
    public void paint(Graphics g) {
        //ve background
        g.drawImage(this.backgoundImage, 0, 0,
                GameConfig.getInst().getScreenWidth(), GameConfig.getInst().getScreenHeight(), null);


        Iterator<Controller> iterator = controllerVect.iterator();
        while(iterator.hasNext()) {
            Controller c = iterator.next();
            c.paint(g);
        }

        g.setFont(new Font("TimesRoman",Font.PLAIN, 20));
        g.drawString("Score: " + Status.getScore() , 30 , 60);
        hpStatusController.paint(g);
//        for(int i = 1; i <= Status.getHp(); i++){
//            Image image = Utils.loadImage("resources/Fairy_moe/heart.png");
//            g.drawImage(image, GameConfig.DEFAULT_SCREEN_GAME - (35*i),
//                    40, 30, 30, null);
//        }
//        g.drawString("HP: " + Status.getHp(), 330, 60);
    }

    @Override
    public void onMouse(Point mousePoint) {
        if(mousePoint.x - 5 > playerController.getGameObject().getX()) {
            playerController.getGameVector().dx = Player.DEFAULT_SPEED;
        } else if(mousePoint.x + 5 < playerController.getGameObject().getX()) {
            playerController.getGameVector().dx = - Player.DEFAULT_SPEED;
        } else {
            playerController.getGameVector().dx = 0;
        }
    }

    @Override
    public void click(MouseEvent e) {

        if(e.getClickCount() == 1){
            this.pause = true;
            System.out.println(e.getLocationOnScreen());
        }
        else if(e.getClickCount() == 2){
            this.pause = false;
        }
    }
}
