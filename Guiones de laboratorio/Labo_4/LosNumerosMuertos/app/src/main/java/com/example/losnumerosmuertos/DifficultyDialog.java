package com.example.losnumerosmuertos;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DifficultyDialog extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        String[] levels = {"Fácil (3 dígitos, 10 intentos)", "Medio (4 dígitos, 8 intentos)", "Difícil (5 dígitos, 6 intentos)"};

        builder.setTitle("Selecciona un nivel")
                .setIcon(R.drawable.ic_stat_name)
                .setItems(levels, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getActivity(), GameActivity.class);
                        intent.putExtra("difficulty", which);
                        startActivity(intent);
                    }
                });

        return builder.create();

    }
}
