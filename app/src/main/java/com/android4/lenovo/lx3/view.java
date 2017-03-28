package com.android4.lenovo.lx3;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by lenovo on 2017/3/26.
 */

public class view extends LinearLayout{
    //����ViewDragHelper
    ViewDragHelper view;

    public view(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
	//ʵ����ViewDragHelper
        view=ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback() {
            @Override
            public boolean tryCaptureView(View child, int pointerId) {
                return true;
            }
	    //������ͼˮƽ����
            @Override
            public int clampViewPositionHorizontal(View child, int left, int dx) {
                return left;
            }
	    //������ͼ��ֱ����
            @Override
            public int clampViewPositionVertical(View child, int top, int dy) {
                return top;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return view.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        view.processTouchEvent(event);
        return true;
    }
}