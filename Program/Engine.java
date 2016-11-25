import java.io.*;
import java.util.*;
public class Engine {
    public static void main (String[] args)throws Exception {
        //Most Danish Windows OS have their locale set to da;Danish and thus expecting decimal types from scanners to contain ',' instead of '.'
        //Hardcoding the locale as us;English will remove that annoying feature.
        Locale.setDefault(new Locale("en", "US"));

        //create a list for each class
        ArrayList<Team> teams = new ArrayList<>();
        ArrayList<Discipline> disciplines = new ArrayList<>();
        ArrayList<Subscription> subscriptions = new ArrayList<>();
        ArrayList<Member> members = new ArrayList<>();

        //fill the lists with data stored in the text files
        Team team1 = new Team (0, "John");
        Team team2 = new Team (0, "Charlie");
        teams.add(team1);
        teams.add(team2);


        Scanner disciplineScanner = new Scanner(new File("data/disciplines.txt"));
        while (disciplineScanner.hasNextLine()){
            String line = disciplineScanner.nextLine();
            String[] str = line.split(":");
            Discipline d = new Discipline(Integer.parseInt(str[0]), str[1]);
            disciplines.add(d);
        }

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
            //if member is not competitive
            if (!Boolean.parseBoolean(str[6])) {
                Member m = new Member(str[0], str[1], str[2], str[3], str[4], Boolean.parseBoolean(str[5]), Boolean.parseBoolean(str[6]), Double.parseDouble(str[7]), sub);
                members.add(m);
            } else {
                CompetitiveMember m = new CompetitiveMember(str[0], str[1], str[2], str[3], str[4], Boolean.parseBoolean(str[5]), Boolean.parseBoolean(str[6]), Double.parseDouble(str[7]), sub, team1, disciplines);
                members.add(m);
            }
        }
        for (Member m : members) {
            System.out.println(m.showMember() + "\n");
        }

        /*Member m2 = new Member("060149-1113", "Charles", "Manson", "12131415", "Prison", true, true, 0.0, null);
        m2.setSubscription(subscriptions.get(m2.findSubscription()));
        System.out.println(m2);*/

    }
}