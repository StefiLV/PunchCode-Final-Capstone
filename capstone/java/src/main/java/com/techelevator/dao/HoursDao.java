package com.techelevator.dao;

import com.techelevator.model.Hours;

import java.util.List;

public interface HoursDao {
    public Hours getId(int id); //gets the specific id

    public List<Hours> getAllHours(int user_id); //get all hours by a specific user

    public List<Hours> getAllIds(int event_id); //get all hours in an event

    public Hours createId(Hours newId); //creating new id

    public void deleteId (int id); //deletes hours by id

    public void updateHours (Hours updatedHours, int updateId); //updates the hours


}
