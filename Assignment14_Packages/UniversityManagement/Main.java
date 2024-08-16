import university.students.Student;
import university.courses.Course;
import university.faculty.Faculty;

public class Main {
    public static void main(String[] args) {
        // Create students
        Student student1 = new Student("John Doe", "S001");
        Student student2 = new Student("Jane Smith", "S002");

        // Create faculty
        Faculty faculty1 = new Faculty("Dr. Emily Johnson", "T001");

        // Create courses
        Course course1 = new Course("Introduction to Programming", "CS101");

        // Assign faculty to course
        faculty1.addCourse(course1);

        // Enroll students in the course
        student1.enrollInCourse(course1);
        student2.enrollInCourse(course1);

        // Print out the details using custom methods
        System.out.println(course1.getCourseDetails());

        System.out.println("\n" + faculty1.getFacultyDetails());

        System.out.println("\n" + student1.getStudentDetails());
        System.out.println(student2.getStudentDetails());
    }
}
