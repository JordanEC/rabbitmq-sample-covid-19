package com.jordanec.rabbitmq_sample_covid_19.receiver.messaging;

import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReceiverConfig
{
    @Value("${topic.continent:*}")
    String continent;
    @Value("${topic.country:*}")
    String country;

    @Bean
    public TopicExchange topic() {
        return new TopicExchange("rabbitmq_sample_covid_19.one");
    }

        @Bean
        public Queue queue1() {
            return new AnonymousQueue();
        }

        @Bean
        public Binding binding1a(TopicExchange topic, Queue queue1) {
            return BindingBuilder.bind(queue1).to(topic).with(continent.concat(".").concat(country));
        }
}
