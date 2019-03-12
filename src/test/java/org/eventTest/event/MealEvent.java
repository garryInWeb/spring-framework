package org.eventTest.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by zhengtengfei on 2018/12/11.
 */
public class MealEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MealEvent(String mealContext) {
        super(mealContext);
    }
}
