package test.dahun.mobileplay.services;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NotificationIntentService extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        int music_index = intent.getExtras().getInt("music_index");
        boolean is_play = intent.getExtras().getBoolean("is_play");

        switch (intent.getExtras().getInt("id")){
            case -1:
                if(music_index == 0){
                    music_index = 7;
                } else{
                    music_index--;
                }
                music_stop(context, music_index);
                music_play(context, music_index);
                break;
            case 0:
                if(is_play){
                    music_pause(context);
                } else{
                    music_play(context, music_index);
                }
                break;
            case 1:
                if(music_index == 7){
                    music_index = 0;
                } else{
                    music_index++;
                }
                music_stop(context, music_index);
                music_play(context, music_index);
                break;
            case 9:
                manager.cancel(9);
                break;
        }

    }

    public void music_stop(Context context, int music_index){
        Intent intent_service_stop = new Intent(context, MusicService.class);
        intent_service_stop.putExtra("index", music_index);
        intent_service_stop.putExtra("state", "stop");
        context.startService(intent_service_stop);
    }

    public void music_play(Context context, int music_index){
        Intent intent_service_play = new Intent(context, MusicService.class);
        intent_service_play.putExtra("index", music_index);
        intent_service_play.putExtra("state", "play");
        context.startService(intent_service_play);
    }

    public void music_pause(Context context){
        Intent intent_service_play = new Intent(context, MusicService.class);
        intent_service_play.putExtra("state", "pause");
        context.startService(intent_service_play);
    }

}
