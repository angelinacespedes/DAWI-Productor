package com.prestamo.kafka.service;

import com.prestamo.entity.Catalogo;
import com.prestamo.entity.Pais;
import com.prestamo.kafka.config.Event;
import com.prestamo.kafka.config.EventType;
import com.prestamo.kafka.entity.CatalogoCreateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class CatalogoEventService {

    @Autowired
    private KafkaTemplate<String, Event<?>> producer;

    @Value("${topic.customer.name:topic-catalogo-CESPEDES}")
    private String topicCatalogo;

    public void publish(Catalogo catalogo) {

        CatalogoCreateEvent created = new CatalogoCreateEvent();
        created.setData(catalogo);
        created.setId(UUID.randomUUID().toString());
        created.setType(EventType.CREATED);
        created.setDate(new Date());

        this.producer.send(topicCatalogo, created);
    }
}