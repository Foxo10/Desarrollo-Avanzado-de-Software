package com.example.tema5;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class ExitDialogFragment extends DialogFragment {
    ExitDialogFragment.ListenerExitDialog miListener;
    public interface ListenerExitDialog{
        void onExitConfirmed();
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        miListener = (ListenerExitDialog) getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("El título del dialog");
        builder.setMessage("¿Deseas salir de la aplicación?");

        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (miListener != null){
                    miListener.onExitConfirmed();
                }

            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }


}
