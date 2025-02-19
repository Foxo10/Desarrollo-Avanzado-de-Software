package com.example.tema5;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    DatePickerFragment.ListenerFechaDialog miListener;
    public interface ListenerFechaDialog{
        void onDateSelected(String date);
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        miListener = (DatePickerFragment.ListenerFechaDialog) getActivity();
        Calendar calendario=Calendar.getInstance();
        int anyo=calendario.get(Calendar.YEAR);
        int mes=calendario.get(Calendar.MONTH);
        int dia=calendario.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog= new DatePickerDialog(getActivity(),this, anyo,mes,dia);
        datePickerDialog.setCanceledOnTouchOutside(false);
        datePickerDialog.setCancelable(false);
        return datePickerDialog;
    }
    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        if (miListener != null) {
            String date = day + "/" + (month + 1) + "/" + year;
            miListener.onDateSelected(date);
        }
    }

}
