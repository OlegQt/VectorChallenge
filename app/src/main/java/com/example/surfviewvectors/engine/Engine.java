package com.example.surfviewvectors.engine;

import android.graphics.Canvas;
import android.os.Build;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public class Engine {
    private final Model model;
    private final Render render;

    private SurfaceHolder surfaceHolder;
    private SurfaceHolder.Callback callBack;

    private boolean stopped;
    long time = System.nanoTime();

    Runnable thread = new Runnable() {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void run() {
            while (!stopped) {
                Canvas canvas;

                if (surfaceHolder == null || (canvas = surfaceHolder.lockCanvas()) == null) {
                    synchronized (Engine.this) {
                        try {
                            Engine.this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    //model.setScreenSize(canvas.getWidth(),canvas.getHeight());
                    long elapsedTime = System.nanoTime() - time;
                    model.update(elapsedTime);
                    render.draw(canvas, model);
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    };

    public void stop(boolean stopped) {
        this.stopped = stopped;
    }

    public Engine(SurfaceView surface) {
        model = new Model();
        render = new Render();

        Thread engineThread = new Thread(thread, "EngineThread");
        engineThread.start();

        callBack = new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
                Engine.this.surfaceHolder = surfaceHolder;
                synchronized (Engine.this) {
                    Engine.this.notifyAll();
                }
            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {
                Engine.this.surfaceHolder = surfaceHolder;
            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
                Engine.this.surfaceHolder = null;
            }
        };
        surface.getHolder().addCallback(callBack);
    }

    public void sendInfoToModel(int param, float value) {
        if(param==0){
            model.setMotionSpeed(value);
        }
        else if(param==1){
            model.setAdditionalInfo(true);
        }
    }

}
