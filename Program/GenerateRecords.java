/**
 * Created by Bertram on 05-12-2016.
 */
import java.text.SimpleDateFormat;
import java.util.*;
public class GenerateRecords {
    public static void main(String[] args) throws Exception {
       Engine e = new Engine();
       e.loadData();
       ArrayList<CompetitiveMember> cmlist = new ArrayList<>();
       for (Member m : e.getMembers()) {
           if (m.getIsCompetitive()) {
               cmlist.add(e.castCompetitiveMember(m));
           }
       }
       Date date = new Date();
       SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy");
       String dateStr = dateFormat.format(date);
       int id = e.generateNextId(e.getRecords().get(e.getRecords().size()-1).toString());
       Random rng = new Random();
       for (CompetitiveMember cm : cmlist) {
           ArrayList<Discipline> disciplines = cm.getDisciplines();
           for (Discipline discipline : disciplines) {
               int disciplineId = discipline.getId();
               double time = 0;
               int rangeMin = 0;
               int rangeMax = 0;
               switch (disciplineId) {
                   case 0:
                       rangeMin = 35;
                       rangeMax = 55;
                       break;
                   case 1:
                       rangeMin = 25;
                       rangeMax = 40;
                       break;
                   case 2:
                       rangeMin = 50;
                       rangeMax = 60;
                       break;
                   case 3:
                       rangeMax = 40;
                       rangeMin = 55;
                       break;
                   case 4:
                       rangeMin = 100;
                       rangeMax = 200;
               }
               time = rangeMin + (rng.nextDouble() * (rangeMax - rangeMin));
               Record r = new Record(id, cm, discipline, time, dateStr, false);
               id++;
               e.getRecords().add(r);
               e.saveRecords();
               System.out.println(r);
           }
       }
    }
}
