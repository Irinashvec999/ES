package homework4;

import java.util.List;

public interface FilteredList {
    List<Student> filterByFaculty(Faculty faculty);
    void filterByFacultyAndCourse();
    void whoWasBornAfterYear(int year);
    void showGroupList(Faculty f, Course course);
}
