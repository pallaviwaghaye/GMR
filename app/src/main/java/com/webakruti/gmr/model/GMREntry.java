package com.webakruti.gmr.model;


public class GMREntry {

    int id;
    String mcode;
    String mname;
    String timedate;
    String mreading;

    public GMREntry() {
    }

    public GMREntry(int id, String mcode, String mname, String timedate, String mreading) {
        this.id = id;
        this.mcode = mcode;
        this.mname = mname;
        this.timedate = timedate;
        this.mreading = mreading;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMcode() {
        return mcode;
    }

    public void setMcode(String mcode) {
        this.mcode = mcode;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getTimedate() {
        return timedate;
    }

    public void setTimedate(String timedate) {
        this.timedate = timedate;
    }

    public String getMreading() {
        return mreading;
    }

    public void setMreading(String mreading) {
        this.mreading = mreading;
    }

    /*public CallEntry() {
    }

    public CallEntry(int callId, String name, String phoneNumber, String emailId, String query, String timeStamp) {
        this.callId = callId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.query = query;
        this.timeStamp = timeStamp;
    }

    public int getCallId() {
        return callId;
    }

    public void setCallId(int callId) {
        this.callId = callId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }*/
}
