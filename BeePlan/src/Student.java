import java.util.List;

public class Student extends User {
    private int labHours;
    private List<String> exams; 
    private boolean absence;

    public Student(int userId,String name, String email, String password, String department, boolean absence) {
        super(userId,name, email, password, department);
        this.absence = absence;
    }

    public int getLabHours() {
        return labHours;
    }

    public void setLabHours(int labHours) {
        this.labHours = labHours;
    }

    public List<String> getExams() {
        return exams;
    }

    public void setExams(List<String> exams) {
        this.exams = exams;
    }

    public boolean isAbsent() {
        return absence;
    }

    public void setAbsence(boolean absence) {
        this.absence = absence;
    }

    
}