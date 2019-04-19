package com.practice.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Vehicle {
@Id	@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="VEHICLE_ID")
private int vehicleId;
@OneToOne
private UserDetails user;
public UserDetails getUser() {
	return user;
}
public void setUser(UserDetails user) {
	this.user = user;
}
public int getVehicleId() {
	return vehicleId;
}
public void setVehicleId(int vehicleId) {
	this.vehicleId = vehicleId;
}
@Column(name="VEHICLE_TYPE")
private String type;
@Column(name="WHEELS")
private int wheels;
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public int getWheels() {
	return wheels;
}
public void setWheels(int wheels) {
	this.wheels = wheels;
}
}
