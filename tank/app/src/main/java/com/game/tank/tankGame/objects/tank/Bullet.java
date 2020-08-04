package com.game.tank.tankGame.objects.tank;

import android.graphics.Canvas;
import android.graphics.Matrix;

public class Bullet {
    private static final int ANIM_TIME = 125;
    private String id;
    private float speed = 800.1f;
    private com.tb.tanks.physic.RecBody2D bodyToHit2D;
    private boolean isVisible = false;
    private boolean beforeVisible = false;
    private com.tb.tanks.tankGame.particles.FireShotImpact fireShotImpact;

    public com.tb.tanks.physic.RecBody2D getBodyToHit2D() {
        return bodyToHit2D;
    }

    public void setBodyToHit2D(com.tb.tanks.physic.RecBody2D bodyToHit2D) {
        this.bodyToHit2D = bodyToHit2D;
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

    public com.tb.tanks.tankGame.particles.FireShotImpact getFireShotImpact() {
        return fireShotImpact;
    }

}
