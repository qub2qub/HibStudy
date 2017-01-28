/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.den.jh.collections.set.ann;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author mkonda
 */
public class AnnotationSetJoinTableTest {

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
        showroom.setLocation("UK, London 2");
        showroom.setManager("Mr. Bean 2");
        Set<Car> cars = new HashSet<Car>();
        
        cars.add(new Car("Toyota", "Racing Green"));
        cars.add(new Car("Nissan", "White"));
        // т.к. у этого кара нет переопределённых методов хэщкод и иквалс -- то все эти записи добавятся.
        cars.add(new Car("BMW", "Black"));
        cars.add(new Car("BMW", "Black"));
        cars.add(new Car("Mercedes", "Silver"));
        cars.add(new Car("Mercedes", "Silver1"));

        showroom.setCars(cars);
        
        session.save(showroom);
        
        session.getTransaction().commit();
        System.out.println("Done");
    }

    private void retrieveList(){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        
        List list = session.createQuery("from by.den.jh.collections.set.ann.Showroom").list();
        
        for (Object object : list) {
            System.out.println("List items: "+object);
        }
        session.getTransaction().commit();
        System.out.println("Done");
        
    }
    public static void main(String[] args) {
        AnnotationSetJoinTableTest test = new AnnotationSetJoinTableTest();
        test.init();
        test.persistAnnotatedLists();
        test.retrieveList();
    }
}
