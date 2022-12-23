package com.techelevator.dao;

import com.techelevator.model.EventUser;
import java.util.List;

public interface EventUserDao {

    List<EventUser> getAll();
//
//    EventUser findByUser(int userId);
//
//    EventUser findByEvent(int eventId);

    boolean updateStatus(EventUser eu, int userId);//update

    boolean create(EventUser eu);
}
