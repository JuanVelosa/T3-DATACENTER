package ui;

import java.util.ArrayList;
import java.util.Scanner;
import model.Reception ;
import model.Server;

public class Main {
	private Reception reception;
    private Scanner sc;
 
    public Main() {
        sc = new Scanner(System.in);
        reception = new Reception();
    }

    public static void main(String[] args) {

        Main obPpal = new Main();

        int option = 0;

        do {
            option = obPpal.showMenuAndGetOption();
            obPpal.answerOption(option);
        } while (option != 0);

    }

    
    //Description: This shows the main menu for the user select the action they wish to do. 
    public int showMenuAndGetOption() {
        System.out.println(
		"\n\n Welcome to Icesi DataCenter , please select one option to continue. \n" + 
		"\n\n  MENU \n" + 
		"(1) To show the list of the available mini-rooms\n" + 
		"(2) To rent a mini-room\n" + 
		"(3) To cancel the rent of a mini-room or for all mini-rooms from a company\n" + 
		"(4) To show status of mini -rooms \n" + 
		"(5) To change the status of the mini-rooms \n" + 
		"(6) To turn off the mini-rooms \n" + 
		"(0) To exit");
        int input = Integer.parseInt(sc.nextLine());
        return input;
    }

    

    /**
     * Descripción: de acuerdo a la seleccion del usuario se dirige al metodo que
     * realiza la accion seleccionada</br>
     * 
     * @param <option> <String> debe ser un numero entero
     */
    public void answerOption(int option) {
        switch (option) {
        case 0:
            System.out.println("Closing the app, bye.");
            break;
        case 1:
            listAvailableMiniRooms();
            break;
        case 2:
            rentMiniroom();
            break;
        case 3:
			cancelTheRentOfMiniRoom();
            break;
        case 4:
			miniRoomStatus() ;
            break;
        case 5:
			changeStatusOfMiniRooms();
            break;

        case 6:
			TurnOffRooms();
            break;
        }
    }

    private void cancelTheRentOfMiniRoom() {

        System.out.println(" (1) To delete mini-room entering the ID, (2) To delete the mini-rooms from a company");
        int option = Integer.parseInt(sc.nextLine());

        if (option == 1) {
			System.out.println("Insert the ID: ");
			int id = Integer.parseInt(sc.nextLine());
			System.out.println(reception.cancelRentAMiniRoomId(id));
        }else if (option == 2) {
			System.out.println("Insert the name of company: ");
            String name = sc.nextLine();
			System.out.println(reception.cancelRentAMiniRoomName(name));
        }

    }

    private void rentMiniroom() {
        System.out.println("Insert the number of mini-room you wish to rent: ");
        int number = Integer.parseInt(sc.nextLine());
        System.out.println("Select the number (1) if you are renting the room as a private company or select (2) if you are renting the mini-room for research project: ");
        int option= Integer.parseInt(sc.nextLine());
        if (option == 1  || option == 2){
           String name;
           String nit;
           if (option == 1){
               System.out.println("Insert the name of company: ");
               name = sc.nextLine();
   
               System.out.println("Insert the nit of company: ");
               nit = sc.nextLine();
			}else{
               name = "ICESI";
               System.out.println("Insert the ID of research project: ");
               nit = sc.nextLine();
		    }
		   System.out.println("Insert the amount of servers: ");
		   int numberOfServes = Integer.parseInt(sc.nextLine());
            
		   ArrayList <Server> rack = new ArrayList<>();
           for (int i=0;i < numberOfServes; i++){
               System.out.println("Insert the amount of memory cache: ");
               double memoryCache = Double.parseDouble(sc.nextLine());

               System.out.println("Insert the number of processors: ");
               int numberOfProcessor = Integer.parseInt(sc.nextLine());

               System.out.println("Select number (1) if the brand is  intel or select (2) if the brand is AMD: ");
               int brandProcessor = Integer.parseInt(sc.nextLine());

               System.out.println("Insert the amount memory ram: ");
               double memoryRam = Double.parseDouble(sc.nextLine());

               System.out.println("Insert the amount of discs: ");
               int amountOfDiscs = Integer.parseInt(sc.nextLine());

               System.out.println("Insert the capacity of disc: ");
               double capacityDisc = Integer.parseInt(sc.nextLine());

               rack.add(new Server(memoryCache, numberOfProcessor, brandProcessor, memoryRam, amountOfDiscs, capacityDisc));
            }
			
            System.out.println(reception.rentAMiniroom(number , name, nit, rack));
        }else{
            System.out.println("The option you select is not valid");
        }
    }

    private void listAvailableMiniRooms() {
        System.out.println(reception.listAvailableRooms());
    }
	
	public void miniRoomStatus(){
		System.out.println(reception.organizeMap());
	}

	private void changeStatusOfMiniRooms(){
		System.out.println(reception.changeStatusOfMiniRooms());
	}
	private void TurnOffRooms(){
		String option; 
		System.out.println("\nShutdown system:\n"+
		"Option  L: turn off the first mini-quarters of all runners, along with the mini-quarters of the first runner.\n"+
		"Option  Z: turn off the mini-quarters of the first and last runner, along with the mini-quarters of the reverse diagonal.\n"+
		"Option  H: turn off the mini-rooms located in the odd-numbered corridors.\n"+
		"Option  O: turn off the mini-rooms located in the windows.\n"+
		"Option  M: turn off all mini-quarters in column N.\n"+
		"Option  P: turn off the mini-rooms of a corridor.\n"+
		"Option  X: to exit the simulator.\n"+
		"Type the corresponding Option  in uppercase:");
		
		option = sc.nextLine();
		switch(option) {
		
		case "L":
			reception.turnOffL();
			break;
		case "Z":
			reception.turnOffZ();
			break;
	
		case "H":
			reception.turnOffH();
			break;

		case "O":
			reception.turnOffO();
			break;
			
		case "M":
			System.out.println("Enter the column:");
            int column = Integer.parseInt(sc.nextLine());
            reception.turnOffM(column);
			break;
			
		case "P":
			System.out.println("Enter the corridor:");
            int corridor =Integer.parseInt(sc.nextLine());
            reception.turnOffP(corridor);
			break;
			
		case "0":
            System.out.println("\nEnd of simulation");
                
            break;		
		}
	}
}