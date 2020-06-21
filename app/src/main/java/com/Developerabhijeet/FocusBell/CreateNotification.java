package com.Developerabhijeet.FocusBell;


import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.media.session.MediaSessionCompat;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class CreateNotification  {

    public static final String  CHANNEL_ID = "CHANNEL1";
    public static final String ACTION_PLAY = "actionplay";
    public static  final  String ACTION_STOP = "actionstop";


    public  static Notification notification;


    public static void createNotificaton(Context context,boolean running,String holdtime){


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
            MediaSessionCompat mediaSessionCompat = new MediaSessionCompat(context,"tag");
            Bitmap icon = BitmapFactory.decodeResource(context.getResources(),R.drawable.image);
            //int draw_play = 0;
            //int draw_stop = 0;
            int draw = 0;

            //PendingIntent pendingIntentplay;
            //PendingIntent pendingIntentStop;
            PendingIntent pendingIntent;
            if(running==true){
                //for play
                Intent intentPlay = new Intent(context, Notificationactionservice.class).setAction(ACTION_PLAY);
                pendingIntent = PendingIntent.getBroadcast(context,0,intentPlay,PendingIntent.FLAG_UPDATE_CURRENT);
                draw= R.drawable.ic_baseline_pause_24;

            }
            else{
                //for Stop
                Intent intentStop = new Intent(context, Notificationactionservice.class).setAction(ACTION_STOP);
                pendingIntent = PendingIntent.getBroadcast(context,0,intentStop,PendingIntent.FLAG_UPDATE_CURRENT);
                draw = R.drawable.ic_baseline_play_arrow_24;


            }




            notification = new NotificationCompat.Builder(context,CHANNEL_ID)
                    .setSmallIcon(R.drawable.timer2)
                    .setContentTitle("Stay Focused")
                    .setContentText("A Bell will ring to make you stay focused")
                    .setLargeIcon(icon)
                    .setShowWhen(false)

                    .setOnlyAlertOnce(true)

                    .addAction(draw,"Stop",pendingIntent)
                    .setStyle(new androidx.media.app.NotificationCompat.MediaStyle()
                            .setShowActionsInCompactView(0)
                            .setMediaSession(mediaSessionCompat.getSessionToken()))
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                    .build();

            notificationManagerCompat.notify(1,notification);




        }



    }


}
