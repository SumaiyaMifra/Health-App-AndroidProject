package com.example.androidproject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest

public class MainActivityTest {
    @Rule
    public androidx.test.ext.junit.rules.ActivityScenarioRule<com.example.androidproject.MainActivity>activityRule=new androidx.test.ext.junit.rules.ActivityScenarioRule<>(com.example.androidproject.MainActivity.class);
    /**
     *UI test for splash screen
     */
    @Test
    public void testSplash() {
        onView(withId(R.id.splash)).check(matches(isDisplayed()));

        onView(withId(R.id.textView)).check(matches(isDisplayed()));



    }


}