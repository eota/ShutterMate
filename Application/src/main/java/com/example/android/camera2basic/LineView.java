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
        float distX = (float) 2.5 * (pointA.x - pointB.x);
        float distY = (float) 2.5 * (pointA.y - pointB.y);
        float x3 = (float) (pointB.x + .1 * (distX *Math.cos(Math.PI/4) - distY *Math.sin(Math.PI/4)));
        float y3 = (float) (pointB.y + .1 * (distY *Math.cos(Math.PI/4) + distX *Math.sin(Math.PI/4)));
        canvas.drawLine(pointB.x, pointB.y, x3, y3, paint);
        float x4 = (float) (pointB.x + .1 * (distX *Math.cos(Math.PI/4) + distY *Math.sin(Math.PI/4)));
        float y4 = (float) (pointB.y + .1 * (distY *Math.cos(Math.PI/4) - distX *Math.sin(Math.PI/4)));
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