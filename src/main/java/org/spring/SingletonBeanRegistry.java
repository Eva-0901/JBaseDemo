package org.spring;

//Where is the register(add) method?
public interface SingletonBeanRegistry {

    Object getSingletonBean(String beanName);
}
