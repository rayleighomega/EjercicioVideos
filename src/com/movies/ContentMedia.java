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
        content = new HashMap<String, List<User>>();

        //Test data
        User userTest = new User("Roger", "Tres", "macaco23", "23/04/2019");
        List<String> tags = new ArrayList<>();
        tags.add("Terror");
        tags.add("Comedia");
        tags.add("Culto");
        Movie movieTest = new Movie("www.cinesinlimites.org", "La traca final", tags);

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