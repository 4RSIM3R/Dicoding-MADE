package com.studio.suku.alarmmanager;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AlarmReceiver extends BroadcastReceiver {
    public static final String TYPE_ONE_TIME = "OneTimeAlarm";
    public static final String TYPE_REPEATING = "RepeatingAlarm";
    public static final String EXTRA_MESSAGE = "message";
    public static final String EXTRA_TYPE = "type";

    //Buat Id untuk Tanda ID
    private final int ID_ONE_TIME = 101;
    private final int ID_REPEAT = 100;


    //Counstructor Class
    public AlarmReceiver(){

    }

    @Override
    public void onReceive(Context context, Intent intent) {

        String type = intent.getStringExtra(EXTRA_TYPE);
        String message = intent.getStringExtra(EXTRA_MESSAGE);

        String title = type.equalsIgnoreCase(TYPE_ONE_TIME) ? TYPE_ONE_TIME : TYPE_REPEATING;
        int notifId = type.equalsIgnoreCase(TYPE_ONE_TIME) ? ID_ONE_TIME : ID_REPEAT;

        showToast(context, title, message);

    }

    private void showToast(Context context, String title, String message){
        String toast = title + " : " + message;
        Toast.makeText(context, toast, Toast.LENGTH_SHORT).show();
    }

    public void setOneTimeAlarm(Context context, String type, String date, String time,
    String message){

        String DateFormat = "yyyy-MM-dd";
        String TimeFormat = "HH:mm";

        if (isDateInValid(date, DateFormat) || isDateInValid(time, TimeFormat)) return;

        //Kita panggil Alarm manager nya
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(context, AlarmReceiver.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        intent.putExtra(EXTRA_TYPE, type);

        Log.e("ONE TIME", date + " " + time);
        String dateArray[] = date.split("-");
        String timeArray[] = time.split(":");

        //Kita Masuk Ke Kalender
        Calendar calendar = Calendar.getInstance();
        //Ini Buat Tahun, Bulan dan tanggal/Harinya
        calendar.set(Calendar.YEAR, Integer.parseInt(dateArray[0]));
        calendar.set(Calendar.MONTH, Integer.parseInt(dateArray[1]) - 1);
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateArray[2]));
        //Ini buat jam nya
        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeArray[0]));
        calendar.set(Calendar.MINUTE, Integer.parseInt(timeArray[1]));
        calendar.set(Calendar.SECOND, 0);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, ID_ONE_TIME, intent, 0);

        if (alarmManager != null){
            alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        }

        Toast.makeText(context, "One time alarm set up", Toast.LENGTH_SHORT).show();


    }

    public boolean isDateInValid(String date, String format){
        try {
            DateFormat df = new SimpleDateFormat(format, Locale.getDefault());
            df.setLenient(false);
            df.parse(date);
            return false;
        }catch (ParseException e){
            return true;
        }
    }

    //Ini Fungsi Buat Notifikasi
    private void showAlarmNotification(Context context, String title, String message, int notifId){

        String CHANNEL_ID = "Channel_1";
        String CHANNEL_NAME = "AlarmManager channel";

        NotificationManager notificationManagerCompat = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        //Ini Buat Ringtone
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        //Builder Notifkasi nya
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_check_black_24dp)
                .setContentTitle(title)
                .setContentText(message)
                .setColor(ContextCompat.getColor(context, android.R.color.transparent))
                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000})
                .setSound(alarmSound);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT
            );

            channel.enableVibration(true);
            channel.setVibrationPattern(new long[]{1000, 1000, 1000, 1000, 1000});

            builder.setChannelId(CHANNEL_ID);

            if (notificationManagerCompat != null) {
                notificationManagerCompat.createNotificationChannel(channel);
            }

        }

        Notification notification = builder.build();
        if (notificationManagerCompat != null) {
            notificationManagerCompat.notify(notifId, notification);
        }



    }
}
