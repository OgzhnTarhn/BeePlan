public class Teoricital {
    private String roomNumber;
    
    public Teoricital(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean checkAvailability() {
        return true;
    }

    public String getRoomNumber() { 
    	return roomNumber; 
    	}
    public void setRoomNumber(String roomNumber) {
    	this.roomNumber = roomNumber;
    	}
}