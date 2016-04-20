package com.wipro.hmsc.domain;

/**
 * 
 * @author si255323
 *
 */
public class User {

	private String userid;
	private String pwd;
	private String name;
	private int age;
	private String type;
	
	public User(String userid, String pwd, String type, String name, int age) {
		this.userid = userid;
		this.pwd = pwd;
		this.type = type;
		this.name = name;
		this.age = age;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public boolean equals(Object o) {
		return ((User)o).getUserid().equals(userid);
	}
	
	public String getType() {
		return type;
	}

}
