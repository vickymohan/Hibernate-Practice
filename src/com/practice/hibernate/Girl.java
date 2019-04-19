package com.practice.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
@Entity
public class Girl extends UserDetails {
	@Column(name="GIRL_SCHOOL_NAME")
	private String schoolname;
	@Column(name="GIRL_STANDARD")
	private int standard;
	public String getSchoolname() {
		return schoolname;
	}
	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}
	public int getStandard() {
		return standard;
	}
	public void setStandard(int standard) {
		this.standard = standard;
	}
}
