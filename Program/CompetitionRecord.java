import java.text.SimpleDateFormat;
public class CompetitionRecord extends Record {
    private String competitionName;
    private int placement;

    public CompetitionRecord(int id, Member member, Discipline discipline, double time, String dateStr, boolean fromCompetition, String competitionName, int placement) throws java.text.ParseException {
        super(id, member, discipline, time, dateStr, fromCompetition);
        this.competitionName = competitionName;
        this.placement = placement;
    }
    @Override
    public String showRecord(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("d. MMM yyyy");
        return "Record ID: " + super.getId() + "\nCompetition: " + competitionName + "\nPlacement: " + placement + "\nMember: " + super.getMember().getFirstName() + " " + super.getMember().getLastName() + "\nDiscipline: " + super.getDiscipline().getName() + "\nTime: " + super.getTime() + "\nDate: " + dateFormat.format(super.getDate());
    }
}
