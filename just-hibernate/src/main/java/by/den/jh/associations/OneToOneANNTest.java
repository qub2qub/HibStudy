/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.den.jh.associations;

import by.den.jh.associations.one2one.ann.Car11Ann;
import by.den.jh.associations.one2one.ann.Engine11Ann;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mkonda
 */
public class OneToOneANNTest {

    private SessionFactory factoryV1 = null;

    private void initAnn() {
        Configuration config = new Configuration()
                .addAnnotatedClass(Car11Ann.class)
                .addAnnotatedClass(Engine11Ann.class)
                .configure("hibernate.cfg.xml");
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        factoryV1 = config.buildSessionFactory(registry);
    }

    private void persistAnn() {
        Session session = factoryV1.getCurrentSession();
        session.beginTransaction();

        Engine11Ann e = new Engine11Ann();
        e.setMake("V8 Series");
        e.setModel("DTS");

        Car11Ann car = new Car11Ann();
        car.setName("Cadillac ATS Sedan");
        car.setColor("White");

        car.setEngine(e);
        e.setCar(car);

        session.save(car);
        session.getTransaction().commit();
        System.out.println("Done");
    }

      private List<Car11Ann> createCars(int numberOfCars) {
        Car11Ann car = null;
        Engine11Ann engine = null;

        List<Car11Ann> cars = new ArrayList<Car11Ann>();

        for (int i = 1; i < numberOfCars; i++) {
            engine = new Engine11Ann();
            engine.setId(100+i);
            engine.setMake("V8 Series " + i);
            engine.setModel("DTS -" + i + 5);

            car = new Car11Ann();
            car.setId(i);
            car.setName("Cadillac ATS Sedan " + i);
            car.setColor("White");
            car.setEngine(engine);

            cars.add(car);
        }

        return cars;
    }

    public static void main(String[] args) {
        OneToOneANNTest p = new OneToOneANNTest();
        p.initAnn();
        p.persistAnn();
        p.factoryV1.close();
    }
}
