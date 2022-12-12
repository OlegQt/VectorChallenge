package com.example.surfviewvectors.engine;

import android.graphics.Color;
import android.graphics.PointF;

import java.util.Random;

public class SpaceVector {
    private final String name;
    private PointF start, end; // Vector start and end points

    protected SpaceVector(String strName) {
        this.name = strName;
        start = new PointF();
        end = new PointF();
        this.randomVector(1400);
    }

    private void randomVector(int bounds) {
        Random pRandom = new Random();
        end.x = pRandom.nextFloat() * 100;
        float offSetX=pRandom.nextFloat()*bounds - (float) bounds/2;
        float offSetY=pRandom.nextFloat()*bounds - (float) bounds/2;
        moveVector(offSetX,offSetY);
        this.rotate((float) (pRandom.nextFloat()*Math.PI));
    }

    protected void moveVector(float x, float y) {
        start.x += x;
        end.x += x;
        start.y += y;
        end.y += y;
    }

    protected void rotate(float angle){
        //Смещаем в начало координат
        float xOffSet = start.x;
        float yOffSet = start.y;
        moveVector(-xOffSet,-yOffSet);
        // Умножаем на матрицу поворода вектора на угол
        float x1= (float) (end.x*Math.cos(angle)+end.y*Math.sin(angle));
        float y1= (float) (end.y*Math.cos(angle)-end.x*Math.sin(angle));
        end.x=x1;
        end.y=y1;
        // Переносим вектор обратно по координатной плоскости
        moveVector(xOffSet,yOffSet);
    }

    protected float getLength(){
        float dX = (float) Math.pow((double) end.x- start.x,2.0);
        float dY = (float) Math.pow((double) end.y- start.y,2.0);
        return (float)Math.sqrt(dX+dY);
    }

    protected float getColorIntensity(float maxLength){
       return 255.0f * this.getLength()/maxLength;
    }

    protected float[] getPoints() {
        return new float[]{start.x, start.y, end.x, end.y};
    }
    protected float[] getPointsOffSet(int W, int H) {
        return new float[]{start.x+W, start.y+H, end.x+W, end.y+H};
    }
}
