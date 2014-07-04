package cn.itcast.service.impl;

import cn.itcast.service.PersonService;

/**
 * 1.拦截所有业务方法
 * 2.判断用户是否有权限，有权限就允许他执行业务方法，没有权限，不允许执行
 * （是否有权限是根据user是否为null）
 * 横切性关键点
 * @author young
 *
 */

public class PersonServiceBean implements PersonService {
	private String user=null;
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	public PersonServiceBean(){
		
	}
	public PersonServiceBean(String user){
		this.user = user;
	} 
	
	@Override
	public void save(String name) {
		System.out.println("我是save()方法");
	}

	@Override
	public void update(String name, Integer personid) {		
		System.out.println("我是update()方法");
	}

	@Override
	public String getPersonName(Integer personid) {
		System.out.println("我是getPersoName()方法");
		return "xxx";
	}

}
