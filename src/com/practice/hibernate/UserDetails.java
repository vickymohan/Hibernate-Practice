package com.practice.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="USER_DETAILS")
@Inheritance(strategy=InheritanceType.JOINED)
public class UserDetails {
	@Column(name="USER_NAME")
	private String userName;
	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private int userId;
	@Column(name="JOINING_DATE")
	@Temporal(TemporalType.DATE)
	private Date joiningdate;
	@Column(name="DESCRIPTION")
	private String description;
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="VEHICLE_ID")
	private Vehicle veh;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.PERSIST)
	/*@JoinTable(name="LINKED_FBACCOUNTS",joinColumns=@JoinColumn(name="USER_ID"),inverseJoinColumns=@JoinColumn(name="MAIL_ID"))*/
	private List<FBAccounts> fb=new ArrayList<FBAccounts>();
	public List<FBAccounts> getFb() {
		return fb;
	}

	public void setFb(List<FBAccounts> fb) {
		this.fb = fb;
	}

	public Vehicle getVeh() {
		return veh;
	}

	public void setVeh(Vehicle veh) {
		this.veh = veh;
	}

	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="ADDRESS",joinColumns=@JoinColumn(name="USER_ID"))
	
	/*@GenericGenerator(name="sequence-gen",strategy="sequence")
	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "sequence-gen", type = @Type(type="int"))*/
	@OrderColumn(name="ADDRESS_ID")
	private List<Address> addr=new ArrayList<Address>();
	/*@Embedded
	@AttributeOverrides(value = { 
	@AttributeOverride(name="firstline",column=@Column(name="HOME_FIRST_LINE")),
	@AttributeOverride(name="secondline",column=@Column(name="HOME_SECOND_LINE")),
	@AttributeOverride(name="pincode",column=@Column(name="HOME_PINCODE")),
	@AttributeOverride(name="city",column=@Column(name="HOME_CITY"))
	})
	private Address address;
	@EmbeddedId
	@Embedded
	private Address officeAddress;*/
	
	public List<Address> getAddr() {
		return addr;
	}

	public void setAddr(List<Address> addr) {
		this.addr = addr;
	}

	public String getUserName() {
		return userName;
	}

	public Date getJoiningdate() {
		return joiningdate;
	}

	public void setJoiningdate(Date joiningdate) {
		this.joiningdate = joiningdate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
