package com.example.losnumerosmuertos;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ExitReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // Cancelar la notificación antes de cerrar la app
        int id = intent.getIntExtra("id", -1);
        if (id != -1) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.cancel(id);
        }

        System.exit(0);
    }
}
