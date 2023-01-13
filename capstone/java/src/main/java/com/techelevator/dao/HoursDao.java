package com.techelevator.dao;

import com.techelevator.model.Hours;

import java.util.List;

public interface HoursDao {

     List<Hours> getAllHours();

     Hours getId(int id); //gets the specific id

     Hours createId(Hours newId); //creating new id

     void deleteId (int id); //deletes hours by id

     void updateHours (Hours updatedHours, int updateId); //updates the hours


}
