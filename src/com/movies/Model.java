package com.movies;

import java.util.*;

/**
 * 
 */
public class Model extends ContentMedia
{

    private String userId;

    /**
     * Default constructor
     */
    public Model()
    {

    }


    /**
     * @param user
     */

    public boolean createContentMedia()
    {

    }

    public List<Movie> getVideos(String user)
    {

        return
    }

    /**
     * @param userId 
     * @param movie 
     * @return
     */
    public boolean postVideos(String userId, Movie movie) {

        this
        return false;
    }

    /**
     * @param name 
     * @param lastName 
     * @return
     */
    public boolean checkUser(String name, String lastName)
    {
        // TODO implement here
        return false;
    }

    /**
     * @param user 
     * @param lastName 
     * @param password 
     * @param regDate 
     * @return
     */
    public String newUser(String name, String lastName, String password, String regDate) {

        User user = new User(name, lastName, password, regDate);

        this.addUser(userId, user);

        this.userId = String.valueOf(this.countUsers()+1);

        return "";
    }

}