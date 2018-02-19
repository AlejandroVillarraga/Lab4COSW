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
        
        Estudiante estud1 = new Estudiante(2101751, "Alejandro"); 
        Estudiante estud2 = new Estudiante(2156894, "Daniel");
        Curso curso1 = new Curso(99999999, "Construcción de Software", "COSW");
        Curso curso2 = new Curso(99999990, "Habilidades gerenciales", "HGER");
        curso1.getEstudiantes().add(estud1);
        curso1.getEstudiantes().add(estud2);
        curso2.getEstudiantes().add(estud1);
        curso2.getEstudiantes().add(estud2);
        estud1.getCursos().add(curso1);
        estud1.getCursos().add(curso2);
        estud2.getCursos().add(curso1);
        estud2.getCursos().add(curso2);
        s.saveOrUpdate(estud1);
        s.saveOrUpdate(estud2);
        s.saveOrUpdate(curso1);
        s.saveOrUpdate(curso2);
        
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