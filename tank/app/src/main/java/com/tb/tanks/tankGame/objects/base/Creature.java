package com.tb.tanks.tankGame.objects.base;

import com.tb.tanks.tankGame.core.TankSoundManager;
import com.tb.tanks.tankGame.core.animation.CollidableObject;
import com.tb.tanks.tankGame.core.tile.TileMap;


public class Creature extends CollidableObject {


    public static int WAKE_UP_VALUE_DOWN_RIGHT = 30;

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

    /**
     * @effects Creates a new Creature at the given pixelX, pixelY position that is capable
     * of producing sounds from the soundManager.
     *
     * True: Collidable, Alive, Sleeping, Flipped.
     * False: OnScreen, Item, Platform, Relevant.
     */
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

    /**
     * @return true if this creature is a Platform, false otherwise.
     */
    public boolean isPlatform() {
        return isPlatform;
    }

    /**
     * @modifies the platform status of this Creature.
     */
    public void setIsPlatform(boolean isPlatform) {
        this.isPlatform = isPlatform;
    }

    /**
     * @return true if this creature is an Item, false otherwise.
     */
    public boolean isItem() {
        return isItem;
    }

    /**
     * @modifies the item status of this Creature (items do not collide with other items/ creatures ex. mushroom).
     */
    public void setIsItem(boolean isItem) {
        this.isItem = isItem;
    }

    /**
     * @return true if this creature is flipped, false otherwise.
     */
    public boolean isFlipped() {
        return isFlipped;
    }

    /**
     * @modifies the flipped status of this Creature.
     */
    public void setIsFlipped(boolean isFlipped) {
        this.isFlipped = isFlipped;
    }

    /**
     * @return true if this creature is sleeping, false otherwise.
     */
    public boolean isSleeping() {
        return isSleeping;
    }

    /**
     * @modifies the sleeping status of this creature to false.
     */
    public void wakeUp() {
        isSleeping = false;
    }

    /**
     * @modifies the sleeping status of this creature to false.
     * @param isLeft true if creative should begin moving left
     */
    public void wakeUp(boolean isLeft) {
        isSleeping = false;
    }

    /**
     * @return true if this creature is alive, false otherwise.
     */
    public boolean isAlive() {
        return isAlive;
    }

    /**
     * @modifies the life state of this creature (alive or dead) to dead.
     */
    public void kill() {
        isAlive = false;
    }

    /**
     * @return true if this creature is a Platform, false otherwise.
     */
    public boolean isAlwaysRelevant() {
        return isAlwaysRelevant;
    }

    /**
     * @modifies the platform status of this Creature.
     */
    public void setIsAlwaysRelevant(boolean isAlwaysRelevant) {
        this.isAlwaysRelevant = isAlwaysRelevant;
    }

    /**
     * @return true if this creature is invisible, false otherwise.
     */
    public boolean isInvisible() {
        return isInvisible;
    }

    /**
     * @modifies the invisible status of this Creature.
     */
    public void setIsInvisible(boolean isInvisible) {
        this.isInvisible = isInvisible;
    }


    public void jumpedOn() { }
    public void flip() { }

    /**
     * checks if two overlapping creatures actually collide or not (if their
     * velocity of approach is positive they are said to be collided else they are separating from each other)
     * @param c
     * @return
     */
    private boolean xCollideWithCreature(Creature c){
        if (x<c.getX()){
            if (dx-c.dx>0) return true;
        }else{
            if (c.dx-dx>0) return true;
        }
        return false;

    }
}
