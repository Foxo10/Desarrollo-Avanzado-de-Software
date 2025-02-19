package com.example.losnumerosmuertos;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class NotificationHelper {
    private static final String CHANNEL_ID = "game_notifications";
    private static final int NOTIFICATION_ID = 1;
    public static void createNotificationChannel(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            if (notificationManager.getNotificationChannel(CHANNEL_ID) == null) {
                NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Notificaciones del Juego", NotificationManager.IMPORTANCE_DEFAULT);
                channel.setDescription("Canal para notificaciones de victoria en el juego");
                notificationManager.createNotificationChannel(channel);
            }
        }
    }
    public static void showWinNotification(Context context, int attemptsUsed) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        // Intent para jugar de nuevo
        Intent restartIntent = new Intent(context, MainActivity.class);
        restartIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        restartIntent.putExtra("id", NOTIFICATION_ID); // Enviar el ID de la notificación
        PendingIntent restartPendingIntent = PendingIntent.getActivity(context, 0, restartIntent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        // Intent para cerrar la app
        Intent exitIntent = new Intent(context, ExitReceiver.class);
        exitIntent.putExtra("id", NOTIFICATION_ID); // Enviar el ID de la notificación
        PendingIntent exitPendingIntent = PendingIntent.getBroadcast(context, 0, exitIntent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        // Construcción de la notificación
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("¡Has ganado!")
                .setContentText("Número acertado en " + attemptsUsed + " intentos.")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true) // Permite que la notificación se cancele automáticamente
                .addAction(android.R.drawable.ic_menu_revert, "Jugar de nuevo", restartPendingIntent)
                .addAction(android.R.drawable.ic_menu_close_clear_cancel, "Cerrar juego", exitPendingIntent);

        // Mostrar la notificación
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

}
