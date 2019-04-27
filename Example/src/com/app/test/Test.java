package com.app.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.app.model.Address;
import com.app.model.Employee;
import com.app.util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		
		Transaction tx=null;
		//Transaction tx = ses.beginTransaction();
		try(Session ses1=HibernateUtil.getSf().openSession()) {
			tx = ses1.beginTransaction();

			Address a=new Address();
			a.setHno("5-76");
			a.setLoc("Hyd");
			
			Employee e=new Employee();
		     e.setEmpid(101);
		     e.setEmpname("sai");
		     e.setAddr(a);
		     
			ses1.save(e);
			tx.commit();
			
		  } 
		catch (Exception ex) { 
			tx.rollback(); 
			ex.printStackTrace();
			}
		  System.out.println("done");
		 
	}
}

