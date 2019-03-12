package org.eventTest.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by zhengtengfei on 2018/12/11.
 */
@Component
public class AllAcceptedListener implements ApplicationListener<ApplicationEvent> {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("AllAcceptedListener >>>>>>>>event:" + event);
    }
}
