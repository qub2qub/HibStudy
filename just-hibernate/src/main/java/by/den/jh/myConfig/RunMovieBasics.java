package by.den.jh.myConfig;

import by.den.jh.domain.Movie;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Denis on 26 Январь 2017
 */
public class RunMovieBasics {

    public static void persistMovie(Session session) {
        Movie movie = new Movie();

        movie.setTitle("Forest Gump");
        movie.setDirector("XZ");
        movie.setSynopsis("Life of a strang boy");
        System.out.println("\n\nSave Movie:" + movie);
        session.beginTransaction();

        session.save(movie);

        session.getTransaction().commit();
    }

    public static void findMovie(int movieId, Session session) {

        session.beginTransaction();

        Movie movie = (Movie) session.load(Movie.class, movieId);

        System.out.println("\n\nFind Movie:" + movie);

        session.getTransaction().commit();

    }

    public static void findAll(Session session) {

        session.beginTransaction();

        List<Movie> movies = session.createQuery("from Movie").list();

        session.getTransaction().commit();

        System.out.println("\n\nAll Movies:" + movies);

    }
}
