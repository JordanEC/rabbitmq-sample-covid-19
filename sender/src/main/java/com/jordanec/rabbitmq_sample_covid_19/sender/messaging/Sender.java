package com.jordanec.rabbitmq_sample_covid_19.sender.messaging;

import com.jordanec.rabbitmq_sample_covid_19.model.Update;
import com.jordanec.rabbitmq_sample_covid_19.sender.service.UpdateService;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender
{
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    UpdateService updateService;

    @Autowired
    TopicExchange topic;

    public Update sendUpdate(Update update) throws Exception
    {
        updateService.validateAndCreate(update);
        rabbitTemplate.convertAndSend(topic.getName(), update.getContinent() + "." + update.getCountryName(), update);
        return update;
    }
}
