package by.den.jh.associations.one2many;

import java.util.Random;
import java.util.Set;

public class Movie {

    private int id = 0;
    private String title = null;
    private Set<Actor> actors = null;

    public Movie(String title) {
        setId(new Random().nextInt(100));
        setTitle(title);
    }

    public Movie() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
