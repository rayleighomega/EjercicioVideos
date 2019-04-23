package com.movies;

import java.nio.CharBuffer;
import java.util.*;

/**
 * 
 */
public class Control
{

    Model m = new Model();

    public boolean loginStatus;
    public String userName;

    Scanner scanner = new Scanner(System.in);

    View v;
    Boolean flagMain = false;
    Boolean flagAddMovie = false;
    Boolean flagViewMovies = false;

    /**
     * Default constructor
     */
    public Control(boolean loginStatus, String userName)
    {
        this.loginStatus = loginStatus;
        this.userName = userName;

        v = new View(); //Create a new view for visualization

        this.waiting(); //Wait for a user action
    }

    public void login(String user, String password)
    {

    }

    public void uploadMovie(Movie movie)
    {
        // TODO implement here
    }


    public void updateView()
    {

    }

    public void registerUser(String user, String lastName, String password)
    {
        // TODO implement here
    }

    public void waiting()
    {
        String c;

        while (true)
        {

            if(this.loginStatus)
            {
                flagMain = true;

                while (flagMain)
                {
                    v.MainScreen();
                    c = scanner.next();

                    if (c.equals("1")) //Add video
                    {
                        String[] movieData = v.addMovie();
                        flagAddMovie = true;

                        m.postVideo(userId, )

                        while (flagAddMovie)
                        {
                            c = scanner.next();

                            if (c.equals("1")) //Back to main
                            {
                                flagMain = true;
                                flagAddMovie = false;
                            }
                        }
                    }
                }

            }
            else
            {
                v.loginScreen();
                v.userInput();
                userName = scanner.next();
                v.passInput();
                String password = scanner.next();

                if(m.checkUser(userName, password))
                {
                    loginStatus = true;
                }
                else
                {
                    loginStatus = false;
                    v.badUser();
                    scanner.next();
                }
            }
        }
    }
}