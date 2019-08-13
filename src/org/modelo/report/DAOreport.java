package org.modelo.report;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.modelo.report.Report;

public class DAOreport {
	public static void add(){
		AnnotationConfiguration cfg= new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session =factory.getCurrentSession();
		try {
			session.beginTransaction();
			Report report =new Report();
			report.setTipo("Privado");
			report.setFolio("7477RT");
			report.setComentario("Reporte 3 ");
			session.save(report);
			session.getTransaction().commit();
			
		} catch (HibernateException e) {
			// TODO: handle exception
			System.out.println("Exepcion agregada: " + e.getMessage());
		}
	}
	
	public static void update(){
		AnnotationConfiguration cfg= new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session =factory.getCurrentSession();
		try {
			session.beginTransaction();
			Report report =new Report();
			report.setId(1);
			report.setTipo("General");
			report.setFolio("7475RT");
			report.setComentario("Reporte Modificado ");
			session.update(report);
			session.getTransaction().commit();
			
		} catch (HibernateException e) {
			// TODO: handle exception
			System.out.println("Exepcion MOdificada: " + e.getMessage());
		}
	}
	
	public static void delete(){
		AnnotationConfiguration cfg= new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session =factory.getCurrentSession();
		try {
			session.beginTransaction();
			Report report = (Report)session.get(Report.class,1);
			session.delete(report);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			System.out.println("Exepcion ELiminada: " + e.getMessage());
		}
	}
	public static void select(){
		AnnotationConfiguration cfg= new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session =factory.getCurrentSession();
		try {
			session.beginTransaction();
			Report report = (Report)session.get(Report.class,2);
			System.out.println(report.getId()+","+report.getTipo()+","
					+report.getComentario());
			session.getTransaction().commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			System.out.println("Exepcion select: " + e.getMessage());
		}
	}
	
	public static void main(String [] args){
		//add();
		//update();
		//delete();
		//select();
		
	}
}
