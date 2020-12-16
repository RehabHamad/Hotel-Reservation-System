/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2_gar_rehab_1808142;
  import java.util.*;

    
public class Reservation {
 
   


        private String URN;
        private Date reservationSDate;
        private Date reservationEDate;
        private Room room;
        private Guest guests;
        private double totalpayment;

        
        
 public Reservation(String URN, Date reservationSDate, Date reservationEDate, Room room, Guest guests, double totalpayment) {
        this.URN = URN;
        this.reservationSDate = reservationSDate;
        this.reservationEDate = reservationEDate;

        this.room = room;
        this.guests = guests;
        this.totalpayment = totalpayment;
    }

   
public Reservation() {
}


 public String getURN() {
        return URN;
    }

    public void setURN(String URN) {
        this.URN = URN;
    }

    public Date getReservationSDate() {
        return reservationSDate;
    }

    public void setReservationSDate(Date reservationSDate) {
        this.reservationSDate = reservationSDate;
    }

    public Date getReservationEDate() {
        return reservationEDate;
    }

    public void setReservationEDate(Date reservationEDate) {
        this.reservationEDate = reservationEDate;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuests() {
        return guests;
    }

    public void setGuests(Guest guests) {
        this.guests = guests;
    }

    public double getTotalpayment() {
        return totalpayment;
    }

    public String toString() {

        int m = reservationSDate.getMonth() + 1, m1 = reservationEDate.getMonth() + 1;
        String d1 = reservationSDate.getDate() + "-" + m + "-" + reservationSDate.getYear();
        String d2 = reservationEDate.getDate() + "-" + m1 + "-" + reservationEDate.getYear();
        String rr = "---------------------- Details of Reservation number " + URN + "------------------------\r\n";
        rr += "Guest Name: " + guests.getName() + "\r\n";
        rr += "Room Number: " + room.getRoomCode() + "\r\n";
        rr += "Reservation From: " + d1 + " to " + d2 + "\r\n";
        rr += "The total payment: " + totalpayment + " SR\r\n";
        rr+= "--------------------------------------------------------------------------------------------------";
        
        
        return rr;

 
 
 
 
 
}
 
 
 
}