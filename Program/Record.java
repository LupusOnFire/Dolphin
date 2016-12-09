//Bertram
import java.text.SimpleDateFormat;
import java.util.Date;

public class Record {
    private int id;
    private CompetitiveMember member;
    private Discipline discipline;
    private double time;
    private Date date;
    private boolean fromCompetition;

    public Record() {
        id = -1;
        member = null;
        date = null;
        time = -1.0;
        fromCompetition = false;
    }

    //constructor
    public Record(int id, CompetitiveMember member, Discipline discipline, double time, String dateStr, boolean fromCompetition) throws java.text.ParseException {
        this.id = id;
        this.member = member;
        this.time = time;
        this.discipline = discipline;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy");
        date = dateFormat.parse(dateStr);
        this.fromCompetition = fromCompetition;
    }

    //getters
    public int getId() {
        return id;
    }
    public Member getMember() {
        return member;
    }
    public Discipline getDiscipline() {
        return discipline;
    }
    public double getTime() {
        return time;
    }
    public Date getDate() {
        return date;
    }
    public boolean isFromCompetition() {
        return fromCompetition;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }
    public void setMember(CompetitiveMember member) {
        this.member = member;
    }
    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }
    public void setTime(double time) {
        this.time = time;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void setFromCompetition(boolean fromCompetition) {
        this.fromCompetition = fromCompetition;
    }

    //methods
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy");
        return id+":"+member.getCpr()+":"+discipline.getId()+":"+time+":"+dateFormat.format(date)+":"+fromCompetition;
    }
    public String getCompetitionName() {
        return "null";
    }

    public String showRecord() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("d. MMM yyyy");
        return "Record ID: " + id + "\nMember: " + member.getFirstName() + " " + member.getLastName() + "\nDiscipline: " + discipline.getName() + "\nTime: " + time + "\nDate: " + dateFormat.format(date);
    }
}
