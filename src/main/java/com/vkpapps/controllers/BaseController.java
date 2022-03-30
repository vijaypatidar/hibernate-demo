package com.vkpapps.controllers;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;

public abstract class BaseController implements ApplicationContextAware {
    protected ApplicationContext applicationContext;
    @Autowired
    protected ApplicationEventPublisher eventPublisher;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
