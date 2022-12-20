package com.techelevator.model;

public class Hours {
    private int id;
    private int user_id;
    private int event_id;
    private int hours;
    private String approval_status;

    public Hours(){}

    public Hours(int id, int user_id, int event_id, int hours, String approval_status){
        this.id = id;
        this.user_id = user_id;
        this.event_id = event_id;
        this.hours = hours;
        this.approval_status = approval_status;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public int getUser_id(){
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id=user_id;
    }

    public int getEvent_id(){
        return event_id;
    }
    public void setEvent_id(int event_id){
        this.event_id=event_id;
    }

    public int getHours(){
        return hours;
    }
    public void setHours(int hours){
        this.hours = hours;
    }

    public String getApproval_status(){
        return approval_status;
    }
    public void setApproval_status(String approval_status){
        this.approval_status=approval_status;
    }
}
