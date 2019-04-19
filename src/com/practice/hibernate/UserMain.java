package com.practice.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserDetails user=new UserDetails();
		user.setUserName("Vicky");
		user.setJoiningdate(new Date());
		user.setDescription("first description");
		
		Address addr=new Address();
		addr.setFirstline("Sembakkam");
		addr.setSecondline("East Tambaram");
		addr.setPincode(600073);
		addr.setCity("Chennai");
		
		Address officeaddr=new Address();
		officeaddr.setFirstline("Thoraipakkam");
		officeaddr.setSecondline("OMR");
		officeaddr.setPincode(600119);
		officeaddr.setCity("Kanchipuram");
		user.getAddr().add(addr);
		user.getAddr().add(officeaddr);
		
		Vehicle v=new Vehicle();
		v.setType("Car");
		v.setWheels(4);
	
		FBAccounts fb=new FBAccounts();
		fb.setAge(25);
		fb.setGender("male");
		fb.setMailid("vckmohan54@gnail.com");
		
		FBAccounts fb2=new FBAccounts();
		fb2.setAge(26);
		fb2.setGender("female");
		fb2.setMailid("iyer897@gmail.com");
				
		user.setVeh(v);
		user.getFb().add(fb2);
		user.getFb().add(fb);
		
		v.setUser(user);
		
		fb.setUser(user);
		fb2.setUser(user);
		
		Boy b=new Boy();
		b.setSchoolName("DAV");
		b.setStandard(4);
		
		Girl g=new Girl();
		g.setSchoolname("KV");
		g.setStandard(6);
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session =sessionFactory.openSession();
		session.beginTransaction();
		session.persist(user);
		session.save(g);
		session.save(b);
		/*the objects for vehicle,fbaccounts gets saved even without saving them individually is beacuse of cascadetype=persist in user details class*/
		/*session.save(v);
		session.save(fb);
		session.save(fb2);*/
		session.getTransaction().commit();
		session.close();
		
		user=null;
		session =sessionFactory.openSession();
		user=session.get(UserDetails.class,1);
		System.out.println("the type of vehicle is "+user.getVeh().getType());
		session.close();
		System.out.println("the ID is "+user.getUserId()+" and the name is " +user.getUserName());
		for(Address a:user.getAddr())
			/*This executes even after session.close() because of fetchtype=Eager in the user details class hence it allows second level objects to be fetched*/
		System.out.println("He is a"+a.getCity()+" guy and works at "+a.getCity());
		/*session.close();*/
		
	}

}
