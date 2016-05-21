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
    private boolean onHelpButton = false;
    Image starButton;
    Image exitButton;
    Image aboutButton;
    Image helpButton;

    public MenuGameScene(){
        this.backgoundImage = Utils.loadImage("resources/background.png");
        starButton = Utils.loadImage("resources/play.png");
        exitButton = Utils.loadImage("resources/exit2.png");
        aboutButton = Utils.loadImage("resources/about2.png");
        helpButton = Utils.loadImage("resources/help2.png");
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
            g.drawImage(this.aboutButton, 20, 510, 145, 70, null);
        }
        if(onHelpButton == true){
            g.drawImage(this.helpButton, 660, 510, 130, 70, null);
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
        if(mousePoint.x >= 20 && mousePoint.x <= 170 && mousePoint.y >=515 && mousePoint.y <= 575){
            onAboutButton = true;
        }
        else onAboutButton = false;
        if(mousePoint.x >= 660 && mousePoint.x <= 770 && mousePoint.y >=510 && mousePoint.y <= 580){
            onHelpButton = true;
        }
        else onHelpButton = false;

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
                else if(e.getX() >= 20 && e.getX() <= 170
                        && e.getY() >= 515 && e.getY() <= 575)
                    changeGameScene(GameSceneType.ABOUT);
                else if(e.getX() >= 660 && e.getX() <= 770
                        && e.getY() >= 510 && e.getY() <= 580)
                    changeGameScene(GameSceneType.HELP);
                break;
        }
    }
}
