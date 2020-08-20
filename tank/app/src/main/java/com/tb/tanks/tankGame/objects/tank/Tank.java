package com.tb.tanks.tankGame.objects.tank;


import android.graphics.Canvas;
import android.graphics.PointF;

import com.tb.tanks.physic.RecBody2D;
import com.tb.tanks.tankGame.core.TankResourceManager;
import com.tb.tanks.tankGame.core.TankSoundManager;
import com.tb.tanks.tankGame.core.animation.Animation;
import com.tb.tanks.tankGame.core.animation.Sprite;
import com.tb.tanks.tankGame.core.tile.TileMap;
import com.tb.tanks.tankGame.objects.tiles.HealthBar;
import com.tb.tanks.tankGame.particles.Explosion;
import com.tb.tanks.tankGame.particles.FireShotFlame;
import com.tb.tanks.tankGame.util.PlayerDefine;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Stack;

import static com.tb.tanks.ConnectionP2P.P2PMessage.*;

public class Tank extends Sprite {

    private static final int STARTING_X = 25;
    private static final int STARTING_Y = 140;
    private static final float STARTING_DY = .03f;
    private static final int STARTING_LIFE = 3;
    private static final int ANIM_TIME = 125;
    public TileMap map;
    /*boolean variable to identify if fireball is to be fired*/

    private boolean isRotate = false;

    /* INITIAL_JUMP_HEIGHT + dx*JUMP_MULTIPLIER */

    /* Boolean variables used to identify which keys are pressed. */
    private boolean isDownHeld, isRightHeld, isLeftHeld, isShiftHeld, isSpaceHeld;
    /* Boolean variables used to identify where Mario is with respect to Platforms. */
    private boolean isRightOfPlatform, isLeftOfPlatform, isBelowPlatform, isAbovePlatform;
    /* Boolean variables used to identify where Mario is with respect to Slopes. */
    private boolean isUpSlope, isDownSlope, onSlopedTile;
    /* Boolean variables used to identify the state of Mario. */
    private boolean isJumping, frictionLock, isInvisible;

    /* Animation variables. */
    private Animation idleTank;

    private int health;
    /*boolean which keeps track of size of mario*/
    private boolean small = false;
    private boolean hasFire = false;
    private boolean isAlive = true;
    private RecBody2D bodyToMove2D;
    private RecBody2D bodyToHit2D;
    public boolean isLevelClear = false;
    private Stack<Bullet> bullets = new Stack<>();
    private ArrayList<FireShotFlame> fireShotFlames;
    private String playerID;
    private long startFire = 0;
    final static private long timeFire = 360;
    private HealthBar healthBar;
    private Explosion explosion;

    public Tank(TankSoundManager soundManager) {

        super(STARTING_X, STARTING_Y);
        dy = STARTING_DY;
        health = PlayerDefine.PLAYER_HEATH;
        this.setFirstDegree(90.f);
        //TankResourceManager.Tank = Bitmap.createScaledBitmap(TankResourceManager.Tank, 43, 64, true);
        PointF[] points = new PointF[4];
        points[0] = new PointF(-70, -95);
        points[1] = new PointF(70, -95);

        points[3] = new PointF(-35, 55);
        points[2] = new PointF(35, 55);

        bodyToMove2D = new RecBody2D(points, new PointF(STARTING_X, STARTING_Y), this.degree);

        PointF[] points2 = new PointF[4];
        points2[0] = new PointF(-65, -90);
        points2[1] = new PointF(65, -90);

        points2[3] = new PointF(-65, 90);
        points2[2] = new PointF(65, 90);

        bodyToHit2D = new RecBody2D(points2, new PointF(STARTING_X, STARTING_Y), this.degree);

        healthBar = new HealthBar(soundManager);

        healthBar.setMaxHealth(this.health);
        healthBar.setHealthCurrent(this.health);

        explosion = new Explosion(soundManager);

        fireShotFlames = new ArrayList<FireShotFlame>();

        this.setDegree(0.f);

        idleTank = new Animation(ANIM_TIME).addFrame(TankResourceManager.Tank);
        setAnimation(idleTank);

    }

    public HealthBar getHealthBar() {
        return healthBar;
    }

    public Explosion getExplosion() {
        return explosion;
    }

    public Stack<Bullet> getBullets() {
        return bullets;
    }

