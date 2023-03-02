package com.highradius.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.highradius.Model.Model;
import org.hibernate.service.ServiceRegistry;

import org.hibernate.Query;

public class FilmsDAO implements FilmsDAOinterface {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement st = null;

	// String SQL queries
	String fetchQuery = "SELECT film_id, title , director, release_year, language_id,rating, special_features, DESCRIPTION FROM film WHERE isDeleted != 1 LIMIT ";
	String addQuery = "INSERT INTO film (title, description, release_year, language_id, director, special_features, rating) VALUES (?, ?, ?, ?, ?, ?, ?)";
	String editQuery = "UPDATE Model set title=:t, description=:d, release=:r, language=:l, rating=:ra, director=:di, special_features=:sp where film_id=:f";
	String deleteQuery = "UPDATE film SET isDeleted = 1  WHERE film_id =?";

	ArrayList<Model> filmList = new ArrayList<Model>();
	Configuration con = new Configuration().configure().addAnnotatedClass(Model.class);

	@SuppressWarnings("deprecation")
	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).build();
	SessionFactory sf = con.buildSessionFactory(reg);

	@Override
	public ArrayList<Model> fetchFilmsFromDB(int start, int limit) {
		ArrayList<Model> films = new ArrayList<Model>();

		Connection con = null;
		try {

			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			Query q = session.createQuery("From Model where isDeleted=0");
			q.setFirstResult(start);
			q.setMaxResults(limit);
			List data1 = q.list();
			for (Iterator it = data1.iterator(); it.hasNext();) {
				Model ob = (Model) it.next();
				filmList.add(ob);
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Ërror in DAO Impl");
		} finally {
			try {
				if (con != null)
					con.close();

			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return filmList;
	}
//		try {
//			conn = new com.highradius.DB.Connection().getconnection();
//			stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery(fetchQuery + start + ", " + limit);
//			while (rs.next()) {
//				Model data = new Model();
//				data.setFilm_id(rs.getInt(1));
//				data.setTitle(rs.getString(2));
//				data.setDirector(rs.getString(3));
//				data.setRelease_year(rs.getInt(4));
//				data.setLanguage(rs.getShort(5));
//				data.setRating(rs.getString(6));
//				data.setSpecial_features(rs.getString(7));
//				data.setDescription(rs.getString(8));
//				films.add(data);
//			}
//			stmt.close();
//			conn.close();
//
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return films;
//	}

	@Override
	public Model addFilmsIntoDB(Model data) {
		// TODO Auto-generated method stub

		Configuration configuration = new Configuration().configure().addAnnotatedClass(Model.class); // configures
																										// settings from
																										// hibernate.cfg.xml
		StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
		serviceRegistryBuilder.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(data);
		tx.commit();
//			conn = new com.highradius.DB.Connection().getconnection();
//			PreparedStatement st = conn.prepareStatement(addQuery);
//			st.setString(1, data.get("title"));
//			st.setString(2, data.get("description"));
//			st.setInt(3, Integer.valueOf(data.get("release_year")));
//			st.setInt(4, Integer.valueOf(data.get("language")));
//			st.setString(5, data.get("director"));
//			st.setString(6, data.get("special_features"));
//			st.setString(7, data.get("rating"));
//			st.executeUpdate();
//
//			conn.close();

		return data;
	}

	@Override
	public HashMap<String, String> editFilmsIntoDB(HashMap<String, String> editdata) {

		try {
			Model editList = new Model();
			System.out.println(editdata.get("title"));
			System.out.println(editdata.get("description"));
			System.out.println(editdata.get("director"));
			Configuration configuration = new Configuration().configure().addAnnotatedClass(Model.class); // configures
			
			StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
			serviceRegistryBuilder.applySettings(configuration.getProperties());
			ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
			SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);

			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			
			 Query q=session.createQuery("update Model set title=:t, description=:d, release_year=:r, language=:l, rating=:ra, director=:di, special_features=:sp where film_id=:f");
				q.setParameter("t", editdata.get("title"));
				q.setParameter("d", editdata.get("description"));
				q.setParameter("r", Integer.valueOf(editdata.get("release_year")));
				q.setParameter("l",Short.valueOf(editdata.get("language")));
				q.setParameter("ra", editdata.get("rating"));
				q.setParameter("di", editdata.get("director"));
				q.setParameter("f", Integer.valueOf(editdata.get("film_id")));
				q.setParameter("sp", editdata.get("special_features"));
			     q.executeUpdate();
				tx.commit();
			
			
			
			
			//Query q = session.createQuery(
//					"update Model set title=:t, description=:d, release=:r, language=:l, rating=:ra, director=:di, special_features=:sp where film_id=:f");
//            
//			editList.setTitle(editdata.get("title"));
//			editList.setDescription(editdata.get("description"));
//			editList.setRelease_year(Integer.valueOf(editdata.get("release_year")));
//			editList.setLanguage(Short.valueOf(editdata.get("language")));
//			editList.setRating(editdata.get("rating"));
//			editList.setDirector(editdata.get("director"));
//			editList.setSpecial_features(editdata.get("special_features"));
//			editList.setFilm_id(Integer.valueOf(editdata.get("film_id")));
//			q.executeUpdate();
//			session.save(editList);
//			tx.commit();
			System.out.println(editdata.get("title"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return editdata;
	}

//		try {
//			conn = new com.highradius.DB.Connection().getconnection();
//			PreparedStatement st = conn.prepareStatement(editQuery);
//
//			st.setString(1, data.get("title"));
//			st.setString(2, data.get("description"));
//			st.setInt(3, Integer.valueOf(data.get("release_year")));
//			st.setInt(4, Integer.valueOf(data.get("language")));
//			st.setString(5, data.get("director"));
//
//			st.setString(6, data.get("special_features"));
//			st.setString(7, data.get("rating"));
//			st.setInt(8, Integer.valueOf(data.get("film_id")));
//			st.executeUpdate();
//
//			conn.close();
//
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return data;
//	}

	@Override
	public ArrayList<Integer> deleteFilmsFromDB(ArrayList<Integer> film_ids) {
		// TODO Auto-generated method stub
		
		
		try {
Configuration configuration = new Configuration().configure().addAnnotatedClass(Model.class); // configures
			
			StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
			serviceRegistryBuilder.applySettings(configuration.getProperties());
			ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
			SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);

			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			// con.close();
			
			for (Integer i : film_ids) {
				Query q = session.createQuery("update Model as mp set isDeleted=1 where mp.film_id=:ids");
				q.setParameter("ids", i);
				q.executeUpdate();
			}

			if (!tx.wasCommitted())
				tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return film_ids;
	}
}