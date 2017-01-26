package by.den.jh.basics;

import by.den.jh.domain.Movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VanillaMovieManager {

    private Connection connection = null;
    private static Random r = new Random();
    private String username = "postgres";
    private String password = "123";
    private String url = "jdbc:postgresql://127.0.0.1:5432/just?currentSchema=justhib";
    private String driverClass = "org.postgresql.Driver";
    private String tableSql = "create table MOVIES (ID integer not null, TITLE varchar(255), DIRECTOR varchar(255), SYNOPSIS varchar(255), primary key (ID))";
    private String insertSql = "INSERT INTO MOVIES VALUES (?,?,?,?)";
/*
    CREATE TABLE justhib.movies
    (
    id integer NOT NULL,
    title character varying(255),
    director character varying(255),
    synopsis character varying(255),
    CONSTRAINT movies_pkey PRIMARY KEY (id)
    )
    WITH (
            OIDS=FALSE
    );
    ALTER TABLE public.movies
    OWNER TO postgres;*/

    public VanillaMovieManager() {

    }

    private void init() {
        // Create a connection
        createConnection();
    }

    private void createConnection() {
        try {
            Class.forName(driverClass).newInstance();
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            System.err.println("Exception while creating a connection:"
                    + ex.getMessage());
        }
        System.out.println("Connection created successfully");
    }

    private Connection getConnection() {
        if (connection == null) {
            createConnection();
        }
        return connection;
    }

    private  void closeConnection() {
        if (connection == null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void persistMovie() {
        try {
            PreparedStatement pst = getConnection().prepareStatement(insertSql);

//            pst.setInt(1, 1);
//            pst.setString(2, "Top Gun");
//            pst.setString(3, "Tony Scott");
//            pst.setString(4, "Maverick is a hot pilot. When he encounters "
//                    + "a pair of MiGs over the Persian Gulf,"
//                    + " his wingman is clearly outflown and freaks. "
//                    + "On almost no fuel, Maverick is able to talk "
//                    + "him back down to the Carrier..");

            pst.setInt(1, 2);
            pst.setString(2, "Jaws");
            pst.setString(3, "Steven Spielberg");
            pst.setString(4, "A tale of a white shark!");

            pst.execute();
            System.out.println("Movie persisted successfully!");
            pst.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void selectMovies() {
        List<Movie> movies = new ArrayList<Movie>();
        Movie m = null;
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM MOVIES");
            while (rs.next()) {
                m = new Movie();
                m.setId(rs.getInt("ID"));
                m.setTitle(rs.getString("TITLE"));
                movies.add(m);
                System.out
                        .println("Movie Found: " + rs.getInt("ID") + ", Title:" + rs.getString("TITLE"));
            }
            rs.close();
            st.close();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public static void main(String[] args) {
        VanillaMovieManager movieManager = new VanillaMovieManager();
        movieManager.init();
        movieManager.persistMovie();
        movieManager.selectMovies();

    }
}
