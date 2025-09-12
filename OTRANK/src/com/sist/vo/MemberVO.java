package com.sist.vo;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class MemberVO {
	private int id_num;
	private String nickname;
	private String Login_id;
	private String Login_pwd;
	private String sex;
	private String post;
	private String addr1;
	private String addr2;	
	private String phone;
	private String name;
	private String bandate;
	private String msg;
	public int getId_num() {
		return id_num;
	}
	public void setId_num(int id_num) {
		this.id_num = id_num;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getLogin_id() {
		return Login_id;
	}
	public void setLogin_id(String login_id) {
		Login_id = login_id;
	}
	public String getLogin_pwd() {
		return Login_pwd;
	}
	public void setLogin_pwd(String login_pwd) {
		Login_pwd = login_pwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBandate() {
		return bandate;
	}
	public void setBandate(String bandate) {
		this.bandate = bandate;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
