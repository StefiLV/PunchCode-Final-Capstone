package com.techelevator.controller;
import com.techelevator.model.Event;
import java.util.List;
import com.techelevator.dao.EventDao;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired EventDao eventDao;

    public EventController(EventDao eventDao) {
        this.eventDao = eventDao;
    }


    @GetMapping(path = {"/events"})
    public List<Event> list() {
        List<Event> allEvents = eventDao.list();
        return allEvents;
    }

    @RequestMapping(path = "/events/{id}", method = RequestMethod.GET)
    public Event get(@PathVariable int id) {
        Event event = eventDao.findById(id);
        if (event == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event Not Found");
        } else {
            return eventDao.findById(id);
        }
    }
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public void create(@Valid @RequestBody Event event){
        eventDao.createEvent(event);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void update(@Valid @RequestBody Event event, @Valid @PathVariable int id) {
        eventDao.updateEvent(event, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id){
        eventDao.deleteEvent(id);
    }


//    @RequestMapping(method = RequestMethod.GET)
//    public List<Event> eventsCause() { return eventDao.eventsByCause(); }
}
