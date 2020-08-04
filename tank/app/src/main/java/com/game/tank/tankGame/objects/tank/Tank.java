package com.game.tank.tankGame.objects.tank;

import android.graphics.PointF;

import java.util.ArrayList;
import java.util.Stack;

public class Tank {
    private static final int STARTING_X = 25;
    private static final int STARTING_Y = 140;
    private static final float STARTING_DY = .03f;
    private static final int STARTING_LIFE = 3;
    private static final int ANIM_TIME = 125;

    private boolean isRotate = false;

    private int health;
    private boolean small = false;
    private boolean hasFire = false;
    private boolean isAlive = true;
    private com.tb.tanks.physic.RecBody2D bodyToMove2D;
    private com.tb.tanks.physic.RecBody2D bodyToHit2D;
    public boolean isLevelClear = false;
    private String playerID;
    private long startFire = 0;
    final static private long timeFire = 360;
    private com.tb.tanks.tankGame.particles.Explosion explosion;

    public Tank() {

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
}
