package com.wf.charpter21.twoProxy.cglib;

import net.sf.cglib.proxy.*;

import java.lang.reflect.Method;
import java.util.Arrays;

public class CheckErrorMain {

    /**
     * CGLIB 生成的代理类会：
     * 继承父类：使用 setSuperclass 指定的父类。
     * 实现接口：使用 setInterfaces 指定的接口。
     * 然而，接口中的方法必须有具体的实现逻辑才能被调用。如果父类中没有实现这些接口方法，那么即使代理类实现了接口，调用这些方法时仍然会抛出 NoSuchMethodError 或其他类似错误。
     *
     * 所以我们的setSuperclass 必须要实现所有的接口逻辑，并且存在对应的方法
     *
     * 问：我设置了接口，但是类中没有对应的接口方法实现，我设置这个接口的意义是什么呢
     * 答：你提到的问题涉及到CGLIB代理机制的核心原理。理解这一点对于正确使用CGLIB非常重要
     * 设置接口的意义：
     * 当你在CGLIB中使用 setInterfaces 方法时，其主要目的是
     * 1.增强功能：让生成的代理类不仅继承父类，还能实现指定的接口。这使得代理对象可以被当作这些接口的实例来使用
     * 2.方法拦截：通过接口定义的方法可以在代理类中被拦截和增强，即使父类中没有实现这些方法
     *
     * 关键点解释
     * 1. 接口实现与方法拦截
     * 接口实现：设置接口后，生成的代理类会实现这些接口。这意味着你可以将代理对象强制转换为这些接口类型，并调用接口中定义的方法。
     * 方法拦截：即使父类中没有实现接口方法，CGLIB也会通过回调机制（如 MethodInterceptor）来处理这些方法调用。也就是说，接口方法的调用会被拦截器捕获并处理。
     * 2. 父类与接口的关系
     * 父类方法优先：如果父类中已经实现了接口中的某些方法，那么这些方法的调用会直接调用父类中的实现，除非你在拦截器中显式地覆盖了这些行为。
     * 接口方法未实现时：如果父类中没有实现接口方法，CGLIB 会依赖于你提供的回调逻辑（如 MethodInterceptor）来处理这些方法调用。如果没有合适的回调逻辑，确实会导致 NoSuchMethodError 或其他异常。
     *
     * 解决方案
     * 为了确保你的代码能够正常工作，建议如下：
     * 提供回调逻辑：确保所有接口方法都有对应的拦截器处理逻辑。即使父类中没有实现这些方法，拦截器也可以处理这些调用。
     * 选择合适的增强目标：如果你希望接口方法有具体的实现逻辑，可以选择一个已经实现这些接口方法的类作为增强目标，或者在父类中实现这些方法
     *
     */

    interface CglibAnother {

        String anotherEcho(String s);

    }

    static class CglibAnotherImpl implements CglibAnother {

        @Override
        public String anotherEcho(String s) {
            System.out.println("进入了原始对象anotherEcho");
            return s;
        }
    }
    static class CglibEcho {


        public String echo(String s) {
            System.out.println("进入了原始对象echo");
            return s;
        }

        public String echo1(String s) {
            System.out.println("进入了原始对象echo1");
            return s;
        }
    }

    public static void main(String[] args) {
        MethodInterceptor methodInterceptor1 = new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("进入了代理代理逻辑intercept1："+ Arrays.toString(objects));
                Object result = methodProxy.invokeSuper(o, objects);
                System.out.println("原始方法进行执行完成，返回："+result);
                return result;
            }
        };
        MethodInterceptor methodInterceptor2 = new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("进入了代理代理逻辑intercept2："+ Arrays.toString(objects));
                Object result = methodProxy.invokeSuper(o, objects);
                System.out.println("原始方法进行执行完成，返回："+result);
                return result;
            }
        };
        MethodInterceptor methodInterceptor3 = new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("进入了代理代理逻辑intercept3："+ Arrays.toString(objects));
                // 这里我可以针对这个方法进行单独逻辑处理，而不会是在进行对应的方法硬调用
                //Object result = methodProxy.invokeSuper(o, objects); // TODO 解决问题的关键就是不让他在进行原逻辑处理，而是转为自定义逻辑
                System.out.println("我做了一些特殊的逻辑处理比如开启监控");


                return null;
            }
        };

        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(Thread.currentThread().getContextClassLoader());
        enhancer.setUseCache(false);
        enhancer.setSuperclass(CglibEcho.class); // 既设置了目标类 又设置了目标接口 ，这样的话，我们的代理类就会继承代理类，实现代理接口,
        enhancer.setInterfaces(new Class[]{CglibAnother.class});
        enhancer.setCallbackFilter(new CallbackFilter() {
            @Override
            public int accept(Method method) {
                if(method.getName().equals("echo")){
                    return 0;
                }
                else if (method.getName().equals("echo1")) {
                    return 1;
                } else if(method.getName().equals("anotherEcho")){
                    return 2;
                }
                return 0;
            };
        });
        enhancer.setCallbacks(new Callback[]{methodInterceptor1,methodInterceptor2,methodInterceptor3}); // 这个设置的回调逻辑的实现类，是设置在callBackTypes中的类型

        CglibEcho echo = (CglibEcho)enhancer.create();
        echo.echo("hello");
        echo.echo1("hello");
        CglibAnother another = (CglibAnother)enhancer.create();
        another.anotherEcho("another");
        // 代理类的方法调用，不一定是要在superClass中进行有实现的 ，但是我们的回调业务逻辑一定要进行拦截处理。
    }
}
