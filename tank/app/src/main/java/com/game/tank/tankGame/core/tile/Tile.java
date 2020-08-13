package com.game.tank.tankGame.core.tile;

import android.graphics.Bitmap;

import com.game.tank.tankGame.core.animation.Animatible;
import com.game.tank.tankGame.core.animation.Animation;

public class Tile extends Animatible {

    // fields
    private int tileX;
    private int tileY;
    private float pixelX;
    private float pixelY;
    protected Bitmap img;

    public Tile(float pixelX, float pixelY, Animation anim, Bitmap img) {

        this.pixelX = pixelX;
        this.pixelY = pixelY;
        this.img = img;
        setAnimation(anim);
    }

    public Tile(int pixelX, int pixelY, Bitmap img) {
        this(pixelX, pixelY, null, img);
    }
}
