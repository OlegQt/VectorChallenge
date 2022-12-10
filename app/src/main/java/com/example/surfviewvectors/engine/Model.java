package com.example.surfviewvectors.engine;

import android.graphics.Point;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Model {
    private ArrayList<SpaceVector> vectorList;
    private int screenHeight, screenWidth;


    public Model() {
        vectorList = new ArrayList<>();
        SpaceVector sV = new SpaceVector(100, 10);
        vectorList.add(sV);
    }

    public void setScreenSize(int w, int h) {
        this.screenHeight = h;
        this.screenWidth = w;
    }


    // Add Random point into ArrayList
    public void update(long elapsedTime) {
        Random pR = new Random();
        //pointArrayList.add(new Point(pR.nextInt(1000),pR.nextInt(1000)));

    }

    // Return full ArrayList of points
    public ArrayList<SpaceVector> getPointsArray() {
        return this.vectorList;
    }
}
