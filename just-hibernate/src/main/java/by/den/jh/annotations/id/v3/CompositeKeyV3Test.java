/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.den.jh.annotations.id.v3;

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
public class CompositeKeyV3Test {

    private SessionFactory factory = null;

    private void init() {
        Configuration config = new Configuration().configure("annotations/hibernate.cfg.xml");
        config.addAnnotatedClass(Course3.class);
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        factory = config.buildSessionFactory(registry);
    }

    private void persist() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Course3 course = new Course3("Financial Risk Management", "Prof. Barry Furry");
        course.setTotalStudents(20);
        course.setRegisteredStudents(12);
        
        session.save(course);
        session.getTransaction().commit();
        System.out.println("Done");
    }

    
    public static void main(String[] args) {
        CompositeKeyV3Test p = new CompositeKeyV3Test();
        p.init();
        p.persist();
    }
}
