package com.csye6225.spring2020.courseservice.datamodel;

import java.util.List;

public class Professor {
	private String firstName;
	private String lastName;
	private String department;
	private String professorId;
	private String joiningDate;
	private List<String> courses;

	public Professor() {

	}

	public Professor(String firstName, String lastName, String professorId, String department,
			String joiningDate, List<String> courses) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.professorId = professorId;
		this.joiningDate = joiningDate;
		this.courses = courses;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

	public String getProfessorId() {
		return professorId;
	}
	public void setProfessorId(String professorId) {
		this.professorId = professorId;
	}

	public String getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	@Override
	public String toString() { 
		return "ProfId=" + getProfessorId() + ", firstName=" + getFirstName()
		+ ", department=" + getDepartment() + ", joiningDate=" + getJoiningDate();
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<String> getCourses() {
		return courses;
	}

	public void setCourses(List<String> courses) {
		this.courses = courses;
	}

}

