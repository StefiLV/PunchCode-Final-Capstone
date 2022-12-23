package com.techelevator.controller;

import com.techelevator.model.Message;
import java.util.List;
import com.techelevator.dao.MessageDao;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController

@RequestMapping("/api")



public class MessageController {

    private final MessageDao messageDao;

    public MessageController(MessageDao messageDao){ this.messageDao = messageDao; }

    @RequestMapping(method = RequestMethod.GET)
    public List<Message> list(){ return messageDao.list(); }


    @RequestMapping(path = "/messages/{id}", method = RequestMethod.GET)



    public Message getById(@PathVariable int msgId){
        Message message = messageDao.getById(msgId);
        if(message == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Message not found. ");
        }else {
            return messageDao.getById(msgId);
        }
    }
    @ResponseStatus(HttpStatus.CREATED)

    @RequestMapping(path = "/messages", method = RequestMethod.POST)

    public void create(@Valid @RequestBody Message message){
        messageDao.createMsg(message);
    }


    @RequestMapping(path = "/messages/{id}", method = RequestMethod.PUT)

    public void update(@Valid @RequestBody Message message, @Valid @PathVariable int msgId) {
        messageDao.updateMsg(message, msgId);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)

    @RequestMapping(path = "/messages/{id}", method = RequestMethod.DELETE)

    public void delete(@PathVariable int msgId){
        messageDao.deleteMsg(msgId);
    }
}
