package com.Dai18cm.gamescene;

import com.Dai18cm.Utils;
import com.Dai18cm.models.GameConfig;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by Admin on 5/16/2016.
 */
public class MenuGameScene extends GameScene {

    Image backgoundImage;
    private boolean onStartButton = false;
    private boolean onExitButton = false;
    private boolean onAboutButton = false;
    Image starButton;
    Image exitButton;
    Image aboutButton;

    public MenuGameScene(){
        this.backgoundImage = Utils.loadImage("resources/background.png");
        starButton = Utils.loadImage("resources/play.png");
        exitButton = Utils.loadImage("resources/exit2.png");
        aboutButton = Utils.loadImage("resources/about1.png");
    }

    @Override
    public void onKeyPress(KeyEvent e) {

    }

    @Override
    public void onKeyRelease(KeyEvent e) {

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
        if(onAboutButton == true){
            g.drawImage(this.aboutButton, 0, 510, 125, 135, null);
        }
    }

    @Override
    public void onMouse(Point mousePoint) {
        if(mousePoint.x >= 340 && mousePoint.x < 460 && mousePoint.y >= 390 && mousePoint.y <= 460){
            onStartButton = true;
        }
        else onStartButton = false;
        if(mousePoint.x >= 340 && mousePoint.x <= 460 && mousePoint.y >=475 && mousePoint.y <= 545){
            onExitButton = true;
        }
        else onExitButton = false;
        if(mousePoint.x >= 10 && mousePoint.x <= 130 && mousePoint.y >=550 && mousePoint.y <= 585){
            onAboutButton = true;
        }
        else onAboutButton = false;

    }

    @Override
    public void click(MouseEvent e) {
        switch (e.getClickCount()){
            case 1: //hardcode
                System.out.println(e.getX() + "         " + e.getY());
                if(e.getX() >= 340 && e.getX() <= 460
                        && e.getY() >= 390 && e.getY() <= 460)
                changeGameScene(GameSceneType.PLAY);
                else if(e.getX() >= 340 && e.getX() <= 460
                        && e.getY() >= 475 && e.getY() <= 545)
                    GameConfig.getInst().checkOutGame = true;
                else if(e.getX() >= 10 && e.getX() <= 130
                        && e.getY() >= 550 && e.getY() <= 585)
                    changeGameScene(GameSceneType.ABOUT);
                break;
        }
    }
}
