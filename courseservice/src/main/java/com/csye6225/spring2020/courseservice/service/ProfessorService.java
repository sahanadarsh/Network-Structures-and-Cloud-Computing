package com.csye6225.spring2020.courseservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Response;

import com.csye6225.spring2020.courseservice.datamodel.Course;
import com.csye6225.spring2020.courseservice.datamodel.InMemoryDatabase;
import com.csye6225.spring2020.courseservice.datamodel.Professor;
import com.csye6225.spring2020.courseservice.exception.DataNotFoundException;

public class ProfessorService{

	static HashMap<String, Professor> prof_Map = InMemoryDatabase.getProfessorDB();

	public ProfessorService(){
	}

	// Getting a list of all professor 
	public List<Professor> getAllProfessors(){	
		ArrayList<Professor> list = new ArrayList<>();
		for (Professor prof : prof_Map.values()) {
			list.add(prof);
		}
		if(list.isEmpty()) {
			throw new DataNotFoundException("No professor in the system");
		}else {
			return list ;
		}
	}

	// Adding a professor
	public Professor addProfessor(Professor professor){
		professor.setProfessorId(professor.getFirstName()+professor.getLastName());
		boolean found = false;
		for (Professor prof : prof_Map.values()) {
			if(prof.getProfessorId().equalsIgnoreCase(professor.getProfessorId())) {
				found = true;
			}
		}
		if (!found) {
			if(CourseService.doesCoursesExit(professor.getCourses())) {
				Professor prof = new Professor(professor.getFirstName() , professor.getLastName(), professor.getProfessorId(), professor.getDepartment(), professor.getJoiningDate(), professor.getCourses());
				prof_Map.put(prof.getProfessorId(), prof);
				return prof;
			}else {
				throw new BadRequestException(Response.status(Response.Status.BAD_REQUEST).entity("Course doesn't exit").build());
			}
		}else {
			throw new BadRequestException(Response.status(Response.Status.BAD_REQUEST).entity("Professor already exit").build());
		}
	}

	// Getting One Professor
	public static Professor getProfessor(String profId) {
		Professor prof = prof_Map.get(profId);
		if(prof == null) {
			throw new DataNotFoundException("Professor with Id " + profId + " not found");
		}
		return prof;
	}


	// Deleting a professor
	public Professor deleteProfessor(String profId) {
		if(prof_Map.containsKey(profId)) {
			return prof_Map.remove(profId);
		}else {
			throw new DataNotFoundException("Professor with Id " + profId + " not found");
		}

	}

	// Updating Professor Info
	public Professor updateProfessorInformation(String profId, Professor prof) {	
		if(!prof_Map.containsKey(profId)) {
			throw new DataNotFoundException("Professor with Id " + profId + " not found");
		}else {
			prof.setProfessorId(prof.getFirstName()+ prof.getLastName());
			if(!prof.getProfessorId().equalsIgnoreCase(profId)) {
				prof_Map.remove(profId);
			}
			prof_Map.put(prof.getProfessorId(), prof);
			return prof;
		}
	}

	// Get professors in a department 
	public List<Professor> getProfessorsByDepartment(String department) {	
		ArrayList<Professor> list = new ArrayList<>();
		boolean invalid = true;
		for (Professor prof : prof_Map.values()) {
			if (prof.getDepartment().equalsIgnoreCase(department)) {
				invalid = false;
				list.add(prof);
			}
		}
		if(!invalid) {
			return list ;
		}else {
			throw new DataNotFoundException ("Professor with the " + department + " doesn't exits");
		}
	}

	// Get professors by joining date
	public List<Professor> getProfessorsByJoiningDate(String joingingDate) {	
		ArrayList<Professor> list = new ArrayList<>();
		boolean invalid = true;
		for (Professor prof : prof_Map.values()) {
			if (prof.getJoiningDate().equalsIgnoreCase(joingingDate)) {
				invalid = false;
				list.add(prof);
			}
		}
		if(!invalid) {
			return list ;
		}else {
			throw new DataNotFoundException ("Professor with the " + joingingDate + " doesn't exits");
		}
	}

	//Get courses associated with a particular professor
	public List<Course> getCoursesByProfessor(String profId) {
		if(prof_Map.containsKey(profId)){
			for (Professor prof : prof_Map.values()) {
				if (prof.getProfessorId().equalsIgnoreCase(profId)) {
					List<String> courses = prof.getCourses();
					List<Course> courseDetails = new ArrayList<>();
					for(int i = 0; i < courses.size(); i++) {
						courseDetails.add(CourseService.getCourse(courses.get(i)));
					}
					return courseDetails;
				}
			}
		}else {
			throw new DataNotFoundException ("Professor with Id " + profId + " not found");
		}
		return null;
	}

	public static boolean doesProfessorsExit(List<String> professors) {
		for(int i = 0; i < professors.size(); i++) {
			if(!prof_Map.containsKey(professors.get(i))) {
				return false;
			}
		}
		return true;
	}

	public static boolean doesProfessorExit(String professorId) {
		if(prof_Map.containsKey(professorId)) {
			return true;
		}else {
			return false;
		}
	}

}
