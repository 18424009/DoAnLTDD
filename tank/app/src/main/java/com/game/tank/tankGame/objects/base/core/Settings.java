package com.game.tank.tankGame.objects.base.core;

import android.content.Context;
import android.view.KeyEvent;

public class Settings {
    private static final float ORIENTATION_DEAD_ZONE_MIN = 0.03f;
    private static final float ORIENTATION_DEAD_ZONE_MAX = 0.1f;
    private static final float ORIENTATION_DEAD_ZONE_SCALE = 0.75f;

    // Raw trackball input is filtered by this value. Increasing it will
    // make the control more twitchy, while decreasing it will make the control more precise.
    private final static float ROLL_FILTER = 0.4f;
    private final static float ROLL_DECAY = 8.0f;

    private final static float KEY_FILTER = 0.25f;
    private final static float SLIDER_FILTER = 0.25f;


    public static boolean soundEnabled = true;
    public static boolean musicEnabled = true;

    public static int soundVolume = 50;
    public static int musicVolume = 50;
    public static int tiltSensitivity = 50;
    public static int movementSensitivity = 50;

    public static int mLeftKeyCode = KeyEvent.KEYCODE_DPAD_LEFT;
    public static int mRightKeyCode = KeyEvent.KEYCODE_DPAD_RIGHT;
    public static int mJumpKeyCode = KeyEvent.KEYCODE_SPACE;
    public static int mAttackKeyCode = KeyEvent.KEYCODE_SHIFT_LEFT;

    public static  boolean mUseClickButtonForAttack = true;
    public static  boolean mUseOrientationForMovement = false;
    public static  boolean mUseOnScreenControls = false;

    public static int[] highScores = new int[] { 0, 0, 0, 0, 0 ,0,0,0,0,0};
    public  static int[] recodTimes =new int[] { 10000, 10000, 10000, 10000, 10000 ,10000,10000,10000,10000,10000};

    public final static String file = ".supermario";

    private static int score=0;
    private static int lives=0;
    private static int time=0;
    private static int coins=0;
    private static int levelsUnlocked=0;
    private static int worldsUnlocked=0;
    private static Context context;
    private static Tank tank;
    
    public static int getWorldsUnlocked() {
        return worldsUnlocked;
    }

    public static void setWorldsUnlocked(int worldsUnlocked) {
        Settings.worldsUnlocked = worldsUnlocked;
    }
    public static int level = 1;
    public static int world = 1;

    public static final int COIN_BONUS=100;
    public static final int GOOMBA_BONUS=300;
    public static final int KOOPA_BONUS=500;
    public static final int LIFE_BONUS=1000;

    public static float accelerometerSenseFactor=1;
}
