package com.Dai18cm.gamescene;

import com.Dai18cm.Utils;
import com.Dai18cm.models.GameConfig;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by Admin on 5/16/2016.
 */
public class GameOverScene extends GameScene {
    private Image backgroundImage;
    public GameOverScene(){
        backgroundImage = Utils.loadImage("resources/background_gameover.png");
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
    }

    @Override
    public void onMouse(Point mousePoint) {

    }

    @Override
    public void click(MouseEvent e) {
        switch (e.getClickCount()){
            case 1:
                changeGameScene(GameSceneType.MENU);
                break;
        }
    }
}
