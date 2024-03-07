package org.spring;

import java.util.HashMap;
import java.util.Map;

//emphasize the singleton.
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    //Singleton Bean registry table.
    private Map<String, Object> singletonObjects = new HashMap<>();
    @Override
    public Object getSingletonBean(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingletonBean(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

}
