public class Team {
    private int id;
    private String trainerName;

    //default constructor
    public Team(){
        id = -1;
        trainerName = "";
    }
    //constructor
    public Team(int id, String trainerName) {
        this.id = id;
        this.trainerName = trainerName;
    }

    //getters
    public int getId() {
        return id;
    }
    public String getTrainerName() {
        return trainerName;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }
    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }
}