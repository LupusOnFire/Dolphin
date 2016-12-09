//Bertram
public class Team {
    private int id;
    private String teamName;
    private String trainerName;

    //default constructor
    public Team(){
        id = -1;
        teamName = "";
        trainerName = "";
    }

    //constructor
    public Team(int id, String teamName, String trainerName) {
        this.id = id;
        this.teamName = teamName;
        this.trainerName = trainerName;
    }

    //getters
    public int getId() {
        return id;
    }
    public String getTeamName() {
        return teamName;
    }
    public String getTrainerName() {
        return trainerName;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

}