package com.tb.tanks.tankGame.objects.tiles;

import android.graphics.Bitmap;
import android.graphics.Point;

public class SlopedTile {

    private Point startingPoint;
    private Point endingPoint;
    private boolean hasPositiveSlope;

    public SlopedTile(int pixelX, int pixelY, Bitmap img, boolean hasPositiveSlope) {

        this.hasPositiveSlope = hasPositiveSlope;

        if(hasPositiveSlope) {
            startingPoint = new Point(pixelX, pixelY + 15);
            endingPoint = new Point(pixelX + 16, pixelY - 1);
        } else {
            startingPoint = new Point(pixelX, pixelY);
            endingPoint = new Point(pixelX + 16, pixelY + 14);
        }
    }

    public Point getStartingPoint() {
        return startingPoint;
    }

    public Point getEndingPoint() {
        return endingPoint;
    }

    public boolean hasPositiveSlope() {
        return hasPositiveSlope;
    }

}
