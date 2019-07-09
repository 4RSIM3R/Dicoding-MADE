package com.studio.suku.alarmmanager;

import android.app.TimePickerDialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TimePickerDialog.OnTimeSetListener {

    Button setOnce;
    ImageButton date, time;
    TextView tvOnceDate, tvOnceTime;
    EditText edtOnceMessage;

    private AlarmReceiver alarmReceiver;

    final String DATE_PICKER_TAG = "DatePicker";
    final String TIME_PICKER_ONCE_TAG = "TimePickerOnce";
    final String TIME_PICKER_REPEAT_TAG = "TimePickerRepeat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        time = findViewById(R.id.btn_once_time);
        setOnce = findViewById(R.id.btn_set_once_alarm);

        edtOnceMessage = findViewById(R.id.edt_once_message);

        tvOnceTime = findViewById(R.id.tv_once_time);

        date.setOnClickListener(this);
        time.setOnClickListener(this);
        setOnce.setOnClickListener(this);

        alarmReceiver = new AlarmReceiver();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_once_time : {
                //Show The Dialog for tim picker Here
                DialogFragment timePicker = new TimePicker();
                timePicker.show(getSupportFragmentManager(), "This Is A Time Picker");
                break;
            }
            case R.id.btn_set_once_alarm : {
                String onceDate = tvOnceDate.getText().toString();
                String onceTime = tvOnceTime.getText().toString();
                String onceMessage = edtOnceMessage.getText().toString();
                //Panggil Fungsi Alarm
                alarmReceiver.setOneTimeAlarm(this, AlarmReceiver.TYPE_ONE_TIME, onceDate, onceTime, onceMessage);
                break;
            }
        }
    }


    public void onDialogDateSet(String tag, int year, int month, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, dayOfMonth);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        tvOnceDate.setText(dateFormat.format(calendar.getTime()));
    }


//    public void onDialogTimeSet(String tag, int hourOfDay, int minute) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
//        calendar.set(Calendar.MINUTE, minute);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
//        switch (tag) {
//            case TIME_PICKER_ONCE_TAG:
//                tvOnceTime.setText(dateFormat.format(calendar.getTime()));
//                break;
//            default:
//                break;
//        }
//    }

    @Override
    public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
        //And Then Set The Result To the textview
        String result = "Hour : " + hourOfDay + " Minute : " + minute;
        tvOnceTime = findViewById(R.id.tv_once_time);
        tvOnceTime.setText(result);
    }
}
