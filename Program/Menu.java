import java.io.*;
import java.util.*;
public class Menu {
   private Engine e;
   private Scanner console;
   
   //constructor
   public Menu (Engine engine)throws Exception {
      this.e = engine;
      this.e.loadData();
      this.console = new Scanner(System.in);          
   }
   
   //mainMenu also returns a boolean which decides if the program should keep running
   //by default it's true, but if the console input is 0, mainMenu returns false and stops the program.
   public boolean mainMenu() {  
      System.out.println("Main menu");
      System.out.println("1. Members");
      System.out.println("2. Competitive");
      System.out.println("3. Economy");
      System.out.println("\n0. Exit");
      System.out.print("\nSelect: ");
      int input = console.nextInt();
      switch (input) {
         case 1:
            //members
            break;
         case 2:
            //competitive stuff
            competitiveMenu();
            break;
         case 3:
            //economy
            break;
         case 0:
            //exit
            return false;
            
         default:
            System.out.println("Wrong input!\n");        
      }
      return true;
   }
   
   public void competitiveMenu() {
      System.out.println("\n\nCompetitive menu");
      System.out.println("1. Records");
      System.out.println("2. Competition records");
      System.out.println("3. Team");
      System.out.println("\n0. Back");
      System.out.print("\nSelect: ");
      int input = console.nextInt();      
      switch (input) {
         case 1:
            recordMenu();
            break;
         case 2:
            //comp records
            break;
         case 3:
            //team menu
            break;
         case 0:
            //back to main menu
            break;         
      }
   }
   
   public void recordMenu() {
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
            break;
         case 2:
            //read
            System.out.println("\n");
            ArrayList<Record> records = e.getPersonalRecords();
            for (Record r : records) {
               System.out.println(r.showRecord());
            }
            recordMenu();
            break;
         case 3:
            //update
            break;
         case 4:
            //delete
            break;
         case 0:
            //back
            competitiveMenu();
            break;        
      }
   }
}
