package homework4_mvc.service;

import homework4_mvc.domain.Faculty;
import homework4_mvc.domain.Student;
import homework4_mvc.repository.StudentRepositoryImpl;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AdminServiceImplTest {

    @Mock
    private StudentRepositoryImpl studentRepository;
    @InjectMocks
    private AdminServiceImpl adminService;

    @After
    public void resetMocks() {
        reset(studentRepository);
    }


    @Test
    public void checkMassagingBetweenRepoAndServiceInFindingById() {
        Student expected = studentRepository.findById(1L);
        Student actual = adminService.findById(1L);
        assertEquals(expected, actual);
    }


    @Test
    public void checkMassagingBetweenRepoAndServiceInDeletingById() {
        Student expected = studentRepository.deleteById(1L);
        Student actual = adminService.deleteById(1L);
        assertEquals(expected, actual);
    }

    @Test
    public void whenFilterByFacultyCalledVerified() {
        doNothing().when(adminService).filterByFaculty(isA(Faculty.class));
        adminService.filterByFaculty(isA(Faculty.class));
        verify(adminService, times(1)).filterByFaculty(isA(Faculty.class));

    }

    @Test
    public void filterByFacultyAndCourseCalledVerified() {
        doNothing().when(adminService).filterByFacultyAndCourse();
        adminService.filterByFacultyAndCourse();
        verify(adminService, times(1)).filterByFacultyAndCourse();
    }

    @Test (expected = Exception.class)
    public void whoWasBornAfterYear() {/////
        doThrow(new Exception()).doNothing().when(adminService).whoWasBornAfterYear(isA(Integer.class));
    }

    @Test(expected = Exception.class)
    public void checkForNullArgument() {
        doThrow().when(adminService).showGroupList(isA(Faculty.class), isNull());
        adminService.showGroupList(Faculty.MECHANICAL, null);
    }
}