package com.wf.charpter21.twoProxy.jdkcglib;

public class EchoServiceImpl implements EchoService{

    @Override
    public String echo(String echo) {
        System.out.println("echoServiceImpl into");
        return echo;
    }
}
