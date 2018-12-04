package com.example.android.camera2basic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class LineView extends View {

    private Paint paint = new Paint();

    private PointF pointA, pointB;

    public LineView(Context context) {
        super(context);
    }

    public LineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(Color.RED);
        paint.setStrokeWidth(20);
        canvas.drawLine(pointA.x,pointA.y,pointB.x,pointB.y,paint);
        float L1 = (float)(Math.sqrt((Math.pow(pointB.x-pointA.x,2) + Math.pow(pointB.y - pointA.y,2))));
        System.out.println("distance " + L1);
        float x3 = (float) (pointB.x + .1 * ((pointA.x - pointB.x)*Math.cos(Math.PI/4) - (pointA.y - pointB.y)*Math.sin(Math.PI/4)));
        float y3 = (float) (pointB.y + .1 * ((pointA.y - pointB.y)*Math.cos(Math.PI/4) + (pointA.x - pointB.x)*Math.sin(Math.PI/4)));
        canvas.drawLine(pointB.x, pointB.y, x3, y3, paint);
        float x4 = (float) (pointB.x + .1 * ((pointA.x - pointB.x)*Math.cos(Math.PI/4) + (pointA.y - pointB.y)*Math.sin(Math.PI/4)));
        float y4 = (float) (pointB.y + .1 * ((pointA.y - pointB.y)*Math.cos(Math.PI/4) - (pointA.x - pointB.x)*Math.sin(Math.PI/4)));
        canvas.drawLine(pointB.x, pointB.y, x4, y4, paint);
        super.onDraw(canvas);
    }

    public void setPointA(PointF point)
    {
        pointA = point ;
    }

    public void setPointB(PointF point)
    {
        pointB = point ;
    }

    public void draw() {
        invalidate();
        requestLayout();
    }
}