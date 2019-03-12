package org.eventTest.listener;

import org.eventTest.event.TroubleEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by zhengtengfei on 2018/12/11.
 */
public class TroubleListener implements ApplicationListener<TroubleEvent> {
    @Override
    public void onApplicationEvent(TroubleEvent event) {
        System.out.println("TroubleListener >>>>>>event:" + event);
    }
}
