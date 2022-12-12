package com.example.surfviewvectors.engine;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;

import androidx.annotation.RequiresApi;

public class Render {
    private final Paint paint;

    public Render() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    private void cls(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.DKGRAY);
        canvas.drawRect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10.0f);
        paint.setColor(Color.BLACK);
        canvas.drawRect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.paint);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void draw(Canvas canvas, Model model) {
        this.cls(canvas);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3.0f);
        paint.setColor(Color.WHITE);
        // For each statement below
        int hW = canvas.getWidth() / 2;
        int hH = canvas.getHeight() / 2;
        //canvas.drawLines(model.getVector().getPointsOffSet(hW,hH),paint);


        for (SpaceVector pV :model.getVectorArray()) {
            float red = pV.getColorIntensity(100);
            int color = Color.rgb(255.0f,red-255,red-255);
            paint.setColor(color);
            canvas.drawLines(pV.getPointsOffSet(hW,hH),paint);
        }
    }
}
