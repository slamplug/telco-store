package com.firstutility.telco.store.service;

public interface TelcoStoreService {
    public void saveEvent(final String applicationId, final String eventType, final String eventData);
}
