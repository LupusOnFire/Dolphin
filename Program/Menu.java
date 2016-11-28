import java.io.*;
import java.util.*;
public class Menu {
   private Engine e;
   private Scanner console;
   
   public Menu (Engine engine)throws Exception {
      this.e = engine;
      this.e.loadData();
      this.console = new Scanner(System.in);
           
   }
   public boolean mainMenu() {  
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
            competitiveMenu();
            break;
         case 3:
            System.out.println("TESTTSWTest2");
            break;
         case 0:
            return false;
            
         default:
            System.out.println("wrong input");        
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
            //records
            break;
         case 3:
            //team
            break;
         case 0:
            //back
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
            competitiveMenu();
            break;        
      }
   }
}
