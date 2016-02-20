package com.lyricaloriginal.icepicksample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import icepick.Icepick;
import icepick.State;

public class MainActivity extends AppCompatActivity {

    private TextView mMsgTextView;

    @State
    String mMessages = "";
    @State
    int mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Icepick.restoreInstanceState(this, savedInstanceState);

        mMsgTextView = (TextView) findViewById(R.id.msg_text_view);
        mMsgTextView.setText(mMessages);

        findViewById(R.id.add_text_button).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        addMsg();
                    }
                });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }

    private void addMsg() {
        mCount++;
        StringBuilder sb = new StringBuilder();
        sb.append(mMessages);
        sb.append(mCount + "回目メッセージ追加\n");
        mMessages = sb.toString();
        mMsgTextView.setText(mMessages);
    }
}
