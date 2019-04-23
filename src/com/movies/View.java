package com.movies;
import java.lang.reflect.Array;
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

        for (String mov : this.getMoviesList())
        {
            System.out.println(mov);
        }
    }

    public void updateData(String userName, List<String> moviesList)
    {
        this.setUserName(userName);
        this.setMoviesList(moviesList);
    }

    public void updateDataPrint(String userName, List<String> moviesList)
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
        System.out.println("Elige una opción: ");
        System.out.println("1. Añadir un video");
        System.out.println("2. Obtener lista de videos");
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
        movieData[0] = scanner.next();
        System.out.print("Titulo: ");
        movieData[1] = scanner.next();
        System.out.print("Tags (espacio para separar): ");
        movieData[2] = scanner.next();

        System.out.println("################################");
        System.out.println("Pulsa 1 para volver al menu principal");

        return movieData;

    }

    public void loginScreen()
    {
        System.out.println("----------------------------------------");
        System.out.println("            Inicio de sesion");
        System.out.println("----------------------------------------");
        System.out.println(" ");
        System.out.println("Introduce usuario: ");
        System.out.println("Introduce contraseña: ");
        System.out.println(" ");
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

    public List<String> getMoviesList()
    {
        return moviesList;
    }

    public void setMoviesList(List<String> moviesList)
    {
        this.moviesList = moviesList;
    }
}