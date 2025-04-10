public class Lab {
    private String roomNumber;
    private int capacity;
    
    public Lab(String roomNumber, int capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
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

    public int getCapacity() {
    	return capacity; 
    	}
    public void setCapacity(int capacity) {
    	this.capacity = capacity;
    	}
}