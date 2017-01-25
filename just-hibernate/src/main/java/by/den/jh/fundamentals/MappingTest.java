/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.den.jh.fundamentals;

import org.hibernate.cfg.Configuration;

/**
 *
 * @author mkonda
 */
public class MappingTest {

    public void testCusomConfigurationWithMapping() {

        Configuration config = new Configuration().configure();
        
//        configuration.addFile("Movie.hbm.xml");
//        configuration.addClass(Movie.class);
//        configuration.addClass(Trade.class);
//        configuration.addFile("classpath:Movie.hbm.xml");
        

//        configuration.addClass(Movie.class);
    }

    public static void main(String[] args) {
        MappingTest test = new MappingTest();
        test.testCusomConfigurationWithMapping();
    }
}
