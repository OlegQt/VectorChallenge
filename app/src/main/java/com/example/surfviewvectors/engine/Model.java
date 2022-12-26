package com.example.surfviewvectors.engine;

import android.graphics.PointF;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Model {

    private final float NORMAL_SPEED = 0.005f;


    private final List<DxPoint> array = new ArrayList<>();

    private float motionSpeed;
    private float rotateSpeed;
    private boolean AdditionalInfo;

    public Model() {
        rotateSpeed = 0.03f;
        motionSpeed = NORMAL_SPEED;
    }

    // Add Random point into ArrayList
    public void update(long elapsedTime) {
        float dZ = 0.01f * motionSpeed;

        Iterator<DxPoint> iterator = this.array.iterator();

        while (iterator.hasNext()) {
            DxPoint pP = iterator.next();
            pP.z -= dZ;
            //pP.rotatePoint(motionSpeed/100);
            if (pP.z <= 0) iterator.remove();
        }
        if (array.size() < 5000) {
            //array.add(new DxPoint(0.5f));
            for (int i = 0; i <10; i++) {
                array.add(new DxPoint());
                array.add(new DxPoint(0.5f));
            }
        }
    }

    void showDuration() {
        rotateSpeed += 0.001f;
    }

    public void setMotionSpeed(float motionSpeed) {
        this.motionSpeed = motionSpeed * NORMAL_SPEED;
    }

    public void setAdditionalInfo(boolean additionalInfo) {
        AdditionalInfo = !AdditionalInfo;
    }

    public boolean isAdditionalInfo() {
        return AdditionalInfo;
    }

    // Return full ArrayList of points
    public List<DxPoint> getPointArray() {
        return this.array;
    }


}