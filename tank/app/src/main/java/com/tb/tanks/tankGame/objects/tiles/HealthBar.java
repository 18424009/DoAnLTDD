package com.tb.tanks.tankGame.objects.tiles;

import android.graphics.Bitmap;

import com.tb.tanks.tankGame.core.TankResourceManager;
import com.tb.tanks.tankGame.core.TankSoundManager;

public class HealthBar  {
    private static final int ANIM_TIME = 125;
    private String id;
    private Bitmap bgHeath;
    private Bitmap heathGreen;
    private boolean isVisible = true;
    private int HealthCurrent = 0;
    private int maxHealth = 0;

    private float scaleY = 1.f;
    private float scaleX = 1.f;

    public HealthBar(TankSoundManager soundManager) {

        bgHeath = TankResourceManager.bgHeath;
        heathGreen = TankResourceManager.heathGreen;

    }

    public String getId() {
        return id;
    }

    public int getHealthCurrent() {
        return HealthCurrent;
    }

    public void setHealthCurrent(int healthCurrent) {
        if(healthCurrent > 0) {
            HealthCurrent = healthCurrent;
            int delta = heathGreen.getWidth() - maxHealth;
            scaleX = (float) (healthCurrent + delta) / heathGreen.getWidth();
        }else{
            scaleX = 0.f;
        }
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }
    }

    public float getScaleY() {
        return scaleY;
    }

    public void setScaleY(float scaleY) {
        this.scaleY = scaleY;
    }

    public float getScaleX() {
        return scaleX;
    }

    public void setScaleX(float scaleX) {
        this.scaleX = scaleX;
    }

}
