package com.game.tank.tankGame.core.tile;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;

import com.game.tank.tankGame.objects.tank.Tank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TileMap {

    // fields
    private GameTile[][] tiles;
    private List<Creature> creatures; // Starts containing every Creature and decreases as they die.
    private List<Creature> relevantCreatures; // List of relevant Creatures to the current frame.
    // This is a subset of creatures.
    private List<Creature> creaturesToAdd; // List of Creatures to be added inbetween frames.
    private List<GameTile> animatedTiles;
    private List<SlopedTile> slopedTiles;
    private Tank player;
    private Tank playerOther;
    private boolean visible =true;
    private ArrayList<Point> bookMarks;
    private List<Rect> waterZones; // List of Water Zones.

    /**
     * Constructs a new TileMap with the specified width and height (in number of tiles)
     * of the map.
     */
    public TileMap(int width, int height) {
        tiles = new GameTile[width][height];
        creatures = new LinkedList<Creature>();
        relevantCreatures = new ArrayList<Creature>();
        creaturesToAdd = new ArrayList<Creature>();
        animatedTiles = new ArrayList<GameTile>();
        slopedTiles = new ArrayList<SlopedTile>();
        bookMarks=new ArrayList<Point>();
        waterZones=new ArrayList<Rect>();

    }

    public GameTile[][] getTiles() {
        return tiles;
    }

    /**
     * @return the width of this TileMap in GameTiles.
     */
    public int getWidth() {
        return tiles.length;
    }

    /**
     * @return the height of this TileMap in GameTiles.
     */
    public int getHeight() {
        return tiles[0].length;
    }

    /**
     * @return the GameTiles at tiles[x][y]. If x or y is out of bounds
     * or if tiles[x][y] == null, null is returned.
     */
    public GameTile getTile(int x, int y) {
        if (x < 0 || x >= getWidth() || y < 0 || y >= getHeight()) {
            return null;
        } else {
            if(tiles[x][y] != null) {
                return tiles[x][y];
            } else {
                return null;
            }
        }
    }

    /**
     * @return the image of the GameTiles at tiles[x][y]. If x or y is out of bounds
     * or if tiles[x][y] == null, null is returned.
     */
    public Bitmap getImage(int x, int y) {
        if (x < 0 || x >= getWidth() || y < 0 || y >= getHeight()) {
            return null;
        } else {
            if(tiles[x][y] != null) {
                return tiles[x][y].getImage();
            } else {
                return null;
            }
        }
    }

    /**
     * Sets tiles[x][y] equal to parameter tile.
     * This is used to set animated GameTiles.
     */
    public void setTile(int x, int y, GameTile tile) {
        tiles[x][y] = tile;
    }

    /**
     * Sets tiles[x][y] equal to a new Tile with no animation and the constant Image img.
     * This is used to set non-animated GameTiles.
     */
    public void setTile(int x, int y, Bitmap img) {
        tiles[x][y] = new GameTile(x, y, null, img);
    }

    /**
     * @return the player sprite.
     */
    public Tank getPlayer() {
        return player;
    }

    public Tank getPlayerOther() {
        return playerOther;
    }

    public void clearBookMarks(){
        bookMarks.clear();
    }

    public void addBookMark(Point pt){
        bookMarks.add(pt);
    }
}
