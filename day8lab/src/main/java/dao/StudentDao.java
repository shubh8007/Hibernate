package dao;

import java.util.List;

import pojos.Course;
import pojos.Student;

public interface StudentDao {
String addStudent(Student s1);
String loginStudent(String email,String password);
List<Student> getnameCourse(Course type);
String updateCourse(Integer studentId,Course course);

public List<Student> getStudentBy(LocalDate date);
}
