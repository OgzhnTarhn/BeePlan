import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class Instructor extends User {
    private LocalDateTime officeTime;
    private int roomNumber;
    private List<Courses> assignedCourses;

    public Instructor(int userId, String email, String password, String schedule, String department, 
                      LocalDateTime officeTime, int roomNumber) {
        super(userId, email, password, schedule, department);
        this.officeTime = officeTime;
        this.roomNumber = roomNumber;
        this.assignedCourses = new ArrayList<>();
    }

    public void updatePersonalSchedule() {
    }

    public boolean isAvailable() {
        return true;
    }

    public LocalDateTime getOfficeTime() { return officeTime; }
    public void setOfficeTime(LocalDateTime officeTime) { this.officeTime = officeTime; }

    public int getRoomNumber() { return roomNumber; }
    public void setRoomNumber(int roomNumber) { this.roomNumber = roomNumber; }

    public boolean addCourseToSchedule(Courses newCourse) {//ınstructorın schedulına ekle
        for(Session newSession : newCourse.getSessions()) {
            for(Courses c : assignedCourses) {
                for(Session existingSession : c.getSessions()) {
                    if(existingSession.getDay().equals(newSession.getDay()) &&
                       Courses.isOverlap(existingSession.getStartTime(), existingSession.getEndTime(),
                                         newSession.getStartTime(), newSession.getEndTime())) {
                        return false;
                    }
                }
            }
        }
        assignedCourses.add(newCourse);
        return true;
    }

    public List<Courses> getAssignedCourses() {
        return assignedCourses;
    }

    public boolean canTeachCourse(Courses c) {
        for(Session sess : c.getSessions()) {
            String day = sess.getDay();
            double courseDuration = Courses.calculateDurationInHours(sess.getStartTime(), sess.getEndTime());
            double dailyLoad = getDailyLoad(day);
            if(dailyLoad + courseDuration > 4.0) {
                return false;
            }
        }
        return true;
    }

    private double getDailyLoad(String day) {
        double load = 0.0;
        for(Courses c : assignedCourses) {
            for(Session sess : c.getSessions()) {
                if(sess.getDay().equalsIgnoreCase(day)) {
                    load += Courses.calculateDurationInHours(sess.getStartTime(), sess.getEndTime());
                }
            }
        }
        return load;
    }
}