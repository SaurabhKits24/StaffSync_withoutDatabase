/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package authentic;

import java.io.BufferedWriter;
import java.io.File;

import java.io.FileWriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Dell
 */
public class Authentic {
     public static void main(String[] args) {
        // Specify the file path
        String filePath = "orignal.dat";
          File file = new File(filePath);
        // Number to write
        int number = 0;
        
          if (file.exists()) {
            
                 
               try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Read the line from the file
            String line = reader.readLine();
            
            // Convert the line to an integer
           number = Integer.parseInt(line);
           if(number>=1)
             number+=1;  
             try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(String.valueOf(number));
            //System.out.println("Number " + number + " written to file successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
              try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(String.valueOf(number));
            System.out.println("Number " + number + " written to file successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
             System.out.print(number);
       
        }         catch (IOException ex) {
                      Logger.getLogger(Authentic.class.getName()).log(Level.SEVERE, null, ex);
                  }
                     
       
        }
          else{
              number+=1;
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(String.valueOf(number));
            System.out.println("Number " + number + " written to file successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
          }
     }
}
