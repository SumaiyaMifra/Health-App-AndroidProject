package com.example.androidproject;

import java.util.ArrayList;
import java.util.List;

public class MeasurementList {
    List<Measurements> measurement=new ArrayList<>();
    public void inserData(Measurements measure)
    {
        if(measurement.contains(measure))
        {
            throw new IllegalArgumentException();
        }
        measurement.add(measure);
    }


    /**
     * @param measurements
     */
    public void delete(Measurements measurements)
    {
        if(measurement.contains(measurements))
        {
            measurement.remove(measurements);
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    public void edit(int position, Measurements measurements)
    {
        measurement.set(position,measurements);
    }
    /**
     * @return item count
     */
    public int count(){
        return measurement.size();
    }
    public List<Measurements>getMeasure()
    {
        return measurement;
    }
}
