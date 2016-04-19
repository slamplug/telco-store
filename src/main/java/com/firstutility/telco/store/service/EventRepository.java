package com.firstutility.telco.store.service;

import com.firstutility.telco.store.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {

}

