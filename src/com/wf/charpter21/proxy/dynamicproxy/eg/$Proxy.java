package com.wf.charpter21.proxy.dynamicproxy.eg;
import com.wf.charpter21.proxy.TeacherDao;
import com.wf.charpter21.proxy.dynamicproxy.DynamicProxyInvocationHandler;
import java.lang.reflect.Method;
public class $Proxy implements TeacherDao{
	private DynamicProxyInvocationHandler h;
	public $Proxy(DynamicProxyInvocationHandler h){ 
		this.h = h;
		}
	public void selectStudent(){
		try{
		Method method = Class.forName("com.wf.charpter21.proxy.TeacherDao").getDeclaredMethod("selectStudent");
		Object[] args = new Object[]{ };
		h.invoke(method,args);
		}
		 catch (Exception e) {
				e.printStackTrace();
		}
		}
	public Integer getAge(Integer param0, Integer param1){
		try{
		Method method = Class.forName("com.wf.charpter21.proxy.TeacherDao").getDeclaredMethod("getAge",Integer.class,Integer.class);
		Object[] args = new Object[]{ param0,param1};
		return (Integer)h.invoke(method,args);
		}
		 catch (Exception e) {
				e.printStackTrace();
		}
		return null;
		}

	/**
	 * 生成的代理类
	 */
}