package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

/**
 * EndpointsAsyncTask
 * Updated by Vassili Kurman on 05/07/2018.
 * Version 1.0
 */
public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApiService = null;
    /**
     * My machine local area IPv4 address
     */
    private static final String IP_ADDRESS = "192.168.0.20";
    private OnAsyncTaskCompleted mOnAsyncTaskCompleted;

    /**
     * Public constructor that takes callback interface as parameter
     * @param onAsyncTaskCompleted
     */
    public EndpointsAsyncTask(OnAsyncTaskCompleted onAsyncTaskCompleted) {
        mOnAsyncTaskCompleted = onAsyncTaskCompleted;
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://" + IP_ADDRESS + ":8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver
            myApiService = builder.build();
        }

        try {
            return myApiService.sayJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if(mOnAsyncTaskCompleted != null) {
            mOnAsyncTaskCompleted.onTaskCompleted(result);
        }
    }
}
