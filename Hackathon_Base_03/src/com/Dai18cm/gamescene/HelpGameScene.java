package com.Dai18cm.gamescene;

import com.Dai18cm.Utils;
import com.Dai18cm.models.GameConfig;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by Admin on 5/21/2016.
 */
public class HelpGameScene extends GameScene {
    Image backgroundImage;
    private boolean onBackButton = false;
    Image backButton;
    public HelpGameScene(){
        backgroundImage = Utils.loadImage("resources/background_help.png");
        backButton = Utils.loadImage("resources/back2.png");
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
        g.drawImage(backgroundImage, 0, 10,
                GameConfig.DEFAULT_SCREEN_WIDTH,
                GameConfig.DEFAULT_SCREEN_HEIGHT,
                null
        );
        if(onBackButton == true){
            g.drawImage(this.backButton, 0, 530, 140, 70, null);
        }
    }

    @Override
    public void onMouse(Point mousePoint) {
        if(mousePoint.x >= 0 && mousePoint.x <= 150 && mousePoint.y >= 520 && mousePoint.y <= 570){
            onBackButton = true;
        }
        else onBackButton = false;
    }

    @Override
    public void click(MouseEvent e) {
        if(e.getX() >= 0 && e.getX() <= 150
                && e.getY() >= 520 && e.getY() <= 570)
            changeGameScene(GameSceneType.MENU);
    }
}
