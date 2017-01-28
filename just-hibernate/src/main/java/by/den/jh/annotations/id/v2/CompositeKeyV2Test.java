/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.den.jh.annotations.id.v2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author mkonda
 */
public class CompositeKeyV2Test {

    private SessionFactory factory = null;

    private void init() {
        Configuration config = new Configuration().configure("annotations/hibernate.cfg.xml");
        config.addAnnotatedClass(Course2.class);
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        factory = config.buildSessionFactory(registry);
    }

    private void persist() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Course2 course = new Course2("Financial Risk Management", "Prof. Barry Furry");
        course.setTotalStudents(21);
        course.setRegisteredStudents(13);
        
        session.save(course);
        session.getTransaction().commit();
        System.out.println("Done");
    }

    
    public static void main(String[] args) {
        CompositeKeyV2Test p = new CompositeKeyV2Test();
        p.init();
        p.persist();
    }
}
