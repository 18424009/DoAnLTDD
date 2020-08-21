package com.tb.tanks.tankGame.objects.base;

import android.graphics.Point;
import android.graphics.RectF;

import com.tb.tanks.tankGame.core.TankSoundManager;
import com.tb.tanks.tankGame.core.animation.CollidableObject;
import com.tb.tanks.tankGame.core.animation.Sprite;
import com.tb.tanks.tankGame.core.tile.GameTile;
import com.tb.tanks.tankGame.core.tile.TileMap;


public class Creature extends CollidableObject {

    protected static int xCollideOffset = 2;
    protected static int offMapOffset = 15;
    protected static float GRAVITY = .0007f; //0.0008f
    protected float gravityEffect = .20f;

    public static int WAKE_UP_VALUE_DOWN_RIGHT = 30;
    public static int WAKE_UP_VALUE_UP_LEFT = -3;

    private boolean isAlwaysRelevant;
    private boolean isAlive;
    private boolean isSleeping;
    private boolean isFlipped;
    private boolean isItem;
    private boolean isPlatform;
    private boolean isInvisible;
    protected float gravityFactor=1;
    protected boolean inWater=false;
    public static TileMap map;

    public Creature() {
        this(0, 0, null);
    }

    public Creature(int pixelX, int pixelY) {
        this(pixelX, pixelY, null);
    }

    public Creature(int pixelX, int pixelY, TankSoundManager soundManager) {
        super(pixelX, pixelY, soundManager);
        setIsCollidable(true);
        isAlive = true;
        isSleeping = true;
        isFlipped = false;
        setIsOnScreen(false);
        isItem = false;
        isPlatform = false;
        isAlwaysRelevant = false;
    }


    public boolean isPlatform() {
        return isPlatform;
    }


    public void setIsPlatform(boolean isPlatform) {
        this.isPlatform = isPlatform;
    }

    public boolean isItem() {
        return isItem;
    }

    public void setIsItem(boolean isItem) {
        this.isItem = isItem;
    }

    public boolean isFlipped() {
        return isFlipped;
    }

    public void setIsFlipped(boolean isFlipped) {
        this.isFlipped = isFlipped;
    }

    public boolean isSleeping() {
        return isSleeping;
    }

    public void wakeUp() {
        isSleeping = false;
    }

    public void wakeUp(boolean isLeft) {
        isSleeping = false;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void kill() {
        isAlive = false;
    }

    public boolean isAlwaysRelevant() {
        return isAlwaysRelevant;
    }

    public void setIsAlwaysRelevant(boolean isAlwaysRelevant) {
        this.isAlwaysRelevant = isAlwaysRelevant;
    }

    public boolean isInvisible() {
        return isInvisible;
    }

    public void setIsInvisible(boolean isInvisible) {
        this.isInvisible = isInvisible;
    }

    public void jumpedOn() { }
    public void flip() { }

    // for tile collisions
    public void xCollide(Point p) {
        if(dx > 0) {
            x = x - xCollideOffset;
        } else {
            x = x + xCollideOffset;
        }
        dx = -dx;
    }

    // for creature collisions
    public void creatureXCollide() {
        if(dx > 0) {
            x = x - xCollideOffset;
        } else {
            x = x + xCollideOffset;
        }
        dx = -dx;
    }

    public static Collision tileCollisionX(GameTile tile, Sprite s) {
        if(s.getX() > tile.getPixelX()) {
            return Collision.WEST;
        } else {
            return Collision.EAST;
        }
    }

    public static Collision tileCollisionY(GameTile tile, Sprite s) {
        if(s.getY() < tile.getPixelY()) {
            return Collision.NORTH;
        } else {
            return Collision.SOUTH;
        }
    }

    public void updateCreature(TileMap map, int time) {

    }
    protected void useAI(TileMap map) {
		/* don't let it go beyond mapfall
		if (x <= 0 || x > map.getWidth() * 16) {
			this.xCollide(null);
		}
		*/
    }

    public void creatureCollision(Creature creature) {

    }

    private boolean xCollideWithCreature(Creature c){
        if (x<c.getX()){
            if (dx-c.dx>0) return true;
        }else{
            if (c.dx-dx>0) return true;
        }
        return false;

    }

    public float getGravityFactor() {
        return gravityFactor;
    }

    public void setGravityFactor(float gravityFactor) {
        this.gravityFactor = gravityFactor;
    }

    private String getBonusInfo(int creatureHitCount){
        return "INCREDIBLE !!!";

    }

    void coll(){
        RectF a = new RectF (0,0,3,3);
        RectF  b = new RectF (1,0,3,3);
        a.intersect(b);
    }


}
