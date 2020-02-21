package com.csye6225.spring2020.courseservice.resources;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.csye6225.spring2020.courseservice.datamodel.Course;
import com.csye6225.spring2020.courseservice.datamodel.Lecture;
import com.csye6225.spring2020.courseservice.datamodel.Professor;
import com.csye6225.spring2020.courseservice.datamodel.Student;
import com.csye6225.spring2020.courseservice.service.CourseService;

@Path("courses")
public class CourseResource {

	CourseService courseService = new CourseService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> getAllCourses() {
		return courseService.getAllCourses();
	}	

	@GET
	@Path("/{courseName}")
	@Produces(MediaType.APPLICATION_JSON)
	public static Course getCourse(@PathParam("courseName") String courseName) {
		System.out.println("Course Resource: Looking for: " + courseName);
		if (courseName == null) {
			return null;
		}
		return CourseService.getCourse(courseName);
	}

	@GET
	@Path("{courseName}/enrolledStudents")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getEnrolledStudentsByProgram(
			@PathParam("courseName") String courseName) {		
		if (courseName == null) {
			return null;
		}
		return courseService.getEnrolledStudentsByCourse(courseName);
	}

	@GET
	@Path("{courseName}/professor")
	@Produces(MediaType.APPLICATION_JSON)
	public Professor getProfessorsByProgram(
			@PathParam("courseName") String courseName) {		
		if (courseName == null) {
			return null;
		}
		return courseService.getProfessorByCourse(courseName);
	}

	@GET
	@Path("{courseName}/studentTA")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudentTAByCourse(
			@PathParam("courseName") String courseName) {		
		if (courseName == null) {
			return null;
		}
		return courseService.getStudentTAByCourse(courseName);
	}

	@GET
	@Path("{courseName}/lectures")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Lecture> getLecturesByCourse(@PathParam("courseName") String courseName) {
		System.out.println("Course Resource: Looking for: " + courseName);
		if (courseName == null) {
			return null;
		}
		return courseService.getLecturesByCourse(courseName);
	}

	@GET
	@Path("{courseName}/credits")
	@Produces(MediaType.APPLICATION_JSON)
	public int getCreditsByCourse(@PathParam("courseName") String courseName) {
		System.out.println("Course Resource: Looking for: " + courseName);
		if (courseName == null) {
			return 0;
		}
		return courseService.getCreditsByCourse(courseName);
	}

	@DELETE
	@Path("/{courseName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Course deleteCourse(@PathParam("courseName") String courseName) {
		return courseService.deleteCourse(courseName);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Course addCourse(Course course) {
		return courseService.addCourse(course);
	}

	@PUT
	@Path("/{courseName}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Course updateCourse(@PathParam("courseName") String courseName, 
			Course course) {
		if(courseName == null) {
			return null;
		}
		return courseService.updateCourseInformattion(courseName, course);
	}

}


