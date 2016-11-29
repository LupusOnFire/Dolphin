import java.util.*;
import java.io.*;

public class DolphinMain {
    public static void main(String[] args) throws Exception {
        Engine e = new Engine();
        Scanner console = new Scanner(System.in);
        e.loadData();
        //e.printMembers();
        //e.printRecords();
        //e.printCredit();
        e.totalIncome();
        // Spørg om CPR i main, laver lige temporary
        //e.editBalance("280493-0003", console);
    }
}
