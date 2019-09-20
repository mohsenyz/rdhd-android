package com.rdhd.app.models;

/*
phonenumber text,
idservice text,
id text,
starttime date,
endtime date,
barcode text,
col text,
 */

public class MyGetService {

    private String phoneNum;
    private String startTime;
    private String endTime;

    public MyGetService(String phoneNum, String startTime, String endTime) {
        this.phoneNum = phoneNum;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
