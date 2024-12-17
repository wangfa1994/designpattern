package com.wf.charpter21.twoProxy.cglib;



import net.sf.cglib.proxy.*;

import java.lang.reflect.Method;
import java.util.Arrays;

public class SampleClass {

    // https://www.cnblogs.com/CarpenterLee/p/8241042.html
    //https://dzone.com/articles/cglib-missing-manual
    // https://mydailyjava.blogspot.com/2013/11/cglib-missing-manual.html


    /**
     * 继承代理，会代理Object 的 hashCode,toString, equals三个方法
     * 无法代理final方法，
     * 生成的字节码和代理类在同一个包中
     * FixedValue 拦截器所拦截的所有方法都会返回此值
     * InvocationHandler  拦截可能导致无限循环调用
     * MethodInterceptor
     *
     */

    public String test(String input) {
        System.out.println("test1");
        return "Hello world!";
    }
    public String test2(){
        System.out.println("test2");
        return "hello world!2";}
    public void test3(){
        System.out.println("test3");
    }


    public static void main(String[] args) throws Exception {
        //testFixedValue();
        testInvocationHandlerError();
        //testInvocationHandler();
    }


    // 方法的返回值很容易的被拦截进行替换，这个会拦截所有的方法，
    // 直接进行返回值的替换，而不再进行原方法逻辑执行
    public static void testFixedValue() throws Exception {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(new FixedValue() {
            @Override
            public Object loadObject() throws Exception {
                return "Hello cglib!";
            }
        });
        SampleClass proxy = (SampleClass) enhancer.create();
        System.out.println( proxy.test(null));
        System.out.println( proxy.test2());
        proxy.test3();
    }

    public static void testInvocationHandlerError() throws Exception {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args)
                    throws Throwable {
                System.out.println(String.format("进入InvocationHandler方法:%s,%s,%s",proxy,method, Arrays.toString(args)));
                return method.invoke(proxy,args);
            }
        });
        SampleClass proxy = (SampleClass) enhancer.create();
        System.out.println( proxy.test(null)); //无限循环 因为任何一次的方法调用都会被转发到InvocationHandler中
        System.out.println( proxy.toString());


    }

    public static void testInvocationHandler() throws Exception {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args)
                    throws Throwable {
                if(method.getDeclaringClass() != Object.class
                        && method.getReturnType() == String.class) {
                    return "Hello cglib!";
                } else {
                    throw new RuntimeException("Do not know what to do.");
                }
            }
        });
        SampleClass proxy = (SampleClass) enhancer.create();
        System.out.println( proxy.test(null)); // "Hello cglib!"
        System.out.println( proxy.toString()); // "Hello cglib!"


    }

    //使用MethodInterceptor 进行解决上述问题
    public void testMethodInterceptor() throws Exception {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
                    throws Throwable {
                if(method.getDeclaringClass() != Object.class
                        && method.getReturnType() == String.class) {
                    return "Hello cglib!";
                } else {
                    return proxy.invokeSuper(obj, args);
                }
            }
        });
        SampleClass proxy = (SampleClass) enhancer.create();

        System.out.println(proxy.test(null));
        System.out.println( proxy.toString());
        System.out.println(proxy.hashCode());; // Does not throw an exception or result in an endless loop.
    }

    public void testCallbackFilter() throws Exception {
        Enhancer enhancer = new Enhancer();
        CallbackHelper callbackHelper = new CallbackHelper(SampleClass.class, new Class[0]) {
            @Override
            protected Object getCallback(Method method) {
                if(method.getDeclaringClass() != Object.class
                        && method.getReturnType() == String.class) {
                    return new FixedValue() {
                        @Override
                        public Object loadObject() throws Exception {
                            return "Hello cglib!";
                        };
                    };
                } else {
                    return NoOp.INSTANCE; // A singleton provided by NoOp.
                }
            }
        };
        enhancer.setSuperclass(MyClass.class);
        enhancer.setCallbackFilter(callbackHelper);
        enhancer.setCallbacks(callbackHelper.getCallbacks());
        SampleClass proxy = (SampleClass) enhancer.create();
        System.out.println(proxy.test(null));
        System.out.println( proxy.toString());
        proxy.hashCode(); // Does not throw an exception or result in an endless loop.
    }


    class MyClass{

    }


}
