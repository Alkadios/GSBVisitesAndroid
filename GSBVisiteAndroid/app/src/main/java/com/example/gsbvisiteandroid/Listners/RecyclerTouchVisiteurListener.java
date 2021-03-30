package com.example.gsbvisiteandroid.Listners;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.example.gsbvisiteandroid.Interfaces.RecyclerViewClickListener;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerTouchVisiteurListener implements RecyclerView.OnItemTouchListener {
    private GestureDetector gestureDetector;
    private RecyclerViewClickListener clickVisiteurListener;

    public RecyclerTouchVisiteurListener(Context context, final RecyclerView recyclerView, final RecyclerViewClickListener clickVisiteurListener)
    {
        this.clickVisiteurListener = clickVisiteurListener;
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
        View child = rv.findChildViewUnder(e.getX() , e.getY());
        if(child != null && clickVisiteurListener != null && gestureDetector.onTouchEvent(e)){
            clickVisiteurListener.onClick(child, rv.getChildAdapterPosition(child));
        }
        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}