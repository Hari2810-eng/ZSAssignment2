package university.courses;

import university.students.Student;
import university.faculty.Faculty;  

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseName;
    private String courseCode;
    private Faculty faculty; 
    private List<Student> enrolledStudents;

    public Course(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public Faculty getFaculty() {
        return faculty; 
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty; 
    }

    public void addStudent(Student student) {
        this.enrolledStudents.add(student);
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public String getCourseDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Course Details:\n");
        details.append("Name: ").append(courseName).append("\n");
        details.append("Code: ").append(courseCode).append("\n");
        details.append("Faculty: ").append(faculty != null ? faculty.getName() : "None").append("\n");
        details.append("Enrolled Students:\n");
        for (Student student : enrolledStudents) {
            details.append("- ").append(student.getName()).append(" (").append(student.getStudentId()).append(")\n");
        }
        return details.toString();
    }
}
