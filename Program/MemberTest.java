public class MemberTest {
   public static void main (String[] args)throws Exception {
      Member m = new Member(0, "280493-0003", "Bertram", "Baltzer Andersen", "88888888", true, 0.0, 0.0);
      System.out.println(m.getAge());
      System.out.println(m.getGender());
   }
}