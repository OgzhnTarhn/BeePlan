import java.time.LocalDateTime;

public class Assistant extends User {
    private LocalDateTime officeTime;
    private int roomNumber;
    private int enteredLabHours;
    
    public Assistant(int userId, String email, String password, String schedule, String department,
                     LocalDateTime officeTime, int roomNumber, int enteredLabHours) {
        super(userId, email, password, schedule, department);
        this.officeTime = officeTime;
        this.roomNumber = roomNumber;
        this.enteredLabHours = enteredLabHours;
    }
    
    public void addSchedule(String newClass) {
    }
    
    public void updatePersonalSchedule() {
    }
    
    public boolean isAvailable() {
        return true;
    }

    public LocalDateTime getOfficeTime() { 
    	return officeTime;
    	}
    public void setOfficeTime(LocalDateTime officeTime) {
    	this.officeTime = officeTime; 
    	}

    public int getRoomNumber() { 
    	return roomNumber; 
    	}
    public void setRoomNumber(int roomNumber) {
    	this.roomNumber = roomNumber; 
    	}

    public int getEnteredLabHours() {
    	return enteredLabHours; 
    	}
    public void setEnteredLabHours(int enteredLabHours) { 
    	this.enteredLabHours = enteredLabHours; 
    	}
}