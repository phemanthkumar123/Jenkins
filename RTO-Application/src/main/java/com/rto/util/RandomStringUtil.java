package com.rto.util;

import org.apache.log4j.Logger;

public class RandomStringUtil {
	private static final Logger logger=Logger.getLogger(RandomStringUtil.class);
	// function to generate a random string of length n 
    static String getRandomString(int n) 
    { 
    	logger.info("entered into getRandomString() method with length: "+n);
        // chose a Character random from this String 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        } 
        logger.info("exiting from getRandomString() method with output random chars: "+sb.toString());
        return sb.toString(); 
    } 
    
    /*public static void main(String[] args) 
    { 
  
        // Get and display the alphanumeric string 
        System.out.println(RandomStringUtil.getAlphaNumericString(2)); 
        System.out.println(RandomStringUtil.getAlphaNumericString(3));
    }*/ 
}
