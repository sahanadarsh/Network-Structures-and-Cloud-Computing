package com.csye6225.spring2020.courseservice.datamodel;

import java.util.List;

public class Course {

	private String courseName;
	private List<String> lectures;
	private String board;
	private String roster;
	private List<String> enrolledStudents;
	private String professorName;
	private String studentTA;
	private int credits;

	public Course() {

	}

	public Course(String courseName, List<String> lectures, String board, String roster, List<String> enrolledStudents,
			String professorName, String studentTA, int credits) {
		this.courseName = courseName;
		this.lectures = lectures;
		this.board = board;
		this.roster = roster;
		this.enrolledStudents = enrolledStudents;
		this.professorName = professorName;
		this.studentTA = studentTA;
		this.credits = credits;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public List<String> getLectures() {
		return lectures;
	}

	public void setLectures(List<String> lectures) {
		this.lectures = lectures;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public String getRoster() {
		return roster;
	}

	public void setRoster(String roster) {
		this.roster = roster;
	}

	public List<String> getEnrolledStudents() {
		return enrolledStudents;
	}

	public void setEnrolledStudents(List<String> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}

	public String getProfessorName() {
		return professorName;
	}

	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}

	public String getStudentTA() {
		return studentTA;
	}

	public void setStudentTA(String studentTA) {
		this.studentTA = studentTA;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

}


