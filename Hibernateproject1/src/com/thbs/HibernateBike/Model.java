package com.thbs.HibernateBike;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Model {
/*
	public static Admin retriveByMail(String email) {
		System.out.println("Model >>getEmployeeList() called ");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();

			if (sessionFactory == null)
				throw new RuntimeException("Oops theres been a problem. Cannot connect to DB! Contact Admin!!");
			else {
				session = sessionFactory.openSession();
				System.out.println("session established");
				Query query = session.createQuery("from Admin where admin_email = :email");
				query.setString("email", email);
				Admin admin = (Admin) query.uniqueResult();
				System.out.println("admin retrived: " + admin);
				if (admin != null)
					return admin;
				else {
					return null;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Oops something bad happened msg = " + e.getMessage());
		} finally {
			if (session != null)
				session.close();
			if (sessionFactory != null)
				sessionFactory.close();
		}

	}

	public static String login(String email, String password) {

		Admin admin = retriveByMail(email);
		System.out.println("admin: " + admin);
		if (admin != null) {
			if (admin.getAdmin_pass().equals(password))
				return Constants.SUCCESS;
			else {
				return "password incorrect";
			}

		} else {
			return "email id not found";
		}
	}

	public static List getBikeslist() {
		System.out.println("Model >>getBikeslist() called ");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();

			if (sessionFactory == null)
				throw new RuntimeException("Oops theres been a problem. Cannot connect to DB! Contact Admin!!");
			else {
				session = sessionFactory.openSession();
				
				List<Bikes> bikes = session.createQuery("from Bikes").list(); 
					
				System.out.println("bikes "+bikes);
				
				if (bikes != null)
					return bikes;
				else {
					return null;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Oops something bad happened msg = " + e.getMessage());
		} finally {
			if (session != null)
				session.close();
			if (sessionFactory != null)
				sessionFactory.close();
		}
	}

	public static String updateBike(Bikes bike) {
		System.out.println("Model >>UpdateBike() called ");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();

			if (sessionFactory == null)
				throw new RuntimeException("Oops theres been a problem. Cannot connect to DB! Contact Admin!!");
			else {
				session = sessionFactory.openSession();
				Transaction t = session.beginTransaction();
				System.out.println(bike.getName() + ".............................." + bike.getBike_id());

				Bikes b = (Bikes) session.get(Bikes.class, bike.getBike_id());
				b.setName(bike.getName());
				b.setEngine(bike.getEngine());
				b.setMileage(bike.getMileage());
				b.setPrice(bike.getPrice());

				session.update(b);
				t.commit();
				session.flush();
				System.out.println("..............................");
				return Constants.SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Oops something bad happened msg = " + e.getMessage());
		} finally {
			if (session != null)
				session.close();
			if (sessionFactory != null)
				sessionFactory.close();
		}
	}

	public static String deleteBike(Bikes bike) {
		System.out.println("Model >>deleteBike() called ");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();

			if (sessionFactory == null)
				throw new RuntimeException("Oops theres been a problem. Cannot connect to DB! Contact Admin!!");
			else {
				session = sessionFactory.openSession();
				Transaction t = session.beginTransaction();
				System.out.println(bike.getName() + " . . " + bike.getBike_id());
				Bikes b = (Bikes) session.get(Bikes.class, bike.getBike_id());
				session.delete(b);
				t.commit();
				session.flush();
				return Constants.SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Oops something bad happened msg = " + e.getMessage());
		} finally {
			if (session != null)
				session.close();
			if (sessionFactory != null)
				sessionFactory.close();
		}
	}

	public static String addBike(Bikes b) {
		System.out.println("In addBike in model");

		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory == null)
				throw new RuntimeException("Oops theres been a problem. Cannot connect to DB! Contact Admin!!");
			else {
				session = sessionFactory.openSession();
				Transaction t = session.beginTransaction();
				System.out.println(b.getName() + " . . " + b.getEngine());
				session.save(b);
				t.commit();
				session.flush();
				return Constants.SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null)
				session.close();
			if (sessionFactory != null)
				sessionFactory.close();
		}
		return null;
	}

	public static List<Bikes> getBikes(List<String> bikeNames) {
		System.out.println("In getBikes in model for comparing");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory == null)
				throw new RuntimeException("Oops theres been a problem. Cannot connect to DB! Contact Admin!!");
			else {
				session = sessionFactory.openSession();
				Transaction t = session.beginTransaction();
				
				List<Bikes> list = new ArrayList<Bikes>(2);
				
				for (String bikeName : bikeNames) {
					Query q = session.createQuery("from Bikes where name=:name1");
					q.setString("name1", bikeName);
					list.add((Bikes) q.uniqueResult());
				}
				System.out.println("list of retrived bike");
				for (Bikes bikes : list) {
					System.out.println(bikes);
				}
				t.commit();
				session.flush();
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null)
				session.close();
			if (sessionFactory != null)
				sessionFactory.close();
		}
		return null;
	}*/
}
