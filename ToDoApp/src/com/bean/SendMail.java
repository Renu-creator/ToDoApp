package com.bean;

import java.util.Random;

public class SendMail 
{
	 public static void main(String[] args) {  
		 
		 int len = 4; 
		 
		 
//		 String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz"; 
		 String AlphaNumericString = "0123456789";

// create StringBuffer size of AlphaNumericString 
		 		StringBuilder sb = new StringBuilder(len); 

		 			for (int i = 0; i <len; i++) { 

// generate a random number between 
// 0 to AlphaNumericString variable length 
		 			int index = (int)(AlphaNumericString.length()* Math.random()); 

// add Character one by one in end of sb 
				sb.append(AlphaNumericString.charAt(index)); 
				} 

		    
		    
		   // String newotp=otp.toString();
		    
		    System.out.println("otp is "+sb);
		    
		    String newotp=sb.toString();
	       
		    Mailer.send("renuka.dandge@gmail.com","RenuRaut@2014","renu.dandge@gmail.com","OTP",newotp);
		    
		    
	       
	 }    

}







/*String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
		    String Small_chars = "abcdefghijklmnopqrstuvwxyz"; 
		    String numbers = "0123456789"; 

		    String values = Capital_chars + Small_chars + 
		                    numbers; 
		 
		    Random rndm_method = new Random(); 

		    char[] otp = new char[len]; 
		    
		    

		    for (int i = 0; i < len; i++) 
		    { 
		        
		        otp[i] = values.charAt(rndm_method.nextInt(values.length())); 

		    }
		    
		    String newotp=otp.toString();
		    
		    System.out.println("otp is "+newotp);
	       
		    Mailer.send("renuka.dandge@gmail.com","RenuRaut@2014","renu.dandge@gmail.com","OTP",newotp);  
	       
	 }    
*/
