package org.eventTest.TestMain;

import org.eventTest.event.MealEvent;
import org.eventTest.event.TroubleEvent;
import org.eventTest.publisher.CustomizePublisher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhengtengfei on 2018/12/11.
 */
public class TestPortal {
    public static void main(String[] args) throws InterruptedException {
        final ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("event/test.xml");

        String[] definitionNames = classPathXmlApplicationContext.getBeanDefinitionNames();
        System.out.println("=============bean start=================");
        for (String definitionName : definitionNames){
            System.out.println("bean-----" + definitionName);
        }
        System.out.println("=============bean end=================");

        final CustomizePublisher customizePublisher = classPathXmlApplicationContext.getBean(CustomizePublisher.class);

        Thread thread = new Thread(() -> {
            System.out.println("meal begin");

            MealEvent mealEvent = new MealEvent("meal award");
            customizePublisher.publish(mealEvent);

        });
        thread.setName("meal-thread");
        thread.start();

        thread.join();
    }
}
