/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.den.jh.collections.list.ann;

import java.util.ArrayList;
import java.util.List;
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
public class AnnotationListTest {

    private SessionFactory factory = null;

    private void init() {
        Configuration config = new Configuration().configure("collections/list/ann/hibernate.cfg.xml")
                .addAnnotatedClass(Showroom.class)
                .addAnnotatedClass(Car.class);
                
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        factory = config.buildSessionFactory(registry);
    }

    private void persistAnnotatedLists() {
        Session session = factory.getCurrentSession();
        
        session.beginTransaction();
        Showroom showroom = new Showroom();
        showroom.setLocation("UK, London");
        showroom.setManager("Mr. Bean");
        List<Car> cars = new ArrayList<Car>();
        
        cars.add(new Car("Toyota", "Racing Green"));
        cars.add(new Car("Nissan", "White"));
        cars.add(new Car("BMW", "Black"));
        cars.add(new Car("BMW", "Black"));
        cars.add(new Car("Mercedes", "Silver"));

        showroom.setCars(cars);
        
        session.save(showroom);
        
        session.getTransaction().commit();
        System.out.println("Done");
    }

    private void retrieveList(){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        
        List list = session.createQuery("from by.den.jh.collections.list.ann.Showroom").list();
        
        for (Object object : list) {
            System.out.println("\n\n>>>>>>>>>>>>>>>** List items: "+object);
        }
        session.getTransaction().commit();
        System.out.println("Done");
        
    }
    public static void main(String[] args) {
        AnnotationListTest test = new AnnotationListTest();
        test.init();
        test.persistAnnotatedLists();
        test.retrieveList();
    }
}
