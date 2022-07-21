package com.example.androidproject;

public class Measurements {
    String time,date,systolic,dayastolic,comment,id,bp;

    public Measurements(String id,String time, String date, String systolic, String dayastolic,String bp, String comment) {
        this.time = time;
        this.date = date;
        this.systolic = systolic;
        this.dayastolic = dayastolic;
        this.comment = comment;
        this.id=id;
        this.bp=bp;
    }
    public String getBp()
    {
        return bp;
    }
  public String getId(){
        return id;
  }
    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public String getSystolic() {
        return systolic;
    }

    public String getDayastolic() {
        return dayastolic;
    }

    public String getComment() {
        return comment;
    }
}
