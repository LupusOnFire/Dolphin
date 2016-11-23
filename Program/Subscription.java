public class Subscription {
   private int id;
   private String type;
   private double price;
   
   public Subscription(){
      id = -1;
      type = "null";
      price = 0.0;
   }
   
   public Subscription(int id, String type, double price) {
      this.id = id;
      this.type = type;
      this.price = price;
   }
   
   public int getId(){
      return id;
   }
   public String getType(){
      return type;
   }
   public double getPrice(){
      return price;
   }
   
   public void setId(int id){
      this.id = id;
   }
   public void setType(String type){
      this.type = type;
   }
   public void setPrice(double price){
      this.price = price;
   }
   
   public String toString(){
      return id + " " + type + " " + price + "\n";
   }
}