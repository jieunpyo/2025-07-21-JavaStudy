package com.sist.dao;

import lombok.Data;

/*
 *   ID    NOT NULL VARCHAR2(20)  
		PWD   NOT NULL VARCHAR2(10)  
		NAME  NOT NULL VARCHAR2(51)  
		POST  NOT NULL VARCHAR2(7)   
		ADDR1 NOT NULL VARCHAR2(250) 
		ADDR2          VARCHAR2(200)
 */
@Data
public class MemberVO {
  private String id;
  private String pwd;
  private String name;
  private String post;
  private String addr1;
  private String addr2;
  private int login;
  private String msg;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
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
public String getPost() {
	return post;
}
public void setPost(String post) {
	this.post = post;
}
public String getAddr1() {
	return addr1;
}
public void setAddr1(String addr1) {
	this.addr1 = addr1;
}
public String getAddr2() {
	return addr2;
}
public void setAddr2(String addr2) {
	this.addr2 = addr2;
}
public int getLogin() {
	return login;
}
public void setLogin(int login) {
	this.login = login;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
  
  
}