package com.example.iorxan.tictactoeandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Launcher launcher = new Launcher();
    Button a1, a2, a3, b1, b2, b3, c1, c2, c3;
    Button[] buttons;
    boolean win = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a1 = (Button) findViewById(R.id.btn1);
        a2 = (Button) findViewById(R.id.btn2);
        a3 = (Button) findViewById(R.id.btn3);
        b1 = (Button) findViewById(R.id.btn4);
        b2 = (Button) findViewById(R.id.btn5);
        b3 = (Button) findViewById(R.id.btn6);
        c1 = (Button) findViewById(R.id.btn7);
        c2 = (Button) findViewById(R.id.btn8);
        c3 = (Button) findViewById(R.id.btn9);

        buttons = new Button[]{a1, a2, a3, b1, b2, b3, c1, c2, c3};
        for (Button button : buttons) {
            button.setOnClickListener(this);
        }
    }

    public void buttonPlayer(Button button) {
        if (launcher.player1 == 1) {
            button.setText("X");
            launcher.player1 = 2;
            button.setClickable(false);
        }
        else {
            button.setText("O");
            launcher.player1 = 1;
            button.setClickable(false);
        }
        winner();
    }

    public void checkHorizontalLine() {
        if (a1.getText().equals(a2.getText()) && a2.getText().equals(a3.getText()) && !a1.isClickable()) {
            win = true;
        }
        else if (b1.getText().equals(b2.getText()) && b2.getText().equals(b3.getText()) && !b1.isClickable()) {
            win = true;
        }
        else if (c1.getText().equals(c2.getText()) && c2.getText().equals(c3.getText()) && !c1.isClickable()) {
            win = true;
        }
    }

    public void checkVerticalLine() {
        if (a1.getText().equals(b1.getText()) && b1.getText().equals(c1.getText()) && !a1.isClickable()) {
            win = true;
        }
        else if (a2.getText().equals(b2.getText()) && b2.getText().equals(c2.getText()) && !a2.isClickable()) {
            win = true;
        }
        else if (a3.getText().equals(b3.getText()) && b3.getText().equals(c3.getText()) && !a3.isClickable()) {
            win = true;
        }
    }

    public void checkDiagonal() {
        if (a1.getText().equals(b2.getText()) && b2.getText().equals(c3.getText()) && !a1.isClickable()) {
            win = true;
        }
        else if (a3.getText().equals(b2.getText()) && b2.getText().equals(c1.getText()) && !a3.isClickable()) {
            win = true;
        }
    }


    public void winner() {
        checkHorizontalLine();
        checkVerticalLine();
        checkDiagonal();

        if (win) {
            if (launcher.player1 == 2) {
                Toast.makeText(getApplicationContext(), "WINNER IS : X", Toast.LENGTH_LONG).show();
            }
            else if (launcher.player1 == 1) {
                Toast.makeText(getApplicationContext(), "WINNER IS : O", Toast.LENGTH_LONG).show();
            }
            disable();
        }
    }

    public void disable() {
        for (Button button : buttons) {
            button.setClickable(false);
        }
    }

    public void enable() {
        for (Button button : buttons) {
            button.setClickable(true);
            button.setText("");
        }
    }

    public void newGame(View view) {
        Intent intent = new Intent(this, Launcher.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        buttonPlayer(button);
    }

}
