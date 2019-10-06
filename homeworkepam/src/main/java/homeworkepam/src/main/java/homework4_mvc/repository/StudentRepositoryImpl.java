package homework4_mvc.repository;

import homework4_mvc.domain.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentRepositoryImpl implements StudentRepository {
    private Map<Long, Student> idToStudent = new HashMap<>();
    private static Long counter = 0L;

    @Override
    public Student save(Student student) {
        return idToStudent.put(++counter,student);
    }

    @Override
    public Student findById(Long id) {
        return idToStudent.get(id);
    }

    @Override
    public void update(Student student) {
        ///
    }

    @Override
    public Student deleteById(Long id) {
        return idToStudent.remove(id);
    }

    public Map<Long, Student> getIdToStudent() {
        return idToStudent;
    }
}
