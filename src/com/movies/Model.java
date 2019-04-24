package com.movies;

import java.time.Instant;
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

    protected List<String> getMoviesTitles()
    {
        User userData = this.getData(this.userId); //Get the base object from the database
        List<Movie> moviesList = userData.getMoviesList();
        List<String> moviesTitles = new ArrayList<>();

        for (Movie movie : moviesList)
        {
            moviesTitles.add(movie.getTitle());
        }
        return moviesTitles; //Get the useful list of movies objects
    }

    protected boolean postMovie(Movie movie)
    {
        User dataObj = this.getData(this.userId); //Get the base object from the database

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

    protected boolean checkUser(String name, String password, String option)
    {
        User user;
        String userId = "";
        Boolean flagCheckUser = false;

        for (int i = 1 ; i <= this.countUsers(); i++)
        {
            user = this.getData(String.valueOf(i));

            switch (option)
            {
                case "1":
                    if (password.equals(user.getPassword()) && name.equals(user.getName())) //match
                    {
                        userId = String.valueOf(i);
                        flagCheckUser = true;
                    }
                    else
                    {
                        userId = "";
                        flagCheckUser = false;
                    }
                    break;
                case "2":
                    if (name.equals(user.getName())) //User name match
                    {
                        userId = String.valueOf(i);
                        flagCheckUser = true;
                    }
                    else
                    {
                        userId = "";
                        flagCheckUser = false;
                    }
                    break;

            }

        }

        this.userId = userId; //Stores the user id for further connections into the db

        return flagCheckUser;
    }

    protected void logout()
    {
        this.userId = "";
    }

    protected String getUserId(String name, String password)
    {
        User user;
        String userId = "";

        for (int i = 1 ; i <= this.countUsers(); i++)
        {
            user = this.getData(String.valueOf(i));

            if (password.equals(user.getPassword()) && name.equals(user.getName())) //match
            {
                userId = String.valueOf(i);
            }
            else
            {
                userId = "";
            }
        }

        this.userId = userId; //Stores the user id for further connections into the db

        return userId;
    }

    protected String newUser(String userName, String lastName, String password)
    {
        User user = new User(userName, lastName, password, Instant.now().toString());

        this.userId = String.valueOf(this.countUsers()+1);
        this.addData(this.userId, user);

        return userId;
    }

    protected class ExceptionDatabase extends RuntimeException
    {
        public ExceptionDatabase(String errorMessage, Throwable err)
        {
            super(errorMessage, err);
        }
    }

}