import java.text.SimpleDateFormat;
import java.util.Calendar;
public class Member {
   //fields
   private String cpr;
   private String firstName;
   private String lastName;
   private String phone;
   private String address;
   private boolean active;
   private double balance;
   private double subscriptionFee;
 
   
   //default constructor
   public Member(){
      cpr = "null";
      firstName = "null";
      lastName = "null";
      phone = "null";
      active = "null";
      active = false;
      balance = 0.0;
      subscriptionFee = 0.0;
   }
   
   //constructor
   public Member(String cpr, String firstName, String lastName, String phone, String address, boolean active, double balance, double subscriptionFee) {
      this.cpr = cpr;
      this.firstName = firstName;
      this.lastName = lastName;
      this.phone = phone;
      this.active = active;
      this.balance = balance;
      this.subscriptionFee = subscriptionFee;
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
   public String getAddress(){
      return address;
   }
   public boolean getActive(){ //lyder dumt :^)
      return active;
   }
   public double getBalance(){
      return balance;
   }
   public double getSubscriptionFee(){
      return subscriptionFee;
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
   public void setAddress(String address){
      this.address = address;
   }
   public void setActive(boolean active){
      this.active = active;
   }
   public void setBalance(double balance){
      this.balance = balance;
   }
   public void setSubscriptionFee(double subscriptionFee){
      this.subscriptionFee = subscriptionFee;
   }
   
   //methods
   public String toString(){
      return cpr + "\n" + firstName + "\n" + lastName + "\n" + phone + "\n" + active + "\n" + balance + "\n" + subscriptionFee + "\n";
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