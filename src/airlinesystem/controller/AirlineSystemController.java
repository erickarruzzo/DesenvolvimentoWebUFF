package airlinesystem.controller;

import airlinesystem.model.entity.airline.Route;
import airlinesystem.persistence.SimulateDB;
import java.util.List;
import java.util.Scanner;

public class AirlineSystemController {

    public void startPrincipalScreen() 
    {
        // TODO code application logic here
        List<Route> routes; 
        
        routes = SimulateDB.startRoutes();
           
        boolean exit = false;
        
        Scanner scanner = new Scanner(System. in); 
        
        System.out.println("Iniciando o sistema de companhia aerea...");
        
        do
        {
            System.out.println("Menu principal");
            System.out.println("Escolha uma das opcoes a seguir:");
            System.out.println("1 - Listar voos disponiveis");
            System.out.println("2 - Procurar por um voo ");
            System.out.println("3 - Realizar check-in");
            System.out.println("4 - Listar seus voos");
            System.out.println("5 - Editar sua conta");
            System.out.println("6 - Sair");
            String input = scanner.nextLine();
            
            switch(input)
            {
                case "1":
                {
                    for (Route route : routes)
                    {
                        System.out.println("Aterrisagem");
                        System.out.println("Data");
                        System.out.println("Pouso");
                        System.out.println("Data");
                        System.out.println("Duracao");
                        
                    }
                }
                case "6":
                {
                    System.out.println("Saindo do sistema...");
                    exit = true;
                }
                default: System.out.println("Escolha uma opcao valida");
            }
        }
        while(exit != true);
    }    
}

