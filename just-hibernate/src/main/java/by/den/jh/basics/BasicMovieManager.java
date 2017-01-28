package by.den.jh.basics;

import java.util.List;

import by.den.jh.domain.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.metamodel.MetadataSources;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class BasicMovieManager {
    private StandardServiceRegistry registry = null;
    public SessionFactory sessionFactory = null;

    public BasicMovieManager() {
        init4xNew(); // не работает с метадата сорсес
//        buildSessionFactory(); // тоже не пашет
//        init4x(); // пашет
//        init4xNewShort(); // пашет
    }

    private SessionFactory buildSessionFactory() {
        System.out.println(">>>>>>>>>>> 1 buildSessionFactory");
        // Create a StandardServiceRegistry
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.temp.use_jdbc_metadata_defaults", "false");
        configuration.addResource("Movie.hbm.xml");
        System.out.println("\n\n>>>>>>>>>>> 1 configuration ");
        configuration.configure("hibernate.cfg.xml");
//        configuration.configure();
        System.out.println("\n\n>>>>>>>>>>> 1 registry ");
        registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        System.out.println("\n\n>>>>>>>>>>> 1 buildMetadata ");
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        return sessionFactory;

        //        Configuration cfg = new Configuration().configure();
//        cfg.addResource("Movie.hbm.xml");
        /*The Hibernate configuration file must define the entity classes:
        1) <mapping class="annotations.Users"/>
                Or you must explicitly add the class to the configuration using
                configuration.addClass(annotations.Users.class)
        // Read mappings as a application resourceName
        // addResource is for add hbml.xml files in case of declarative approach
        2) configuration.addResource("myFile.hbm.xml");
        // или 3й вариант
        3) plus one, adding "<mapping resource="myFile.hbm.xml"/>" in hibernate.cfg.xml also worked
        */
    }

    private void init4xNewShort() {
        System.out.println(">>>>>>>>>>> 2 init4xNewShort");
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    private void init4xNew() {
        System.out.println("\n\n>>>>>>>>>>> 3 init4xNew ___ registry");
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        registry = new StandardServiceRegistryBuilder()
                .applySettings(cfg.getProperties())
//                .configure() // configures settings from hibernate.cfg.xml
                .build();
        System.out.println("\n\n>>>>>>>>>>> 3 buildMetadata ");

        try {
            // эта хрень для xml мапингов не рулит
//            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
            // а надо взять из конфига.
            sessionFactory = cfg.buildSessionFactory(registry);
        } catch (Exception e) {
            System.out.println("Error while creating sessionFactory!");
            e.printStackTrace();
            destroyRegistry();
        }
    }

    private void destroyRegistry() {
        StandardServiceRegistryBuilder.destroy( registry );
    }

    private void init4x() {
        Configuration config = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
                config.getProperties()).buildServiceRegistry();
        sessionFactory = config.buildSessionFactory(serviceRegistry);
    }

    private void init3x() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    private void persistMovie() {
        Movie movie = new Movie();

        movie.setId(3);
        movie.setTitle("Jaws 2");
        movie.setDirector("Steven Spielberg");
        movie.setSynopsis("Story of a gigantic great white shark!");

        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        session.save(movie);

        session.getTransaction().commit();
    }

    private void findMovie(int movieId) {

        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        Movie movie = (Movie) session.load(Movie.class, movieId);

        System.out.println("\n\nMovie:" + movie);

        session.getTransaction().commit();

    }

    private void findAll() {

        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        List<Movie> movies = session.createQuery("from Movie").list();

        session.getTransaction().commit();

        System.out.println("\n\nAll Movies:" + movies);

    }

    public static void main(String[] args) {
        BasicMovieManager movieManager = new BasicMovieManager();

//        movieManager.persistMovie();

        movieManager.findMovie(1);

        movieManager.findAll();

        if (movieManager.sessionFactory != null) {
            movieManager.sessionFactory.close();
        }
    }
}