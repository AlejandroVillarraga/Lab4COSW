package edu.eci.cosw.jpa.sample;

import edu.eci.cosw.jpa.sample.model.Curso;
import edu.eci.cosw.jpa.sample.model.Estudiante;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author hcadavid
 */
public class SimpleMainApp {
   
    public static void main(String a[]){
        SessionFactory sf=getSessionFactory();
        Session s=sf.openSession();
        Transaction tx=s.beginTransaction();
        
        Estudiante e1 = new Estudiante(2101751, "Alejandro"); 
        Estudiante e2 = new Estudiante(2156894, "Daniel");
        Curso c1 = new Curso(99999, "Construcción de Software", "COSW");
        Curso c2 = new Curso(999990, "Habilidades gerenciales", "HGER");
        c1.getEstudiantes().add(e1);
        c1.getEstudiantes().add(e2);
        c2.getEstudiantes().add(e1);
        c2.getEstudiantes().add(e2);
        e1.getCursos().add(c1);
        e1.getCursos().add(c2);
        e2.getCursos().add(c1);
        e2.getCursos().add(c2);
        s.saveOrUpdate(e1);
        s.saveOrUpdate(e2);
        s.saveOrUpdate(c1);
        s.saveOrUpdate(c2);
        
        tx.commit(); 
        s.close();
        sf.close();
    }

    public static SessionFactory getSessionFactory() {
        // loads configuration and mappings
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry
                = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        // builds a session factory from the service registry
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

}