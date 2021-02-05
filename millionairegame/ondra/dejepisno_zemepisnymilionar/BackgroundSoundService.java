package com.millionairegame.ondra.dejepisno_zemepisnymilionar;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import java.util.Random;

public class BackgroundSoundService extends Service {
    private static final String TAG = null;
    MediaPlayer player;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onLowMemory() {
    }

    public void onStart(Intent intent, int i) {
    }

    public void onStop() {
    }

    public IBinder onUnBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        int nextInt = new Random().nextInt(3) + 1;
        if (nextInt == 1) {
            this.player = MediaPlayer.create(this, C1760R.raw.musicjedna);
        } else if (nextInt == 2) {
            this.player = MediaPlayer.create(this, C1760R.raw.musicdva);
        } else {
            this.player = MediaPlayer.create(this, C1760R.raw.music3);
        }
        this.player.setLooping(true);
        this.player.setVolume(100.0f, 100.0f);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        this.player.start();
        return 2;
    }

    public void onPause() {
        this.player.stop();
    }

    public void onResume() {
        this.player.start();
    }

    public void onDestroy() {
        this.player.stop();
        this.player.release();
    }
}
