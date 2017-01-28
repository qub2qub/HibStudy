package by.den.jh.basics.pseudo;

import by.den.jh.domain.Movie;

public class MoviePersistor {

    public void perist(Movie movie) {
		System.out.println(" persisting mechanism goes here..");
	}
	
	public void fetch(String title) {
		System.out.println("fetching a movie by title mechanism goes here..");
	}
}