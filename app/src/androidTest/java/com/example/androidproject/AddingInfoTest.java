package com.example.androidproject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest

public class AddingInfoTest {
    @Rule
    public androidx.test.ext.junit.rules.ActivityScenarioRule<com.example.androidproject.Update_Activity>activityRule=new androidx.test.ext.junit.rules.ActivityScenarioRule<>(com.example.androidproject.Update_Activity.class);

    @Test
    public void updateactivity(){

        onView(withId(R.id.button)).perform(click());//confirm the city and add to list
        onView(withId(R.id.time)).perform(ViewActions.typeText("12:00"));
        //Espresso.pressBack();
        onView(withId(R.id.date)).perform(ViewActions.typeText("12/07/22"));
        //Espresso.pressBack();
        onView(withId(R.id.systolic)).perform(ViewActions.typeText("120"));
        //Espresso.pressBack();
        onView(withId(R.id.dayastolic)).perform(ViewActions.typeText("80"));
        //Espresso.pressBack();
        onView(withId(R.id.bp)).perform(ViewActions.typeText("80"));
        Espresso.pressBack();
        onView(withId(R.id.comment)).perform(ViewActions.typeText("sitting"));
        //Espresso.pressBack();

        onView(withId(R.id.add)).perform(click());//confirm the city and add to list
        Espresso.pressBack();
    }

}