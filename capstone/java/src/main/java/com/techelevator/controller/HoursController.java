package com.techelevator.controller;

import com.techelevator.model.Event;
import com.techelevator.model.Hours;
import com.techelevator.dao.HoursDao;

import java.util.List;

import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping ("/api/hours")

public class HoursController {

    @Autowired HoursDao dao;

    public HoursController(HoursDao dao){
        this.dao = dao;
    }

    @GetMapping(path = "")
    public List<Hours> getAllHours() {
        List<Hours> getAllHours = dao.getAllHours();
        return getAllHours;
    }


    @RequestMapping(path="/{id}", method = RequestMethod.GET) //requesting for the individual hour id
    public Hours getId(@PathVariable int id){
        Hours hours = dao.getId(id);
        if(hours == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hours not found.");
        }
        else {
            return dao.getId(id);
        }
    }

//    @RequestMapping(path = "/{id}", method = RequestMethod.GET) // getting all the hours by a user
//    public List<Hours> getHours(@PathVariable int user_id){
//        List<Hours> hours = dao.getAllHours(user_id);
//        if(hours == null){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hours not found.");
//        }
//        else {
//            return dao.getAllHours(user_id);
//        }
//    }
//
//    @RequestMapping(path = "/{event_id}", method = RequestMethod.GET) //getting all ids in an event
//    public List<Hours> getIds(@PathVariable int event_id){
//        List<Hours> ids = dao.getAllIds(event_id);
//        if(ids == null){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found.");
//        }
//        else {
//            return dao.getAllIds(event_id);
//        }
//    }

    @ResponseStatus(HttpStatus.CREATED) //creating new hours
    @RequestMapping( method = RequestMethod.POST)
    public void create(@Valid @RequestBody Hours hours){
            dao.createId(hours);
    }

    @RequestMapping(path = "/{updateId}", method = RequestMethod.PUT) //updating the hours
    public void update(@Valid @RequestBody Hours hours, @Valid @PathVariable int updateId){
        dao.updateHours(hours, updateId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT) //deleting the hours
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id){
        dao.deleteId(id);
    }




}
