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

package vkurman.androidjokes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * <code>JokeActivity</code> is an activity that displays joke.
 *
 * Created by Vassili Kurman on 05/07/2018.
 * Version 1.0
 */
public class JokeActivity extends AppCompatActivity {

    public static final String JOKE_EXTRA = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView jokeTextView = findViewById(R.id.tv_joke);

        Intent intent = getIntent();
        String joke = intent.getStringExtra(JOKE_EXTRA);
        if(!TextUtils.isEmpty(joke)) {
            jokeTextView.setText(joke);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}