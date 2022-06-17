package com.example.lab7_many_dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onCloseButtonClick(View view)
    {
        String[] mI = {"Томаты","Курица","Шампиньоны","Маслины"};//массив со значениями
        final boolean[] mSelectedI = {false,false,false,false};//массив с хранением выбора

        AlertDialog.Builder bl = new AlertDialog.Builder(MainActivity.this);
        bl.setTitle("Выберите инградиенты для своей пиццы")
                .setIcon(R.drawable.pizza)
                .setCancelable(false)
                .setMultiChoiceItems(mI, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        mSelectedI[i] = b;
                    }
                })
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        })
                .setNegativeButton("OТМЕНА",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
        AlertDialog alert = bl.create();
        alert.show();
    }
}