package model;
import java.util.ArrayList;
public class Reception {

    private MiniRoom[][] miniRooms;

    public Reception () {
        this.miniRooms = new MiniRoom[8][50];
        createMiniRooms();
    }
	/**
	*Description: This method create the rent of the minirooms
	*
	*
	*/
    public void createMiniRooms() {
        int number = 1;
        for (int i = 0; i < miniRooms.length; i++) {
            for (int g = 0; g < miniRooms[0].length; g++) {
                boolean window = false;
                if (i == 0 || i == 7 || g == 0 || g == 49) {
                    window = true;
                }
                miniRooms[i][g] = new MiniRoom(number, g, i, window);
                number++;
            }
        }
        miniRooms[7][49].setStatus(true);
    }

    public String listAvailableRooms() {
        String message = "";
        for (int i = 0; i < miniRooms.length; i++) {
            for (int g = 0; g < miniRooms[0].length; g++) {
                MiniRoom aux=miniRooms[i][g];
                if (aux.pRent()==false) {
                    message+=aux.toString()+"\n";
                }
            }
        }
        return message;
    }

	public String changeStatusOfMiniRooms (){
		String message = ""; 
		for(int e = 0; e < miniRooms.length;e++){
			for(int g = 0; g < miniRooms[0].length; g++){
				miniRooms[e][g].setStatus(true);
			}
		}
		message= "All of the rooms were lit";
		return message; 
	}

    public String rentAMiniroom(int number, String name, String nit, ArrayList<Server> rack) {
        MiniRoom room=searchRoom(number);
        room.setCompany(new Company(name, nit));
        room.setRack(rack);
        room.setRent(true);
        return "Rent a mini-room success";
    }

    public MiniRoom searchRoom(int number){
        MiniRoom room=null;
        boolean find = false;
        for (int i = 0; i < miniRooms.length && !find; i++) {
            for (int g = 0; g < miniRooms[0].length; g++) {
                if (miniRooms[i][g].getNumber()==number) {
                    find=true;
                   room=miniRooms[i][g];
                }
            }
        }
    return room;
    }

    public String  cancelRentAMiniRoomId(int id) {
        String message="The mini-room doesn't exist";
        if (searchRoom(id) !=null){
            MiniRoom mini=searchRoom(id);
            double proccesCapacity =mini.cancelRent();
            message="The mini room rent has been canceled correctly and your procces capacity is :"+proccesCapacity;
        }
        return message;
    }
	public char [][] miniRoomStatusMap(){
		char[][] presentStatus= new char [8][50];
		char symbol= 'x';
		for(int o=0; o<miniRooms.length;o++){
			for(int i=0; i<miniRooms[0].length;i++){
				symbol='x';
				MiniRoom aux=miniRooms[o][i];
				if(aux.getStatus().equals("ON")){
					symbol='o';
				}
				presentStatus[o][i]=symbol;
			}
		}
		return presentStatus;
	}
	public String organizeMap(){
		char[][] status= miniRoomStatusMap();
		String map = mainMap(status);
		return map;
	}
	
	public String mainMap(char[][] status){
		String map=""; 
		for(int j=0;j<miniRooms.length;j++){
			for(int i=0; i<miniRooms[0].length;i++){
				map += status[j][i] + " ";
			}
			map += "\n";
		}
		return map; 
	}
	

    public String  cancelRentAMiniRoomName(String name) {
        boolean cancel=false;
        double proccesCapacity=0;
        String message="The company haven't rent a mini-rooms";
        for (int i = 0; i < miniRooms.length; i++) {
            for (int g = 0; g < miniRooms[0].length; g++) {
               if (miniRooms[i][g].getCompany() != null){
                   if(miniRooms[i][g].getCompany().getName().equals(name)){
                     proccesCapacity+=miniRooms[i][g].cancelRent();
                    cancel=true;
                   }
                }
            }
        }
        if (cancel==true){
            message="The mini-room rent has been canceled correctly and your procces capacity is :"+proccesCapacity;
        }
        return message;
    }
	public void turnOffL(){
		for (int i=0; i<miniRooms.length; i++){
			miniRooms[i][0].setStatus(false);
		}

		for (int i=1; i<miniRooms[0].length; i++){
			miniRooms[0][i].setStatus(false);
		}
	}
	public void turnOffZ(){
		for (int i=0; i<miniRooms[0].length; i++){
			miniRooms[0][i].setStatus(false);
			miniRooms[miniRooms.length-1][i].setStatus(false);
			
		}

		for (int i=miniRooms.length-1, j=miniRooms[0].length-1; i>-1 && j>-1; i--, j--){
			miniRooms[i][j].setStatus(false);
		}
	}
	public void turnOffH(){
		for (int i=0; i<miniRooms.length; i++){
			if ((i+1)%2 != 0){
				for (int j=0; j<miniRooms[0].length; j++){
					miniRooms[i][j].setStatus(false);
				}
			}
		}
	}
	public void turnOffO(){
		for (int i=0; i<miniRooms.length; i++){
			for (int j=0; j<miniRooms[0].length; j++){
				if (j==0 || j==(miniRooms[0].length-1) || i==0 || i==(miniRooms.length-1)){
					miniRooms[i][j].setStatus(false);
				}
			}
		}
	}
	public void turnOffM(int column){
		for (int i=0; i<miniRooms.length; i++){
			miniRooms[i][column-1].setStatus(false);
		}
	}
	public void turnOffP(int corridor){
		for (int j=0; j<miniRooms[0].length; j++){
			miniRooms[corridor-1][j].setStatus(false);
		}
	}
	
}