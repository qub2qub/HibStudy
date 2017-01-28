/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.den.jh.collections.idbags;

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
public class IDBAGSTest {

    private SessionFactory factory = null;

    private void init() {
        Configuration config = new Configuration().configure("collections/idbags/hibernate.cfg.xml");
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        factory = config.buildSessionFactory(registry);
    }

    private void persistBags() {
        Session session = factory.getCurrentSession();
        
        session.beginTransaction();
        Showroom showroom = new Showroom();
//        showroom.setLocation("East Croydon, Greater London");
//        showroom.setManager("Barry Larry");
        showroom.setLocation("Minsk, Arena");
        showroom.setManager("Dima D");
        List<Car> cars = new ArrayList<Car>();
        
        cars.add(new Car("kia", "Green"));
        cars.add(new Car("kia", "Green"));
        cars.add(new Car("zap", "White"));

        showroom.setCars(cars);
        
        session.save(showroom);
        
        session.getTransaction().commit();
        System.out.println("Done");
    }

    private void retrieveBags(){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        
        List list = session.createQuery("from by.den.jh.collections.bags.Showroom").list();
        
        for (Object object : list) {
            System.out.println("List items: "+object);
        }
        session.getTransaction().commit();
        System.out.println("Done");
        
    }
    public static void main(String[] args) {
        IDBAGSTest test = new IDBAGSTest();
        test.init();
        test.persistBags();
        test.retrieveBags();
    }
}
