import java.io.*;
import java.util.*;
public class readMultiLineFileExample {
   public static void main (String[] args)throws Exception {
   
      String filename = "multiline.dat";
      Scanner fileReader = new Scanner(new File(filename));
      
      int count = 0;
      int id = 0;
      String title = "null";
      String firstName = "null";
      String lastName = "null";
      String phone = "null";
      
      while (fileReader.hasNextLine()) {
         Scanner lineReader = new Scanner(fileReader.nextLine());
         switch (count) {
            case 0:
               id = lineReader.nextInt();
               break;
            case 1:
               title = lineReader.nextLine();
               break;
            case 2:
               firstName = lineReader.nextLine();
               break;
            case 3:
               lastName = lineReader.nextLine();
               break;
            case 4:
               phone = lineReader.nextLine();
               break;            
         }
         count++;
         if (count == 5) {
            count = 0;
            System.out.println("\nID = " + id + "\nTitle = " + title + "\nFirst name = " + firstName + "\nLast name = " + lastName + "\nPhone = " + phone);
         }
      }
   }
}