package com.movies;
import java.util.*;

public class View {

    private String userName;
    private List<String> moviesList;

    /**
     * Default constructor
     */
    public View(String userName, List<String> moviesList)
    {
        this.setUserName(userName);
        this.setMoviesList(moviesList);
    }

    /**
     * Methods
     */
    public void printData()
    {
        System.out.println("################################");
        System.out.println("Usuario: "+ this.getUserName());
        System.out.println("################################");
        System.out.println("Lista de videos:");

        for (String mov : this.getMoviesList())
        {
            System.out.println(mov);
        }
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public List<String> getMoviesList()
    {
        return moviesList;
    }

    public void setMoviesList(List<String> moviesList)
    {
        this.moviesList = moviesList;
    }
}