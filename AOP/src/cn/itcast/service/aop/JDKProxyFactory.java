package cn.itcast.service.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import cn.itcast.service.impl.PersonServiceBean;

public class JDKProxyFactory implements InvocationHandler{
	private Object targetObject;
	public Object createProxyIntance(Object targetObject){
		this.targetObject = targetObject;
		//��һ����������װ�������ڶ���������������󣬵��������󣬻ص�  ������invoke����
		return Proxy.newProxyInstance(this.targetObject.getClass().getClassLoader(),this.targetObject.getClass().getInterfaces() , this);		  
	} 
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		PersonServiceBean bean = (PersonServiceBean)this.targetObject;
		Object result = null;
		if(bean.getUser()!=null){
			result = method.invoke(targetObject, args);
		}				
		return result;
	}
}
