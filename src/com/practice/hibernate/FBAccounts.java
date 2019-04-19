package com.practice.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FBAccounts {
@Id
@Column(name="MAIL_ID",nullable=false)
private String mailid;
public String getMailid() {
	return mailid;
}
public void setMailid(String mailid) {
	this.mailid = mailid;
}
@ManyToOne
@JoinColumn(name="USER_ID")
private UserDetails user;
public UserDetails getUser() {
	return user;
}
public void setUser(UserDetails user) {
	this.user = user;
}
@Column(name="GENDER")
private String gender;
@Column(name="AGE")
private int age;
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
}
