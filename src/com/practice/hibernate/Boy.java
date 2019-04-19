package com.practice.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
@Entity
public class Boy extends UserDetails {
@Column(name="BOY_SCHOOL_NAME")	
private String schoolName;
@Column(name="BOY_STANDARD")
private int standard;
public String getSchoolName() {
	return schoolName;
}
public void setSchoolName(String schoolName) {
	this.schoolName = schoolName;
}
public int getStandard() {
	return standard;
}
public void setStandard(int standard) {
	this.standard = standard;
}
}
