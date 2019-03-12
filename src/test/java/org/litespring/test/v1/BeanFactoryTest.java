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

public class BeanFactoryTest {

    DefaultListableBeanFactory factory;
    XmlBeanDefinitionReader reader;
    @Before
    public void setUp(){
        factory = new DefaultListableBeanFactory();
        reader = new XmlBeanDefinitionReader(factory);
    }
    @Test
    public void testBeanFactory(){

        reader.loadBeanDefinitions(new ClassPathResource("petstore-v1.xml"));

        // singleton 测试
        BeanDefinition bd = factory.getBeanDefinition("petStore");

        assertTrue(bd.isSingleton());

        assertFalse(bd.isPrototype());

//        assertEquals(BeanDefinition.SCOPE_SINGLETON,bd.getScope());

        assertEquals("org.litespring.service.v1.PetStoreService",bd.getBeanClassName());

        PetStoreService petStoreService = (PetStoreService)factory.getBean("petStore");

        assertNotNull(petStoreService);

        PetStoreService petStoreService1 = (PetStoreService)factory.getBean("petStore");

        assertTrue(petStoreService.equals(petStoreService1));

        // prototype 测试
        BeanDefinition prototypeStore = factory.getBeanDefinition("prototypeStore");

        assertTrue(prototypeStore.isPrototype());

        assertFalse(prototypeStore.isSingleton());

        assertEquals(BeanDefinition.SCOPE_PROTOTYPE,prototypeStore.getScope());

        PrototypeService prototypeService = (PrototypeService)factory.getBean("prototypeStore");

        assertNotNull(prototypeService);

        PrototypeService prototypeService1 = (PrototypeService)factory.getBean("prototypeStore");

        assertFalse(prototypeService.equals(prototypeService1));

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
