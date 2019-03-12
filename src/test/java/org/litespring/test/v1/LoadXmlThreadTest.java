package org.litespring.test.v1;

import org.junit.Before;
import org.junit.Test;
import org.litespring.service.v1.PetStoreService;
import org.litespring.service.v1.PrototypeService;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import static org.junit.Assert.*;

public class LoadXmlThreadTest {

    DefaultListableBeanFactory factory;
    XmlBeanDefinitionReader reader;
    @Before
    public void setUp(){
        factory = new DefaultListableBeanFactory();
        reader = new XmlBeanDefinitionReader(factory);
    }
    @Test
    public void testBeanFactory(){

        new Thread(() -> {
            reader.loadBeanDefinitions(new ClassPathResource("petstore-v1.xml"));
        }).start();
        new Thread(() -> {
            reader.loadBeanDefinitions(new ClassPathResource("petstore-v1.xml"));
        }).start();

        new Thread(() -> {
            reader.loadBeanDefinitions(new ClassPathResource("petstore-v1.xml"));
        }).start();

        new Thread(() -> {
            reader.loadBeanDefinitions(new ClassPathResource("petstore-v1.xml"));
        }).start();

        new Thread(() -> {
            reader.loadBeanDefinitions(new ClassPathResource("petstore-v1.xml"));
        }).start();

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {

        }
        reader.loadBeanDefinitions(new ClassPathResource("petstore-v1.xml"));
    }

    @Test
    public void testBeanCreationException(){

        reader.loadBeanDefinitions(new ClassPathResource("petstore-v1.xml"));

        try{
            factory.getBean("abc");
        }catch (BeanCreationException e){
            return;
        }
        fail("exception BeanCreationException");
    }

    @Test
    public void testBeanDefinitionException(){
        try{
            reader.loadBeanDefinitions(new ClassPathResource("abv.xml"));
        }catch (BeanDefinitionStoreException e){
            return;
        }
        fail("exception BeanDefinitionException");
    }
}
