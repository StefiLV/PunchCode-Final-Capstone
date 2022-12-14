

package com.techelevator.dao;

import com.techelevator.model.Event;

import java.util.List;

public interface EventDao {

    List<Event> findAll();

    Event getEventById(int eventId);

    Event findByName(String name);

    int findIdByName(String name);

    boolean create(String name, String address, String startDate, String endDate, String startTime, String endTime, String description);
}