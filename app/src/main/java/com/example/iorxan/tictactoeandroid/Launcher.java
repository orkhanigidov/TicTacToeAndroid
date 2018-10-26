package com.example.iorxan.tictactoeandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Launcher extends Activity{

    public static int player1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launcher);
    }

    public void chooseX(View view) {
        player1 = 1;
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void chooseO(View view) {
        player1 = 2;
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
