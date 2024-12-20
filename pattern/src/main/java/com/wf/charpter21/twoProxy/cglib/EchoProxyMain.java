package com.wf.charpter21.twoProxy.cglib;




import com.wf.charpter21.twoProxy.jdkcglib.EchoService;
import net.sf.cglib.core.DefaultGeneratorStrategy;
import net.sf.cglib.core.DefaultNamingPolicy;
import net.sf.cglib.proxy.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class EchoProxyMain {


    public static void main(String[] args) {

        //firstEnhancer();

        //secondEnhancer();

       // threeEnhancer();
       // fourEnhancer();
        // fiveEnhancer();
        checkError();

    }



    private static void checkError(){
        //先默认两个增强逻辑
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
                Object result = methodProxy.invokeSuper(o, objects);
                System.out.println("原始方法进行执行完成，返回："+result);
                return result;
            }
        };

        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(Thread.currentThread().getContextClassLoader());
        enhancer.setUseCache(false);
        enhancer.setSuperclass(CglibEcho.class);
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
    }


    private static void fiveEnhancer(){
        //先默认两个增强逻辑
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


        // 模仿SpringAop的 enchaner创建

        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(Thread.currentThread().getContextClassLoader()); // 设置类加载器 ，这个类加载器用来生产增强代理类
        enhancer.setUseCache(false); // 是否为具有相同属性的类使用和更新生成类的静态缓存。默认为true。
        //enhancer.setSuperclass(CglibEcho.class); // 设置我们要增强的类，如果这个类有超类的话，使用我们的setInterfaces设置接口是最好的,代理类会继承这个类
        enhancer.setSuperclass(CglibAnotherImpl.class); // 设置新生成的代理类要继承的父类
        enhancer.setInterfaces(new Class[]{CglibAnother.class}); // 指定生成的代理类所要实现的接口 ，这两个方法结合使用，可以让cglib动态生成一个继承指定父类并实现指定接口的新类

        enhancer.setNamingPolicy(new CustomerNamingPolic()); // 设置我们的命名策略 生成对应子类的命名

        enhancer.setStrategy(new CustomerGeneratorStrategy()); // 设置用于从此生成器创建字节码的策略,可以通过这里得到我们的字节码
        enhancer.setCallbackFilter(new CustomerCallbackFilter(CglibAnotherImpl.class.getName()));// 当我们存在多个增强逻辑的时候，我们需要进行判断方法要使用哪个增强逻辑，通过这个回调过滤器进行返回增强逻辑的数组下标


        enhancer.setCallbackTypes(new Class[]{ MethodInterceptor.class ,MethodInterceptor.class}); // 设置要使用的回调类型数组 , 当调用createClass时，可以用它来代替setCallbacks
        enhancer.setInterceptDuringConstruction(false); // 设置是否拦截从代理的构造函数内部调用的方法。
        enhancer.setCallbacks(new Callback[]{methodInterceptor1,methodInterceptor2}); // 这个设置的回调逻辑的实现类，是设置在callBackTypes中的类型

        CglibEcho echo = (CglibEcho)enhancer.create();
        echo.echo("hello");
        echo.echo1("hello");
        CglibAnother another = (CglibAnother)enhancer.create();
        another.anotherEcho("another");



    }

    private static void fourEnhancer(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CglibEcho.class); // 设置我们的增强类


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

        CallbackFilter filter1 = new CallbackFilter() {
            @Override
            public int accept(Method method) {
                if(method.getName().equals("echo")){
                    return 0;
                }
                else if (method.getName().equals("echo1")) {
                    return 1;
                }
                return 0;
            }
        };

        // 设置我们方法调用时的增强逻辑,  当我们设置多个增强逻辑的时候，需要添加我们的Filter进行过滤，指定哪些方法使用哪个回调增强
        enhancer.setCallbacks(new Callback[]{methodInterceptor1,methodInterceptor2});
        enhancer.setCallbackFilter(filter1);

        CglibEcho o = (CglibEcho)enhancer.create();
        String echo = o.echo("echo");
        System.out.println(echo);
        System.out.println("=======");
        String echo1 = o.echo1("echo");
        System.out.println(echo1);

    }



    private static void threeEnhancer() {
        Enhancer enhancer = new Enhancer(); //Enhancer 相当于jdk代理中的Proxy
        enhancer.setSuperclass(CglibEcho.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("进入了代理代理逻辑intercept："+ Arrays.toString(objects));
                Object result = methodProxy.invokeSuper(o, objects);
                System.out.println("原始方法进行执行完成，返回："+result);
                return result;
            }
        });

        enhancer.setStrategy(new DefaultGeneratorStrategy() {
            protected byte[] transform(byte[] b) {
                addClassToDisk(b);
                return b;

            }});
        CglibEcho cglibEcho = (CglibEcho)enhancer.create();
        cglibEcho.echo("echo");

    }

    private static void secondEnhancer() {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);

        FixedValue helloCglibLoadObject = new FixedValue() {
            @Override
            public Object loadObject() throws Exception {
                System.out.println("hello cglib loadObject");
                return "loadObject method callback!";
            }
        };

        InvocationHandler helloCglibInvoke = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("hello cglib invoke");
                return "invoke method callback";
            }

            ;
        };

        // 进行回调
        enhancer.setCallbacks(new Callback[]{helloCglibLoadObject,helloCglibInvoke});
        SampleClass proxy = (SampleClass) enhancer.create();
        System.out.println(proxy.test(null));


    }

    private static void firstEnhancer() {
        Enhancer enhancer = new Enhancer(); //Enhancer 相当于jdk代理中的Proxy
        enhancer.setSuperclass(SampleClass.class);
        // 进行回调
        enhancer.setCallback(new FixedValue() {
            @Override
            public Object loadObject() throws Exception {
                System.out.println("hello cglib loadObject");
                return "loadObject method callback!";
            }
        });

        // 进行文件保存
        enhancer.setStrategy(new DefaultGeneratorStrategy() {
            protected byte[] transform(byte[] b) {
                addClassToDisk(b);
                return b;

            }});

        SampleClass proxy = (SampleClass) enhancer.create();
        // System.out.println(proxy.hashCode()); // 报错，因为FixedValue 拦截的总会返回一个String对象 而hashCode则需要number
        System.out.println(proxy.test(null));
    }





    private static void addClassToDisk(byte[] b) {

        FileOutputStream out = null;
        try {
            // jdk 动态代理会在项目的根目录下生成对应的class文件，$Proxy
            out = new FileOutputStream("$CglibProxy.class");
            //将代理对象的class字节码写到硬盘上
            out.write(b);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    static class CustomerNamingPolic extends DefaultNamingPolicy {
        @Override
        protected String getTag() {
            return "ByCustomerCGLIB";
        }

    }
    static class CustomerGeneratorStrategy extends DefaultGeneratorStrategy{
        @Override
        protected byte[] transform(byte[] b) throws Exception {
            addClassToDisk(b);
            return super.transform(b);
        }
    }

    static class CustomerCallbackFilter implements CallbackFilter{

        // 只是单纯的一个属性，用来确定传参
        private String className;

        public CustomerCallbackFilter(String className) {
            this.className = className;
        }

        @Override
        public int accept(Method method) {
            System.out.println("className"+className);
            if(method.getName().equals("echo")){
                return 0;
            }
            else if (method.getName().equals("echo1")) {
                return 1;
            } else if(method.getName().equals("anotherEcho")){
                return 0;
            }

            return 0;
        }
    }
}
