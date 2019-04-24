package com.movies;

import java.util.*;

public class View {

    private String userName;
    private List<String> moviesList;
    private List<String> urlsList;
    private List<String> tagsList;
    private Scanner scanner = new Scanner(System.in);

    /**
     * Default constructor
     */
    public View()
    {

    }

    /**
     * Methods
     */
    public void printMovies(String option)
    {
        clearConsole();

        System.out.println("----------------------------------------");
        System.out.println("            Usuario: "+ this.getUserName());
        System.out.println("----------------------------------------");
        System.out.println(" ");
        System.out.println("Lista de videos");

        switch (option)
        {
            case "simple":
                for (String mov : this.getMoviesList())
                {
                    System.out.println(mov);
                }
                break;
            case "all":
                String printFormat = "| %-28s | %-28s | %-28s |%n";

                System.out.format(" ------------------------------ ------------------------------ ------------------------------ %n");
                System.out.format("| Titulo                       | URL                          | Tags                         |%n");
                System.out.format(" ------------------------------ ------------------------------ ------------------------------ %n");

                String[] outputList1 = new String[this.getMoviesList().size()];
                String[] outputList2 = new String[this.getMoviesList().size()];
                String[] outputList3 = new String[this.getMoviesList().size()];

                int i = 0;
                for (String mov : this.getMoviesList())
                {
                    outputList1[i] = mov;
                    i++;
                }

                i = 0;
                for (String url : this.getUrlsList())
                {
                    outputList2[i] = url;
                    i++;
                }

                i = 0;
                for (String tags : this.getTagsList()) //List<String> was converted to Strings in the model method
                {
                    outputList3[i] = tags;
                    i++;
                }

                for (i = 0; i < this.getMoviesList().size(); i++)
                {
                    System.out.format(printFormat, outputList1[i], outputList2[i], outputList3[i]);
                }
                System.out.format(" ------------------------------ ------------------------------ ------------------------------ ");

                break;
        }


        System.out.format(" %n");
        System.out.format(" %n");
        System.out.println("Pulsa 1 y luego Enter para volver al menu principal");
    }

    public void updateData(String userName, List<String> moviesList)
    {
        this.setUserName(userName);
        this.setMoviesList(moviesList);
    }

    public void updateData(String userName, List<String> moviesList, List<String> urlsList, List<String> tagsList)
    {
        this.setUserName(userName);
        this.setMoviesList(moviesList);
        this.setUrlsList(urlsList);
        this.setTagsList(tagsList);
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

    public void userBad()
    {
        System.out.println("Error: Usuario no o contraseña incorrectos ...");
        System.out.println("Pulsa cualquier tecla para continuar");
        scanner.next();
    }

    public void userNotAvailable()
    {
        System.out.println("Error: usuario ya registrado");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
    }

    public void userRegistrationOk()
    {
        System.out.println("Error: usuario ya registrado");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
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

    public List<String> getUrlsList()
    {
        return urlsList;
    }

    public void setUrlsList(List<String> urlsList)
    {
        this.urlsList = urlsList;
    }

    public List<String> getTagsList()
    {
        return tagsList;
    }

    public void setTagsList(List<String> tagsList)
    {
        this.tagsList = tagsList;
    }
}