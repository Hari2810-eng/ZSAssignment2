package university.faculty;

import university.courses.Course;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private String name;
    private String facultyId;
    private List<Course> teachingCourses;

    public Faculty(String name, String facultyId) {
        this.name = name;
        this.facultyId = facultyId;
        this.teachingCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public List<Course> getTeachingCourses() {
        return teachingCourses;
    }

    public void addCourse(Course course) {
        this.teachingCourses.add(course);
        course.setFaculty(this); // Associate this faculty with the course
    }

    public String getFacultyDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Faculty Details:\n");
        details.append("Name: ").append(name).append("\n");
        details.append("ID: ").append(facultyId).append("\n");
        details.append("Teaching Courses:\n");
        for (Course course : teachingCourses) {
            details.append("- ").append(course.getCourseName()).append(" (").append(course.getCourseCode()).append(")\n");
        }
        return details.toString();
    }
}
