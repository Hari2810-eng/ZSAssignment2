package university.students;

import university.courses.Course;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private String name;
	private String studentId;
	private List<Course> enrolledCourses;

	public Student(String name, String studentId) {
		this.name = name;
		this.studentId = studentId;
		this.enrolledCourses = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public String getStudentId() {
		return studentId;
	}

	public void enrollInCourse(Course course){
		this.enrolledCourses.add(course);
		course.addStudent(this);
	}
	public List<Course> getEnrolledCourses() {
		return enrolledCourses;
	}

	public String getStudentDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Student Details:\n");
        details.append("Name: ").append(name).append("\n");
        details.append("ID: ").append(studentId).append("\n");
        details.append("Enrolled Courses:\n");
        for (Course course : enrolledCourses) {
            details.append("- ").append(course.getCourseName()).append(" (").append(course.getCourseCode()).append(")\n");
        }
        return details.toString();
    }

}
