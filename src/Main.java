import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Main {
    static Random rand = new Random();
    static String[] shortDays = {"Mon", "Tue", "Wed", "Thu", "Fri"};
    static LocalTime[][] timeSlots = {
        {LocalTime.of(9,20), LocalTime.of(11,10)},
        {LocalTime.of(11,20), LocalTime.of(13,10)},
        {LocalTime.of(13,20), LocalTime.of(15,10)},
        {LocalTime.of(15,20), LocalTime.of(17,00)} //17.00'da bitir dememin sebebi 17.20-19.10 arasına ders koymaya çalışıyor LocalTime start = timeSlots[slotIndex][0] LocalTime end = timeSlots[slotIndex][1] buradaki 1 yüzünden
    };

    public static void main(String[] args) {
        Instructor sadikHoca = new Instructor(1, "sadik@cankaya.edu.tr", "1234", "", "SENG", null, 0);
        Instructor avenoglu = new Instructor(2, "avenoglu@cankaya.edu.tr", "1234", "", "SENG", null, 1);
        Instructor sevgi = new Instructor(3, "sevgitunc@cankaya.edu.tr", "1234","", "SENG",null, 2);
        Instructor cagıltay = new Instructor(4, "cagıltay@cankaya.edu.tr", "1234","", "SENG",null, 3);
        Instructor celikkale = new Instructor(5, "celikkale@cankaya.edu.tr", "1234","", "SENG",null, 4);
        Instructor karadeniz = new Instructor(6, "karadeniz@cankaya.edu.tr", "1234","", "SENG",null, 5);
        Instructor ipek = new Instructor(7, "ipek@cankaya.edu.tr", "1234","", "SENG",null, 6);
        List<Assistant> noAsst = new ArrayList<>();
        List<Instructor> commonInstructors = new ArrayList<>();
        List<Instructor> Instructor203 = new ArrayList<>();
        List<Instructor> Buse = new ArrayList<>();
        
        List<Instructor> sengInstructors = new ArrayList<>();
        sengInstructors.add(sadikHoca);
        List<Instructor> sengInstructors2 = new ArrayList<Instructor>();
        sengInstructors2.add(avenoglu);
        List<Instructor> sengInstructors3 = new ArrayList<Instructor>();
        sengInstructors3.add(sevgi);
        List<Instructor> sengInstructors4 = new ArrayList<Instructor>();
        sengInstructors4.add(cagıltay);
        List<Instructor> sengInstructors5 = new ArrayList<Instructor>();
        sengInstructors5.add(celikkale);
        List<Instructor> sengInstructors6 = new ArrayList<Instructor>();
        sengInstructors6.add(karadeniz);
        List<Instructor> physInstructors = new ArrayList<Instructor>();
        physInstructors.add(ipek);
        
        List<Courses> allCourses = new ArrayList<>();

        
        Courses PHYS131_Theoretical = new Courses(1001, "PHYS131", 1, "SENG", 200, true, noAsst, commonInstructors, 2, 0);
        PHYS131_Theoretical.addSession(new Session("Mon", LocalTime.of(9,20), LocalTime.of(11,10), false)); 
        allCourses.add(PHYS131_Theoretical);
        
        Courses PHYS131_Theoretical1 = new Courses(1002, "PHYS131", 1, "SENG", 200, true, noAsst, commonInstructors, 2, 0);
        PHYS131_Theoretical.addSession(new Session("Wed", LocalTime.of(9,20), LocalTime.of(11,10), false)); 
        allCourses.add(PHYS131_Theoretical1);

        Courses TURK101 = new Courses(1002, "TURK101", 1, "SENG", 200, true, noAsst, commonInstructors, 1, 0);
        TURK101.addSession(new Session("Mon", LocalTime.of(11,20), LocalTime.of(12,10), false)); 
        allCourses.add(TURK101);

      
        Courses MATH157 = new Courses(1003, "MATH157", 1, "SENG", 200, true, noAsst, commonInstructors, 2, 0);
        MATH157.addSession(new Session("Mon", LocalTime.of(13,20), LocalTime.of(15,10), false)); 
        allCourses.add(MATH157);
        
        Courses MATH1571 = new Courses(1003, "MATH157", 1, "SENG", 200, true, noAsst, commonInstructors, 2, 0);
        MATH157.addSession(new Session("Wed", LocalTime.of(13,20), LocalTime.of(15,10), false)); 
        allCourses.add(MATH1571);

       
        Courses ENG121 = new Courses(1004, "ENG121", 1, "SENG", 25, true, noAsst, commonInstructors, 3, 0);
        ENG121.addSession(new Session("Tue", LocalTime.of(9,20), LocalTime.of(12,10), false)); 
        allCourses.add(ENG121);
        
        Courses BIO101 = new Courses(1005, "BIO101", 1, "SENG", 200, true, noAsst, commonInstructors, 3, 0);
        BIO101.addSession(new Session("Thu", LocalTime.of(9,20), LocalTime.of(12,10), false)); 
        allCourses.add(BIO101); 
        
        Courses PHYS131_Lab = new Courses(1006, "PHYS131", 1, "SENG", 200, true, noAsst, commonInstructors, 0, 2);
        PHYS131_Lab.addSession(new Session("Mon", LocalTime.of(15,20), LocalTime.of(17,10), true)); 
        allCourses.add(PHYS131_Lab);
        
        Courses MATH223_1 = new Courses(2001, "MATH223", 2, "SENG", 200, true, noAsst, commonInstructors, 3, 0);
        MATH223_1.addSession(new Session("Tue", LocalTime.of(9,20), LocalTime.of(12,10), false)); 
        allCourses.add(MATH223_1);

        Courses MATH223_2 = new Courses(2002, "MATH223 (Lab)", 2, "SENG", 200, true, noAsst, commonInstructors, 0, 2);
        MATH223_2.addSession(new Session("Thu", LocalTime.of(9,20), LocalTime.of(11,10), false)); 
        allCourses.add(MATH223_2);
      
        Courses HIST201 = new Courses(2003, "HIST201", 2, "SENG", 200, true, noAsst, commonInstructors, 1, 0);
        HIST201.addSession(new Session("Mon", LocalTime.of(12,20), LocalTime.of(13,10), false)); 
        allCourses.add(HIST201);
      
        Courses math205 = new Courses(2003, "MATH205", 3, "SENG", 200, true, noAsst, commonInstructors, 3, 0);
        math205.addSession(new Session("Wed", LocalTime.of(9,20), LocalTime.of(12,10), false)); 
        allCourses.add(math205);
        Courses HIST202 = new Courses(3003, "HIST202", 3, "SENG", 200, true, noAsst, commonInstructors, 1, 0);
        HIST202.addSession(new Session("Fri", LocalTime.of(10,20), LocalTime.of(11,10), false)); 
        allCourses.add(HIST202);
       
        Courses[] additionalCourses = {   
        	new Courses(1007, "SENG101", 1, "SENG", 70, true, noAsst, sengInstructors, 3, 2),
            new Courses(2008, "SENG201", 2, "SENG", 60, true, noAsst, sengInstructors5, 3, 2),
            new Courses(2009, "SENG203", 2, "SENG", 100, true, noAsst, Instructor203, 3, 0),
            new Courses(2010, "SENG206", 2, "SENG", 65, true, noAsst, sengInstructors3, 3, 0),
            new Courses(2011, "SENG271", 2, "SENG", 60, true, noAsst, Buse, 2, 0),
            //new Courses(2012, "PHYS 132", 2, "SENG", 200, true, noAsst, physInstructors, 4, 2),
            //new Courses(2013, "MATH158", 2, "SENG", 200, true, noAsst, commonInstructors, 4, 0),
            new Courses(2014, "TURK102", 2, "SENG", 200, true, noAsst, commonInstructors, 1, 0),
            new Courses(3000, "SENG315", 3, "SENG", 40, true, noAsst, sengInstructors2, 3, 0),
            new Courses(3001, "SENG301", 3, "SENG", 45, true, noAsst, sengInstructors3, 2, 2),
            new Courses(3002, "SENG303", 3, "SENG", 40, true, noAsst, sengInstructors, 3, 0),
            new Courses(3003, "SENG383", 3, "SENG", 40, true, noAsst, sengInstructors5, 2, 0),
            new Courses(4000, "SENG429", 4, "SENG", 35, true, noAsst, sengInstructors2, 1, 2),
            new Courses(4001, "SENG449", 4, "SENG", 60, true, noAsst, sengInstructors4, 3, 0),
            new Courses(4002, "SENG465", 4, "SENG", 40, true, noAsst, sengInstructors2, 3, 0),
            new Courses(4003, "SENG474", 4, "SENG", 65, true, noAsst, sengInstructors3, 3, 0),
            new Courses(4004, "SENG445", 4, "SENG", 30, true, noAsst, sengInstructors6, 3, 0),
            new Courses(4005, "SENG426", 4, "SENG", 30, true, noAsst, sengInstructors5, 4, 0),
            //new Courses(4006, "CENG493", 4, "SENG", 60,true, noAsst, commonInstructors, 2, 0),
            //new Courses(4007, "CENG346", 4, "SENG", 60, true, noAsst, commonInstructors, 2, 0)
        };
        

        for (Courses course : additionalCourses) {
            if (course.getWeeklyPracticalHours() == 0) { 
                if (!assignCourseRandomly(allCourses, course)) {
                    System.out.println("Uygun zaman dilimi bulunamadı: " + course.getCourseName());
                }
            } else {
               
                Courses labCourse = new Courses(course.getCourseId(), course.getCourseName() + " Lab", course.getYear(), course.getDepartment(),
                                                course.getCapacity(), true, noAsst, course.getInstructors(),
                                                0, course.getWeeklyPracticalHours());
              
                if (!assignCourseRandomly(allCourses, course, labCourse)) {
                    System.out.println("Uygun zaman dilimi bulunamadı: " + course.getCourseName() + " ve " + labCourse.getCourseName());
                }
            }
        }
        ScheduleManager.printWeeklyScheduleFormat(allCourses, "SENG", 1);
        ScheduleManager.printWeeklyScheduleFormat(allCourses, "SENG", 2);
        ScheduleManager.printWeeklyScheduleFormat(allCourses, "SENG", 3);
        ScheduleManager.printWeeklyScheduleFormat(allCourses, "SENG", 4);
    }

    private static boolean assignCourseRandomly(List<Courses> allCourses, Courses targetCourse) {  
        int attempts = 1000;  
        while(attempts > 0) {  
            attempts--;  
            int d1 = rand.nextInt(shortDays.length);  
            String chosenDay = shortDays[d1];  

            int slotIndex = rand.nextInt(timeSlots.length);  
            LocalTime start = timeSlots[slotIndex][0];  
            LocalTime end = timeSlots[slotIndex][1];  
            //***** Friday 13.10-15.20 restriction
            if (chosenDay.equals("Fri")) {
                if(!(end.isBefore(LocalTime.of(13,10)) || start.isAfter(LocalTime.of(15,20)))) {
                    continue;
                }
            }

            if(end.isAfter(LocalTime.of(17,0))) {
                continue;
            }

            Session newSession = new Session(chosenDay, start, end, targetCourse.getWeeklyPracticalHours() > 0);
            targetCourse.addSession(newSession);

            
            if(ScheduleManager.tryToAddCourse(allCourses, targetCourse)) {  
                return true;  
            } else {  
                targetCourse.getSessions().remove(newSession); 
            }  
        }  
        return false; 
    }  

    private static boolean assignCourseRandomly(List<Courses> allCourses, Courses theoreticalCourse, Courses labCourse) {  
        int attempts = 1000;  
        while(attempts > 0) {  
            attempts--;  
            int d1 = rand.nextInt(shortDays.length);  
            String chosenDayTheoretical = shortDays[d1];  

            int slotIndex = rand.nextInt(timeSlots.length);  
            LocalTime startTheoretical = timeSlots[slotIndex][0];  
            LocalTime endTheoretical = timeSlots[slotIndex][1];  

            if (chosenDayTheoretical.equals("Fri")) {
                if(!(endTheoretical.isBefore(LocalTime.of(13,10)) || startTheoretical.isAfter(LocalTime.of(15,20)))) {
                    continue; 
                }
            }

            if(endTheoretical.isAfter(LocalTime.of(17,0))) {
                continue;
            }

            Session theoreticalSession = new Session(chosenDayTheoretical, startTheoretical, endTheoretical, false);
            theoreticalCourse.addSession(theoreticalSession);

            List<Integer> availableSlots = new ArrayList<>();
            for(int i = 0; i < timeSlots.length; i++) {
                LocalTime labStart = timeSlots[i][0];
                if(labStart.isAfter(endTheoretical)) {
                    availableSlots.add(i);
                }
            }

            if(availableSlots.isEmpty()) {
                theoreticalCourse.getSessions().remove(theoreticalSession);
                continue; 
            }

            int selectedLabSlotIndex = availableSlots.get(rand.nextInt(availableSlots.size()));
            LocalTime startLab = timeSlots[selectedLabSlotIndex][0];
            LocalTime endLab = timeSlots[selectedLabSlotIndex][1];

            if (theoreticalSession.getDay().equals("Fri")) {
                if(!(endLab.isBefore(LocalTime.of(13,10)) || startLab.isAfter(LocalTime.of(15,20)))) {
                    theoreticalCourse.getSessions().remove(theoreticalSession);
                    continue; 
                }
            }

            if(endLab.isAfter(LocalTime.of(17,0))) {
                theoreticalCourse.getSessions().remove(theoreticalSession);
                continue;
            }

            Session labSession = new Session(theoreticalSession.getDay(), startLab, endLab, true);
            labCourse.addSession(labSession);

             
            if(ScheduleManager.tryToAddCourse(allCourses, theoreticalCourse) && 
               ScheduleManager.tryToAddCourse(allCourses, labCourse)) {  
                return true;  
            } else {  
               
                theoreticalCourse.getSessions().remove(theoreticalSession); 
                labCourse.getSessions().remove(labSession);
            }  
        }  
        return false;  
    }  
}