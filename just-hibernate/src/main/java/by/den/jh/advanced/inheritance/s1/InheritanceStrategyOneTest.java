/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.den.jh.advanced.inheritance.s1;

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
public class InheritanceStrategyOneTest {

    private SessionFactory factory = null;

    private void init() {
        Configuration config = new Configuration()
                .configure("advanced/inheritance/s1/hibernate.cfg.xml")
                .configure("advanced/inheritance/s1/hibernate.cfg.ann.xml")
                .addAnnotatedClass(ANNEmployee.class)
                .addAnnotatedClass(ANNExecutive.class);
                ;
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        factory = config.buildSessionFactory(registry);
    }

    private void test() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Employee emp = new Employee("Barry Bumbles");

        session.save(emp);

        Executive ex = new Executive("Harry Dumbles");
        ex.setRole("Director");
        
        session.save(ex);
        session.getTransaction().commit();

        System.out.println("Done");
    }
    private void testAnn() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        ANNEmployee emp = new ANNEmployee("Barry1 Bumbles");
        session.save(emp);
        ANNExecutive ex = new ANNExecutive("Harry2 Dumbles");
        ex.setRole("Director1");
        session.save(ex);
        session.getTransaction().commit();

        System.out.println("Done");
    }


    public static void main(String[] args) {
        InheritanceStrategyOneTest test = new InheritanceStrategyOneTest();
        test.init();
//        test.test();
        test.testAnn();
    }
}
