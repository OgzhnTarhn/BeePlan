import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

class Courses {
    private int courseId;
    private String courseName;
    private int year;            
    private String department;   
    private int capacity;
    private boolean isMandatory;
    private List<Assistant> assistants; 
    private List<Instructor> instructors;
    private int weeklyTheoreticalHours;
    private int weeklyPracticalHours;
    private List<Session> sessions;

    public Courses(int courseId, String courseName, int year, String department, int capacity, boolean isMandatory, 
                   List<Assistant> assistants, List<Instructor> instructors, 
                   int weeklyTheoreticalHours, int weeklyPracticalHours) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.year = year;
        this.department = department;
        this.capacity = capacity;
        this.isMandatory = isMandatory;
        this.assistants = assistants;
        this.instructors = instructors;
        this.weeklyTheoreticalHours = weeklyTheoreticalHours;
        this.weeklyPracticalHours = weeklyPracticalHours;
        this.sessions = new ArrayList<>();
    }

    public static boolean isOverlap(LocalTime start1, LocalTime end1, LocalTime start2, LocalTime end2) {
        return start1.isBefore(end2) && start2.isBefore(end1);
    }

    public static double calculateDurationInHours(LocalTime start, LocalTime end) {
        return (end.getHour() + end.getMinute() / 60.0) - (start.getHour() + start.getMinute() / 60.0);
    }

   
    public int getCourseId() {
    	return courseId; 
    	}
    
    public void setCourseId(int courseId) {
    	this.courseId = courseId; 
    	}

    public int getCapacity() { 
    	return capacity; 
    	}

    public int getYear() {
    	return year; 
    	}
    
    public String getDepartment() { 
    	return department; 
    	}

    public String getCourseName() {
    	return courseName; 
    	}

    public int getWeeklyTheoreticalHours() {
    	return weeklyTheoreticalHours; 
    	}

    public void setWeeklyTheoreticalHours(int weeklyTheoreticalHours) {
        this.weeklyTheoreticalHours = weeklyTheoreticalHours;
    }

    public int getWeeklyPracticalHours() {
    	return weeklyPracticalHours;
    	}

    public void setWeeklyPracticalHours(int weeklyPracticalHours) {
        this.weeklyPracticalHours = weeklyPracticalHours;
    }

    public List<Instructor> getInstructors() { 
    	return instructors; 
    	}

    public List<Session> getSessions() { 
    	return sessions; 
    	}

    public void addSession(Session session) {
        this.sessions.add(session);
    }
}