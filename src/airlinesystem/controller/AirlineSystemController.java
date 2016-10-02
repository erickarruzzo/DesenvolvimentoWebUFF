package airlinesystem.controller;

import airlinesystem.login.Login;
import airlinesystem.model.entity.airline.Route;
import airlinesystem.model.exception.WrongPasswordException;
import airlinesystem.model.exception.WrongUsernameException;
import airlinesystem.persistence.SimulateDB;
import java.util.List;
import java.util.Scanner;

public class AirlineSystemController 
{
    public void initLoginScreen()
    {
        boolean exit = false;
        String input;
        Scanner scanner = new Scanner(System.in);
        
        do
        {
            System.out.println("Selecione a opcao desejada");
            System.out.println("1 - Realizar login");
            System.out.println("2 - Criar uma conta");
            input = scanner.nextLine();
            
            switch(input)
            {
                case "1":
                {
                    validateLogin(scanner);
                }
                case "2":
                {
                    System.out.println("Entre com seu username");
                    String username = scanner.nextLine();
                    System.out.println("Entre com sua senha");
                    String password = scanner.nextLine();
                    
                    //TODO metodo para salvar conta no simulateDB
                    
                    break;
                }
                default: 
                {    System.out.println("Escolha uma opcao valida");
                     break;
                }
            }    
            
        }
        while(exit == false);
    }
    
    public void validateLogin(Scanner scanner)
    { 
        String username;
        String password;
        
        boolean authenticated = false;
        
        System.out.println("Entre com seu nome de usuario");
        username = scanner.nextLine();
        System.out.println("Entre com sua senha");
        password = scanner.nextLine();
        
        while (!authenticated)
        {
            try
            {
                Login.authenticate(username, password);
                authenticated = true;
            }
            catch(WrongPasswordException | WrongUsernameException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public static void showRoute(Route route)
    {
        System.out.print("Numero do voo ");
        System.out.println(route.getRouteId());

        System.out.print("Origem ");
        System.out.println(route.getOrigin());

        System.out.print("Destino ");
        System.out.println(route.getDestiny());

        System.out.print("Data de Embarque ");
        System.out.println(route.getFlightTime());

        System.out.print("Aterrisagem ");
        System.out.println(route.getLandTime());

        System.out.print("Aeronave ");
        System.out.println( route.getAirplane().getCompany() + " " + route.getAirplane().getModel());
    }

    public void initMainScreen(Scanner scanner) 
    {
        // TODO code application logic here
        List<Route> routes; 
        
        routes = SimulateDB.retrieveRoutes();
           
        boolean exit = false;
        String input;
        
        System.out.println("Iniciando o sistema de companhia aerea...");
        
        do
        {
            System.out.println("Menu principal");
            System.out.println("Escolha uma das opcoes a seguir:");
            System.out.println("1 - Listar voos disponiveis");
            System.out.println("2 - Procurar por um voo ");
            System.out.println("3 - Realizar a compra de um voo");
            System.out.println("4 - Realizar check-in");
            System.out.println("5 - Listar seus voos");
            System.out.println("6 - Editar sua conta");
            System.out.println("7 - Sair");
            input = scanner.nextLine();
            
            switch(input)
            {
                case "1":
                {
                    for (Route route : routes)
                    {
                        showRoute(route);
                        //System.out.println("Duracao");
                    }
                    break;
                }
                case "2":
                {
                    searchFlight(scanner, routes);
                    System.out.println("Voce deseja adquirir algum voo?");
                    boolean resp = scanner.nextLine().equals("s") ? true : false;
                    if(resp)
                    {
                        //chama metodo que compra
                    }
                    break;
                }
                case "3":
                {
                    searchFlight(scanner,routes);
                    //metodo que compra
                    break;
                }
                case "7":
                {
                    System.out.println("Saindo do sistema...");
                    exit = true;
                    break;
                }
                default: 
                {    System.out.println("Escolha uma opcao valida");
                     break;
                }
            }
        }
        while(exit != true);
    }    

    private void searchFlight(Scanner scanner, List<Route> routes) {
        String origin;
        String destiny;
        String date;
        boolean conexao;
        int tempoMax = 0;
        
        System.out.println("Digite a origem");
        origin = scanner.nextLine();
        
        System.out.println("Digite o destino");
        destiny = scanner.nextLine();
        
        System.out.println("Digite o data pretendido do voo");
        date = scanner.nextLine();
        
        System.out.println("Considerar conexoes? s/n");
        conexao = scanner.nextLine().equals("s") ?  true : false;
        
        if (conexao)
        {
            System.out.println("Entre com o tempo maximo de espera em cada conexao (em horas)");
            //nextInt method does not consume the last newline character of your input
            //http://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-nextint-or-other-nextfoo
            //tempoMax = scanner.nextInt();
            try
            {
                tempoMax = Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException e)
            {
                e.printStackTrace();
            }
        }
        
        List<List<Route>> flights = SimulateDB.getFlights(origin,destiny,date,conexao,tempoMax,routes);
        
        //Exibir voos (que podem ser conjuntos de rotas)
        int index = 0;
        for (List<Route> listRoute : flights)
        {
            System.out.println("Opcao "+index);
            for(Route route : listRoute)
            {
                showRoute(route);
            }
        }
    }
}