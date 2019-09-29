package homework4_mvc.service;

import homework4_mvc.domain.Course;
import homework4_mvc.domain.Faculty;
import homework4_mvc.domain.Student;

import java.util.List;

public interface AdminService {
    Student findById(Long id) throws NoSuchFieldException;

    void update(Student student);

    Student deleteById(Long id) throws NoSuchFieldException;

    List<Student> filterByFaculty(Faculty faculty);

    List<Student> filterByFacultyAndCourse();

    List<Student> whoWasBornAfterYear(int year);

    List<Student> showGroupList(Faculty f, Course course);
}
