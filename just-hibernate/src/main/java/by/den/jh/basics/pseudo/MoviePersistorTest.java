package by.den.jh.basics.pseudo;

import by.den.jh.domain.Movie;

public class MoviePersistorTest {
	MoviePersistor moviePersistor = new MoviePersistor();

	private void test() {
		Movie movie = new Movie();

		movie.setId(3);
		movie.setTitle("Jaws 2");
		movie.setDirector("Steven Spielberg");
		movie.setSynopsis("Story of a gigantic great white shark!");

		moviePersistor.perist(movie);
		
		
	}

	public static void main(String[] args) {
		MoviePersistorTest moviePersistorTest = new MoviePersistorTest();
		moviePersistorTest.test();
	}
}