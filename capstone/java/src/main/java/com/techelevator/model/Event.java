package com.techelevator.model;

public class Event {

    private int eventId;
    private String name;
    private String orgLogo;
    private int ownerId;
    private String address;
    private String startDate;
    private String endDate;
    private String startTime;
    private String endTime;
    private String description;
    private int counter;

    public Event(){ }

    public Event(int eventId, String name, String orgLogo, int ownerId, String address, String startDate, String endDate, String startTime, String endTime, String description, int counter){
        this.eventId = eventId;
        this.name = name;
        this.orgLogo = orgLogo;
        this.ownerId = ownerId;
        this.address = address;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.counter = counter;
    }

    public int getEventId(int id) { return eventId; }
    public void setEventId(int id) { this.eventId = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getOrgLogo() { return orgLogo; }
    public void setOrgLogo(String orgLogo) { this.orgLogo = orgLogo; }

    public int getownerId() { return ownerId; }
    public void setownerId(int ownerId){ this.ownerId = ownerId; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }

    public String getEndDate() { return endDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }

    public String getStartTime() { return startTime; }
    public void setStartTime(String startTime) { this.startTime = startTime; }

    public String getEndTime() { return endTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getCounter() { return counter; }
    public void setCounter(int counter) { this.counter = counter; }

}

