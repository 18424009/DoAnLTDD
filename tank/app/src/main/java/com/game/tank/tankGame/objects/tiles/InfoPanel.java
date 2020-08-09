package com.game.tank.tankGame.objects.tiles;

import android.graphics.Color;

public class InfoPanel {
    protected int borderColor = Color.BLACK, bgColorNormal = Color.LTGRAY;
    protected int bgColorFocused = Color.DKGRAY, foreColor = Color.BLACK;
    protected int borderWidth = 2;

    private String info[];
    private int width=0, height;

    public InfoPanel(int pixelX, int pixelY, String info) {
        info="Tank";
        this.info=info.split(";");
        height=24;//backPanel.getHeight();
        for (String s:this.info){
            if (width<s.length()*8)width=s.length()*8;
        }
        width=width+16;
        height=this.info.length*12+8;

    }

    public String[] getInfo() {
        return info;
    }

}
