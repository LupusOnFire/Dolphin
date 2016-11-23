import java.io.*;
import java.util.*;
public class MemberTest {
   public static void main (String[] args)throws Exception {
      Locale.setDefault(new Locale("en", "US"));
      ArrayList<Subscription> subscriptions = new ArrayList<>();
      ArrayList<Member> members = new ArrayList<>();
      Scanner subscriptionReader = new Scanner(new File("data/subscription.txt"));
      while (subscriptionReader.hasNextLine()){
         int id = subscriptionReader.nextInt();
         String type = subscriptionReader.next();
         double price = subscriptionReader.nextDouble();
         Subscription s = new Subscription(id, type, price);
         subscriptions.add(s);
      }
      Scanner memberReader = new Scanner(new File("data/member.txt"));
      while (memberReader.hasNextLine()) {
         Subscription sub = null;
         String line = memberReader.nextLine();
         String[] str = line.split(":");
         for (Subscription s : subscriptions) {
            if (s.getId() == Integer.parseInt(str[8])){
               sub = s;
               break;
            }
         }   
         Member m = new Member(str[0], str[1], str[2], str[3], str[4], Boolean.parseBoolean(str[5]), Boolean.parseBoolean(str[6]), Double.parseDouble(str[7]), sub);
         members.add(m);
      }   
      System.out.println(members);
   }
}