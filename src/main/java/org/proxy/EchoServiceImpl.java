package org.proxy;

public class EchoServiceImpl implements EchoService{
    @Override
    public String echoInformation(String info) {
        System.out.println("Info in echo service: " + info);
        return info;
    }
}
