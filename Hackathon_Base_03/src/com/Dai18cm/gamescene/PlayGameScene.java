package com.Dai18cm.gamescene;

import com.Dai18cm.LevelManager;
import com.Dai18cm.Utils;
import com.Dai18cm.controllers.*;
import com.Dai18cm.models.GameConfig;
import com.Dai18cm.models.Player;
import com.Dai18cm.models.Status;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Admin on 5/16/2016.
 */
public class PlayGameScene extends GameScene {
    public boolean pause = false;

    private PlayerController playerController;
   // private Player2Controller player2Controller;

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
       // this.player2Controller = Player2Controller.getInst();
        this.sunFlowerController = SunFlowerController.getInst();

        controllerVect.add(EnemyControllerManager.getInst());
        controllerVect.add(GiftControllerManager.getInst());
        controllerVect.add(SpermControllerManager.getInst());
        controllerVect.add(ButterflyControllerManager.getInst());
        controllerVect.add(this.sunFlowerController);
        controllerVect.add(this.playerController);
       // controllerVect.add(this.player2Controller);

        this.backgoundImage = Utils.loadImage("resources/background_game.png");
    }

    public void resetPlayGameScene(){
        Status.resetHP();
        Status.resetScore();
        LevelManager.reset();
        EnemyControllerManager.setNULL();
        GiftControllerManager.setNULL();
        SpermControllerManager.setNULL();
        ButterflyControllerManager.setNULL();
        //this.playerController.setNULL();
        collisionPool.reset();
    }

    @Override
    public void onKeyPress(KeyEvent e) {
//        PlayerDirection playerDirection = PlayerDirection.NONE;
//
//        switch (e.getKeyCode()) {
//            case KeyEvent.VK_LEFT:
//                playerDirection = PlayerDirection.LEFT;
//                break;
//            case KeyEvent.VK_RIGHT:
//                playerDirection = PlayerDirection.RIGHT;
//                break;
//        }
//        this.player2Controller.move(playerDirection);
    }

    @Override
    public void onKeyRelease(KeyEvent e) {
//        PlayerDirection playerDirection = PlayerDirection.NONE;
//        switch (e.getKeyCode()) {
//            case KeyEvent.VK_LEFT:
//            case KeyEvent.VK_RIGHT:
//                playerDirection = PlayerDirection.STOP_X;
//                break;
//        }
//        this.player2Controller.move(playerDirection);
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
            if(Status.getScore() > Status.highestScore){
                Status.highestScore = Status.getScore();
                Utils.writeFile();
                GameOverScene.isHighestScore = true;
            }
            Status.playerScore = Status.getScore();
            resetPlayGameScene();
            //playerController.getGameObject().setAlive(false);
            EnemyControllerManager.getInst().levelChange(LevelType.LEVEL_0);
            changeGameScene(GameSceneType.GAME_OVER);

        }
        if(this.pause == true){
            this.playerController.setPause(true);
            EnemyControllerManager.getInst().PAUSE = true;
            GiftControllerManager.getInst().PAUSE = true;
            SpermControllerManager.getInst().PAUSE = true;
            ButterflyControllerManager.getInst().PAUSE = true;
        }else {
            this.playerController.setPause(false);
            EnemyControllerManager.getInst().PAUSE = false;
            GiftControllerManager.getInst().PAUSE = false;
            SpermControllerManager.getInst().PAUSE = false;
            ButterflyControllerManager.getInst().PAUSE = false;
        }
    }

    @Override
    public void paint(Graphics g) {
        g.setFont(new Font("TimesRoman",Font.PLAIN, 20));
        //ve background
        g.drawImage(this.backgoundImage, 0, 0,
                GameConfig.getInst().getScreenWidth(), GameConfig.getInst().getScreenHeight(), null);

        if(this.pause == true) g.drawString("PAUSE" , 300 , 280);
        Iterator<Controller> iterator = controllerVect.iterator();
        while(iterator.hasNext()) {
            Controller c = iterator.next();
            c.paint(g);
        }


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
