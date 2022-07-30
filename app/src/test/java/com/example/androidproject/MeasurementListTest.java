package com.example.androidproject;

import static org.junit.Assert.*;

import org.junit.Test;

public class MeasurementListTest {
    private MeasurementList mockList()
    {
        MeasurementList measurement=new MeasurementList();
        measurement.inserData(mockMeasure());
        return measurement;
    }
    private Measurements mockMeasure()
    {
        return new Measurements("xyz","12.00","12/02/2022","108","90","78","sitting");
    }

    @Test
    public void testInsertData() {
        MeasurementList measurementListist=mockList();
        assertEquals(1,measurementListist.getMeasure().size());

        Measurements measurements=new Measurements("xyz","12.00","12/02/2022","120","90","80","standing");
        measurementListist.inserData(measurements);

        assertEquals(2,measurementListist.getMeasure().size());
        assertTrue(measurementListist.getMeasure().contains(measurements));
    }
    private Measurements mockmeasurements() {
        return new Measurements("xyz","12.00","12/02/2022","120","90","80","standing");
    }
    @Test
    public void testInsertException()
    {
        MeasurementList measurementList=new MeasurementList();
        Measurements measurements=mockmeasurements();
        measurementList.inserData(measurements);

        assertThrows(IllegalArgumentException.class,()->{
            measurementList.inserData(measurements);
        });
    }
    @Test
    public void testDelete()
    {
        MeasurementList measurementList=mockList();
        Measurements measure = new Measurements("xyz","12.00","12/02/2022","120","90","80","standing");
        measurementList.inserData(measure);
        assertTrue(measurementList.getMeasure().contains(measure));
        measurementList.delete(measure);
        assertFalse(measurementList.getMeasure().contains(measure));

    }

    /**
     * exception test
     */
    @Test
    public void testDeleteException(){
        MeasurementList measurementList=new MeasurementList();
        Measurements measurements=new Measurements("xyz","12.00","12/02/2022","120","90","80","standing");
        Measurements measurements1=new Measurements("pqr","11.00","13/02/2022","110","100","80","sitting");
        measurementList.inserData(measurements);
        measurementList.inserData(measurements1);
        /**
         * checking count method with assertequals
         */
        assertEquals(2,measurementList.count());

        measurementList.delete(measurements);
        assertEquals(1,measurementList.count());
        /**
         * checking delete method throw exception
         */
        assertThrows(IllegalArgumentException.class, () -> {
            measurementList.delete(measurements);
        });

    }
    @Test
    public void testEdit()
    {
        MeasurementList mList=mockList();
        Measurements measurementsnew = new Measurements("pqr","11.00","13/02/2022","110","100","80","sitting");
        mList.inserData(measurementsnew);
        assertTrue(mList.getMeasure().contains(measurementsnew));
        Measurements newmeasure=new Measurements("pqr","10.00","13/02/2022","100","90","80","sitting");
        mList.edit(1,newmeasure);
        assertFalse(mList.getMeasure().contains(measurementsnew));
        assertTrue(mList.getMeasure().contains(newmeasure));
    }


}