import java.util.*;
import java.io.*;

public class DolphinMain {
    public static void main(String[] args) throws Exception {
      Engine e = new Engine();
      e.loadData();
      mainMenu(e);
    }
    
    public static void mainMenu(Engine e) {
      Scanner console = new Scanner(System.in);
      boolean run = true;
      
      while (run) {
         System.out.println("Main menu");
         System.out.println("1. Members");
         System.out.println("2. Competitive");
         System.out.println("3. Economy");
         System.out.println();
         System.out.println("0. Exit");
         System.out.println();
         System.out.print("Select: ");
         int input = console.nextInt();
         System.out.println();
         System.out.println();
         
         switch (input) {
            case 1:
               //Insert Member methodcall here
               members(console, e);
               run = false;
               break;
            case 2:
               //Insert Competitive methodcall here
               run = false;
               break;
            case 3:
               //Insert Economy methodcall here
               run = false;
               break;
            case 0:
               System.out.println("Goodbye.");
               run = false;
               break;
            default:
               System.out.println("There is no menu with that number. Try again.");
               break;
         }
         
      }
      //e.printMembers();
      //e.printRecords()
    }
    
    public static void members(Scanner console, Engine e) {
      System.out.println("Members menu");
      System.out.println("1. Create");
      System.out.println("2. Show");
      System.out.println("3. Edit");
      System.out.println("4. Delete");
      System.out.println();
      System.out.println("0. Back");
      System.out.println();
      
      System.out.print("Select: ");
      int input = console.nextInt();
      
      switch (input) {
         case 1:
            break;
         case 2:
            System.out.println("1. Show all members");
            System.out.println("2. Specify by CPR number");
            System.out.println();
            System.out.print("Select: ");
            int subInput = console.nextInt();
            System.out.println();
            System.out.println();
            
            switch (subInput) {
               case 1:
                  e.printMembers();
                  mainMenu(e);
                  break;
               case 2:
                  System.out.print("insert CPR: ");
                  String cprInput = console.next();
                  e.printSpecificMember(cprInput);
                  mainMenu(e);
                  break;
               default:
                  System.out.println("There is no menu with that number. Returning to main menu.");
                  mainMenu(e);
                  break;
            }
         
         case 3:
            break;
         case 4:
            break;
         case 0:
            System.out.println("Returning to main menu.");
            mainMenu(e);
            break;
         default:
            System.out.println("There is no menu with that number. Returning to main menu.");
            mainMenu(e);
            break;
      }
    }
    
    
    //Competitive {
    
    //}
    
    
    //Economy {
    
    //}
}
