package com.wf.charpter21.proxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @Author: wangfa
 * @Date: 2020/3/25 22:02
 * @Description: 模拟动态代理
 */
public class ProxyUtil {


    /**  动态代理的聚合模式 将目标对象放置到我们的代理对象中
     *  * @param target 目标对象
     * 逻辑是死的 ，如果动态增强逻辑？
     * 对于不同的需求，所需要的动态逻辑是死的，所以我们不能简单地写死，而是根据不同的业务进行不同的增强，
     * 所以我们可以利用钩子函数
     * jdk 利用接口回调
     *  1. 生成java文件
     *  2.编程class文件
     *  3.jvm ClassLoad加载
     *  4.生成对象
     */
    public static Object newInstance(Object target){
        // 根据传递的目标对象，获取目标对象所实现的接口，这个接口也是代理对象要实现的，
        // 接口可能会多个，会处理多个，但是现在只取第一个
        Class<?> targetInf = target.getClass().getInterfaces()[0];

        String line = "\n";
        String tab ="\t";


        String content="";
        String infoName = targetInf.getSimpleName();
        String packageStr = "package com.wf;"+line;
        String importStr = "import "+targetInf.getName()+";"+line;
        String classFirstStr ="public class $Proxy implements "+ infoName+"{"+line;
        String filedStr = tab+"private "+infoName+" target;"+line;
        String  constractStr =tab+ "public $Proxy("+infoName+" target){ "+line+
                tab+tab+"this.target = target;"+line+
                tab+tab+"}"+line;


        // 重写所有的方法
        /** public void selectStudent() {
             teacherDao.selectStudent();
             }
         *
         */

        Method[] methods = targetInf.getDeclaredMethods();
        String methodStr = "";
        for (Method method : methods) {
            String  retutnStr = method.getReturnType().getSimpleName();
            String methodName = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            String argsStr="";
            String argsName="";
            for (int i = 0; i <parameterTypes.length ; i++) {
                argsStr+=parameterTypes[i].getName() +" param"+i+",";
                // 用作调用传递
                argsName+="param"+i+",";
            }
            argsStr = argsStr.length()!=0?argsStr.substring(0,argsStr.length()-1):"";
            argsName = argsName.length()!=0?argsName.substring(0,argsName.length()-1):"";

            methodStr +=tab+"public "+retutnStr+" "+methodName+"("+argsStr+"){"+line+
                        // 内容 死的代理逻辑
                    tab+tab+"System.out.println(\"假装增强log\");"+line;

            // 添加返回值
            if(method.getReturnType().getName().equals("void")){
                methodStr+= tab+tab+"target."+methodName+"("+argsName+");"+line+
                        tab+"}"+line;
            }else{
                methodStr+= tab+tab+" return target."+methodName+"("+argsName+");"+line+
                        tab+"}"+line;
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
            Constructor<?> constructor = aClass.getConstructor(targetInf);
            Object proxy = constructor.newInstance(target);

            return proxy;

        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }



}
