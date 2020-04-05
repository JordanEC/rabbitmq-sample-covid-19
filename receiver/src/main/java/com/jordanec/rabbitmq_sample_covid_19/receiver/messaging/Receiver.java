package com.jordanec.rabbitmq_sample_covid_19.receiver.messaging;

import com.jordanec.rabbitmq_sample_covid_19.model.Update;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver
{
    @RabbitListener(queues = "#{queue1.name}")
    public void receive(Update update)
    {
        System.out.println("--receive() Update received: " + update);
    }
}
