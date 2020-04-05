package com.jordanec.rabbitmq_sample_covid_19.sender.controller;

import com.jordanec.rabbitmq_sample_covid_19.model.Update;
import com.jordanec.rabbitmq_sample_covid_19.sender.messaging.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "update")
public class UpdateController
{
    @Autowired Sender sender;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Update create(@RequestBody Update update) throws Exception
    {
        Update updateResponse = sender.sendUpdate(update);
        return updateResponse;
    }
}
