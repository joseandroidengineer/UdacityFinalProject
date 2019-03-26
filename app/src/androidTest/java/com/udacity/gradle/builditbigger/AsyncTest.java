package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.annotation.UiThreadTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Pair;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class AsyncTest extends TestCase implements JokeTaskListener{

    EndpointsAsyncTask endpointsAsyncTask;
    CountDownLatch signal;
    private Context context;

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule;

    protected void setUp() throws Exception {
        super.setUp();
        activityTestRule = new ActivityTestRule<>(MainActivity.class);
        context = InstrumentationRegistry.getContext();
        signal = new CountDownLatch(1);
        endpointsAsyncTask = new EndpointsAsyncTask(this);
    }

    @UiThreadTest
    public void testDownload() throws InterruptedException, ExecutionException {
        endpointsAsyncTask.execute(new Pair<>(context, "Jose"));
        signal.await(30, TimeUnit.SECONDS);
        String joke = endpointsAsyncTask.get();
        assertNotNull(joke);
    }




    @Override
    public void jokeTaskCompleted() {
        signal.countDown();

    }
}
