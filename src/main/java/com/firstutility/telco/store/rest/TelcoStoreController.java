package com.firstutility.telco.store.rest;

import com.firstutility.telco.store.service.TelcoStoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TelcoStoreController {

    private static final Logger logger = LoggerFactory.getLogger(TelcoStoreController.class);

    @Autowired
    private TelcoStoreService telcoStoreService;

    @RequestMapping(path = "/store/{eventType}/{id}", method = RequestMethod.POST, consumes = {"application/json"})
    ResponseEntity<?> store(@PathVariable String eventType, @PathVariable String id, @RequestBody String jsonStr) {
        logger.info("eventType: " + eventType + ", id: " + id + ", body:" + jsonStr);

        telcoStoreService.saveEvent(id, eventType, jsonStr);

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(path = "/store/{eventType}/{id}", method = RequestMethod.GET, produces = {"application/json"})
    ResponseEntity<?> retrieve(@PathVariable(value = "eventType") String eventType, @PathVariable(value = "id") String id) {
        logger.info("eventType: " + eventType + ", id: " + id);

        return new ResponseEntity(HttpStatus.OK);
    }
}
