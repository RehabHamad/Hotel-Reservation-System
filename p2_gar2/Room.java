/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2_gar_rehab_1808142;




import java.util.*;


public class Room {


    private String roomCode;
    private String roomView;
    private String roomType;
    private Date startDate;
    private Date endDate;
    private int guestnumber;
    private double price;

    public Room(String roomCode, String roomView, String roomType, int guestnumber, double price, Date startDate, Date endDate) {
        this.roomCode = roomCode;
        this.roomView = roomView;
        this.roomType = roomType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.guestnumber = guestnumber;
        this.price = price;
    }

    public Room() {
    }

    public String getRoomCode() {
        return roomCode;
    }
    
    

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public String getRoomView() {
        return roomView;
    }

    public void setRoomView(String roomView) {
        this.roomView = roomView;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getGuestnumber() {
        return guestnumber;
    }

    public void setGuestnumber(int guestnumber) {
        this.guestnumber = guestnumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        int m = startDate.getMonth() + 1;
        int m1 = endDate.getMonth() + 1;
        String startd = startDate.getDate() + "-" + m + "-" + startDate.getYear();
        String endd = endDate.getDate() + "-" + m1 + "-" + endDate.getYear();
       
    return  "--------------------------------- Details of room number " + roomCode + "--------------------"
     + " -----------------\r\nRoom View: " + roomView + " \r\nRoom Type: " + roomType + " \r\nAvailable"
      + " from : " + startd  + " to " + endd+ " \r\nPrice : " + price;
    }

    
    
    
    
    
    
    
    
}
