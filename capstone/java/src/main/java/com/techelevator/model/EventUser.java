package com.techelevator.model;

public class EventUser {

    private int euId;
    private int userId;
    private int eventId;
    private String approval;

    public EventUser(){ }

    public EventUser(int euId, int userId, int eventId, String approval){
        this.euId = euId;
        this.userId = userId;
        this.eventId = eventId;
        this.approval = approval;
    }
    public int getEuId() { return euId; }
    public void setEuId(int euId){ this.euId = euId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId){ this.userId = userId; }

    public int getEventId() { return eventId; }
    public void setEventId(int eventId) { this.eventId = eventId; }

    public String getApproval() { return approval; }
    public void setApproval(String approval){ this.approval = approval; }

}
