//Bertram
public class Subscription {
   //fields
   private int id;
   private String type;
   private double price;
   
   //default constructor
   public Subscription(){
      id = -1;
      type = "null";
      price = 0.0;
   }
   
   //constructor
   public Subscription(int id, String type, double price) {
      this.id = id;
      this.type = type;
      this.price = price;
   }
   
   //getters
   public int getId(){
      return id;
   }
   public String getType(){
      return type;
   }
   public double getPrice(){
      return price;
   }
   
   //setters
   public void setId(int id){
      this.id = id;
   }
   public void setType(String type){
      this.type = type;
   }
   public void setPrice(double price){
      this.price = price;
   }
   
   /*public String toString(){
      return id + " " + type + " " + price + "\n";
   }*/
}