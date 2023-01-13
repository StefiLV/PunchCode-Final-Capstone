package com.techelevator.dao;

import com.techelevator.model.Event;
import java.util.List;

public interface EventDao {

    List<Event> list();

    Event findById(int eventId);

    boolean updateEvent(Event event, int id);

    boolean createEvent(Event newEvent);

    boolean deleteEvent(int id);

}