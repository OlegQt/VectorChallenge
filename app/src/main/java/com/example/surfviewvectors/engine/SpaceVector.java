package com.example.surfviewvectors.engine;



public class SpaceVector {
    protected float x ,y; // Vector coordinates. Vector stars at {0,0}
    public SpaceVector(int x, int y){
        this.x=x;
        this.y=y;
    }
    public void rotateVector(float angle){
        // Умножаем на матрицу поворода вектора на угол
        float x1= (float) (x*Math.cos(angle)+y*Math.sin(angle));
        float y1= (float) (y*Math.cos(angle)-x*Math.sin(angle));
        this.x=x1;
        this.y=y1;
    }
    public void sumVector(SpaceVector sV,String sign)
    {
        if(sign.equals("+")) {
            this.x += sV.x;
            this.y += sV.y;
        }
        else if(sign.equals("-"))
        {
            this.x -= sV.x;
            this.y -= sV.y;
        }
    }
}
