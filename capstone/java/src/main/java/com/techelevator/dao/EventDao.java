package com.techelevator.dao;

import com.techelevator.model.Event;

import java.util.List;

public interface EventDao {

    List<Event> list();

    Event findById(int eventId);

//    Event findByName(String name);

    boolean updateEvent(Event event, int id);

    void createEvent(Event eventToCreate);

    void deleteEvent(int id);

    List<Event> usersForEvent();

    List<Event> eventsByCause();
}