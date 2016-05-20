package com.Dai18cm.gamescene;

import com.Dai18cm.Utils;
import com.Dai18cm.models.GameConfig;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by Admin on 5/16/2016.
 */
public class MenuGameScene extends GameScene {

    Image backgoundImage;
    private boolean onStartButton = false;
    private boolean onExitButton = false;
    Image starButton;
    Image exitButton;

    public MenuGameScene(){
        this.backgoundImage = Utils.loadImage("resources/background.png");
        starButton = Utils.loadImage("resources/play.png");
        exitButton = Utils.loadImage("resources/exit2.png");
    }

    @Override
    public void run(Point mousePoint) {
        onMouse(mousePoint);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(this.backgoundImage, 0, 0,
                GameConfig.getInst().getScreenWidth(), GameConfig.getInst().getScreenHeight(), null);
        if(onStartButton == true){
            g.drawImage(this.starButton , 340 , 390 , 120 , 70 , null);
        }
        if(onExitButton == true){
            g.drawImage(this.exitButton , 340 , 470 , 120 , 70 , null);
        }
    }

    @Override
    public void onMouse(Point mousePoint) {
//        if(mousePoint.x - 5 > playerController.getGameObject().getX()) {
//            playerController.getGameVector().dx = Player.DEFAULT_SPEED;
//        } else if(mousePoint.x + 5 < playerController.getGameObject().getX()) {
//            playerController.getGameVector().dx = - Player.DEFAULT_SPEED;
//        } else {
//            playerController.getGameVector().dx = 0;
//        }
        //System.out.println(mousePoint.x +"    " + mousePoint.y);
        if(mousePoint.x >= 340 && mousePoint.x < 460 && mousePoint.y >= 390 && mousePoint.y <= 460){
            onStartButton = true;
        }
        else onStartButton = false;
        if(mousePoint.x >= 340 && mousePoint.x <= 460 && mousePoint.y >=475 && mousePoint.y <= 545){
            onExitButton = true;
        }
        else onExitButton = false;

    }

    @Override
    public void click(MouseEvent e) {
        switch (e.getClickCount()){
            case 1: //hardcode
                System.out.println(e.getY() + "         " + e.getLocationOnScreen().getX());
                if(e.getLocationOnScreen().getX() >= 625 && e.getLocationOnScreen().getX() <= 800
                        && e.getLocationOnScreen().getY() >= 465 && e.getLocationOnScreen().getY() <= 550)
                changeGameScene(GameSceneType.PLAY);
                else if(e.getLocationOnScreen().getX() >= 625 && e.getLocationOnScreen().getX() <= 800
                        && e.getLocationOnScreen().getY() >= 570 && e.getLocationOnScreen().getY() <= 640)
                    GameConfig.getInst().checkOutGame = true;
                break;
        }
    }
}
