import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ScheduleManager {
    public static List<String> getAllDepartments(List<Courses> courses) {
        Set<String> deps = new HashSet<>();
        for(Courses c : courses) {
            deps.add(c.getDepartment());
        }
        return new ArrayList<>(deps);
    }

    public static List<Integer> getAllYears(List<Courses> courses) {
        Set<Integer> yrs = new HashSet<>();
        for(Courses c : courses) {
            yrs.add(c.getYear());
        }
        return new ArrayList<>(yrs);
    }

    public static void printWeeklyScheduleFormat(List<Courses> coursesList, String department, int year) {
        List<Courses> filtered = new ArrayList<>();
        for(Courses c : coursesList) {
            if(c.getDepartment().equalsIgnoreCase(department) && c.getYear() == year) {
                filtered.add(c);
            }
        }

        if(filtered.isEmpty()) {
            System.out.println(department + " " + year + ". sınıf için ders bulunamadı.");
            return;
        }

        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        
        System.out.println("\n" + year + ". Sınıf (" + department + ") Ders Programı:");
        System.out.println("---------------------------------------------------------");
        System.out.printf("%-10s | %-60s\n", "Gün", "Dersler (Saat)");
        System.out.println("---------------------------------------------------------");

        for(String dayName : daysOfWeek) {
            List<String> dayCourses = new ArrayList<>();
            for(Courses c : filtered) {
                for(Session sess : c.getSessions()) {
                    if(isCourseOnDay(sess, dayName)) {
                        String type = sess.isLab() ? "Lab" : "Teorik";
                        dayCourses.add(c.getCourseName() + " (" + type + ") " 
                                       + fmtTime(sess.getStartTime()) + "-" + fmtTime(sess.getEndTime()));
                    }
                }
            }

            System.out.printf("%-10s | ", dayName);
            if(dayCourses.isEmpty()) {
                System.out.println("----");
            } else {
                dayCourses.sort((s1, s2) -> {
                    LocalTime t1 = extractStartTime(s1);
                    LocalTime t2 = extractStartTime(s2);
                    return t1.compareTo(t2);
                });
                for(String courseInfo : dayCourses) {
                    System.out.println(courseInfo);
                    System.out.printf("%-10s | ", "");
                }
            }
            System.out.println("---------------------------------------------------------");
        }
    }

    private static boolean isCourseOnDay(Session sess, String fullDay) {
        String shortDay = sess.getDay().trim();
        return dayMatches(shortDay, fullDay);
    }

    private static boolean dayMatches(String shortDay, String fullDay) {
        shortDay = shortDay.trim();
        if(shortDay.equalsIgnoreCase("Mon") && fullDay.equalsIgnoreCase("Monday")) return true;
        if(shortDay.equalsIgnoreCase("Tue") && fullDay.equalsIgnoreCase("Tuesday")) return true;
        if(shortDay.equalsIgnoreCase("Wed") && fullDay.equalsIgnoreCase("Wednesday")) return true;
        if(shortDay.equalsIgnoreCase("Thu") && fullDay.equalsIgnoreCase("Thursday")) return true;
        if(shortDay.equalsIgnoreCase("Fri") && fullDay.equalsIgnoreCase("Friday")) return true;
        return false;
    }

    private static String fmtTime(LocalTime time) {
        return String.format("%02d:%02d", time.getHour(), time.getMinute());
    }

    private static LocalTime extractStartTime(String courseInfo) {
        String[] parts = courseInfo.split(" ");
        String timePart = parts[parts.length - 1];
        String startTimeStr = timePart.split("-")[0];
        return LocalTime.parse(startTimeStr);
    }

    public static boolean tryToAddCourse(List<Courses> allCourses, Courses newCourse) {
        for(Courses c : allCourses) {
            if(c.getDepartment().equalsIgnoreCase(newCourse.getDepartment()) && c.getYear() == newCourse.getYear()) {
                for(Session newSess : newCourse.getSessions()) {
                    for(Session existingSess : c.getSessions()) {
                        if(existingSess.getDay().equalsIgnoreCase(newSess.getDay()) &&
                           isOverlap(existingSess.getStartTime(), existingSess.getEndTime(),
                                     newSess.getStartTime(), newSess.getEndTime())) {
                            return false;
                        }
                    }
                }
            }
        }

        for(Instructor inst : newCourse.getInstructors()) {
            if(!inst.canTeachCourse(newCourse)) {
                return false;
            }
        }

        for(Instructor inst : newCourse.getInstructors()) {
            if(!inst.addCourseToSchedule(newCourse)) {
                return false;
            }
        }

        allCourses.add(newCourse);
        return true;
    }

    private static boolean isOverlap(LocalTime start1, LocalTime end1, LocalTime start2, LocalTime end2) {
        return start1.isBefore(end2) && start2.isBefore(end1);
    }
}