package cn.itcast.service.impl;

import cn.itcast.service.PersonService;

/**
 * 
 * ����ʹ��cglib�����ʵ��AOP ��Ҫ����cglib.jar�ļ�
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
		System.out.println("����save()����");
	}
	
	public void update(String name, Integer personid) {		
		System.out.println("����update()����");
	}

	public String getPersonName(Integer personid) {
		System.out.println("����getPersoName()����");
		return "xxx";
	}

}
