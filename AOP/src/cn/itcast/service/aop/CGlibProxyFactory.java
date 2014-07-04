package cn.itcast.service.aop;

import java.lang.reflect.Method;

import cn.itcast.service.impl.PersonServiceBean;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGlibProxyFactory implements MethodInterceptor {
	private Object targetObject;
	public Object createProxyIntance(Object targetObject){
		this.targetObject = targetObject; //Ŀ����
		Enhancer enhancer = new Enhancer();
		//��Ҫ���ø���
		enhancer.setSuperclass(this.targetObject.getClass());//��final
		enhancer.setCallback((Callback) this);
		return enhancer.create();
		
	}
	@Override
	public Object intercept(Object proxy, Method method, Object[] args,
			MethodProxy methodProxy) throws Throwable {
		PersonServiceBean bean = (PersonServiceBean)this.targetObject;
		Object result = null; //����֪ͨ
		if(bean.getUser()!=null){
			//....advice(); -->ǰ��֪ͨ
			try {
				result = methodProxy.invoke(targetObject, args);
				//afteradvice(); --> ����֪ͨ
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//exceptionadvice();-->����֪ͨ			
			} finally {
				//finallyadvice(); --> ����֪ͨ
			}		
		}	
		return result;
	}
}
