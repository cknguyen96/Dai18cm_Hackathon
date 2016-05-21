package com.Dai18cm.gamescene;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by Admin on 5/16/2016.
 */
public abstract class GameScene {
    private GameSceneListener gameSceneListener;
    public void setGameSceneListener(GameSceneListener gameSceneListener) {
        this.gameSceneListener = gameSceneListener;
    }

    protected void changeGameScene(GameSceneType gameSceneType) {
        if(gameSceneListener != null) {
            gameSceneListener.changeGameScence(gameSceneType);
        }
    }

    public abstract void onKeyPress(KeyEvent e);
    public abstract void onKeyRelease(KeyEvent e);

    public abstract void run(Point mousePoint);

    public abstract void paint(Graphics g);

    public abstract void onMouse(Point mousePoint);

    public abstract void click(MouseEvent e);
}
