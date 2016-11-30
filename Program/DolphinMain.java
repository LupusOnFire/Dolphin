public class DolphinMain {
   public static void main(String[] args) throws Exception {
      Engine e = new Engine();
      Menu menu = new Menu(e);
      while (menu.mainMenu()){      
      }  
   }
}
