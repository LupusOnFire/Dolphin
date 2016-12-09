//Bertram
public class CompetitionRecord extends Record {
    private String competitionName;
    private int placement;

    public CompetitionRecord(int id, CompetitiveMember member, Discipline discipline, double time, String dateStr, boolean fromCompetition, String competitionName, int placement) throws java.text.ParseException {
        super(id, member, discipline, time, dateStr, fromCompetition);
        this.competitionName = competitionName;
        this.placement = placement;
    }
    @Override
    public String getCompetitionName() {
        return competitionName;
    }
    public int getPlacement() {
        return placement;
    }
    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }
    public void setPlacement(int placement) {
        this.placement = placement;
    }
    @Override
    public String toString(){
        return super.toString() + "#" + competitionName + "#" + placement;
    }
}