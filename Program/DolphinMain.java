import java.io.*;
import java.util.*;
public class DolphinMain {
   public static void main(String[] args) throws Exception {
      Engine e = new Engine();
      e.loadData();
      boolean run = true;
      while (run) {
         run = mainMenu(e);      
      }  
   }
   public static boolean mainMenu(Engine e) {
      Scanner console = new Scanner(System.in);   
      System.out.println("Main menu");
      System.out.println("1. Members");
      System.out.println("2. Competitive");
      System.out.println("3. Economy");
      System.out.println("\n0. Exit");
      System.out.print("\nSelect a submenu: ");
      int input = console.nextInt();
      switch (input) {
         case 1:
            break;
         case 2:
            competitiveMenu(e, console);
         case 3:
            break;
         case 0:
            return false;        
      }
      return true;
   }
   public static void competitiveMenu(Engine e, Scanner console) {
      System.out.println("\n\nCompetitive menu");
      System.out.println("1. Records");
      System.out.println("2. Competition records");
      System.out.println("3. Team");
      System.out.println("\n0. Back");
      System.out.print("\nSelect: ");
      int input = console.nextInt();      
      switch (input) {
         case 1:
            recordMenu(e, console);
            break;
         case 2:
         case 3:
            break;
         case 0:
            mainMenu(e);
            break;         
      }
   }
   public static void recordMenu(Engine e, Scanner console) {
      System.out.println("\n\nRecord menu");
      System.out.println("1. Create new");
      System.out.println("2. View records");
      System.out.println("3. Edit record");
      System.out.println("4. Delete record");
      System.out.println("\n0. Back");
      System.out.print("\nSelect: ");
      int input = console.nextInt();
      switch (input) {
         case 1:
            //create
         case 2:
            //read
         case 3:
            //update
         case 4:
            //delete
         case 0:
            mainMenu(e);        
      }
   }
}
