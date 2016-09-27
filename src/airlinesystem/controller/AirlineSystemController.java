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
        
        Scanner scanner; 
        scanner = new Scanner(System.in);
        
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
                        System.out.println("Origem");
                        System.out.println(route.getOrigin());
                        
                        System.out.println("Destino");
                        System.out.println(route.getDestiny());
                        
                        System.out.println("Data");
                        System.out.println(route.getDate());
                        System.out.println("Aterrisagem");
                        System.out.println(route.getLandTime());
                        System.out.println("Embarque");
                        System.out.println(route.getFlightTime());
                        
                        System.out.println("Aeronave");
//                        System.out.println( route.getAirplane().getCompany() + " " + route.getAirplane().getModel());
                        
                        //System.out.println("Duracao");
                        
                    }
                    break;
                }
                case "6":
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

