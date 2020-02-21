package com.csye6225.spring2020.courseservice.datamodel;

import java.util.List;

public class Student {

	private String firstName;
	private String lastName;
	private String studentId;
	private String image;
	private List<String> enrolledCourses;
	private String program;

	public Student() {

	}

	public Student(String studentId, String firstName, String lastName, String image, String programName, List<String> enrolledCourses) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentId = studentId;
		this.image = image;
		this.enrolledCourses = enrolledCourses;
		this.program = programName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<String> getEnrolledCourses() {
		return enrolledCourses;
	}

	public void setEnrolledCourses(List<String> enrolledCourses) {
		this.enrolledCourses = enrolledCourses;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

}
