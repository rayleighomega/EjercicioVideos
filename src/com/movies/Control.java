package com.movies;

import java.util.*;

/**
 * 
 */
public class Control
{
    //Create a model
    private Model model = new Model();

    //Internal control variables like login status and current login
    private boolean loginStatus;
    private String userName;

    //Data input from console
    Scanner scanner = new Scanner(System.in);

    //User interface and control variables
    private View view;
    private Boolean flagAddMovie = false;
    private Boolean flagViewMovies = false;

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

    private boolean login()
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

                if(model.checkUser(userName, password, "1")) //Option:1 Check user and pass, Option: 2 check only username
                {
                    loginStatus = true;
                }
                else
                {
                    loginStatus = false;
                    view.userBad();
                }
                break;
            case "2":
                this.userRegistration();
        }

        return loginStatus;
    }

    private boolean logout()
    {
        this.userName = "";
        this.loginStatus = false;
        model.logout();

        return true;
    }

    //NOTE: Printing of data uses a buffer to store the list of movies
    private void uploadMovie()
    {
        String[] movieData = view.addMovie(); //Call for visualization and user input
        Movie movie = this.movieFormat(movieData); //Converts strings to Movie object
        model.postMovie(movie); //Add the movie to the user's list

        this.updateView(); //Update de buffer of the visualization side
    }

    //Only used for buffer update
    private void updateView()
    {
        view.updateData(this.userName, model.getMoviesTitles(), model.getMoviesURL(), model.getMoviesTags()); //Update the data to visualize
    }

    private void userRegistration()
    {
        String password;

        view.registrationScreen();

        view.userInput();
        this.userName = scanner.next();

        view.lastNameInput();
        String lastName = scanner.next();

        view.passInput();
        password = scanner.next();

        if(model.checkUser(userName, "", "2")) //Option:1 Check user and pass, Option: 2 check only username
        {
            view.userNotAvailable();
        }
        else
        {
            model.newUser(userName, lastName, password);
            view.userRegistrationOk();
        }

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

    private void waiting()
    {
        String c;

        while (true)
        {
            if(this.loginStatus)
            {
                view.setUserName(this.userName);
                view.MainScreen();

                c = scanner.next();

                switch (c)
                {
                    case "1" :
                        this.uploadMovie(); //call to add

                        break;
                    case "2":

                        this.updateView(); //Update data buffer
                        view.printMovies("all"); //Print data from buffer

                        break;
                    case "3":

                        this.logout();

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