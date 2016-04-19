package com.firstutility.telco.store.service;

import com.firstutility.telco.store.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;

@Service
@Transactional
public class TelcoStoreServiceImpl implements TelcoStoreService {

    @Autowired
    private EventRepository eventRepository;

    public void saveEvent(final String applicationId, final String eventType, final String eventData) {

        Event event = new Event() {{
            setApplicationId(applicationId);
            setEventType(eventType);
            setEventDateTime(new Timestamp(new Date().getTime()));
            setEventData(eventData);
        }};

        eventRepository.save(event);
    }
}
