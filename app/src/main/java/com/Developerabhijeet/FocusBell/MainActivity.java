package com.Developerabhijeet.FocusBell;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;




public class MainActivity extends AppCompatActivity {


    MediaPlayer player;
    private int secounds = 0;
    private boolean running;
    public String holdSelection;


    public NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runTimer();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannel();
            registerReceiver(broadcastReceiver, new IntentFilter("Start_something"));
            startService(new Intent(getBaseContext(), OnClearFromRecentService.class));

        }

        if (savedInstanceState != null) {

            secounds = savedInstanceState.getInt("secounds");
            running = savedInstanceState.getBoolean("running");


        }
    }

    public void onStartPlay() {

        running = true;
        CreateNotification.createNotificaton(MainActivity.this, running, holdSelection);

    }

    public void onStoppause() {
        running = false;
        CreateNotification.createNotificaton(MainActivity.this, running, holdSelection);

    }

    public void onReset() {
        running = false;

        CreateNotification.createNotificaton(MainActivity.this, running, holdSelection);

    }


    public void createChannel() {


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CreateNotification.CHANNEL_ID,
                    "Focus bell", NotificationManager.IMPORTANCE_DEFAULT);

            notificationManager = getSystemService(NotificationManager.class);
            if (notificationManager != null) {

                notificationManager.createNotificationChannel(channel);
            }


        }

    }

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getExtras().getString("actionname");

            switch (action) {
                case CreateNotification.ACTION_PLAY:

                    if (running) {
                        onStoppause();

                    } else {
                        onStartPlay();
                    }
                    break;
                case CreateNotification.ACTION_STOP:
                    if (running == false) {
                        onStartPlay();
                    }
                    break;


            }


        }

    };

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("secounds", secounds);
        outState.putBoolean("running", running);
    }


    public void onClickStart(View view) {


        running = true;
        onStartPlay();


    }


    public void onClickStop(View view) {
        running = false;
        stopplayer();
        onStoppause();

    }

    private void stopplayer() {
        if (player != null) {
            player.release();
            player = null;
        }

    }

    public void onClickReset(View view) {
        running = false;
        secounds = 0;
        onReset();
    }

    private void runTimer() {

        final TextView timeview = (TextView) findViewById(R.id.CurrentTimeShower);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                Spinner TimeDurationContainer = (Spinner) findViewById(R.id.TimeDurationType);
                String TimeSelected = String.valueOf(TimeDurationContainer.getSelectedItem());


                int hours = secounds / 3600;
                int min = (secounds % 3600) / 60;
                int secs = secounds % 60;


                String CurrentTime = String.format("%d:%02d:%02d", hours, min, secs);


                timeview.setText(CurrentTime);

                if (running) {
                    secounds++;

                }


                handler.postDelayed(this, 1000);


                if (TimeSelected.equals("1min")) {

                    holdSelection = "After Every - 1 min a bell will ring";

                    if (secounds % 60 == 0 && running == true) {

                        playForPariticularTime();
                    }
                } else if (TimeSelected.equals("2min")) {

                    holdSelection = "After Every - 2 min a bell will ring";

                    if (secounds % 120 == 0 && running == true) {

                        playForPariticularTime();
                    }
                } else if (TimeSelected.equals("5min")) {

                    holdSelection = "After Every - 5 min a bell will ring";

                    if (secounds % (60 * 5) == 0 && running == true) {

                        playForPariticularTime();
                    }
                } else if (TimeSelected.equals("10min")) {

                    holdSelection = "After Every - 10 min a bell will ring";

                    if (secounds % (60 * 10) == 0 && running == true) {

                        playForPariticularTime();
                    }
                } else if (TimeSelected.equals("15min")) {

                    holdSelection = "After Every - 15 min a bell will ring";

                    if (secounds % (60 * 15) == 0 && running == true) {

                        playForPariticularTime();
                    }
                } else if (TimeSelected.equals("20min")) {

                    holdSelection = "After Every - 20 min a bell will ring";

                    if (secounds % (60 * 20) == 0 && running == true) {

                        playForPariticularTime();
                    }
                } else if (TimeSelected.equals("25min")) {

                    holdSelection = "After Every - 25 min a bell will ring";

                    if (secounds % (60 * 25) == 0 && running == true) {
                        playForPariticularTime();
                    }
                } else if (TimeSelected.equals("30min")) {

                    holdSelection = "After Every - 30 min a bell will ring";

                    if (secounds % (60 * 30) == 0 && running == true) {
                        playForPariticularTime();
                    }
                } else if (TimeSelected.equals("35min")) {

                    holdSelection = "After Every - 35 min a bell will ring";

                    if (secounds % (60 * 35) == 0 && running == true) {
                        playForPariticularTime();
                    }
                } else if (TimeSelected.equals("40min")) {

                    holdSelection = "After Every - 40 min a bell will ring";

                    if (secounds % (60 * 40) == 0 && running == true) {
                        playForPariticularTime();
                    }
                } else if (TimeSelected.equals("45min")) {

                    holdSelection = "After Every - 45 min a bell will ring";


                    if (secounds % (60 * 45) == 0 && running == true) {
                        playForPariticularTime();
                    }
                } else if (TimeSelected.equals("50min")) {

                    holdSelection = "After Every - 35 min a bell will ring";


                    if (secounds % (60 * 50) == 0 && running == true) {
                        playForPariticularTime();
                    }
                } else if (TimeSelected.equals("55min")) {

                    holdSelection = "After Every - 55 min a bell will ring";


                    if (secounds % (60 * 55) == 0 && running == true) {
                        playForPariticularTime();
                    }
                } else if (TimeSelected.equals("60min")) {

                    holdSelection = "After Every - 60 min a bell will ring";


                    if (secounds % (60 * 60) == 0 && running == true) {
                        playForPariticularTime();
                    }
                }


            }
        });

    }

    protected void onStop() {
        super.onStop();
        stopplayer();
    }

    public void playForPariticularTime() {

        if (player == null) {

            player = MediaPlayer.create(this, R.raw.bell1);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopplayer();
                }
            });
        }
        player.start();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.cancelAll();
        }
        unregisterReceiver(broadcastReceiver);
    }
}