package com.techelevator.controller;

import com.techelevator.model.Hours;
import com.techelevator.dao.HoursDao;

import java.util.List;

import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")

public class HoursController {

    private final HoursDao dao;

    public HoursController(HoursDao dao){
        this.dao = dao;
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

    @RequestMapping(path = "/{user_id}", method = RequestMethod.GET) // getting all the hours by a user
    public List<Hours> getHours(@PathVariable int user_id){
        List<Hours> hours = dao.getAllHours(user_id);
        if(hours == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.");
        }
        else {
            return dao.getAllHours(user_id);
        }
    }

    @RequestMapping(path = "/{event_id}", method = RequestMethod.GET) //getting all ids in an event
    public List<Hours> getIds(@PathVariable int event_id){
        List<Hours> ids = dao.getAllIds(event_id);
        if(ids ==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found.");
        }
        else {
            return dao.getAllIds(event_id);
        }
    }

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
    @RequestMapping(path = "/{id{}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id){
        dao.deleteId(id);
    }




}
