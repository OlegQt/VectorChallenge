package com.example.surfviewvectors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.Button;

import com.example.surfviewvectors.engine.Engine;
import com.example.surfviewvectors.engine.Model;

public class MainActivity extends AppCompatActivity {
    Engine engine;

    SurfaceView surface;
    Button btbExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btbExit=findViewById(R.id.btb_exit);
        surface = findViewById(R.id.surface);
        engine=new Engine(surface);

        btbExit.setOnClickListener(view ->
        {
            onDestroy();
            finishAndRemoveTask();
            System.exit(0);
        });
    }

    @Override
    protected void onDestroy() {
        engine.stop(true);
        super.onDestroy();
    }

}