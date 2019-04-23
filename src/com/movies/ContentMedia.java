package com.movies;

import java.util.*;


/**
 * 
 */
public class ContentMedia
{

    private HashMap content = new HashMap<String, List<User>>();

    /**
     * Default constructor
     */
    public ContentMedia()
    {

    }

    /**
     * Methods
     */
    protected void addUser(String userId, User user)
    {
        this.content.put(userId, user);
    }

    protected int countUsers()
    {
        return this.content.size();
    }


}