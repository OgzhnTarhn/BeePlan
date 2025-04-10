import java.time.LocalTime;

class Session {
    private String day; 
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean isLab;

    public Session(String day, LocalTime startTime, LocalTime endTime, boolean isLab) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isLab = isLab;
    }

    public String getDay() {
    	return day; 
    }
    public void setDay(String day) { 
    	this.day = day; 
    	}

    public LocalTime getStartTime() { 
    	return startTime; 
    	}
    public void setStartTime(LocalTime startTime) { 
    	this.startTime = startTime; 
    	}

    public LocalTime getEndTime() { 
    	return endTime; 
    	}
    public void setEndTime(LocalTime endTime) { 
    	this.endTime = endTime;
    	}

    public boolean isLab() { 
    	return isLab; 
    	}
    public void setLab(boolean isLab) { 
    	this.isLab = isLab; 
    	}
}