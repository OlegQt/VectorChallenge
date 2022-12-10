package com.example.surfviewvectors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.SurfaceView;

import com.example.surfviewvectors.engine.Engine;
import com.example.surfviewvectors.engine.Model;

public class MainActivity extends AppCompatActivity {
    Engine engine;

    SurfaceView surface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        surface = findViewById(R.id.surface);
        engine=new Engine(surface);
    }

    @Override
    protected void onDestroy() {
        engine.stop(true);
        super.onDestroy();
    }
}