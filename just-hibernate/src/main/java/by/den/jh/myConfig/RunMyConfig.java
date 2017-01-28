package by.den.jh.myConfig;

import org.hibernate.Session;

/**
 * Created by Denis on 26 Январь 2017
 */
public class RunMyConfig {
    public static void main(String[] args) {
//        RunMovieBasics.persistMovie(HibernateUtil.getSessionFactory().getCurrentSession());
        RunMovieBasics.findMovie(1, HibernateUtil.getSessionFactory().getCurrentSession());
        RunMovieBasics.findAll(HibernateUtil.getSessionFactory().getCurrentSession());
        //terminate session factory, otherwise program won't end
        HibernateUtil.getSessionFactory().close();
    }
}
