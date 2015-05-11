package com.mju.software;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mju.dao.DataTaker;
import com.mju.model.CourseModel;

@Controller
public class CourseController {
	
	
	@RequestMapping(value = "/coursehome", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		DataTaker dt = new DataTaker();
		return "home";
	}
	
	@RequestMapping(value = "/courses", method = RequestMethod.GET)
	public String courses(Locale locale, Model model) {
		CourseModel cm = new CourseModel();
		
		CourseModel[] co = this.getAllCourses();
	
		String res="";
	
		for(CourseModel cmm : co){
			res = res + "<p>"+cmm.getTitle()+" <a href='delete/"+cmm.getID()+"'>Delete</a></p>";
		}
		
		model.addAttribute("res", res);
		return "courses";
	}

	
	@RequestMapping(value = "/delete/{ID}", method = RequestMethod.GET)
	public String delete(Locale locale, Model model,  @PathVariable("ID") int ID ) {
		CourseModel cm = new CourseModel();
		cm.setID(ID);
		if(this.removeCourse(cm))
			model.addAttribute("res", "removed");
		else
			model.addAttribute("res", "not removed");
		return "delete";
	}
	
	@RequestMapping(value = "/addcourse", method = RequestMethod.GET)
	public String addcourse(Locale locale, Model model ) {
		return "addcourse";
	}
	
	@RequestMapping(value = "/addcoursedone", method = RequestMethod.POST)
	public String addcoursedone(Locale locale, Model model , @ModelAttribute("name") String name) {
		
		if(this.addNewCourse(name))
			model.addAttribute("res", "added");
		else
			model.addAttribute("res", "not added");
		return "addcoursedone";
	}	
	
	
	// Functions area
	
	public CourseModel[] getAllCourses() {
		DataTaker dt = new DataTaker();
		// TODO Auto-generated method stub
		return dt.getCourses();
	}

	public boolean addNewCourse(String courseName) {
		DataTaker dt = new DataTaker();
		// TODO Auto-generated method stub
		return dt.addCourse(courseName);
	}

	public boolean removeCourse(CourseModel cm) {
		DataTaker dt = new DataTaker();
		// TODO Auto-generated method stub
		return dt.removeCourseID(cm);
	}

	public boolean editCourse(CourseModel cm) {
		DataTaker dt = new DataTaker();
		// TODO Auto-generated method stub
		return dt.editCourseID(cm);
	}
}
