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

        paint.setStrokeWidth(12);

        canvas.drawLine(pointA.x,pointA.y,pointB.x,pointB.y,paint);
//        double theta = Math.tanh((pointB.y - pointA.y)/(pointB.x - pointA.x));
//
//        double thetaA = -theta + Math.PI/4;
//        double thetaB = -theta - Math.PI/4;
//
//        float xA = (float) (pointB.x - 20 * Math.sin(thetaA));
//        float yA = (float) (pointB.y - 20 * Math.cos(thetaA));
//
//        float xB = (float) (pointB.x - 20 * Math.sin(thetaB));
//        float yB = (float) (pointB.y - 20 * Math.cos(thetaB));
//
//        canvas.drawLine(xA,yA,pointB.x,pointB.y,paint);
//        canvas.drawLine(xB,yB,pointB.x,pointB.y,paint);

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