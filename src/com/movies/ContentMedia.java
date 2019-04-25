package com.movies;

import java.util.*;


/**
 * 
 */
public class ContentMedia
{

    private HashMap content;

    /**
     * Default constructor
     */
    public ContentMedia()
    {
        //Object for the database
        content = new HashMap<String, List<User>>();

        //Test data
        Movie movieTest;

        User userTest = new User("Roger", "Tres", "macaco23", "23/04/2019");

        List<String> tags1 = new ArrayList<>();
        tags1.add("Terror");
        tags1.add("Comedia");
        tags1.add("Culto");
        movieTest = new Movie("www.cinesinlimites.org", "La traca final", tags1);
        userTest.addMovie(movieTest);

        List<String> tags2 = new ArrayList<>();
        tags2.add("Sci-Fi");
        tags2.add("Drama");
        tags2.add("Drogas");
        movieTest = new Movie("www.locopeliculas.com", "El padre de todo", tags2);
        userTest.addMovie(movieTest);

        List<String> tags3 = new ArrayList<>();
        tags3.add("Gore");
        tags3.add("UFO");
        tags3.add("Vejez");
        movieTest = new Movie("www.todopelis.nu", "La venda del abuelo", tags3);
        userTest.addMovie(movieTest);

        content.put("1", userTest);
    }

    /**
     * Methods
     */
    protected void addData(String userId, User user)
    {
        this.content.put(userId, user); //Use this property to simulate a database
    }

    protected User getData(String userId)
    {
        User u = (User) this.content.get(userId); //Use this property to simulate a database
        return u;
    }

    protected int countUsers()
    {
        return this.content.size();
    }


}