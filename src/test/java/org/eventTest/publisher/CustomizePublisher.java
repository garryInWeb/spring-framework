package org.eventTest.publisher;

import org.eventTest.event.MealEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * Created by zhengtengfei on 2018/12/11.
 */
@Component
public class CustomizePublisher implements ApplicationEventPublisherAware{

    private ApplicationEventPublisher applicationEventPublisher;

    public void publish(MealEvent mealEvent){
        applicationEventPublisher.publishEvent(mealEvent);
    }
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
