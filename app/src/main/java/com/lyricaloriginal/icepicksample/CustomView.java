package com.lyricaloriginal.icepicksample;

import android.content.Context;
import android.graphics.Color;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;

import icepick.Icepick;
import icepick.State;

/**
 * Created by LyricalMaestro on 2016/02/20.
 */
public class CustomView extends View {

    @State
    int mColorIndex = 0;

    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    public Parcelable onSaveInstanceState() {
        return Icepick.saveInstanceState(this, super.onSaveInstanceState());
    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(Icepick.restoreInstanceState(this, state));
        changeColor();
    }

    private void init() {
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                changeColorIndex();
            }
        });
        changeColor();
    }

    private void changeColorIndex() {
        mColorIndex = (mColorIndex + 1) % 4;
        changeColor();
    }

    private void changeColor() {
        switch (mColorIndex) {
            case 0:
                setBackgroundColor(Color.RED);
                break;
            case 1:
                setBackgroundColor(Color.YELLOW);
                break;
            case 2:
                setBackgroundColor(Color.BLUE);
                break;
            case 3:
                setBackgroundColor(Color.GREEN);
                break;
        }
    }

}
