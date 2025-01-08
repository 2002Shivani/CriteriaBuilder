package com.main;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.dao.DBOperations;
import com.entity.DistrictDetails;

public class Main {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(DistrictDetails.class);
		
		DistrictDetails district = new DistrictDetails();

		System.out.println("Application Running......");
		DBOperations db = new DBOperations();
		
		
		
		int choice;
		do {
			
			
			System.out.println("1.Insert Data 2.Delete Data 3.Update Data 4.Show Data 0.Exit");
			System.out.println("Enter Choice(0-4):");
			choice = in.nextInt();
		

			switch (choice) {

			case 1:
				SessionFactory sessionFactory = configuration.buildSessionFactory();
				Session session = sessionFactory.openSession(); 
				Transaction transaction = session.beginTransaction();
				db.insertData(district, session, transaction);
				session.close();
				break;
			case 2:
				SessionFactory sessionFactoryD = configuration.buildSessionFactory();
				Session sessionD = sessionFactoryD.openSession(); 
				Transaction transactionD = sessionD.beginTransaction();
				db.deleteData(district, sessionD, transactionD);
				sessionD.close();
				break;
				
			case 3:
				SessionFactory sessionFactoryU = configuration.buildSessionFactory();
				Session sessionU = sessionFactoryU.openSession(); 
				Transaction transactionU = sessionU.beginTransaction();
				db.updateData(district, sessionU, transactionU);
				sessionU.close();
				break;
			case 4:
				SessionFactory sessionFactoryS = configuration.buildSessionFactory();
				Session sessionS = sessionFactoryS.openSession();
				Transaction transactionS = sessionS.beginTransaction();
				db.showData(district, sessionS, transactionS);
				sessionS.close();
				break;
		
				
			case 0:
				System.out.println("Exit");
				break;
			default:
				System.out.println("Invalid Choice");
				
			}
		} while (choice != 0);
		
	
	}

}