    public RecBody2D getBodyToMove2D() {
        return bodyToMove2D;
    }

    public RecBody2D getBodyToHit2D() {
        return bodyToHit2D;
    }

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
        for (Bullet bll : bullets) {
            bll.setId(playerID);
        }
    }

    public ArrayList<FireShotFlame> getFireShotFlames() {
        return fireShotFlames;
    }

    @Override
    public void setX(float x) {
        super.setX(x);
        bodyToMove2D.setParentX(x);
        bodyToHit2D.setParentX(x);
        healthBar.setX(x);
        explosion.setX(x);

        for (FireShotFlame fireShotFlame : fireShotFlames) {
            //if (!fireShotFlame.isVisible()) {
            float rdi = (float) Math.toRadians(degree);
            float s = (float) Math.sin(rdi);
            float c = (float) Math.cos(rdi);
            float xnew = 0 * c + (getHeight() - 50) * s;
            fireShotFlame.setX(x + xnew);
            fireShotFlame.setDegree(degree);
            break;
            //}
        }
    }

    @Override
    public void setY(float y) {
        super.setY(y);
        bodyToMove2D.setParentY(y);
        bodyToHit2D.setParentY(y);
        healthBar.setY(y);
        explosion.setY(y);

        for (FireShotFlame fireShotFlame : fireShotFlames) {
            //if (!fireShotFlame.isVisible()) {
            float rdi = (float) Math.toRadians(degree);
            float s = (float) Math.sin(rdi);
            float c = (float) Math.cos(rdi);
            float ynew = 0 * s - (getHeight() - 50) * c;
            fireShotFlame.setY(y + ynew);
            fireShotFlame.setDegree(degree);
            break;
            // }
        }

    }

    @Override
    public void setDegree(float degree) {
        super.setDegree(degree);
        bodyToMove2D.setAngle(degree);
        bodyToHit2D.setAngle(degree);
        explosion.setDegree(degree);

        for (FireShotFlame fireShotFlame : fireShotFlames) {
            //if (!fireShotFlame.isVisible()) {
            float rdi = (float) Math.toRadians(degree);
            float s = (float) Math.sin(rdi);
            float c = (float) Math.cos(rdi);
            float xnew = 0 * c + (getHeight() - 50) * s;
            float ynew = 0 * s - (getHeight() - 50) * c;
            fireShotFlame.setX(x + xnew);
            fireShotFlame.setY(y + ynew);
            fireShotFlame.setDegree(degree);
            break;
            //}
        }
    }

    public boolean isSmall() {
        return small;
    }

    @Override
    public void draw(Canvas g, float x, float y, float offsetX, float offsetY) {
        if(isAlive) {
            draw(g, x + offsetX, y + offsetY);
            bodyToMove2D.draw(g, x, y);
            bodyToHit2D.draw(g, x, y);
        }
    }

    public void setIsRotate(boolean rotate) {
        this.isRotate = rotate;
    }

    public boolean isRotate() {
        return this.isRotate;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
        healthBar.setHealthCurrent(health);
        if(health <=0){
            if(isAlive) explosion.setVisible(true);
            isAlive = false;

        }
        else isAlive = true;
    }


    public void resetHealth() {
        this.health = STARTING_LIFE;
    }

    public boolean isInvisible() {
        return isInvisible;
    }

    public String fire() {
        return "{playerID: " + this.getPlayerID() + ", isFire: true, TYPE_MESSAGE: "+ MESSAGE_PLAYER_INPUT_FIRE +"}" ;
    }

    public void setAnimation(Animation newAnim) {
        super.setAnimation(newAnim);
    }


    public void update(TileMap map, float time) {
        if(isAlive) {
            update(map, time, false);

            for (FireShotFlame fireShotFlame : fireShotFlames) {
                if (!fireShotFlame.isVisible()) {
                    fireShotFlame.setDegree(degree);
                }
                fireShotFlame.update((int) time);
            }

            bodyToMove2D.Update();
            bodyToHit2D.Update();
        }
    }

    public void update(TileMap map, float time, boolean lockInput) {

    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }


    private void GameOver() {
        // TODO Auto-generated method stub

    }

    private void StageClear() {
        // TODO Auto-generated method stub
        this.isLevelClear = true;
        //isSystemDriven=false;
    }
}

