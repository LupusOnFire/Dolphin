import java.io.*;
import java.util.*;
public class MemberTest {
   public static void main (String[] args)throws Exception {
      //Most Danish Windows OS have their locale set to da;Danish and thus expecting decimal types from scanners to contain ',' instead of '.'
      //Hardcoding the locale as us;English will remove that annoying feature.
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
      //System.out.println(members);          
      
      Member m2 = new Member("06028-1113", "Charles", "Manson", "12131415", "Prison", true, true, 0.0, null);
      m2.setSubscription(subscriptions.get(m2.findSubscription()));   
      System.out.println(m2);
   }
}