package com.techelevator.dao;

import com.techelevator.model.Event;

import java.util.List;

public interface EventDao {

    List<Event> list();

    Event findById(int eventId);

    Event findByName(String name);

    boolean updateEvent(int id, Event event);

    boolean createEvent(Event eventToCreate);

    boolean deleteEvent(int id);
}

