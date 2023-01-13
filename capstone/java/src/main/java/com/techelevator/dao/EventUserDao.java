package com.techelevator.dao;

import com.techelevator.model.EventUser;
import java.util.List;

public interface EventUserDao {

    List<EventUser> getAll();

    boolean updateStatus(EventUser eu, int userId);//update

    boolean create(EventUser eu);
}
