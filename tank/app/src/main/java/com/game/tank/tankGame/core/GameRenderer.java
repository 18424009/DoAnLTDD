package com.game.tank.tankGame.core;

import android.graphics.Bitmap;

public class GameRenderer {
    private boolean drawHudEnabled=true;
    private Bitmap background;
    public static int xOffset=0;
    public static int yOffset=0;

    // Converts a pixel position to a tile position.
    public static int pixelsToTiles(int pixels, int bit_size) {
        // use shifting to get correct values for negative pixels
        return pixels >> bit_size;
        // or, for tile sizes that aren't a power of two,
        // use the floor function: return (int)Math.floor((float)pixels / TILE_SIZE);
    }

    // Converts a tile position to a pixel position.
    public static int tilesToPixels(int numTiles, int bit_size) {
        // no real reason to use shifting here. it's slighty faster, but doesn't add up to much
        // on modern processors.
        return numTiles << bit_size;
        // use this if the tile size isn't a power of 2:
        //return numTiles * TILE_SIZE;
    }

    
}
