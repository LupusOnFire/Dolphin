import java.io.*;
import java.util.*;
import java.text.*;
public class Menu {
   private Engine e;
   private Scanner console;
   //private Scanner fuckConsole;
   
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
         case 1: //Martin & Søren
            membersMenu(); //DONE FUCK-O'S - except styling.. MAYBE! Eat sleep RIP repeat.
            break;
         case 2: //Bertramp - TRAMPERTYREN
            //competitive stuff
            competitiveMenu();
            break;
         case 3: //Leivur
            //economy
            break;
         case 0: //Hurr durr. Needs tweak. Does not always exit correctly.
            //exit
            System.exit(0); //Needs better solution.
            return false; //Does not work as intended.
            
         default: //Half-wits end up here.
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
            System.out.println("\n1. Show all members");
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
                  System.out.print("\nInsert CPR: ");
                  String cprInput = console.next();
                  System.out.println(e.getMember(cprInput));
                  mainMenu();
                  break;
               default:
                  System.out.println("\nThere is no menu with that number. Returning to main menu.\n\n");
                  mainMenu();
                  break;
            }
         
         case 3:
            editMember();
            membersMenu();
            break;
         case 4:
            deleteMember();
            break;
         case 0:
            System.out.println("Returning to main menu.\n\n");
            mainMenu();
            break;
         default:
            System.out.println("There is no menu with that number. Returning to main menu.\n\n");
            mainMenu();
            break;
      }
   }
   
   public void deleteMember() {
      System.out.println("Write CPR of member to delete: ");
      console.nextLine();
      String cpr = console.nextLine();
      
      Member m = e.getMember(cpr);
      if (m == null) {
         System.out.println("Failed to find a member from CPR (" + cpr + ")!");
         membersMenu();
      }
      String deletedMember = m.getFirstName() + " " + m.getLastName();
      System.out.print("Are you sure? The member will no longer exist in the system (y/n): ");
      String answer = console.nextLine();
      if (answer.equalsIgnoreCase("y")) {
         try {
            e.deleteMember(m);
            e.saveMembers();
            System.out.println("Member: " + deletedMember + " Has been deleted.");
            System.out.println("\n");
         } catch (Exception error) {
            System.out.println("Something did not go as planned.");
            System.out.println("\n");
         }
         membersMenu();
      } else {
         System.out.println("Returning.");
         membersMenu();
      }
      
   }
   
   public void editMember() {
      System.out.println("Write CPR of member to edit: ");
      console.nextLine();
      String cpr = console.nextLine();     
            
      Member m = e.getMember(cpr);
      if (m == null) {
         System.out.println("Failed to find a member from CPR (" + cpr + ")!");
         membersMenu();
      }
            
      System.out.println("Select information to update: ");
      System.out.println("1. First name");
      System.out.println("2. Last name");
      System.out.println("3. Phone number");
      System.out.println("4. Address");
      System.out.println("5. Activity");
      if (m.getIsActive()) {
         System.out.println("6. Competitiveness");
      }
      System.out.println();
      System.out.println("0. Back");
      
      int input = console.nextInt();
      console.nextLine();
      switch (input) {
         case 1:
            System.out.print("New first name: ");
            String fName = console.nextLine();
            m.setFirstName(fName);
            break;
         case 2:
            System.out.print("New last name: ");
            String lName = console.nextLine();
            m.setLastName(lName);
            break;
         case 3:
            System.out.print("New phone number: ");
            String phone = console.nextLine();
            m.setPhone(phone);
            break;
         case 4:
            System.out.print("New address: ");
            String address = console.nextLine();
            m.setAddress(address);
            break;
         case 5:
            System.out.print("Set activity (true/false): ");
            boolean activity = console.nextBoolean();
            m.setIsActive(activity);
            break;
         case 6:
            System.out.print("Set competivity (true/false): ");
            boolean competitive = console.nextBoolean();
            console.nextLine();
            if (competitive) {
               try {
                  CompetitiveMember cm = new CompetitiveMember(m.getCpr(), m.getFirstName(), m.getLastName(), m.getPhone(), m.getAddress(), m.getIsActive(), true, m.getBalance(), e.getSubscriptions(), e.getTeams(), selectDisciplines());
                  e.addMember(cm);
                  e.deleteMember(m);
                  e.saveMembers();
               } catch (Exception error) {
                  System.out.println("Something happened.");
               }
            } else {
               m.setIsCompetitive(false);
               try {
                  Member convertedM = new Member(m.getCpr(), m.getFirstName(), m.getLastName(), m.getPhone(), m.getAddress(), m.getIsActive(), false, m.getBalance(), e.getSubscriptions());
                  System.out.println(convertedM);
                  e.addMember(convertedM);
                  e.deleteMember(m);
                  e.saveMembers();
               } catch (Exception Error) {
                  System.out.println("Something went south.");
               }
            }
            break;
         case 0:
            System.out.println("Returning to edit menu.\n\n");
            membersMenu();
            break;
         default:
            System.out.println("There is no menu with that number. Returning to edit menu.\n\n");
            editMember();
            break;
      }
      
   }
   
   public void showMember() {
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
            showSpecificMember();
            showMember();
            break;
         default:
            System.out.println("There is no menu with that number. Returning to main menu.\n\n");
            mainMenu();
            break;
      }
   }
   
   public void showSpecificMember() {
      System.out.print("insert CPR: ");
      String cprInput = console.next();
      System.out.println(e.getMember(cprInput)); //Style the printing on this one... Later..
      
   }
    
   public void createMember() {
      console.nextLine();
      System.out.print("CPR: ");
      String cpr = console.nextLine();
      System.out.print("First name: ");
      String fName = console.nextLine();
      System.out.print("Last name: ");
      String lName = console.nextLine();
      System.out.print("Phone number: ");
      String phone = console.nextLine();
      System.out.print("Address: ");
      String address = console.nextLine();
      System.out.print("Active member: (y/n) ");
      boolean active = false;
      
      if (console.nextLine().equalsIgnoreCase("y")) {
         active = true;
      }
      boolean competitive = false;
      System.out.print("Competitive member: (y/n) ");
      ArrayList<Discipline> activeDisciplines = new ArrayList<>();
      if (console.nextLine().equalsIgnoreCase("y")) {
         competitive = true;
         activeDisciplines = selectDisciplines();
      }

      System.out.print("Balance: ");
      double balance = console.nextDouble();
      
      ArrayList<Subscription> subsciptions = e.getSubscriptions();
      
      try {
         if (!competitive) {
            Member m = new Member(cpr, fName, lName, phone, address, active, competitive, balance, subsciptions);
            e.addMember(m);
         } 
         else {
            CompetitiveMember cm = new CompetitiveMember(cpr, fName, lName, phone, address, active, competitive, balance, subsciptions, e.getTeams(), activeDisciplines);
            e.addMember(cm);
         }
         e.saveMembers();
         System.out.println("Added new member: " + fName + " " + lName);
      } 
      catch (Exception error) {
         System.out.println("Failed to create object");
      }
      
      mainMenu();
   }
   
   public ArrayList<Discipline> selectDisciplines() {
      ArrayList<Discipline> activeDisciplines = new ArrayList<>();
      ArrayList<Discipline> disciplines = e.getDisciplines();
      int count = 1;
      String disciplineStr = "";
      System.out.println("Select active disciplines: ");
      for (Discipline d : disciplines) {
         System.out.print(count + ". " + d.getName() + " (y/n) ");
         if (console.nextLine().equalsIgnoreCase("y")){
            disciplineStr += d.getId();
         }
         count++;
      }
      for (int i = 0; i < disciplineStr.length(); i++) {
         activeDisciplines.add(disciplines.get(Character.getNumericValue(disciplineStr.charAt(i))));
      }
      return activeDisciplines;
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
      } 
      catch (Exception error) {
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