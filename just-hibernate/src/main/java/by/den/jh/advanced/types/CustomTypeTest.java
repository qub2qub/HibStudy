/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.den.jh.advanced.types;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author mkonda
 */
public class CustomTypeTest {

    private SessionFactory factory = null;

    private void init() {
        Configuration config = new Configuration().configure("/types/hibernate.cfg.xml");
//        config.addAnnotatedClass(TravelReview.class);
        config.registerTypeOverride(new PhoneNumberType());
        
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        factory = config.buildSessionFactory(registry);

    }


    public static void main(String[] args) {
        CustomTypeTest test = new CustomTypeTest();
        test.init();
    }
}
