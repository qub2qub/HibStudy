/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.den.jh.associations;

import by.den.jh.associations.one2many.bi.Actor;
import by.den.jh.associations.one2many.bi.Movie;

import java.util.HashSet;
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
public class OneToManyBidirectionalTest {

    private SessionFactory factory = null;

    private void init() {
        Configuration config = new Configuration().configure("associations/one2many/bi/hibernate.cfg.xml");
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        factory = config.buildSessionFactory(registry);
    }

    private void persist() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Movie movie = createMovie();
        session.save(movie);

        session.getTransaction().commit();
        System.out.println("Done");
    }

    private Movie createMovie() {
        Movie movie = null;
        Actor actor = null;

        Set<Actor> actors = new HashSet<Actor>();

        movie = new Movie("Johnny English");

        actor = new Actor(movie, "Rowan", "Atkinson", "Mr Bean");
        actors.add(actor);

        movie.setActors(actors);


        return movie;
    }

    public static void main(String[] args) {
        OneToManyBidirectionalTest p = new OneToManyBidirectionalTest();
        p.init();
        p.persist();
    }
}
