package com.tb.tanks.tankGame.objects.tank;

import android.graphics.PointF;

import com.tb.tanks.tankGame.core.TankSoundManager;
import com.tb.tanks.tankGame.core.animation.Animation;

public class Bullet {
    private static final int ANIM_TIME = 125;
    private String id;
    private float speed = 800.1f;
    private Animation idleBullet;
    private boolean isVisible = false;
    private boolean beforeVisible = false;

    public Bullet(TankSoundManager soundManager) {

        PointF[] points = new PointF[4];
        points[0] = new PointF(-9, -18);
        points[1] = new PointF(6, -18);

        points[3] = new PointF(-9, 10);
        points[2] = new PointF(6, 10);
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        beforeVisible = isVisible;
        isVisible = visible;
    }

    public boolean isBeforeVisible() {
        return beforeVisible;
    }

}
