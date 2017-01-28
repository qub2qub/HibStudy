/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.den.jh.collections.list;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author mkonda
 */
public class ListTest {

    private SessionFactory factory = null;

    private void init() {
        Configuration config = new Configuration().configure("hibernate.cfg.xml"); //collections/list/hibernate.cfg.xml

        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        factory = config.buildSessionFactory(registry);
    }

    private void persistLists() {
        Session session = factory.getCurrentSession();
        
        session.beginTransaction();
        Showroom showroom = new Showroom();
        showroom.setLocation("Minsk, Arena");
        showroom.setManager("Lie Chan");
        List<Car> cars = new ArrayList<Car>();
        
        cars.add(new Car("Toyota3", "Racing Yellow"));
        cars.add(new Car("Toyota4", "Racing Blur"));
        cars.add(new Car("Nissan2", "Green"));
        cars.add(new Car("BMW2", "White"));
        cars.add(new Car("Mercedes2", "Gold"));

        showroom.setCars(cars);
        
        session.save(showroom);
        
        session.getTransaction().commit();
        System.out.println("Done");
    }

    private void retrieveList(){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        
        List list = session.createQuery("from by.den.jh.collections.list.Showroom").list();
        
        for (Object object : list) {
            System.out.println("|| List items: "+object);
        }
        session.getTransaction().commit();
        System.out.println("Done");
        
    }
    public static void main(String[] args) {
        ListTest test = new ListTest();
        test.init();
        test.persistLists();
        test.retrieveList();
    }
}
