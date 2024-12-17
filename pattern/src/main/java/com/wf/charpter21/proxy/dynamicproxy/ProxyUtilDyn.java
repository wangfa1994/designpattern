package com.wf.charpter21.proxy.dynamicproxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collections;

/**
 * @Author: wangfa
 * @Date: 2020/3/26 12:35
 * @Description: 动态代理我们的逻辑
 */
public class ProxyUtilDyn {


    /**
     *
     * @param targetInf targetInterface
     * @param h invocationHandler
     * @return
     */
    public static Object newInstancedDynamic(Class targetInf,DynamicProxyInvocationHandler h){

        String line = "\n";
        String tab ="\t";


        String content="";
        String infoName = targetInf.getSimpleName();
        String packageStr = "package com.wf;"+line;
        String importStr = "import "+targetInf.getName()+";"+line+
                "import com.wf.charpter21.proxy.dynamicproxy.DynamicProxyInvocationHandler;"+line+
                "import java.lang.reflect.Method;"+line;
        String classFirstStr ="public class $Proxy implements "+ infoName+"{"+line;

        // 属性
        String filedStr = tab+"private DynamicProxyInvocationHandler h;"+line;
        // 构造方法
        String  constractStr =tab+ "public $Proxy(DynamicProxyInvocationHandler h){ "+line+
                tab+tab+"this.h = h;"+line+
                tab+tab+"}"+line;


        // 重写所有的方法
        Method[] methods = targetInf.getDeclaredMethods();
        String methodStr = "";
        for (Method method : methods) {
            String  retutnStr = method.getReturnType().getSimpleName();
            String methodName = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            String argsStr="";
            String argsName="";

            // 获取参数
            String agrschuandi =tab+tab+"Object[] args = new Object[]{ ";
            String getMethodargs ="";
            for (int i = 0; i <parameterTypes.length ; i++) {
                argsStr+=parameterTypes[i].getName() +" param"+i+",";
                argsName+="param"+i+",";
                getMethodargs+=parameterTypes[i].getSimpleName()+".class,";
            }
            agrschuandi+=argsName;

            argsStr = argsStr.length()!=0?argsStr.substring(0,argsStr.length()-1):"";
            argsName = argsName.length()!=0?argsName.substring(0,argsName.length()-1):"";
            agrschuandi = agrschuandi.endsWith(",")?agrschuandi.substring(0,agrschuandi.length()-1):agrschuandi;
            agrschuandi+="};"+line;

            methodStr +=tab+"public "+retutnStr+" "+methodName+"("+argsStr+"){"+line+
                    tab+tab;
            // 这个方法是目标对象的方法，
            String proxyMethodStr ="try{"+line+ tab+tab+"Method method = Class.forName(\""+targetInf.getName()+"\").getDeclaredMethod(\""+methodName+"\"";
            // 判断是否有参数
            if(getMethodargs.length()!=0){
                proxyMethodStr+=","+getMethodargs;
                proxyMethodStr =proxyMethodStr.substring(0,proxyMethodStr.length()-1);
                proxyMethodStr+=");"+line;
            }else{
                proxyMethodStr+=");"+line;
            }



            // 注意我们调用的动态的方法是DynamicProxyInvocationHandler的invoke方法，参数的method，是目标对象的方法
            methodStr+=proxyMethodStr;
            // 加参数值
            methodStr+=agrschuandi;
            //判断返回值
            if(method.getReturnType().getName().equals("void")){

                methodStr+=tab+tab+"h.invoke(method,args);"+line;
                methodStr+=tab+tab+"}"+line;
            }else{
                methodStr+=tab+tab+"return ("+method.getReturnType().getSimpleName()+")h.invoke(method,args);"+line;
                methodStr+=tab+tab+"}"+line;
            }
            String exend = tab+tab+" catch (Exception e) {" +line+tab+tab+tab+tab+ "e.printStackTrace();\n" +tab+tab+"}"+line;

            //最后的返回
            if(method.getReturnType().getName().equals("void")){
                exend+=tab+tab+"}"+line;
                methodStr+=exend;
            }else{
                exend+=tab+tab+"return null;"+line+tab+tab+"}"+line;
                methodStr+=exend;


            }
        }

        content =packageStr+importStr+classFirstStr+filedStr+constractStr+methodStr+"}";

        try {


            File file = new File("F:/com/wf/$Proxy.java");
            if(!file.exists()){
                File parentFile = file.getParentFile();
                if(!parentFile.exists()){
                    parentFile.mkdirs();
                }
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.flush();
            fileWriter.close();



            // 编译成对应的.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager fileManager = compiler.getStandardFileManager(null,null,null);
            Iterable units = fileManager.getJavaFileObjects(file);
            JavaCompiler.CompilationTask t = compiler.getTask(null,fileManager,null,null,null,units);
            t.call();
            fileManager.close();


            // 加载class文件 利用URLClassLoader 是因为我们生成的文件不再我们的项目中
            URL[] urls = new URL[]{new URL("file:F:\\\\")};
            URLClassLoader urlClassLoader = new URLClassLoader(urls);
            Class<?> aClass = urlClassLoader.loadClass("com.wf.$Proxy");

            // 没有默认的构造方法，不能使用这种方式，
            // aClass.newInstance();

            //  new实例 根据参数确定构造方法 把目标对象放进去，返回代理对象
            Constructor<?> constructor = aClass.getConstructor(DynamicProxyInvocationHandler.class);
           Object proxy = constructor.newInstance(h);

            return proxy;

        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }


}
