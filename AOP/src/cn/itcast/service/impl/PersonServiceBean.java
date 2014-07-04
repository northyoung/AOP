package cn.itcast.service.impl;

import cn.itcast.service.PersonService;

/**
 * 1.��������ҵ�񷽷�
 * 2.�ж��û��Ƿ���Ȩ�ޣ���Ȩ�޾�������ִ��ҵ�񷽷���û��Ȩ�ޣ�������ִ��
 * ���Ƿ���Ȩ���Ǹ���user�Ƿ�Ϊnull��
 * �����Թؼ���
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
		System.out.println("����save()����");
	}

	@Override
	public void update(String name, Integer personid) {		
		System.out.println("����update()����");
	}

	@Override
	public String getPersonName(Integer personid) {
		System.out.println("����getPersoName()����");
		return "xxx";
	}

}
