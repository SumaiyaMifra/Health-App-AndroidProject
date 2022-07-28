package com.example.androidproject;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest

public class ViewInfoTest {
    @Rule
    public androidx.test.ext.junit.rules.ActivityScenarioRule<com.example.androidproject.Update_Activity>activityRules=new androidx.test.ext.junit.rules.ActivityScenarioRule<>(com.example.androidproject.Update_Activity.class);
    public androidx.test.ext.junit.rules.ActivityScenarioRule<com.example.androidproject.ViewInfo>activityRule=new androidx.test.ext.junit.rules.ActivityScenarioRule<>(com.example.androidproject.ViewInfo.class);

    @Test
    public void view(){

    }

}