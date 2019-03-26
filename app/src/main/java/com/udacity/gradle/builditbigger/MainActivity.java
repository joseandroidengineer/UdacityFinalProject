package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

import fantasticbaking.com.jge.jokeandroidlibrary.JokeActivity;
import fantasticbaking.com.jge.joketeller.Jokes;


public class MainActivity extends AppCompatActivity implements JokeTaskListener {

    private Jokes jokes;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jokes = new Jokes();
        Toast.makeText(this, jokes.jokeOne() , Toast.LENGTH_SHORT).show();
        pb = findViewById(R.id.progressBar);

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
        Jokes jokes = new Jokes();
        String coolJokeFromJava = jokes.jokeOne();
        pb.setVisibility(View.VISIBLE);
        new EndpointsAsyncTask(this).execute(new Pair<Context, String>(this, "Jose"));
        pb.setVisibility(View.INVISIBLE);
        //startActivity(intent);
    }

    @Override
    public void jokeTaskCompleted() {

    }

}
