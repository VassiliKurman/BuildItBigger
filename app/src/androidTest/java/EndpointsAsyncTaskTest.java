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
import android.content.Context;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;
import android.util.Pair;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * EndpointsAsyncTaskTest
 * Created by Vassili Kurman on 21/07/2018.
 * Version 1.0
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class EndpointsAsyncTaskTest {

    private static final String TEST_JOKE = "My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away.";

    @Test
    public void triggerIntentTest() {
        try {
            // Retrieving joke via AsyncTask
            String joke = new EndpointsAsyncTask().execute(new Pair<Context, String>(null, "free")).get();

            // Checking that actual joke is returned, meaning that string is not null and not empty
            assertThat(joke, is(TEST_JOKE));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}