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
		this.targetObject = targetObject; //目标类
		Enhancer enhancer = new Enhancer();
		//需要设置父类
		enhancer.setSuperclass(this.targetObject.getClass());//非final
		enhancer.setCallback((Callback) this);
		return enhancer.create();
		
	}
	@Override
	public Object intercept(Object proxy, Method method, Object[] args,
			MethodProxy methodProxy) throws Throwable {
		PersonServiceBean bean = (PersonServiceBean)this.targetObject;
		Object result = null; //环绕通知
		if(bean.getUser()!=null){
			//....advice(); -->前置通知
			try {
				result = methodProxy.invoke(targetObject, args);
				//afteradvice(); --> 后置通知
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//exceptionadvice();-->例外通知			
			} finally {
				//finallyadvice(); --> 最终通知
			}		
		}	
		return result;
	}
}
