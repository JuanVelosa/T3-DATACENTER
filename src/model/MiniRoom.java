package model;

import java.io.ObjectInputFilter.Status;
import java.util.ArrayList;

public class MiniRoom {

    private int number;
    private double price;
    private boolean rent;
    private int colum;
    private int row;
    private boolean window;
    private ArrayList <Server> rack;
    private Company company;
    private boolean status;
    	//if status is true =on
        //if status is false=off;

    public MiniRoom(int number,int colum,int row,boolean window) {
        this.number = number;
        this.price = 0;
        this.rent = false;
        this.row=row;
        this.colum=colum;
        this.window=window;
        this.setRack(new ArrayList<>());
        this.setCompany(null);
        this.status=false;
    }

    //TODO insert method for calculate rent´

    public double getProccesCapacity(){
        int total=0;
        for (int i = 0; i < rack.size(); i++) {
            total+=rack.get(i).getProccesCapacity();
        }
        return total;
    }

    public double cancelRent(){
        double proccesCapacity=getProccesCapacity();
        rack.clear();
        this.company=null;
        this.rent=false;
        this.status=false;

        return proccesCapacity ;
    }

	//Getters and Setters. 
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public ArrayList <Server> getRack() {
        return rack;
    }

    public void setRack(ArrayList <Server> rack) {
        this.rack = rack;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public boolean pRent() {
        return this.rent;
    }

    public boolean getRent() {
        return this.rent;
    }

    public void setRent(boolean rent) {
        this.rent = rent;
    }

    public int getColum() {
        return this.colum;
    }

    public void setColum(int colum) {
        this.colum = colum;
    }

    public int getRow() {
        return this.row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public boolean pWindow() {
        return this.window;
    }

    public boolean getWindow() {
        return this.window;
    }

    public void setWindow(boolean window) {
        this.window = window;
    }



    public String getStatus() {
        if (this.status==true){
            return "ON";
        }else{
            return "OFF";
        }
        
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

	//toString method 
    @Override
    public String toString() {
        return 
            "the number: " + getNumber() + "\n" +
            "the price: " + getPrice() + "\n" +
            "the rent: " + pRent() + "\n" +
            "the colum: " + getColum() + "\n" +
            "the row: " + getRow() + "\n" +
            "the window: " + pWindow() + "\n"+
            "Status:" +getStatus();
    }
	
	//toString method 
    public String toStringStatus() {
        return 
            "the number: " + getNumber() + "\n" +
            "Status:" + getStatus();
    }
}