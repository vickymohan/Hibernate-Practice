package com.practice.hibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address implements Serializable{
@Column(name="FIRST_LINE")
private String firstline;
@Column(name="SECOND_LINE")
private String secondline;
public String getFirstline() {
	return firstline;
}
public void setFirstline(String firstline) {
	this.firstline = firstline;
}
public String getSecondline() {
	return secondline;
}
public void setSecondline(String secondline) {
	this.secondline = secondline;
}
public int getPincode() {
	return pincode;
}
public void setPincode(int pincode) {
	this.pincode = pincode;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
@Column(name="PINCODE")
private int pincode;
@Column(name="CITY")
private String city;
}
