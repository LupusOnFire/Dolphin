import java.util.*;
public class CompetitiveMember extends Member {
    //fields
    private Team team;
    private ArrayList<Discipline> disciplines;

    //constructor
    public CompetitiveMember(String cpr, String firstName, String lastName, String phone, String address, boolean isActive, boolean isCompetitive, double balance, Subscription subscription, Team team, ArrayList<Discipline> disciplines) {
        super(cpr, firstName, lastName, phone, address, isActive, isCompetitive, balance, subscription);
        this.team = team;
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
        return super.showMember() + "\nTeam: " + team + "\nActive Disciplines: " + activeDisciplines;
    }
}