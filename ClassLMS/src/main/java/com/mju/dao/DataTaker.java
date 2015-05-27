package com.mju.dao;

import java.util.HashMap;
import java.util.Map;

import com.mju.model.*;


public class DataTaker {
  
	UserModel user;
	
    CourseModel[] courses = new CourseModel[4];
    
    Map<String, UserModel> userMap = new HashMap<String, UserModel>();
    
    int NOC;
    public DataTaker(){
    	// Pseudo users
    	AdminModel am = new AdminModel();
    	am.setUsername("Ahmed");
    	am.setPassword("pass");
    	am.setID(1);
    	userMap.put(am.getUsername(), am);
    	
    	ProfessorModel pm = new ProfessorModel();
    	pm.setUsername("Prof.Choi");
    	pm.setPassword("pass");
    	pm.setID(2);
    	userMap.put(pm.getUsername(), pm);
    	
    	StudentModel sm = new StudentModel();
    	sm.setUsername("Hai");
    	sm.setPassword("pass");
    	sm.setID(3);
    	userMap.put(sm.getUsername(), sm);
    	
    	// Pseudo courses
    	courses[0] = new CourseModel();
    	courses[0].setTitle("c1");
    	courses[0].setID(0);
    	courses[1] = new CourseModel();
    	courses[1].setTitle("c2");
    	courses[1].setID(1);
    	courses[2] = new CourseModel();
    	courses[2].setTitle("c3");
    	courses[2].setID(2);
    	courses[3] = new CourseModel();
    	courses[3].setTitle("c4");
    	courses[3].setID(3);
  
    	NOC = 4;
    }
    
    public UserModel getUser(UserModel m) {
        UserModel user = userMap.get(m.getUsername());

        if (user != null && m.getPassword().equals(user.getPassword())) {
        	return user;
        } else {
        	return null;
        }
    }

    public boolean logoutUser() {
        // Destory the session with the server here
        return true;
    }

    public boolean addNewUser(UserModel am) {
        this.user = am;
        return true;
    }

	public CourseModel[] getCourses() {
		// TODO Auto-generated method stub
		
		return this.courses;
	}

	public boolean addCourse(String courseName) {
		// TODO Auto-generated method stub
		courses[NOC].setTitle(courseName);
		NOC++;
		return courses[NOC-1].getTitle().equals(courseName);
	}

	public boolean removeCourseID(CourseModel cm) {
		// TODO Auto-generated method stub
		return true;
	}
	
	public boolean editCourseID(CourseModel cm) {
		// TODO Auto-generated method stub
		courses[cm.getID()].setTitle(cm.getTitle());
		return courses[cm.getID()].getTitle() == cm.getTitle();
	}
}
