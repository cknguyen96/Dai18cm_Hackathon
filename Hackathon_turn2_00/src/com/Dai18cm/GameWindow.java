package com.Dai18cm;

import com.Dai18cm.gamescene.*;
import com.Dai18cm.models.GameConfig;
import com.Dai18cm.models.Status;
import com.sun.corba.se.impl.protocol.giopmsgheaders.FragmentMessage_1_1;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;

/**
 * Created by Admin on 5/16/2016.
 */
public class GameWindow extends Frame implements Runnable, GameSceneListener{
    Image backgroundImage;
    Thread thread;
    Image backbufferedImage;
    GameScene gameScene;
    public GameWindow(){
        this.gameScene = new MenuGameScene();
        this.gameScene.setGameSceneListener(this);
        this.setLocation(300, 80);
        this.setVisible(true);
        this.setSize(GameConfig.DEFAULT_SCREEN_WIDTH, GameConfig.DEFAULT_SCREEN_HEIGHT);
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gameScene.click(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (true){
            try {
                Point mousePoint = MouseInfo.getPointerInfo().getLocation();

                mousePoint.x -= getLocationOnScreen().x;
                mousePoint.y -= getLocationOnScreen().y;

                gameScene.run(mousePoint);
                repaint();
                Thread.sleep(GameConfig.DEFAULT_THREAD_DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(Graphics g) {
        if(GameConfig.getInst().checkOutGame == true){
            System.exit(0);
        }
        if (backbufferedImage == null){
            backbufferedImage = new BufferedImage(GameConfig.DEFAULT_SCREEN_WIDTH,
                    GameConfig.DEFAULT_SCREEN_HEIGHT,
                    1
            );
        }
        Graphics backbufferedImageGraphics = backbufferedImage.getGraphics();
        this.gameScene.paint(backbufferedImageGraphics);
        g.drawImage(backbufferedImage, 0, 0,
                GameConfig.DEFAULT_SCREEN_WIDTH,
                GameConfig.DEFAULT_SCREEN_HEIGHT,
                null
        );
    }

    @Override
    public void changeGameScence(GameSceneType gameSceneType) {
        switch (gameSceneType){
            case MENU:
                this.gameScene = new MenuGameScene();
                this.gameScene.setGameSceneListener(this);
                break;
            case PLAY:
                this.gameScene = new PlayGameScene();
                this.gameScene.setGameSceneListener(this);
                //if(Status.getHp() <= 0) gameSceneManager = null;
                break;
            case GAME_OVER:
                this.gameScene = new GameOverScene();
                this.gameScene.setGameSceneListener(this);
                break;
        }
    }
}
