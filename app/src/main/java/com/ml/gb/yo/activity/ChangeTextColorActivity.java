package com.ml.gb.yo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

import com.ml.gb.yo.R;
import com.ml.gb.yo.toyView.ChangeTextColorTextView;

import io.fabric.sdk.android.Fabric;

/**
 * Created by ccen on 9/29/14.
 */
public class ChangeTextColorActivity extends Activity {
    ChangeTextColorTextView tv;
    EditText et;
    private TwitterLoginButton loginButton;
    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "aIrQGvL3RSB3eHJABvWfPwrMo";
    private static final String TWITTER_SECRET = "A1YgXVd3fGRhnngWqGuZTZU7fbZLATF1P5xkNiLUFDpSwbw7mn";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);

        Fabric.with(this, new Twitter(authConfig));

        setContentView(R.layout.change_text_color_layout);
        tv = (ChangeTextColorTextView) findViewById(R.id.changeTextColorTV);
        et = (EditText) findViewById(R.id.editText);
        loginButton = (TwitterLoginButton) findViewById(R.id.twitter_login_button);
        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                // Do something with result, which provides a TwitterSession for making API calls

            }

            @Override
            public void failure(TwitterException exception) {
                // Do something on failure
            }
        });

    }

    public void setText(CharSequence text) {
        tv.setTextBounded(text);
    }

    public void setTextFromField(View view) {
        tv.setTextBounded(et.getText());
    }
}
