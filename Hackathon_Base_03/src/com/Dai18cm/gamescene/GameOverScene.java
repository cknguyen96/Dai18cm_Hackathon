package com.Dai18cm.gamescene;

import com.Dai18cm.Utils;
import com.Dai18cm.models.GameConfig;
import com.Dai18cm.models.Status;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by Admin on 5/16/2016.
 */
public class GameOverScene extends GameScene {
    public static boolean isHighestScore = false;
    private Image backgroundImage;
    public GameOverScene(){
        backgroundImage = Utils.loadImage("resources/background_gameover.png");
    }

    @Override
    public void onKeyPress(KeyEvent e) {

    }

    @Override
    public void onKeyRelease(KeyEvent e) {

    }

    @Override
    public void run(Point mousePoint) {

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(backgroundImage, 0, 0,
                GameConfig.DEFAULT_SCREEN_WIDTH,
                GameConfig.DEFAULT_SCREEN_HEIGHT,
                null
        );
        if(isHighestScore == true){
            g.setFont(new Font("TimesRoman",Font.PLAIN, 20));
            g.drawString("NEW HIGH SCORE: " + Status.highestScore , 30 , 60);
        } else {
            g.setFont(new Font("TimesRoman",Font.PLAIN, 20));
            g.drawString("HIGH SCORE: " + Status.highestScore , 30 , 60);
            g.drawString("SCORE: " + Status.playerScore , 30 , 90);
        }
    }

    @Override
    public void onMouse(Point mousePoint) {

    }

    @Override
    public void click(MouseEvent e) {
        switch (e.getClickCount()){
            case 1:
                this.isHighestScore = false;
                changeGameScene(GameSceneType.MENU);
                break;
        }
    }
}
