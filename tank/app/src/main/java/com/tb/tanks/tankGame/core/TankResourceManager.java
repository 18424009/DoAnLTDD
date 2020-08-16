package com.tb.tanks.tankGame.core;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

public class TankResourceManager
{
    //---------------------------------------------
    // VARIABLES
    //---------------------------------------------
    public static Activity activity;
    public static InputStream inputStream;
    public static BitmapFactory.Options options;

    private static boolean firstTimeCreate = true;

    //tank
    public static Bitmap Tank;
    public static Bitmap Bullet1;
    public static Bitmap[] FireShotImpacts;
    public static Bitmap[] FireShotFlames;
    public static Bitmap[] Explosions;
    public static Bitmap bgHeath;
    public static Bitmap heathGreen;


    //Background
    public static Bitmap Background;
    //splash
    public static Bitmap Splash;
    //menu
    public static Bitmap menu;
    //3stars
    public static Bitmap star3;
    // mario pic for main menu
    public static Bitmap marioPic;
    //grass


    //Hud
    public static  Bitmap[] fontSmall, fontMedium, fontLarge;


    public TankResourceManager(Activity pActivity)
    {
        activity=pActivity;
        options=new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
    }

    /**
     * loads resources in memory if resources are not already loaded
     */
    public  void loadResouces(){
        if (firstTimeCreate==true){
            options.inPreferredConfig = Bitmap.Config.ARGB_4444;
            //tank
            Tank = loadImage("tank/Tank_01_192x192.png");
            //bullet
            Bullet1 = loadImage("tank/bullet1.png");

            bgHeath= loadImage("health_bar/bghealth.png");
            heathGreen= loadImage("health_bar/health.png");

            LoadFireShotImpacts();
            LoadFireShotFlames();
            LoadExplosions();
        }
        firstTimeCreate=false;
    }

    public void LoadFireShotImpacts(){
        FireShotImpacts = new Bitmap[4];
        for(int i = 0; i < 4; i++){
            Bitmap fireShotImp = loadImage("fire_shot_impacts/Sprite_Fire_Shots_Impact_A_00"+ i +".png");
            FireShotImpacts[i] = fireShotImp;
        }
    }

    public void LoadExplosions(){
        Explosions = new Bitmap[9];
        for(int i = 0; i < 9; i++){
            Bitmap explosion = loadImage("explosions/Sprite_Effects_Explosion_00"+ i +".png");
            Explosions[i] = explosion;
        }
    }

    public void LoadFireShotFlames(){
        FireShotFlames = new Bitmap[4];
        for(int i = 0; i < 4; i++){
            Bitmap fireShotImp = loadImage("fire_shot_flames/Sprite_Fire_Shots_Shot_A_00"+ i +".png");
            FireShotFlames[i] = fireShotImp;
        }
    }

    //loads random background
    public static void loadBackground(int index){
        Background=loadImage("backgrounds/backgroundtank1.png");
    }


    public static Bitmap loadImage(String fileName)
    {
        try {
            Log.i("resource",fileName);
            inputStream = activity.getAssets().open(fileName);

            return BitmapFactory.decodeStream(inputStream, null, new BitmapFactory.Options());

        } catch (IOException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            Log.e("resource",e.getMessage()+fileName);
        }
        return null;
    }

    /** Horizontally flips img. */
    public static Bitmap horizontalFlip(Bitmap img) {
        /*
		int w = img.getWidth();
        int h = img.getHeight();
        Bitmap dimg = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas g = new Canvas(dimg);
        g.drawBitmap(img, new Rect(w, 0, 0, h),new Rect(0, 0, w, h), null);
        */
        return img;
    }

}