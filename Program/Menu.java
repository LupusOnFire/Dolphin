import java.io.*;
import java.util.*;
import java.text.*;
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
            membersMenu();
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
   
   public void membersMenu() {
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
            createMember();
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
                  System.out.println();
                  showAllMembers();
                  break;
               case 2:
                  System.out.print("insert CPR: ");
                  String cprInput = console.next();
                  System.out.println(e.getMember(cprInput));
                  mainMenu();
                  break;
               default:
                  System.out.println("There is no menu with that number. Returning to main menu.");
                  mainMenu();
                  break;
            }
         
         case 3:
            break;
         case 4:
            break;
         case 0:
            System.out.println("Returning to main menu.");
            mainMenu();
            break;
         default:
            System.out.println("There is no menu with that number. Returning to main menu.");
            mainMenu();
            break;
      }
    }
    
    public void createMember() {
      //We need:
      //CPR
      //Firstname
      //Lastname
      //Phone
      //Address
      //isActive
      //isCompetitive
      //balance
      //Subscription
      
      
      
      mainMenu();
    }
    
    public void showAllMembers() {
      ArrayList<Member> members = e.getMemberList();
      for (Member m : members) {
         System.out.println(m.toString());
      }
      System.out.println();
      System.out.println();
      mainMenu();      
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
            createRecord();
            recordMenu();
            break;
         case 2:
            //read
            System.out.println("\n");
            printRecords();
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
   public void createRecord(){
      //generate the next id by getting the last saved record id from the full record arraylist and add 1
      int id = e.generateNextId(e.getRecords().get(e.getRecords().size()-1).toString());
      
      System.out.print("CPR: ");
      String cpr = console.next();
      Member member = e.getMember(cpr);
      if (member == null) {
         System.out.println("failed to find a member from cpr (" + cpr + ")!");
         createRecord();
      }
      ArrayList<Discipline> disciplines = e.getDisciplines();
      int i = 1;
      for (Discipline d : disciplines) {
         System.out.println(i + ". " + d.getName());
         i++;
      }
      System.out.print("Select a discipline: ");
      int disciplineId = console.nextInt()-1;
      System.out.print("Time: ");
      double time = console.nextDouble();
      System.out.println("Date");
      System.out.println("1. Now");
      System.out.println("2. Manually enter");
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy");
      Date date = new Date();
      String dateStr = dateFormat.format(date);
      if (console.nextInt() == 2) {        
         System.out.println("Example: " + dateFormat.format(date));
         System.out.print("Date: ");     
         dateStr = console.next();
      }
      //due to the record constructor parsing a string to a date, we have to try-catch or throw an exception
      try {
         Record r = new Record(id, member, disciplines.get(disciplineId), time, dateStr, false);
         e.addRecord(r);
         System.out.println("Added new time from " + r.getMember().getFirstName() + " " + r.getMember().getLastName());
      } catch (Exception error) {
         System.out.println("Failed to create object");
      }
   }
   public void printRecords() {
      SimpleDateFormat dateFormat = new SimpleDateFormat("d. MMM yyyy");
      ArrayList<Record> records = e.getPersonalRecords();
      for (Record r : records) {
         System.out.println("Record ID: " + r.getId());
         System.out.println("Member: " + r.getMember().getFirstName() + " " + r.getMember().getLastName());
         System.out.println("Discipline: " + r.getDiscipline().getName());
         System.out.println("Time: " + r.getTime());
         System.out.println("Date: " + dateFormat.format(r.getDate()) + "\n");
      }
   }
   
}
