/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import vkurman.androidjokes.JokeActivity;
import vkurman.javajokes.JokesProvider;

/**
 * <code>MainActivity</code> is an activity that starts app.
 *
 * Created by Udacity developers.
 * Updated by Vassili Kurman on 05/07/2018.
 * Version 1.0
 */
public class MainActivity extends AppCompatActivity {

//    private JokesProvider jokesProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        if(jokesProvider == null) {
//            jokesProvider = new JokesProvider();
//        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        new EndpointsAsyncTask().execute(new Pair<Context, String>(this, ""));

//        String joke = null;
//        Intent intent = new Intent(this, JokeActivity.class);
////        intent.putExtra(JokeActivity.JOKE_EXTRA, jokesProvider.getJoke());
//        intent.putExtra(JokeActivity.JOKE_EXTRA, joke);
//        startActivity(intent);
    }
}