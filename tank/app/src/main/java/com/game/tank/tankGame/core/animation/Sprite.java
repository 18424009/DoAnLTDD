package com.game.tank.tankGame.core.animation;

import android.graphics.Canvas;
import android.graphics.Matrix;

public class Sprite extends Animatible {

    protected float x;
    protected float y;
    protected float dx;
    protected float dy;

    protected float degree = 0;
    protected float firstDegree = 0;

    public Sprite() {
        this(0, 0);
    }

    public Sprite(int x, int y) {
        this.x = x;
        this.y = y;
        dx = 0;
        dy = 0;
    }

    public void draw(Canvas g, float x, float y) {
        Matrix matrix = new Matrix();
        matrix.postTranslate(-currentAnimation().getImage().getWidth() / 2, -currentAnimation().getImage().getHeight() / 2);
        matrix.postRotate(degree);
        matrix.postTranslate(x, y);
        //g.drawBitmap(Bitmap.createBitmap(currentAnimation().getImage(), 0, 0, currentAnimation().getImage().getWidth(), currentAnimation().getImage().getHeight(), matrix, true), x, y, null);
        g.drawBitmap(currentAnimation().getImage(), matrix, null);
    }

}
