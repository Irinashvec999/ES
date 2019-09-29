package homework4_mvc.service;

import homework4_mvc.domain.Course;
import homework4_mvc.domain.Student;
import homework4_mvc.domain.Faculty;
import homework4_mvc.repository.StudentRepositoryImpl;

import java.util.*;
import java.util.stream.Collectors;

public class AdminServiceImpl implements AdminService {
    private final StudentRepositoryImpl studentRepository;

    public AdminServiceImpl(StudentRepositoryImpl studentRepository) {
        this.studentRepository = studentRepository;
    }
    public void save(Student student){
        studentRepository.save(student);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void update(Student student) {
        studentRepository.update(student);
    }

    @Override
    public Student deleteById(Long id) {
        return studentRepository.deleteById(id);
    }

    @Override
    public List<Student> filterByFaculty(Faculty faculty) {
        System.out.println("\nStudents of " + faculty + " faculty");
        List<Student> studentMap = studentData().values()
                .stream()
                .filter(student -> student.getUniversityData()
                        .getFaculty() == faculty)
                .collect(Collectors.toList());
        return studentMap;
    }

    @Override
    public List<Student> filterByFacultyAndCourse() {
        List<Student> filteredByFacultyAndCourse = new ArrayList<>();
        for (Faculty f : Faculty.values()) {
            System.out.println("\nStudents of " + f + " faculty, sorted by courses: ");
            filteredByFacultyAndCourse = studentData().values()
                    .stream()
                    .filter(student -> student.getUniversityData().getFaculty() == f)
                    .sorted(Comparator.comparing(student -> student.getUniversityData().getCourse().getNumber()))
                    .collect(Collectors.toList());
        }
        return filteredByFacultyAndCourse;
    }

    @Override
    public List<Student> whoWasBornAfterYear(int year) {
        System.out.println("\nThey were born after " + year + ":");
        List<Student> students = studentData().values()
                .stream()
                .filter(student -> student.getbDate().getYear() > year)
                .collect(Collectors.toList());
        return students;
    }

    @Override
    public List<Student> showGroupList(Faculty f, Course course) {
        System.out.println("\nThere are students of " +
                f + " faculty, " +
                " group № " + course.getGroup() +
                " course № " + course.getNumber() + ":");
        List<Student> studentMap = studentData().values()
                .stream()
                .filter(student -> student.getUniversityData().getFaculty() == f)
                .sorted(Comparator.comparing(student -> student.getUniversityData().getCourse().getGroup()))
                .collect(Collectors.toList());
        return studentMap;
    }

    public Map<Long, Student> studentData() {
        return studentRepository.getIdToStudent();
    }
}
