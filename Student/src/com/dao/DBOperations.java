package com.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.main.Main;

import com.student.StudentDetails;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class DBOperations {

	Scanner in = new Scanner(System.in);

	public void insertData(StudentDetails student, Session session, Transaction transaction) {

		try {

			System.out.println("Insertion Section");

			System.out.println("Student ID:");
			int studId = in.nextInt();
			student.setStudId(studId);
			in.nextLine();
			System.out.println("Student Name:");
			String studName = in.nextLine();
			student.setStudName(studName);

			System.out.println("Student Class:");
			String studClass = in.nextLine();
			student.setStudClass(studClass);

			System.out.println("Student DOB:");
			String studDOB = in.nextLine();
			student.setStudDOB(studDOB);

			System.out.println("Student age:");
			int studAge = in.nextInt();
			student.setStudAge(studAge);

			session.persist(student);
			transaction.commit();

			System.out.println(student + " data inserted....");

		} catch (Exception e) {
			System.out.println("Error:" + e);
		}
	}

	public void deleteData(StudentDetails student, Session session, Transaction transaction) {

		System.out.println("Delete Section");
		System.out.println("Enter ID for deletion");
		int id = in.nextInt();
		student = session.get(StudentDetails.class, id);
		session.remove(student);
		transaction.commit();

		System.out.println(student + " data is deleted....");

	}

	public void updateData(StudentDetails student, Session session, Transaction transaction) {

		try {

			System.out.println("Update Data");
			System.out.println("Enter a Student ID whose data you want to update");
			int studId = in.nextInt();
			
			student = session.get(StudentDetails.class, studId);
			
			int choice;
			do {
			System.out.println("1.studName 2.studClass 3.studDOB 4.studAge 0.Exit");
			System.out.println("Enter Choice");
			choice   =  in.nextInt();
			in.nextLine();

			switch(choice) {
			case 1: 
				System.out.println("Student Name:");
				String studName = in.nextLine();
				student.setStudName(studName);
				session.merge(student);
				transaction.commit();
				break;
			case 2: 
				System.out.println("Student Class:");
				String studClass = in.nextLine();
				student.setStudClass(studClass);
				session.merge(student);
				transaction.commit();
				break;
			case 3:
				System.out.println("Student DOB:");
				String studDOB = in.nextLine();
				student.setStudDOB(studDOB);
				session.merge(student);
				transaction.commit();
				break;
			case 4: 
				System.out.println("Student age:");
				int studAge = in.nextInt();
				student.setStudAge(studAge);
				session.merge(student);
				transaction.commit();
				break;
			case 0: 
				System.out.println("Exit from Update");
				break;
			default: System.out.println("Invalid Choice");			
			}			
			}while(choice!=0);
		} catch (Exception e) {

		}
	}

	public void showData( StudentDetails student ,Session session, Transaction transaction) {

		CriteriaBuilder hcb  = session.getCriteriaBuilder();
		CriteriaQuery<Object> cq = hcb.createQuery();
		Root<StudentDetails> root = cq.from(StudentDetails.class);
		
		cq.select(root);
		
		Query query = session.createQuery(cq);
		List<StudentDetails> list = query.getResultList();
		
		for(StudentDetails stud :list) {
			System.out.println(stud);
		}
		
		
	}

}
