package com.game.tank.tankGame.core.animation;

import android.graphics.Bitmap;

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

    /**
     * Add a frame to the animation with the default animation length milliseconds.
     * @modifies defaultAnimLength == duration.
     * @returns this Animation with the added frame.
     */
    public Animation addFrame(Bitmap image) {
        totalDuration += defaultAnimLength;
        frames.add(new AnimFrame(image, totalDuration));
        return this;
    }

    /**
     * Add a frame to the animation with a given duration in milliseconds.
     * @modifies defaultAnimLength == duration.
     * @returns this Animation with the added frame.
     */
    public Animation addFrame(Bitmap image, long duration) {
        totalDuration += duration;
        frames.add(new AnimFrame(image, totalDuration));
        defaultAnimLength = duration;
        return this;
    }

    /**
     * Starts this animation.
     */
    public void start() {
        animTime = 0;
        currFrameIndex = 0;
    }

    public int getCurrFrameIndex() {
        return currFrameIndex;
    }

    public void setCurrFrameIndex(int currFrameIndex) {
        this.currFrameIndex = currFrameIndex;
    }

    public long getAnimTime() {
        return animTime;
    }

    public void setAnimTime(long animTime) {
        this.animTime = animTime;
    }

    /**
     * @return the height of the current animation in pixels.
     */
    public int getHeight() {
        return getFrame(currFrameIndex).image.getHeight();
    }

    /**
     * @return the width of the current animation in pixels.
     */
    public int getWidth() {
        return getFrame(currFrameIndex).image.getWidth();
    }

    /**
     * Updates the animation by a give amount of time.
     * The frames are updated accordingly to the internal timer of this animation.
     */
    public void update(long elapsedTime) {

        if (frames.size() > 1) { // must have at least 2 frames to animate
            animTime += elapsedTime; // animation time increase here

            if (animTime >= totalDuration) { //reset animation
                animTime = 0;
                currFrameIndex = 0; // back to first frame
                endOfAnimationAction();

            }

            if(animTime > getFrame(currFrameIndex).endTime) {
                currFrameIndex++;
            }
        }
    }

    /**
     * Override this method to add an action when animation finishes its entire duration.
     */
    public void endOfAnimationAction() { }

    /**
     * @return an array of the images in this animation.
     * note: this method is never called.
     */
    public Bitmap[] getImages() {
        if(frames.size() == 0) {
            return null;
        } else {
            return (Bitmap[]) frames.toArray();
        }
    }

    /**
     * @return the Image of the current frame of this animation.
     */
    public Bitmap getImage() {
        if (frames.size() == 0) {
            return null;
        }
        else {
            return getFrame(currFrameIndex).image;
        }
    }

    /**
     * @return the Image of the current frame of this animation.
     */
    public boolean setImage(Bitmap img) {
        if (frames.size() == 0) {
            return false;
        }
        else {
            getFrame(currFrameIndex).image = img;
            return true;
        }
    }

    /**
     * @return the AnimFrame of the given frame.
     * This is used in update to get the end time of the current frame.
     */
    private AnimFrame getFrame(int i) {
        return frames.get(i);
    }

    /**
     * An inner class used to help manage timing of each frame in the animation.
     */
    private class AnimFrame {

        Bitmap image;
        long endTime; // the totalDuration up to the end of this frame
        // is the endTime for this frame

        public AnimFrame(Bitmap image, long endTime) {
            this.image = image;
            this.endTime = endTime;
        }
    }

}
