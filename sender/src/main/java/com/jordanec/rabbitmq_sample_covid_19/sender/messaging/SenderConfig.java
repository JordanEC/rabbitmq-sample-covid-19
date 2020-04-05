package com.jordanec.rabbitmq_sample_covid_19.sender.messaging;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderConfig
{
    @Bean
    public TopicExchange topic() {
        return new TopicExchange("rabbitmq_sample_covid_19.one");
    }
}