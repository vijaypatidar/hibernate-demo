package com.vkpapps.listeners;

import com.vkpapps.events.CityLoadEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventListeners {
    static private final Logger logger = LoggerFactory.getLogger(EventListeners.class);

    @EventListener
    public void handleCityLoadEvent(CityLoadEvent event) {
        logger.info(event.toString());
    }

}
