import java.text.SimpleDateFormat;
import java.util.Calendar;
public class Member {
   //fields
   private String cpr;
   private String firstName;
   private String lastName;
   private String phone;
   private String address;
   private boolean isActive;
   private boolean isCompetitive;
   private double balance;
   private Subscription subscription;
   
   
   //default constructor
   public Member(){
      cpr = "null";
      firstName = "null";
      lastName = "null";
      phone = "null";
      isActive = false;
      isCompetitive = false;
      balance = 0.0;
      subscription = new Subscription();
   }
   
   //constructor
   public Member(String cpr, String firstName, String lastName, String phone, String address, boolean isActive, boolean isCompetitive, double balance, Subscription subscription) {
      this.cpr = cpr;
      this.firstName = firstName;
      this.lastName = lastName;
      this.phone = phone;
      this.address = address;
      this.isActive = isActive;
      this.isCompetitive = isCompetitive;
      this.balance = balance;
      this.subscription = subscription;
   }
   
   //getters
   public String getCpr(){
      return cpr;
   }
   public String getFirstName(){
      return firstName;
   }
   public String getLastName(){
      return lastName;
   }
   public String getPhone(){
      return phone;
   }
   public boolean getIsActive(){
      return isActive;
   }
   public boolean getIsCompetitive(){
      return isCompetitive;
   }
   public double getBalance(){
      return balance;
   }
   public Subscription getSubscription(){
      return subscription;
   }
   
   //setters
   public void setCpr(String cpr){
      this.cpr = cpr;
   }
   public void setFirstName(String firstName){
      this.firstName = firstName;
   }
   public void setLastName(String lastName){
      this.firstName = firstName;
   }
   public void setPhone(String phone){
      this.phone = phone;
   }
   public void setIsActive(boolean isActive){
      this.isActive = isActive;
   }
   public void setIsCompetitive(boolean isCompetitive){
      this.isCompetitive = isCompetitive;
   }
   public void setBalance(double balance){
      this.balance = balance;
   }
   public void setSubscription(Subscription subscription){
      this.subscription = subscription;
   }
   
   //methods
   public String toString(){
      return cpr + "\n" + firstName + "\n" + lastName + "\n" + phone + "\n" + isActive + "\n" + isCompetitive  + "\n" + balance + "\n" + subscription + "\n";
   }
   
   public int getAge()throws Exception{
      //declare format of cpr
      SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyy");
      //use the first 6 characters of cpr and parse it to birth
      Calendar birth = Calendar.getInstance();
      birth.setTime(dateFormat.parse(cpr.substring(0, 6)));
      //subtract birthdate from current date
      Calendar age = Calendar.getInstance();
      age.add(Calendar.DAY_OF_MONTH, -birth.get(Calendar.DAY_OF_MONTH));
      age.add(Calendar.MONTH, -birth.get(Calendar.MONTH));
      age.add(Calendar.YEAR, -birth.get(Calendar.YEAR));
      //return age in years
      return age.get(Calendar.YEAR);
   }
   
   public String getGender(){
      //get last digit from cpr
      int genderInt = Integer.parseInt(cpr.substring(cpr.length()-1));
      //even == female
      if (genderInt % 2 == 0)
         return "Female";  
      return "Male";
   }
}
