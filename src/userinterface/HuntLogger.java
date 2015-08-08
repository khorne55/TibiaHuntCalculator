package userinterface;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
  
public class HuntLogger {
     
    public static void main(String[] args) {
               
        try {
             String filename ="C:/Users/Khorne/Desktop/HuntLog.log";
             FileWriter log = new FileWriter(filename,true);
             log.write("x");
             log.close();

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
         
       
         
    }
     
}