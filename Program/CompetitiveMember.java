import java.util.*;
public class CompetitiveMember extends Member {
    //fields
    private Team team;
    private ArrayList<Discipline> disciplines;

    //constructor
    public CompetitiveMember(String cpr, String firstName, String lastName, String phone, String address, boolean isActive, boolean isCompetitive, double balance, ArrayList<Subscription> subscriptions, ArrayList<Team> teams, ArrayList<Discipline> disciplines) throws Exception {
        super(cpr, firstName, lastName, phone, address, isActive, isCompetitive, balance, subscriptions);
        team = teams.get(findTeamId());
        this.disciplines = disciplines;
    }

    //getters
    public Team getTeam() {
        return team;
    }
    public ArrayList<Discipline> getDisciplines() {
        return disciplines;
    }

    //setters
    public void setTeam(Team team) {
        this.team = team;
    }
    public void setDisciplines(ArrayList<Discipline> disciplines) {
        this.disciplines = disciplines;
    }
    @Override
    public String toString() {
      String disciplineNumberStr = "";
      for (Discipline d : disciplines) {
         disciplineNumberStr += d.getId();
      }
      return super.toString() + "#" + disciplineNumberStr;
    }
    
    @Override
    public String showMember() {
        //create a string with the members active disciplines
        String activeDisciplines = "none";
        int arrayEndIndex = disciplines.size()-1;
        if (arrayEndIndex != -1) {
            //use fenceposting to seperate each discipline from the arraylist with a comma
            activeDisciplines = "";
            for (int i = 0; i < arrayEndIndex; i++) {
               activeDisciplines += disciplines.get(i).getName() + ", ";
            }
            activeDisciplines += disciplines.get(arrayEndIndex).getName();
        }
        return super.showMember() + "\nTeam: " + team.getTeamName() + "\nActive Disciplines: " + activeDisciplines;
    }
    public int findTeamId() throws Exception {
        String gender = getGender();
        int age = getAge();
        if (gender.equals("Male")) {
            if (age < 18)
                return 0;
            else
                return 1;
        } else {
            if (age < 18)
                return 2;
        }
        return 3;
    }
}