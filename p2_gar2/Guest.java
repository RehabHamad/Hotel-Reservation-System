/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2_gar_rehab_1808142;

/**
 *
 * @author hamad
 */
public class Guest {

    private String name;
    private int age;
    private char gender;
    private String Phone;



 
public  Guest () {
}

public  Guest ( String name ,  int age, char gender,  String Phone) {
 
 this.name=name;

this.age=age;

this.gender=gender;

this.Phone=Phone;
    
   
}



public void setName(String name){
  
    this.name=name;  
    
}public void setAge(int age){
    
  this.age=age;  
    
}public void setGender(char gender){
  
 this.gender=gender;
    
}public void setPhone(String Phone ){
    
   this.Phone=Phone; 
    
}



public String getName(){
  
  return name ;
    
}public int getAge(){
    
 return age ;  
}public char  getGender(){
  
    return gender;
    
}public String  getPhone(){
    
   return Phone; 
    
}




}

