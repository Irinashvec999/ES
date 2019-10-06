package homework4_mvc.repository;

import homework4_mvc.domain.Student;

public interface StudentRepository {
    //C
    Student save(Student student);
    //R
    Student findById(Long id);
    //U
    void update(Student student);
    //D
    Student deleteById(Long id);

}
