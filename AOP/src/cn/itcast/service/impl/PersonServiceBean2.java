package cn.itcast.service.impl;

import cn.itcast.service.PersonService;

/**
 * 
 * 本例使用cglib框架来实现AOP 需要引入cglib.jar文件
 * @author young 
 * 
 */

public class PersonServiceBean2 {
	private String user=null;
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	public PersonServiceBean2(){
		
	}
	public PersonServiceBean2(String user){
		this.user = user;
	} 
	
	public void save(String name) {
		System.out.println("我是save()方法");
	}
	
	public void update(String name, Integer personid) {		
		System.out.println("我是update()方法");
	}

	public String getPersonName(Integer personid) {
		System.out.println("我是getPersoName()方法");
		return "xxx";
	}

}
