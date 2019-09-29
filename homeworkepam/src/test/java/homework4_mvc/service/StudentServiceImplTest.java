package homework4_mvc.service;

import homework4_mvc.domain.*;
import homework4_mvc.repository.StudentRepository;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private StudentServiceImpl studentService;

    @After
    public void reset() {
        Mockito.reset(studentRepository);
    }

    @Test
    public void isRegisterMethodReturnNotNull() {
        Student student = Student.builder()
                .withId(4)
                .withName("A")
                .withSecondName("B")
                .withSurname("C")
                .withBDate(1, 1, 2000)
                .withAddress(new Address(1, "D", "E"))
                .withUniversityData(new UniversityData(Faculty.MECHANICAL, new Course(2, 2)))
                .build();
        when(studentRepository.save(any(Student.class))).thenReturn(student);
        Student student1 = studentService.register(student);

        assertNotNull(student1);
    }

    @Test
    public void register1() {
    }
}