package homework4_mvc.service;

import homework4_mvc.domain.Student;
import homework4_mvc.repository.StudentRepository;


public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;

    }

    @Override
    public Student register(Student student) {
        if (student == null){
            throw new IllegalArgumentException("Something wrong");
        }
        return studentRepository.save(student);
    }
}
