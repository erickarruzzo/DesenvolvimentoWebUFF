package airlinesystem.controller;

import airlinesystem.model.entity.airline.Route;
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
                    validateLogin();
                }
                case "2":
                {
                    System.out.println("Entre com seu email");
                    String email = scanner.nextLine();
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
    
    public void validateLogin()
    {
        Scanner scanner = new Scanner(System.in);
        
        String username;
        String password;
        
        System.out.println("Entre com seu nome de usuario");
        username = scanner.nextLine();
        System.out.println("Entre com sua senha");
        password = scanner.nextLine();
        
        if ((username != null &&  username.equals("")) || (password != null && password.equals("")))
        {
            System.out.println("Campo vazio");
        }
        else if ( SimulateDB.validateLogin(username, password) )
        {
            System.out.println("Login efetuado com sucesso");
        }
        else
        {
            System.out.println("Falha no Login");
            //TODO switch case para verificar se deseja retornar a tela inicial ou 
            validateLogin();
        }
    }

    public void initMainScreen() 
    {
        // TODO code application logic here
        List<Route> routes; 
        
        routes = SimulateDB.startRoutes();
           
        boolean exit = false;
        String input;
        Scanner scanner = new Scanner(System.in);
        
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
                        
                        //System.out.println("Duracao");
                        
                    }
                    break;
                }
                case "2":
                {
                    String origin;
                    String destiny;
                    String day;
                    boolean conexao;
                    int tempoMax = 0;
                    
                    System.out.println("Digite a origem");
                    origin = scanner.nextLine();
                    
                    System.out.println("Digite o destino");
                    destiny = scanner.nextLine();
                    
                    System.out.println("Digite o dia pretendido do voo");
                    day = scanner.nextLine();
                    
                    System.out.println("Considerar conexoes? s/n");
                    conexao = scanner.nextLine().equals("s") ?  true : false;
                    
                    if (conexao)
                    {
                        System.out.println("Entre com o tempo maximo de espera em cada conexao");
                        tempoMax = Integer.getInteger(scanner.nextLine());
                    }
                    
                    List<List<Route>> flights = SimulateDB.getFlights(origin,destiny,day,conexao,tempoMax,routes);
                    
                    //Exibir voos (que podem ser conjuntos de rotas)
                    
                    break;
                }
                case "3":
                {
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
}

