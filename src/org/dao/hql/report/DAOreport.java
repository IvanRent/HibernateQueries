package org.dao.hql.report;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

public class DAOreport {
		public static void insert()
		{
			AnnotationConfiguration cfg = new AnnotationConfiguration();
			cfg.configure("hibernate.cfg.xml");
			SessionFactory factory = cfg.buildSessionFactory();
			Session session = factory.getCurrentSession();
			try {
				session.beginTransaction();
				Query query=
						session.createQuery("insert into Repor2 (id, " + 
				"tipo,folio,comentario) select id, tipo, folio, comentario from Report");
				query.executeUpdate();
				session.getTransaction();
				
			} catch (HibernateException e) {
				System.out.println("Exception insert:" + e.getMessage());
			}
		
		}
		public static void main(String[] args) {
			insert();
		}
}
