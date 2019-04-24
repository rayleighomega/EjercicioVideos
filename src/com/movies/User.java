package com.movies;
import java.util.*;

/**
 * 
 */
public class User
{

    private String name;
    private String lastName;
    private String password;
    private String regDate;
    private List<Movie> movies = new ArrayList<>();

    /**
     * Default constructor
     */
    public User(String name, String lastName, String password, String regDate)
    {
        this.setName(name);
        this.setLastName(lastName);
        this.setPassword(password);
        this.setregDate(regDate);
    }

    public void addMovie(Movie movie)
    {
        this.movies.add(movie);
    }

    /**
     * Getters and Setters
     */
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getRegDate()
    {
        return regDate;
    }

    public void setregDate(String regDate)
    {
        this.regDate = regDate;
    }

    public List<Movie> getMoviesList()
    {
        return movies;
    }

    public void setMovies(List<Movie> movies)
    {
        this.movies = movies;
    }
}