import java.io.*;
import java.util.*;
public class Engine {
   //create a list for each object
   private ArrayList<Team> teams = new ArrayList<>();
   private ArrayList<Discipline> disciplines = new ArrayList<>();
   private ArrayList<Subscription> subscriptions = new ArrayList<>();
   private ArrayList<Member> members = new ArrayList<>();
   private ArrayList<Record> records = new ArrayList<>();
   
   public ArrayList<Discipline> getDisciplines() {
      return disciplines;
   }
   public ArrayList<Record> getPersonalRecords() {
      ArrayList<Record> pRecords = new ArrayList<>();
      for (Record r : records) {
         if (!r.isFromCompetition()) {
            pRecords.add(r);
         }
      }
      return pRecords;
   }
   public ArrayList<Record> getRecords(){
      return records;
   }
   public void addRecord(Record r){
      records.add(r);
   }
   public Member getMember(String cpr){
      for (Member m : members) {
         if (cpr.equals(m.getCpr())) {
            return m;
         }
      }
      return null;
   }

   public void loadData() throws Exception {
      //Most Danish Windows OS have their locale set to da;Danish and thus expecting decimal types from scanners to contain ',' instead of '.'
      //Hardcoding the locale as us;English will remove that annoying feature.
      Locale.setDefault(new Locale("en", "US"));
   
   
      //fill all the lists with data stored in their respective text files, one by one
      //the order is important, because some objects are depending on other objects to have been initialized
      Scanner teamScanner = new Scanner(new File("data/teams.txt"));
      while (teamScanner.hasNextLine()){
         String line = teamScanner.nextLine();
         String[] str = line.split(":");
         Team t = new Team(Integer.parseInt(str[0]), str[1], str[2]);
         teams.add(t);
      }
   
      Scanner disciplineScanner = new Scanner(new File("data/disciplines.txt"));
      while (disciplineScanner.hasNextLine()){
         String line = disciplineScanner.nextLine();
         String[] str = line.split(":");
         Discipline d = new Discipline(Integer.parseInt(str[0]), str[1]);
         disciplines.add(d);
      }
   
      Scanner subscriptionReader = new Scanner(new File("data/subscriptions.txt"));
      while (subscriptionReader.hasNextLine()){
         int id = subscriptionReader.nextInt();
         String type = subscriptionReader.next();
         double price = subscriptionReader.nextDouble();
         Subscription s = new Subscription(id, type, price);
         subscriptions.add(s);
      }
   
      //members and the subclass, competitive members, is stored in the same file
      //by splitting each text-line with a delimiters we can have more 'tokens' for our competitive members
      Scanner memberReader = new Scanner(new File("data/members.txt"));
      while (memberReader.hasNextLine()) {
         String line = memberReader.nextLine();
         //split the line into a string-array foreach '#'
         String[] comp = line.split("#");
         //the first string in the array is the info for the super class, split that once more with another delimiter so we can use the parameters to create member objects.
         String[] str = comp[0].split(":");
      
         //if member is not competitive
         if (!Boolean.parseBoolean(str[6])) {
            Member m = new Member(str[0], str[1], str[2], str[3], str[4], Boolean.parseBoolean(str[5]), Boolean.parseBoolean(str[6]), Double.parseDouble(str[7]), subscriptions);
            members.add(m);
         //if member is competitive
         } 
         else {
            //a competitive member has one or more disciplines, we store those disciplines in the text files as a number
            //each digit in that number represents a discipline id, so we split the digits and collect each discipline from the list and add them to a new list for the member
            ArrayList<Discipline> activeDisciplines = new ArrayList<>();
            for (int i = 0; i < comp[1].length(); i++) {
               activeDisciplines.add(disciplines.get(Character.getNumericValue(comp[1].charAt(i))));
            }
            CompetitiveMember m = new CompetitiveMember(str[0], str[1], str[2], str[3], str[4], Boolean.parseBoolean(str[5]), Boolean.parseBoolean(str[6]), Double.parseDouble(str[7]), subscriptions, teams, activeDisciplines);
            members.add(m);
         }
      }
      //records and the subclass competitive records is also stored in the same file
      //using the same trick as before we split the text-lines with delimiters
      Scanner recordScanner = new Scanner(new File("data/records.txt"));
      while(recordScanner.hasNextLine()) {
         String line = recordScanner.nextLine();
         String[] comp = line.split("#");
         String[] str = comp[0].split(":");
         //a record holds a member object, pointing to the member who set the record
         //in the textfile this connection is stored as the cpr of that member
         //search the memberlist for the cpr string and get the correct member object
         Member recordHolder = null;
         for (Member m : members) {
            if (str[1].equals(m.getCpr())) {
               recordHolder = m;
               break;
            }
         }
         //a record also has a discipline
         //using the stored id of the discipline, get that discipline object
         Discipline discipline = null;
         for (Discipline d : disciplines) {
            if (Integer.parseInt(str[2]) == d.getId()) {
               discipline = d;
               break;
            }
         }
         //if the record is not from a competition
         if (!Boolean.parseBoolean(str[5])) {
            Record r = new Record(Integer.parseInt(str[0]), recordHolder, discipline, Double.parseDouble(str[3]), str[4], Boolean.parseBoolean(str[5]));
            records.add(r);
         //if it is, use the subclass and load the extra parameters for the constructor
         } 
         else {
            CompetitionRecord r = new CompetitionRecord(Integer.parseInt(str[0]), recordHolder, discipline, Double.parseDouble(str[3]), str[4], Boolean.parseBoolean(str[5]), comp[1], Integer.parseInt(comp[2]));
            records.add(r);
         }
      }
   }
   /*public void saveRecords(){
   FileWriter fw = new FileWriter("data/records.txt");
      fw.write(records.get(0).toString();
      for (Record r : records) {
         fw.write
      }
   }*/
   public int generateNextId(String objectToString) {
      String[] str = objectToString.split(":");
      return (Integer.parseInt(str[0])+1);
   }
   public void printCredit() {
      for (Member m : members) {
         if (m.getBalance() < 0) {
            System.out.println(m.showMember() + "\n");
         }
      }
   }
   public void editBalance(String cpr, Scanner console) {
      for (Member m : members) {
         if (m.getCpr().equals(cpr)) {
            System.out.println("How much do you wish to add?");
            double amount = console.nextDouble();
            m.setBalance(m.getBalance() + amount);
            break;
         }
      }
   }
   public void totalIncome() {
      double totalIncome = 0.0;
      System.out.print("Total income from subscriptions is: ");
      for (Member m : members) {         
         totalIncome += m.getBalance();        
      }
      System.out.print(totalIncome);
      System.out.println(" Kr"); 
   }
   
}