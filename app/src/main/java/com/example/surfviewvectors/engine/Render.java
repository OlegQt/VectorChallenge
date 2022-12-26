package com.example.surfviewvectors.engine;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
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
        paint.setTextSize(25.0f);
        // For each statement below
        int hW = canvas.getWidth() / 2;
        int hH = canvas.getHeight() / 2;
        //canvas.drawLines(model.getVector().getPointsOffSet(hW,hH),paint);

        // Show number of POINTS
        if (model.isAdditionalInfo()) {
            paint.setColor(Color.MAGENTA);
            canvas.drawText(String.valueOf(model.getPointArray().size()), 10.0f, 50.0f, paint);
        }

        for (DxPoint pP : model.getPointArray()) {
            PointF tP = pP.get2dPoint(10.0f, hW, hH);
            paint.setColor(Color.WHITE);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawPoint(tP.x, tP.y, paint);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(tP.x, tP.y, pP.getPointRadius(), paint);

            // Draw Z-value for some of points
            if (model.isAdditionalInfo() && pP.level > 0.97f) {
                paint.setColor(Color.MAGENTA);
                canvas.drawText(String.valueOf(pP.z), 0, 3, tP.x + 5.0f, tP.y, paint);

            }

        }
    }
}
