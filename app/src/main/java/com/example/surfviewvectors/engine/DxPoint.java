package com.example.surfviewvectors.engine;

import android.graphics.Point;
import android.graphics.PointF;

import java.util.Random;

public class DxPoint extends PointF {
    protected float z;
    protected float level;

    public DxPoint(float x, float y, float z) {
        super(x, y);
        this.z = z;

    }

    public DxPoint(float range) {
        Random random = new Random();
        z = random.nextFloat() * 5.0f + 1.0f;
        x = random.nextFloat() * range - (range / 2);
        y = random.nextFloat() * range - (range / 2);
        level = random.nextFloat();
    }

    public DxPoint() {
        Random random = new Random();
        z = random.nextFloat() + 5.0f; // Создание в одной плоскости Z=(5,6)
        x = random.nextFloat() / 10.0f + 0.05f;
        rotatePoint((float) (random.nextFloat() * Math.PI * 2));
        level = random.nextFloat();
    }

    public void rotatePoint(float angle) {
        // Умножаем на матрицу поворода вектора на угол

        float x1 = (float) (x * Math.cos(angle) + y * Math.sin(angle));
        float y1 = (float) (y * Math.cos(angle) - x * Math.sin(angle));
        x = x1;
        y = y1;
    }

    public PointF get2dPoint(float distance, float hW, float hH) {
        // Учет расстояния от точки до экрана
        float xPos = x / z;
        float yPos = y / z;
        // Транслирование координат точки на плоскость экрана
        xPos = xPos * hW + hW;
        yPos = hH - yPos * hH;
        return new PointF(xPos, yPos);
    }

    public float getPointRadius() {
        float rad = 1 / z;
        return rad;
    }
}
