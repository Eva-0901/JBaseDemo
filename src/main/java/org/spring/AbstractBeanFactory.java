package org.spring;

//Factory is the son of Registry :) LOL
//We treat different type of beans using different registry, but they all produced by factory.
//We divided the responsibility of bean factory into two abstract steps, get Bean Definition & Create Bean.
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory{


    //A draft get bean flow, no get Bean Definition & create Bean details.
    @Override
    public Object getBean(String beanName) throws BeansException {
        //Get from singleton bean registry table first.
        Object bean = super.getSingletonBean(beanName);
        if (bean != null) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

}
