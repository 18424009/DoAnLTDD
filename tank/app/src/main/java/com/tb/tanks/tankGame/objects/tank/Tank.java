package com.game.tanks.tankGame.objects.tank;

import android.graphics.PointF;
import com.game.tanks.tankGame.core.TankSoundManager;
import com.game.tanks.tankGame.core.animation.Animation;
import java.util.Stack;

public class Tank {

    private static final int STARTING_X = 25;
    private static final int STARTING_Y = 140;
    private static final float STARTING_DY = .03f;
    private static final int STARTING_LIFE = 3;
    private static final int ANIM_TIME = 125;
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
    public boolean isLevelClear = false;
    private Stack<Bullet> bullets = new Stack<>();
    private String playerID;
    private long startFire = 0;
    final static private long timeFire = 360;

    public Tank(TankSoundManager soundManager) {
        //TankResourceManager.Tank = Bitmap.createScaledBitmap(TankResourceManager.Tank, 43, 64, true);
        PointF[] points = new PointF[4];
        points[0] = new PointF(-70, -95);
        points[1] = new PointF(70, -95);

        points[3] = new PointF(-35, 55);
        points[2] = new PointF(35, 55);


        PointF[] points2 = new PointF[4];
        points2[0] = new PointF(-65, -90);
        points2[1] = new PointF(65, -90);

        points2[3] = new PointF(-65, 90);
        points2[2] = new PointF(65, 90);

    }

    public Stack<Bullet> getBullets() {
        return bullets;
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


    public boolean isSmall() {
        return small;
    }

    public boolean getHasFire() {
        return hasFire;
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

    public void resetHealth() {
        this.health = STARTING_LIFE;
    }

    public boolean isInvisible() {
        return isInvisible;
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

