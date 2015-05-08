package com.mju.dao;

import java.util.HashMap;

import com.mju.model.AdminModel;
import com.mju.model.CourseModel;


public class DataTaker {

    String username = "Ahmed";
    String password = "pass";
    String ID = "1";
  
    CourseModel[] courses = new CourseModel[4];
    
    int NOC;
    public DataTaker(){
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
    
    public HashMap<String, String> getUser(AdminModel am) {
        HashMap<String, String> user = new HashMap<String, String>();

        if(am.getUsername().equals(this.username) && am.getPassword().equals(this.password)) {
            user.put("username", this.username);
            user.put("password", this.password);
            user.put("ID", this.ID);
            return user;
        }
        else
        	return null;
    }

    public boolean logoutUser() {
        // Destory the session with the server here
        return true;
    }

    public boolean addNewUser(AdminModel am) {
        this.username = am.getUsername();
        this.password = am.getPassword();
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
