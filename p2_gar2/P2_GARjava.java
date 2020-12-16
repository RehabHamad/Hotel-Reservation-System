// By Rehab Hamad

// Program Number: # 2
//course name : Programming II ,CPCS 203


package p2_gar;

import java.io.File;



 import java.io.*; 
 import java.util.*;
    

public class P2_GAR {

    
    
    
     public static void main(String[] args) throws FileNotFoundException, Exception {

        File file1 = new File("input.txt");
        if (!file1.exists()) {
            System.out.println("input File Not Found");
            System.exit(0);
        }
        Scanner read = new Scanner(file1);
        PrintWriter print = new PrintWriter("output.txt");
        Room[] room;
        Guest[] guest;
        Reservation[] reservation;
        room = new Room[read.nextInt()];
        guest = new Guest[read.nextInt()];
        reservation = new Reservation[read.nextInt()];
        print.println("--------------- Welcome to Hotel Reservation System ---------------");
        print.println();
        print.println();
        String g = "";
        int i = 0, k = 0, r = 0;
        while (read.hasNext()) {
           
             g = read.next();
            
             if (g.equals("Quit")) {
                break;
            }
            if (g.equals("Add_Room")) {
                if (i < room.length) {
                    room[i] = read_Rooms_info(read);
                    print.println("Room " + room[i].getRoomCode() + " was added successfully to the system");
                    i++;
                } else {
                    print.println("Room " + read.next() + " was not added, you exceed the maximum number of rooms");
                }
            }
            if (g.equals("Add_Guest")) {
                if (k < guest.length) {
                    guest[k] = read_Guest_info(read);

                    print.println("Guest " + guest[k].getName() + " was added successfully to the system");
                    k++;
                } else {
                    print.println("Guest " + read.next() + " was not added, you exceed the maximum number of guests");
                }
            }
            if (g.equals("Make_Reservation")) {
                if (r < reservation.length) {
                   
                    
                    String ss[] = read.nextLine().split(" ");
                    String s6[] = ss[4].split("-");
                    String s7[] = ss[5].split("-");
                    int m = Integer.parseInt(s6[1]) - 1;
                    int m1 = Integer.parseInt(s7[1]) - 1;
                    Date sd = new Date(Integer.parseInt(s6[2]), m, Integer.parseInt(s6[0]));
                   
                    Date ed= new Date(Integer.parseInt(s7[2]), m1, Integer.parseInt(s7[0]));
                    
                    Room ro = check_RoomCode(ss[1], room);
                    Guest ge = check_Geust(ss[3], guest);
                    if (check_RoomCode(ss[1], room) == null) {
                        
                        print.println("The room code " + ss[1] + " is not in the system");
                    } else if (check_RoomGuestNumber(ss[1], Integer.parseInt(ss[2]), room) == null) {
                        
                        print.println("The number of guests exceed the maximum number for the requested room");
                    } else if (check_Geust(ss[3], guest) == null) {
                        
                     print.println("The guest " + ss[3] + " is not a registered in the system");
                    } else if (check_RoomDate(ss[1], sd, ed, room) == null) {
                        
                        
                        print.println("The requested room is not available for the requested period");
                    } else if (ro != null && ge != null) {
                        
                 reservation[r]=read_Reservation_info(ss,check_RoomCode(ss[1],room),check_Geust(ss[3], guest),r);
                    
                  update_date(reservation[r].getRoom(),room);
                    
                       r++;
                        print.println("The reservation was successfully completed and reservation number is Re00" + r);
                   
                    }
                } else {
                    
                    print.println("You exceeded the number of reservation requests");
                }
            }
            if (g.equals("Print_Reservation")) {
                String r1 = read.next();
                Reservation re = check_Reservation(r1, reservation);
                if (re == null) {
                    print.println("The reservation code " + r1 + " is not in the system");
                } else {
                    print.println(re.toString());

                }
            }
            Room roomS[] = Search_Room(read.next(), read.next(), room);
            print.println("----------------------- The following rooms match your search criteria ------------------ ");
            
            for (int j = 0; j < roomS.length; j++) {
                int n=0;
                
                if (roomS[j] != null) {
                    n++;
                    int m = roomS[j].getStartDate().getMonth() + 1;
                    int m1 = roomS[j].getEndDate().getMonth() + 1;
                    String d1 = roomS[j].getStartDate().getDate() + "-" + m + "-" + roomS[j].getStartDate().getYear();
                    String d2 = roomS[j].getEndDate().getDate() + "-" + m1 + "-" + roomS[j].getEndDate().getYear();
                    print.println(n + "- Room number:" + roomS[j].getRoomCode() + " Room capacity:" + roomS[j].getGuestnumber() + " price:" + roomS[j].getPrice() + " available from:" + d1 + " to " + d2);
                }
            }
            print.println("--------------------------------------------------------------------------------------------------");
        
        if (g.equals("Room_Status")) {
            String r1 = read.next();
            Room ro = check_RoomData(r1, room);
            if (ro == null) {
                if (g.equals("Search_Print")) {
                    int n = 0;

                    print.println("The room number " + r1 + " is not in the system");
                } else {
                    print.println(ro.toString());
                }
            }
        }
        }
        print.println("--------------------------------------------------------------------------------------------------");
        print.println("Thanks for using Hotel Reservation System, Good Bye!");
        
        
        read.close();
        print.close();
    }

     
     
     
    public static Room read_Rooms_info(Scanner read) {
       
        String s1 = read.next();
        String s2 = read.next();
        String s3 = read.next();
        int s4 = read.nextInt();
        double s5 = read.nextDouble();
        String s6[] = read.next().split("-"); 
        String s7[]=read.next().split("-");
        
        int m = Integer.parseInt(s6[1]) - 1;
        int m1 = Integer.parseInt(s7[1]) - 1;

        Date sd = new Date(Integer.parseInt(s6[2]), m, Integer.parseInt(s6[0]));
        Date ed=new Date(Integer.parseInt(s7[2]),m1, Integer.parseInt(s7[0]));
        Room r=new Room(s1,s2,s3,s4,s5,sd,ed);
        return r;
    }

