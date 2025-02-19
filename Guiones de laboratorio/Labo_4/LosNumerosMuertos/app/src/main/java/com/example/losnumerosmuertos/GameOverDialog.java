package com.example.losnumerosmuertos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class GameOverDialog extends DialogFragment {
    private String secretNumber;
    public GameOverDialog(String secretNumber) {
        this.secretNumber = secretNumber;
    }
    @Nullable
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setTitle("Fin del juego")
                .setMessage("Ohhhh! Se te han terminado los intentos.\nEl número era: " + secretNumber)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        requireActivity().finish();
                    }
                });
        return builder.create();
    }


}
