package com.wf.charpter21.twoProxy.jdkcglib;

import java.lang.reflect.Proxy;

public class EchoProxyMain {

    public static void main(String[] args) {
        // 代理类再被代理？

        EchoService proxyInstance = (EchoService)Proxy.newProxyInstance(EchoProxyMain.class.getClassLoader(), new Class[]{EchoService.class}, new EchoProxy());

        String echo = proxyInstance.echo("hello");


        // 进行二层代理 ，这里其实不是真正的二类代理， 代理类你再进行代理的时候，其实得到的还是第一个代理类的接口，和第一个代理是一样的。 只不过是由增加了二层上的逻辑
        // 产生的代理类的字节码是一样的，只是名称会累加一
        //EchoService secondProxy = (EchoService)Proxy.newProxyInstance(EchoProxyMain.class.getClassLoader(), new Class[]{EchoService.class}, new SecondProxy(proxyInstance));
        EchoService secondProxy = (EchoService)Proxy.newProxyInstance(EchoProxyMain.class.getClassLoader(), proxyInstance.getClass().getInterfaces(), new SecondProxy(proxyInstance));

        String echo2 = secondProxy.echo("hello");
        System.out.println("进行了二次代理:"+echo2);

    }
}
