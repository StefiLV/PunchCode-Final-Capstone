package com.techelevator.controller;
import com.techelevator.dao.EventUserDao;
import com.techelevator.model.Event;
import com.techelevator.model.EventUser;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class EUController {

    @Autowired
    EventUserDao eventUserDao;

    public EUController(EventUserDao eventUserDao){
        this.eventUserDao = eventUserDao;
    }

    @GetMapping(path = {"/events/volunteers"})
    public List<EventUser> list() {

        return eventUserDao.getAll();
    }

    @RequestMapping(path = "/events/volunteers/{id}", method = RequestMethod.PUT)
    public void updateStatus(@Valid @RequestBody EventUser eu, @Valid @RequestBody int id){
        eventUserDao.updateStatus(eu, id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/events/volunteers", method = RequestMethod.POST)
    public void create(@Valid @RequestBody EventUser eu){
        eventUserDao.create(eu);
    }
}
