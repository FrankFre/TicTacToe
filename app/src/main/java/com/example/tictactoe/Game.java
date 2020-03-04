package com.example.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Game extends AppCompatActivity implements View.OnClickListener {

    Button f11, f12, f13, f21, f22, f23, f31, f32,f33;
    String xo = "X";
    int[][] gameStorage;
    private Object R;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    f11 = findViewById(R,id.field_1_1);
    f12 = findViewById(R,id.field_1_2);
    f13 = findViewById(R,id.field_1_3);
    f21 = findViewById(R,id.field_2_1);
    f22 = findViewById(R,id.field_2_2);
    f23 = findViewById(R,id.field_2_3);
    f31 = findViewById(R,id.field_3_1);
    f32 = findViewById(R,id.field_3_2);
    f33 = findViewById(R,id.field_3_3);

    f11.setOnClickListener(this);
    f12.setOnClickListener(this);
    f13.setOnClickListener(this);
    f21.setOnClickListener(this);
    f22.setOnClickListener(this);
    f23.setOnClickListener(this);
    f31.setOnClickListener(this);
    f32.setOnClickListener(this);
    f33.setOnClickListener(this);

    gameStorage = new int[3][3];
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.field_1_1:
                f11.setText(xo);
                handleInput(1, 1);
            break;

            case R.id.field_1_2:
                f12.setText(xo);
                handleInput(1, 2);
            break;

            case R.id.field_1_3:
                f13.setText(xo);
                handleInput(1, 3);
            break;

            case R.id.field_2_1:
                f21.setText(xo);
                handleInput(2, 1);
            break;

            case R.id.field_2_2:
                f22.setText(xo);
                handleInput(2, 2);
            break;

            case R.id.field_2_3:
                f23.setText(xo);
                handleInput(2, 3);
            break;

            case R.id.field_3_1:
                f31.setText(xo);
                handleInput(3, 1);
            break;

            case R.id.field_3_2:
                f32.setText(xo);
                handleInput(3, 2);
            break;

            case R.id.field_3_3:
                f33.setText(xo);
                handleInput(3, 3);
            break;

    }
}

private void handleInput(int x, int y){
    if (gameStorage[x-1][y-1] == 0) {
        if(xo.equals("X")){
                gameStorage[x-1][y-1] = 1;
                xo = "0";
            }  else  {
                gameStorage[x-1][y-1] = -1;
                xo = "X";
            }
        }
    if  (checkGameEnd()) {
            finishGame();
        }
    }

private boolean checkGameEnd(){
        return    (Math.abs(gameStorage[0][0] + gameStorage[0][1] + gameStorage[0][2]) == 3
                || Math.abs(gameStorage[1][0] + gameStorage[1][1] + gameStorage[1][2]) == 3
                || Math.abs(gameStorage[2][0] + gameStorage[2][1] + gameStorage[2][2]) == 3
                || Math.abs(gameStorage[0][0] + gameStorage[1][0] + gameStorage[2][0]) == 3
                || Math.abs(gameStorage[0][1] + gameStorage[1][1] + gameStorage[2][1]) == 3
                || Math.abs(gameStorage[0][2] + gameStorage[1][2] + gameStorage[2][2]) == 3
                || Math.abs(gameStorage[0][0] + gameStorage[1][1] + gameStorage[2][2]) == 3
                || Math.abs(gameStorage[0][2] + gameStorage[1][1] + gameStorage[2][0]) == 3);
        }

 private void finishGame()  {

        if (xo.equals("X")) {
                Toast.makeText(getApplicationContext(), "O gewinnt!",Toast.LENGTH_LONG).show();
        }   else   {
                Toast.makeText(getApplicationContext(), "X gewinnt!",Toast.LENGTH_LONG).show();
        }

        Intent intent = new Intent( this,Game.class);
        startActivity(intent);
        this.finsh();

    }
}
