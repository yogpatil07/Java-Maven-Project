package com.deloitte.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class AddDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			System.out.println("Enter Name");
			String name = sc.next();
			System.out.println("Enter Salary");
			Double sal = sc.nextDouble();

			Employee e = new Employee(name, sal);
			
			session.save(e);

			session.getTransaction().commit();
			
			System.out.println("Done.. ");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
			factory.close();
		}
	}
}