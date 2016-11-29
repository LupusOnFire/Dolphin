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
            createRecord();
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
      try {
         Record r = new Record(id, member, disciplines.get(disciplineId), time, dateStr, false);
         e.addRecord(r);
         System.out.println(e.getRecords().size());
      } catch (Exception error) {
         System.out.println("failed to create object");
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
