package com.movies;

import java.time.Instant;
import java.util.*;

/**
 * 
 */
public class Control
{
    //Create a model
    Model model = new Model();

    //Internal control variables like login status and current login
    private boolean loginStatus;
    private String userName;

    //Data input from console
    Scanner scanner = new Scanner(System.in);

    //User interface and control variables
    View view;
    Boolean flagAddMovie = false;
    Boolean flagViewMovies = false;

    /**
     * Default constructor
     */
    public Control(boolean loginStatus, String userName)
    {
        this.loginStatus = loginStatus;
        this.userName = userName;

        view = new View(); //Create a new view for visualization

        this.waiting(); //Wait for a user action
    }

    public boolean login()
    {
        view.loginScreen();

        String option = scanner.next();
        String password;

        switch (option)
        {
            case "1" :
                view.userInput();
                this.userName = scanner.next();
                view.passInput();
                password = scanner.next();

                if(model.checkUser(userName, password))
                {
                    loginStatus = true;
                }
                else
                {
                    loginStatus = false;
                    view.badUser();
                    scanner.next();
                }
                break;
            case "2":
                view.registrationScreen();

                view.userInput();
                this.userName = scanner.next();

                view.lastNameInput();
                String lastName = scanner.next();

                view.passInput();
                password = scanner.next();

                model.newUser(userName, lastName, password);
        }


        return loginStatus;
    }

    public boolean logout()
    {
        this.userName = "";
        this.loginStatus = false;
        model.logout();

        return true;
    }

    private void uploadMovie()
    {
        String[] movieData = view.addMovie(); //Call for visualization and user input
        Movie movie = this.movieFormat(movieData); //Converts strings to Movie object
        model.postMovie(movie); //Add the movie to the user's list

        this.updateView();
    }

    public void updateView()
    {
        view.updateData(this.userName, model.getMoviesTitles()); //Update the data to visualize
    }

    public void registerUser(String userName, String lastName, String password)
    {
        model.newUser(userName, lastName, password);
    }

    private Movie movieFormat(String[] movieData)
    {
            Movie movie;
            List<String> tags = new ArrayList<>();

            String[] tagsString = movieData[2].split(" ");

            for (String tag : tagsString)
            {
                tags.add(tag);
            }

            movie = new Movie(movieData[0], movieData[1], tags);

            return movie;
    }

    public void waiting()
    {
        String c;

        while (true)
        {
            if(this.loginStatus)
            {
                view.setUserName(this.userName);
                view.MainScreen();

                c = scanner.next();

                c.equals("1");

                switch (c)
                {
                    case "1" :
                        flagAddMovie = true;
                        this.uploadMovie(); //call to add

                        while (flagAddMovie)
                        {
                            c = scanner.next();

                            if (c.equals("1")) //Back to main
                            {
                                flagAddMovie = false;
                            }
                        }

                        break;
                    case "2":
                        flagViewMovies = true;

                        while (flagViewMovies)
                        {
                            this.updateView(); //Update data buffer
                            view.printMovies(); //Print data from buffer
                            c = scanner.next();

                            if (c.equals("1")) //Back to main
                            {
                                flagViewMovies = false;
                            }
                        }
                        break;
                    case "3":

                        if(this.logout())
                        {
                            flagViewMovies = false;
                        }

                        break;
                }

            }
            else
            {
                this.login(); //Login Screen
            }
        }
    }
}