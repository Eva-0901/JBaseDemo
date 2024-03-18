package org.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JavaProxyTest {

    public static void main(String[] args) {
        Object proxyInstance = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{EchoService.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //method 被代理的方法
                //args 方法的参数
                if (EchoService.class.isAssignableFrom(method.getDeclaringClass())) {
                    EchoService defaultService = new EchoServiceImpl();
                    String result = defaultService.echoInformation((String)args[0]);
                    System.out.println("[echo proxy]: " + (String)args[0]);
                    return result;
                }
                return null;
            }
        });

        EchoService echoServiceProxy = (EchoService) proxyInstance;
        ((EchoService) proxyInstance).echoInformation("Eva interview smoothly!");
    }
}
