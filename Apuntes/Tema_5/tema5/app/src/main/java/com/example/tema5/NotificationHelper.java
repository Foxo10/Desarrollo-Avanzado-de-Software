package com.example.tema5;

import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.app.NotificationManager;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class NotificationHelper {
    private static final String CHANNEL_ID = "fecha_notificacion";
    private static final int NOTIFICATION_ID = 1;
    public static void createNotificationChannel(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Canal de Fechas";
            String description = "Canal para notificaciones de selección de fecha";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);
        }
    }
    public static void showNotification(Context context, String fechaSeleccionada) {
        // Intent para abrir SecondActivity cuando se pulse la notificación
        Intent intent = new Intent(context, SecondActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        PendingIntent pendingIntent = PendingIntent.getActivity(
                context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
        );

        // Construcción de la notificación
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)  // Icono de la notificación
                .setContentTitle("Fecha seleccionada")
                .setContentText("Has seleccionado la fecha: " + fechaSeleccionada)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)  // Prioridad normal
                .setContentIntent(pendingIntent)  // Acción al pulsar
                .setVibrate(new long[]{0, 1000, 500, 1000})
                .setAutoCancel(true);  // Se elimina al pulsar

        // Obtener el NotificationManager y lanzar la notificación
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }
}
