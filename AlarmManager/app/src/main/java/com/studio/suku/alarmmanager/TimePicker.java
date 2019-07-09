package com.studio.suku.alarmmanager;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;

import java.util.Calendar;

public class TimePicker extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //Firstly Get The Date From Calendar
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.HOUR_OF_DAY;
        int minute = calendar.MINUTE;
        //And Then Return TimePickerDialog Herer
        return new TimePickerDialog(getActivity(), (TimePickerDialog.OnTimeSetListener) getActivity(),
                hour, minute, android.text.format.DateFormat.is24HourFormat(getActivity()));
    }

}
