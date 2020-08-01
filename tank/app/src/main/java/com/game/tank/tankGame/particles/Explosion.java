package com.tb.tanks.tankGame.particles;

import android.graphics.Canvas;
import android.graphics.Matrix;

import com.tb.tanks.tankGame.core.TankResourceManager;
import com.tb.tanks.tankGame.core.TankSoundManager;
import com.tb.tanks.tankGame.core.animation.Animation;
import com.tb.tanks.tankGame.core.animation.Sprite;

public class Explosion extends Sprite {
    private static final int ANIM_TIME = 40;
    private Animation idleExplosion;
    private boolean isVisible = false;
    private ShouldHide shouldHide;

    public Explosion(TankSoundManager soundManager) {
        super(0, 0);

        this.setDegree(0.f);
        idleExplosion = new Animation(ANIM_TIME);
        for (int i = 0; i < TankResourceManager.Explosions.length; i++) {
            idleExplosion.addFrame(TankResourceManager.Explosions[i]);
        }
        setAnimation(idleExplosion);
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public ShouldHide getShouldHide() {
        return shouldHide;
    }

    public void setShouldHide(ShouldHide shouldHide) {
        this.shouldHide = shouldHide;
    }

    @Override
    public void update(int time) {
    }

    public void shouldHide() {
    }

    @Override
    public void draw(Canvas g, float x, float y) {
    }

}
