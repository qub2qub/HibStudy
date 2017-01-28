/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.den.jh.collections.set;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
public class SetTest {

    private SessionFactory factory = null;

    private void init() {
        Configuration config = new Configuration().configure("collections/set/hibernate.cfg.xml");
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        factory = config.buildSessionFactory(registry);
    }

    private void persistSets() {
        Session session = factory.getCurrentSession();
        
        session.beginTransaction();
        Showroom showroom = new Showroom();
        showroom.setLocation("Minsk, Arena");
        showroom.setManager("Lao Dzi");
        Set<Car> cars = new HashSet<Car>();
        
        cars.add(new Car("Toyota2", "Racing Green"));
        cars.add(new Car("BMW2", "Black"));
        cars.add(new Car("DuplicateCar", "None"));
        cars.add(new Car("DuplicateCar", "None"));

        showroom.setCars(cars);
        
        session.save(showroom);
        
        session.getTransaction().commit();
        System.out.println("Done");
    }

    private void retrieveSets(){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        
        List list = session.createQuery("from by.den.jh.collections.set.Showroom").list();
        
        for (Object object : list) {
            System.out.println("\n\n*********************** List items: "+object);
        }
        session.getTransaction().commit();
        System.out.println("Done");
        
    }
    
    public static void main(String[] args) {
        SetTest test = new SetTest();
        test.init();
        test.persistSets();
        test.retrieveSets();
    }
}
