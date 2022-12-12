package com.example.surfviewvectors.engine;

import java.util.ArrayList;
import java.util.Random;

public class Model {
    private ArrayList<SpaceVector> vectorArray;


    public Model() {
        this.vectorArray = new ArrayList<SpaceVector>();

    }


    // Add Random point into ArrayList
    public void update(long elapsedTime) {
        //long milliard = 1000000000;
        for (SpaceVector pV : this.vectorArray) {
            pV.rotate(0.009f);
        }
        if (vectorArray.size() < 2000) vectorArray.add(new SpaceVector("vector"));
    }

    // Return full ArrayList of points
    public ArrayList<SpaceVector> getVectorArray() {
        return this.vectorArray;
    }
}