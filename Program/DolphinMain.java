public class DolphinMain {
    public static void main(String[] args) throws Exception {
        Engine e = new Engine();
        e.loadData();
        e.printMembers();
        e.printRecords();
    }
}