    public static Guest read_Guest_info(Scanner read) {
        String s1 = read.next();
        int s2 = read.nextInt();
        char s3 = read.next().charAt(0);
        String s4 = read.next();
        Guest g = new Guest(s1, s2, s3, s4);
        return g;
    }

    
    
    
    
    
    public static Reservation read_Reservation_info(String[] ss, Room r, Guest g, int i) {
        i++;
        String s6[] = ss[4].split("-");
        String s7[] = ss[5].split("-");
        int m = Integer.parseInt(s6[1]) - 1;
        int m1 = Integer.parseInt(s7[1]) - 1;
        Date sd = new Date(Integer.parseInt(s6[2]), m, Integer.parseInt(s6[0]));
        Date ed=new Date(Integer.parseInt(s7[2]),m1, Integer.parseInt(s7[0]));
        String URN = "Re00" + i;
        int dd = ed.getDate() - sd.getDate();

        double pay = dd * r.getPrice();
        Reservation re = new Reservation(URN, sd, ed, r, g, pay);
        
        
        
         if (re.getReservationSDate().compareTo(r.getStartDate()) > 0) {
            r.setEndDate(re.getReservationSDate());
        }
        if (re.getReservationSDate().compareTo(r.getStartDate()) == 0 && re.getReservationEDate().compareTo(r.getStartDate()) > 0) {
            r.setStartDate(re.getReservationEDate());
        }
         return re;
    }
    
    
    
    
    
    public static void update_date(Room r, Room room[]) {
        for (int i = 0; i < room.length; i++) {
            if (room[i].getRoomCode().compareTo(r.getRoomCode()) == 0) {
                room[i].setStartDate(r.getStartDate());
                room[i].setEndDate(r.getEndDate());
            }
        }
    }

    public static Room check_RoomCode(String rCode, Room[] room) {
        for (int i = 0; i < room.length; i++) {
            if (room[i].getRoomCode().compareTo(rCode) == 0) {
                return room[i];
            }
        }
        return null;
    }

    public static Guest check_Geust(String name, Guest[] geust) {
        for (int i = 0; i < geust.length; i++) {
            if (geust[i].getName().compareTo(name) == 0) {
               
                return geust[i];
            }
        }
        return null;
    }

    public static Room check_RoomGuestNumber(String rCode, int gn, Room[] room) {
        for (int i = 0; i < room.length; i++) {

            if (room[i].getRoomCode().compareTo(rCode) == 0 && room[i].getGuestnumber() >= gn) {
                return room[i];
            }
        }
        return null;
    }

    public static Room check_RoomDate(String rCode, Date sd, Date ed, Room[] room) throws Exception {
        for (int i = 0; i < room.length; i++) {
            if (room[i].getRoomCode().compareTo(rCode) == 0 && room[i].getStartDate().compareTo(sd) <= 0 && room[i].getEndDate().compareTo(ed) >= 0) {
                return room[i];
            }
        }
        return null;
    }

    public static Reservation check_Reservation(String r, Reservation res[]) {
        for (int i = 0; i < res.length; i++) {
            if (res[i].getURN().compareTo(r) == 0) {
                return res[i];
            }
        }
        return null;
    }

    public static Room[] Search_Room(String r1, String r2, Room[] room) {
        Room ro[] = new Room[room.length];
        for (int i = 0; i < room.length; i++) {
           
            if (room[i].getRoomView().compareTo(r1) == 0 && room[i].getRoomType().compareTo(r2) == 0) {
                ro[i] = room[i];
            }
        }
        return ro;
    }

    public static Room check_RoomData(String r, Room room[]) {
        for (int i = 0; i < room.length; i++) {
            if (room[i].getRoomCode().compareTo(r) == 0) {
                return room[i];
            }
        }
        return null;
    }

} 
        
        
    
 
    
 

        
        
        
        
        
        
        
        


    
   
    
    
    
    
    
    

