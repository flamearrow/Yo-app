package com.ml.gb.yo.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.ml.gb.yo.R;
import com.ml.gb.yo.fragment.FriendList;
import com.ml.gb.yo.fragment.MenuList;
import com.ml.gb.yo.fragment.SignUpList;
import com.ml.gb.yo.fragment.WelcomeList;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new WelcomeList())
                    .commit();
        }

    }


    public void shout(View view) {
        Toast.makeText(this, "MLGB!", Toast.LENGTH_SHORT).show();
    }

}
