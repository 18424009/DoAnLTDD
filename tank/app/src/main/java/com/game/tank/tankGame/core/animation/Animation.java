package com.game.tank.tankGame.core.animation;

import java.util.ArrayList;

public class Animation {

    // fields
    private ArrayList<AnimFrame> frames;
    private int currFrameIndex; // index of current frame
    private long animTime; // current time in animation
    private long totalDuration; // length of entire animation
    private long defaultAnimLength;

    /**
     * Constructs a new Animation object with no frames.
     */
    public Animation() {
        frames = new ArrayList<AnimFrame>();
        totalDuration = 0;
        defaultAnimLength = 0;
        start();
    }

    /**
     * Constructs a new Animation object with no frames and with the
     * specified default animation length;
     */
    public Animation(long defaultAnimLength) {
        frames = new ArrayList<AnimFrame>();
        totalDuration = 0;
        this.defaultAnimLength = defaultAnimLength;
        start();
    }

    /**
     * Sets the default animation length (DAL);
     * @return this Animation with the default animation length changed.
     */
    public Animation setDAL(long defaultAnimLength) {
        this.defaultAnimLength = defaultAnimLength;
        return this;
    }

}
