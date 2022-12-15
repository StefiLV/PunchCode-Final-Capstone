

package com.techelevator.controller;
import com.techelevator.model.Event;
import java.util.List;
import com.techelevator.dao.EventDao;
import com.techelevator.model.EventNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventDao eventDao;

    public EventController(EventDao eventDao) {
        this.eventDao = eventDao;
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<Event> list() {
        return eventDao.list();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
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
        public Event update(@Valid @RequestBody Event event, @Valid @PathVariable int id){
          Event updatedEvent = eventDao.updateEvent(id, event);
        if (updatedEvent == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Bad Event");
        }else if (id <= 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Bad Id");
        }else {
            return updatedEvent;
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id){
        eventDao.deleteEvent(id);
    }
}