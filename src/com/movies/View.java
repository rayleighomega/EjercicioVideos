package com.movies;

import java.util.*;

public class View {

    private String userName;
    private List<String> moviesList;

    /**
     * Default constructor
     */
    public View()
    {

    }

    /**
     * Methods
     */
    public void printMovies()
    {
        clearConsole();

        System.out.println("----------------------------------------");
        System.out.println("            Usuario: "+ this.getUserName());
        System.out.println("----------------------------------------");
        System.out.println(" ");
        System.out.println("Lista de videos:");
        System.out.println("****************************************");

        for (String mov : this.getMoviesList())
        {
            System.out.println(mov);
        }

        System.out.println(" ");
        System.out.println("----------------------------------");
        System.out.println("Pulsa 1 y luego Enter para volver al menu principal");
    }

    public void updateData(String userName, List<String> moviesList)
    {
        this.setUserName(userName);
        this.setMoviesList(moviesList);
    }

    public void updateDataPrint(String userName, List<String>  moviesList)
    {
        this.setUserName(userName);
        this.setMoviesList(moviesList);

        this.printMovies();
    }

    public void MainScreen()
    {
        clearConsole();

        System.out.println("----------------------------------------");
        System.out.println("            Usuario: "+ this.getUserName());
        System.out.println("----------------------------------------");
        System.out.println(" ");
        System.out.println("Elige una opción, introduce el número y luego Enter");
        System.out.println("1. Añadir un video");
        System.out.println("2. Obtener lista de videos");
        System.out.println("3. Logout");
    }

    public String[] addMovie()
    {
        Scanner scanner = new Scanner(System.in);

        clearConsole();

        String[] movieData = new String[3];

        System.out.println("----------------------------------------");
        System.out.println("            Usuario: "+ this.getUserName());
        System.out.println("----------------------------------------");
        System.out.println(" ");

        System.out.print("Url: ");
        movieData[0] = scanner.nextLine();
        System.out.print("Titulo: ");
        movieData[1] = scanner.nextLine();
        System.out.print("Tags (espacio para separar): ");
        movieData[2] = scanner.nextLine();
        System.out.println(" ");
        System.out.println("----------------------------------");
        System.out.println("Pulsa 1 y luego Enter para volver al menu principal");

        return movieData;

    }

    public void loginScreen()
    {
        System.out.println("----------------------------------------");
        System.out.println("            Inicio de sesion");
        System.out.println("----------------------------------------");
        System.out.println(" ");
        System.out.println("1. Login con usuario existente");
        System.out.println("2. Crea un nuevo usuario");
        System.out.println("----------------------------------------");
        System.out.println(" ");

    }

    public void registrationScreen()
    {
        System.out.println("----------------------------------------");
        System.out.println("            Registro nuevo usuario");
        System.out.println("----------------------------------------");
        System.out.println(" ");
        System.out.println(" ");
    }

    public void userInput()
    {
        System.out.print("Usuario: ");
    }

    public void passInput()
    {
        System.out.print("Contraseña: ");
    }

    public void lastNameInput()
    {
        System.out.print("Apellido: ");
    }

    public void badUser()
    {
        System.out.println("Error: Usuario no o contraseña incorrectos ...");
        System.out.println("Pulsa cualquier tecla para continuar");
    }

    public final static void clearConsole()
    {
        System.out.println(new String(new char[50]).replace("\0", "\r\n"));
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public List<String>  getMoviesList()
    {
        return moviesList;
    }

    public void setMoviesList(List<String> moviesList)
    {
        this.moviesList = moviesList;
    }
}