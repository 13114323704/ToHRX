package com.hq.tohrx.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.hq.tohrx.R;

/**
 * Created by 黄庆 on 2018/2/14.
 */

public class MusicService extends Service {
    private MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int operate = intent.getIntExtra("operate", 0);

        switch (operate) {
            case 0:
                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.music_bg);
                    if (!mediaPlayer.isPlaying()) {
                        mediaPlayer.start();
                    }
                } else if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start();

                }else if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    mediaPlayer = null;
                }

                break;
            default:
                break;
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
