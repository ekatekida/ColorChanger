package com.example.androidapp;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private ConstraintLayout bg;

    int blueColorValue = Color.BLUE;
    int redColorValue = Color.RED;
    int greenColorValue = Color.GREEN;
    Random rnd = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        bg = findViewById(R.id.main);
        btn.setOnClickListener(v ->{
            bg.setBackgroundColor(redColorValue);
            Log.d("ACTION", "red");
        });

        btn2.setOnClickListener(v ->{
            bg.setBackgroundColor(greenColorValue);
            Log.d("ACTION", "green");
        });

        btn3.setOnClickListener(v ->{
            bg.setBackgroundColor(blueColorValue);
            Log.d("ACTION", "blue");
        });

        btn4.setOnClickListener(v ->{
            int randomColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            bg.setBackgroundColor(randomColor);
            Log.d("ACTION", "randomColor");
        });
    }
}