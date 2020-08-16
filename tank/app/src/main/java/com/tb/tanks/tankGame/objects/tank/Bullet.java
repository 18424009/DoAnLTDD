package com.tb.tanks.tankGame.objects.tank;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;


import com.tb.tanks.physic.RecBody2D;
import com.tb.tanks.tankGame.core.TankResourceManager;
import com.tb.tanks.tankGame.core.TankSoundManager;
import com.tb.tanks.tankGame.core.animation.Animation;
import com.tb.tanks.tankGame.core.animation.Sprite;
import com.tb.tanks.tankGame.core.tile.TileMap;
import com.tb.tanks.tankGame.particles.FireShotImpact;

public class Bullet extends Sprite {
    private static final int ANIM_TIME = 125;
    private String id;
    private float speed = 800.1f;
    private Animation idleBullet;
    private RecBody2D bodyToHit2D;
    private boolean isVisible = false;
    private boolean beforeVisible = false;
    private FireShotImpact fireShotImpact;

    public Bullet(TankSoundManager soundManager) {

        super(0, 0);

        PointF[] points = new PointF[4];
        points[0] = new PointF(-9, -18);
        points[1] = new PointF(6, -18);

        points[3] = new PointF(-9, 10);
        points[2] = new PointF(6, 10);

        bodyToHit2D = new RecBody2D(points, new PointF(0, 0), this.degree);

        idleBullet = new Animation(ANIM_TIME).addFrame(TankResourceManager.Bullet1);
        setAnimation(idleBullet);
        fireShotImpact = new FireShotImpact(soundManager);
        this.setDegree(0.f);
    }

    public RecBody2D getBodyToHit2D() {
        return bodyToHit2D;
    }

    public void setBodyToHit2D(RecBody2D bodyToHit2D) {
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

}
