package org.spring;

public interface BeanFactory {

    Object getBean(String beanName) throws BeansException;
}
