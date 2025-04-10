class User {
    private int userId;
    private String email;
    private String password;
    private String schedule;
    private String department;

    public User(int userId, String email, String password, String schedule, String department) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.schedule = schedule;
        this.department = department;
    }

    public int getUserId() {
    	return userId; 
    	}
    public void setUserId(int userId) { 
    	this.userId = userId; 
    	}

    public String getEmail() { 
    	return email; 
    	}
    public void setEmail(String email) { 
    	this.email = email; 
    	}

    public String getPassword() {
    	return password; 
    	}
    public void setPassword(String password) { 
    	this.password = password;
    	}

    public String getSchedule() {
    	return schedule;
    	}
    public void setSchedule(String schedule) { 
    	this.schedule = schedule; 
    	}

    public String getDepartment() { 
    	return department; 
    	}
    public void setDepartment(String department) {
    	this.department = department; 
    	}
}
