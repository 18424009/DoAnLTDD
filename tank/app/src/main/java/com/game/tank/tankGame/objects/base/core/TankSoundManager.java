package com.game.tank.tankGame.objects.base.core;

import android.app.Activity;
import com.tb.tanks.framework.sfx.AndroidAudio;

import java.util.Random;

public class TankSoundManager extends AndroidAudio {
    private static boolean firstTimeCreate = true;
    public static boolean musicEnabled=true;
    public static boolean soundEnabled=true;
    public TankSoundManager(Activity activity) {
        super(activity);
    }

    /**
     * loads resources in memory if resources are not already loaded
     */
    public  void loadResouces(){
        if (firstTimeCreate==true){
            bump = createSound("sounds/bump.wav");
            kick = createSound("sounds/kick.wav");
            coin = createSound("sounds/coin.wav");
            jump = createSound("sounds/jump.wav");
            pause = createSound("sounds/pause.wav");
            itemSprout = createSound("sounds/item_sprout.wav");
            bonusPoints = createSound("sounds/veggie_throw.wav");
            healthUp = createSound("sounds/power_up.wav");
            healthDown = createSound("sounds/power_down.wav");

            hurt1 = createSound("sounds/mario_ooh.wav");
            hurt2 = createSound("sounds/mario_oh.wav");
            yahoo1 = createSound("sounds/mario_waha.wav");
            yahoo2 = createSound("sounds/mario_woohoo.wav");
            brick_shatter=createSound("sounds/crack.wav");
            fireball=createSound("sounds/fireball.wav");
            die=createSound("sounds/die.wav");
            powerUp=createSound("sounds/power_up.wav");
            powerDown=createSound("sounds/power_down.wav");
            stage_clear=createSound("sounds/win_stage.wav");
            stage_begin=createSound("sounds/level_enter.wav");
            stomp=createSound("sounds/stomp.wav");
            gulp=createSound("sounds/gulp.wav");
            switchScreen=createSound("sounds/level_enter.wav");
            click=createSound("sounds/coin.wav");
        }
        firstTimeCreate=false;
    }

    /**
     * returns true if resources are ready (loaded in memory)
     * @return
     */
    public boolean isReady(){
        return !firstTimeCreate;
    }

    private void loadMusic(){
        //music=createMusic(filename);
        menuMusic=createMusic("music/smw_map.mid");//main_menu_music.midi");
        Random r = new Random();
        int rNum = r.nextInt(4);
        if(rNum == 0) {
            gameMusic=createMusic("music/smwovr2.mid");
        } else if(rNum == 1) {
            gameMusic=createMusic("music/smwovr1.mid");
        } else if(rNum == 2) {
            gameMusic=createMusic("music/smb_hammerbros.mid");
        } else  {
            gameMusic=createMusic("music/smrpg_nimbus1.mid");
        }
        if (menuMusic!=null)menuMusic.setLooping(true);
        if (gameMusic!=null){
            gameMusic.setLooping(true);
            music=menuMusic;
            if (musicEnabled && music!=null)music.play();
        }

    }
}
