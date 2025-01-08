package com.dao;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.entity.DistrictDetails;
import com.main.Main;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class DBOperations {

	Scanner in = new Scanner(System.in);

	public void insertData(DistrictDetails district, Session session, Transaction transaction) {

		try {
			System.out.println("districtId:");
			int id = in.nextInt();
			district.setDistrictId(id);
			in.nextLine();
			System.out.println("districtName:");
			String name = in.nextLine();
			district.setDistrictName(name);
			System.out.println("districtPopulation:");
			int poln = in.nextInt();
			district.setDistrictPopulation(poln);
			in.nextLine();
			System.out.println("districtIASName:");
			String ias = in.nextLine();
			district.setDistrictIASName(ias);
			System.out.println("districtPinCode:");
			int pin = in.nextInt();
			district.setDistrictPinCode(pin);
			in.nextLine();
			System.out.println("distictState:");
			String state = in.nextLine();
			district.setDistictState(state);

			session.persist(district);
			transaction.commit();

			System.out.println(district + " data is inserted");
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}
	}

	public void deleteData(DistrictDetails district, Session session, Transaction transaction) {

		System.out.println("Delete Section");
		System.out.println("Enter ID for deletion");
		int id = in.nextInt();

		district = session.get(DistrictDetails.class, id);
		session.remove(district);
		transaction.commit();

		System.out.println(district + " data is deleted....");

	}

	public void updateData(DistrictDetails district, Session session, Transaction transaction) {

		System.out.println("Update Section");
		System.out.println("Enter District districtId for data update");
		int districtId = in.nextInt();
		district = session.get(DistrictDetails.class, districtId);
		int choice;

		do {
			System.out.println(
					"1.districtName 2.districtPopulation 3.districtIASName 4.districtPinCode 5.distictState 0.Exit");
			System.out.println("Enter Update Choice:");
			choice = in.nextInt();
			in.nextLine();
			switch (choice) {
			case 1:
				System.out.println("districtName:");
				String name = in.nextLine();
				district.setDistrictName(name);
				session.merge(district);
				transaction.commit();

				break;
			case 2:
				System.out.println("districtPopulation:");
				int poln = in.nextInt();
				district.setDistrictPopulation(poln);
				session.merge(district);
				transaction.commit();
				break;
			case 3:
				System.out.println("districtIASName:");
				String ias = in.nextLine();
				district.setDistrictIASName(ias);
				session.merge(district);
				transaction.commit();
				break;
			case 4:
				System.out.println("districtPinCode:");
				int pin = in.nextInt();
				district.setDistrictPinCode(pin);
				session.merge(district);
				transaction.commit();
				break;
			case 5:
				System.out.println("distictState:");
				String state = in.nextLine();
				district.setDistictState(state);
				session.merge(district);
				transaction.commit();
				break;
			case 0:
				break;
			default:
				System.out.println("Inavlid Upadte Choice");

			}
		} while (choice != 0);

	}

	public void showData(DistrictDetails district, Session session, Transaction transaction) {

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Object> cq = cb.createQuery();
		Root<DistrictDetails> root = cq.from(DistrictDetails.class);

		cq.select(root);

		Query query = session.createQuery(cq);
		List<DistrictDetails> list = query.getResultList();

		for (DistrictDetails dist : list) {
			
			System.out.println(dist);
		}

	}

}
