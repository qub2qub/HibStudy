/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.den.jh.associations;

//import by.den.jh.associations.one2many.Actor;
//import by.den.jh.associations.one2many.Movie;

import java.util.HashSet;
import java.util.Set;

import by.den.jh.associations.one2many.bi.Actor;
import by.den.jh.associations.one2many.bi.Movie;
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
public class OneToManyTest {

    private SessionFactory factory = null;

    private void init() {
//        Configuration config = new Configuration().configure("associations/one2many/hibernate.cfg.xml");
        Configuration config = new Configuration().configure("associations/one2many/bi/hibernate.cfg.xml");
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        factory = config.buildSessionFactory(registry);
    }

    private void persist() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        session.save(createMovie());
        session.save(createMovie2());

        session.getTransaction().commit();
        System.out.println("Done");
    }

    private Movie createMovie() {
        Movie movie = null;
        Actor actor = null;

        Set<Actor> actors = new HashSet<Actor>();

        movie = new Movie("Chennai Express");

//        actor = new Actor("Sharukh", "Khan", "King Khan");
        actor = new Actor(movie, "Sharukh", "Khan", "King Khan");
        actors.add(actor);
//        actor = new Actor("Deepika", "Padukone", "Miss Chennai");
        actor = new Actor(movie, "Deepika", "Padukone", "Miss Chennai");
        actors.add(actor);

        movie.setActors(actors);

        return movie;
    }

    private Movie createMovie2() {
        Movie movie = null;
        Actor actor = null;

        Set<Actor> actors = new HashSet<Actor>();

        movie = new Movie("KinDzaDza");

//        actor = new Actor("Leonov", "Tolst", "Andrey");
        actor = new Actor(movie, "Leonov", "Tolst", "Andrey");
        actors.add(actor);
//        actor = new Actor("Pacan", "Maloy", "Skripach");
        actor = new Actor(movie, "Pacan", "Maloy", "Skripach");
        actors.add(actor);

        movie.setActors(actors);

        return movie;
    }

    public static void main(String[] args) {
        OneToManyTest p = new OneToManyTest();
        p.init();
        p.persist();
    }
}
