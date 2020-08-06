package com.game.tank.tankGame.core;

import android.graphics.Bitmap;

import java.util.ArrayList;
import com.tb.tanks.framework.gfx.AndroidGame;

public class GameLoader {
    private ArrayList<Bitmap> plain;
    private Bitmap[] plainTiles;


    private Bitmap block_wall;
    private Bitmap block_256x128;
    private Bitmap block_128x128;
    private Bitmap rock_02_128x128;
    private Bitmap well_128x128;
    private Bitmap building_A_512x512;

    private AndroidGame gameActivity;
    private boolean togglePlatform_velocity=false;
    private int backGroundImageIndex=0;
    private ArrayList<String> infoPanels;

    public GameLoader(AndroidGame activity) {
        this.gameActivity=activity;

        block_wall = TankResourceManager.loadImage("tiles/Block_A_02.png");
        block_256x128 = TankResourceManager.loadImage("tiles/Block_C_01.png");
        block_128x128 = TankResourceManager.loadImage("tiles/Block_C_02.png");
        rock_02_128x128 = TankResourceManager.loadImage("tiles/Rock_02_128x128.png");
        well_128x128 = TankResourceManager.loadImage("tiles/Well_128x128.png");
        building_A_512x512 = TankResourceManager.loadImage("tiles/Building_A_512x512.png");
        infoPanels =new ArrayList<String>();


    }
}
