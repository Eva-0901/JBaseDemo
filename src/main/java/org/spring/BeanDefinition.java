package org.spring;

//Simplify the bean definition to only class type.
//Note: one bean corresponding to one bean definition instance.
public class BeanDefinition {

    private Class beanClass;

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return this.beanClass;
    }
}
