package org.dao.hql.report;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.modelo.report.Report;
public class DAOHQLReport {
	public static void update (){
		//configuracion de hibernate
		AnnotationConfiguration cfg= new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session =factory.getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("update report set tipo = :p," +
			"folio = :p1 , comentario = :p2 where id = :p3");
			query.setParameter("p" ,"Mensual");
			query.setParameter("p1" ,"8080Update");
			query.setParameter("p2" ,"Update DAOHQL");
			query.setParameter("p3" , 2);
			query.executeUpdate();
		} catch (HibernateException e) {
		   System.out.println("Exception Update: "+ e.getMessage());	
		}
	}
	public static void delete(){
		AnnotationConfiguration cfg= new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session =factory.getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(" delete from Report where id = :p");
			query.setParameter("p", 2);
			query.executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exeption delete: " + e.getMessage());
		}
		
	}
	public static void select(){
		AnnotationConfiguration cfg= new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session =factory.getCurrentSession();
		try {
			session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Report> list=(List<Report>)
			 session.createQuery("from Report").list();
			for (Report x: list) {
				System.out.println(x.getId()+","+ x.getFolio()+","+x.getComentario());
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exeption delete: " + e.getMessage());
		}
		
	}
	
	public static void insert(){
		AnnotationConfiguration cfg= new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session =factory.getCurrentSession();
		try {
			session.beginTransaction();
			//@SuppressWarnings("unchecked")
			Query query= session.createQuery("insert into Repor (id,"+
			"tipo,folio,comentario) select id,tipo,folio,comentario from Report");
			query.executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exeption delete: " + e.getMessage());
		}
		
	}
	
	public static void  executeProc()
	{
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session =factory.getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createSQLQuery("CALL proc(:p, :p1");
			query.setParameter("p", 50);
			query.setParameter("p1", "Region-50");
			query.executeUpdate();
			session.getTransaction().commit();
			
			
		} catch (HibernateException e) {
			System.out.println("Exception insert:" + e.getMessage());
		}
		
	}
	public static void main(String[] args) {
		//update();
		//delete();
		//select();
		insert();
		//executeProc();
		
	}
}
