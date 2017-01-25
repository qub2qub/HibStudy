package by.den.jh.common;

import by.den.jh.domain.DomainUtil;
import by.den.jh.domain.Movie;

public class BasicsTest extends HibernateSupport {
	public BasicsTest() {
		super();
	}
	
	public void persistMovie(Movie m){
		System.out.println("Persisting the movie..");
		
		begin();
		
		getSession().persist(m);
		
		end();
		
		System.out.println("Persisting the movie done!");
	}
	
	public static void main(String[] args) {
		BasicsTest test = new BasicsTest();
		
		test.init("hibernate-javadb-config.xml");
		
		test.persistMovie(DomainUtil.createNewMovie());
	}
	
}
