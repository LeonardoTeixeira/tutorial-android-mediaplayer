package br.com.leonardoteixeira.tutorialmediaplayer;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MediaPlayer mp;

    private Button btnDog;
    private Button btnCat;
    private Button btnHorse;
    private Button btnCow;
    private Button btnPig;
    private Button btnRooster;
    private Button btnLion;
    private Button btnTurkey;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mp = new MediaPlayer();
    mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
        @Override
        public void onPrepared(MediaPlayer mp) {
            mp.start();
        }
    });

    btnDog = (Button) findViewById(R.id.btnDog);
    btnCat = (Button) findViewById(R.id.btnCat);
    btnHorse = (Button) findViewById(R.id.btnHorse);
    btnCow = (Button) findViewById(R.id.btnCow);
    btnPig = (Button) findViewById(R.id.btnPig);
    btnRooster = (Button) findViewById(R.id.btnRooster);
    btnLion = (Button) findViewById(R.id.btnLion);
    btnTurkey = (Button) findViewById(R.id.btnTurkey);

    btnDog.setOnClickListener(this);
    btnCat.setOnClickListener(this);
    btnHorse.setOnClickListener(this);
    btnCow.setOnClickListener(this);
    btnPig.setOnClickListener(this);
    btnRooster.setOnClickListener(this);
    btnLion.setOnClickListener(this);
    btnTurkey.setOnClickListener(this);
}


    @Override
    public void onClick(View v) {
        try {
            if (mp.isPlaying()) {
                mp.stop();
            }
            mp.reset();
            AssetFileDescriptor afd = null;
            switch (v.getId()) {
                case R.id.btnDog:
                    afd = getResources().openRawResourceFd(R.raw.dog);
                    break;
                case R.id.btnCat:
                    afd = getResources().openRawResourceFd(R.raw.cat);
                    break;
                case R.id.btnHorse:
                    afd = getResources().openRawResourceFd(R.raw.horse);
                    break;
                case R.id.btnCow:
                    afd = getResources().openRawResourceFd(R.raw.cow);
                    break;
                case R.id.btnPig:
                    afd = getResources().openRawResourceFd(R.raw.pig);
                    break;
                case R.id.btnRooster:
                    afd = getResources().openRawResourceFd(R.raw.rooster);
                    break;
                case R.id.btnLion:
                    afd = getResources().openRawResourceFd(R.raw.lion);
                    break;
                case R.id.btnTurkey:
                    afd = getResources().openRawResourceFd(R.raw.turkey);
                    break;
            }
            if (afd != null) {
                mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                mp.prepareAsync();
            }
        } catch (IOException e) {
            Log.e("", e.getMessage());
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mp.isPlaying()) {
            mp.stop();
        }
        mp.release();
    }
}
