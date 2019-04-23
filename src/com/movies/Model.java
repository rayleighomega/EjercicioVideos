package com.movies;

import java.util.*;

/**
 * ContentMedia class do not require any parameters to be initialize
 */
public class Model extends ContentMedia
{

    private String userId;

    /**
     * Default constructor
     */
    public Model()
    {
        //Creates the fake database when the model object is created
    }

    public List<Movie> getVideos(String userId)
    {
        User dataObj = this.getData(userId); //Get the base object from the database

        return dataObj.getMovies(); //get the useful field to the method
    }

    public boolean postVideo(Movie movie)
    {
        User dataObj = this.getData(userId); //Get the base object from the database

        try
        {
            dataObj.addMovie(movie); //Add a new movie to the user object in the database
        }
        catch (ExceptionDatabase e)
        {
            throw new ExceptionDatabase("postVideo: Unable to add a movie into the database", e);
        }

        return false;
    }

    public boolean checkUser(String name, String password)
    {
        User user;

        for (int i = 1 ; i <= this.countUsers(); i++)
        {
            user = this.getData(String.valueOf(i));
            if (password.equals(user.getPassword()) && name.equals(user.getName())) //match
            {
                return true;
            }
            else
            {
                return false;
            }

        }
        return false;
    }

    public String newUser(String name, String lastName, String password, String regDate) {

        User user = new User(name, lastName, password, regDate);

        this.addData(userId, user);

        this.userId = String.valueOf(this.countUsers()+1);

        return "";
    }

    public class ExceptionDatabase extends RuntimeException
    {
        public ExceptionDatabase(String errorMessage, Throwable err)
        {
            super(errorMessage, err);
        }
    }

}