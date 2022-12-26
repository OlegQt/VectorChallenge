package com.example.surfviewvectors;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.Slide;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import com.example.surfviewvectors.engine.Engine;
import com.google.android.material.slider.Slider;

public class MainActivity extends AppCompatActivity {
    Engine engine;

    SurfaceView surface;
    Button btbExit,btnInfo;
    Slider sld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sld=findViewById(R.id.sld);
        btbExit=findViewById(R.id.btb_exit);
        btnInfo=findViewById(R.id.btn_info);
        surface = findViewById(R.id.surface);

        btnInfo.setText("INFO");
        btbExit.setText("QUIT");

        engine=new Engine(surface);

        btbExit.setOnClickListener(view ->
        {
            onDestroy();
            finishAndRemoveTask();
            System.exit(0);
        });
        btnInfo.setOnClickListener(view ->
        {
            engine.sendInfoToModel(1,0.0f);
        });
        sld.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                engine.sendInfoToModel(0,value);
            }
        });

    }

    @Override
    protected void onDestroy() {
        engine.stop(true);
        super.onDestroy();
    }

}