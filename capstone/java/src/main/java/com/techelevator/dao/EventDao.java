

package com.techelevator.dao;

import com.techelevator.model.Event;

import java.util.List;

public interface EventDao {

    List<Event> list();

    Event findById(int eventId);

//    Event findByName(String name);

    Event updateEvent(int id, Event event);

    void createEvent(Event eventToCreate);

    void deleteEvent(int id);
}