package com.vkpapps.events;

import org.springframework.context.ApplicationEvent;

public class CityLoadEvent extends ApplicationEvent {
    public CityLoadEvent(Object source) {
        super(source);
    }
}
