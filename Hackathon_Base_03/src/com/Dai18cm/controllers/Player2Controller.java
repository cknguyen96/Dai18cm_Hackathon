package com.Dai18cm.controllers;

import com.Dai18cm.models.GameConfig;
import com.Dai18cm.models.GameVector;
import com.Dai18cm.models.Player;
import com.Dai18cm.views.GameDrawer;
import com.Dai18cm.views.ImageDrawer;

import java.awt.*;
import java.util.Vector;

/**
 * Created by Admin on 5/21/2016.
 */
public class Player2Controller extends PlayerController implements Colliable {

    private boolean inBuff = false;

    private Vector<GiftController> giftControllerVector = new Vector<GiftController>();

    private Player2Controller(Player gameObject, GameDrawer gameDrawer, GameVector gameVecto) {
        super(gameObject, gameDrawer, gameVecto);
    }

    private Player2Controller(Player gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
    }

    private static Player2Controller inst;
    public static Player2Controller getInst() {
        Player2Controller player2Controller = null;
        if (inst == null) {
            Player player = new Player(200, 510, Player.DEFAULT_WIDTH , Player.DEFAULT_HEIGHT);
            ImageDrawer imageDrawer = new ImageDrawer("resources/condom.png");
            player2Controller = new Player2Controller(player, imageDrawer);
        }
        return player2Controller;
    }

    @Override
    public void run() {
        Rectangle rectangle = this.gameObject.getNextRect(this.gameVector);
        if (GameConfig.getInst().isInScreen(rectangle) && this.getGameObject().isAlive() == true) {
            if (this.inBuff == true) outBuff();
            super.run();
        }
    }

    @Override
    public void paint(Graphics g) {
        this.gameDrawer.paint(this.gameObject, g);
    }
}
