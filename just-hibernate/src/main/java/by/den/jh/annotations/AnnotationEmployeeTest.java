/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.den.jh.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author mkonda
 */
public class AnnotationEmployeeTest {

    private SessionFactory factory = null;

    private void init() {
        Configuration config = new Configuration()
                .configure("annotations/hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class);
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        factory = config.buildSessionFactory(registry);
    }

    private void persist() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Employee emp = new Employee("M Konda");
        
        session.save(emp);

        session.getTransaction().commit();
        System.out.println("Done");
    }

    
    public static void main(String[] args) {
        AnnotationEmployeeTest p = new AnnotationEmployeeTest();
        p.init();
        p.persist();
    }
}
