package homework4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FilteredListImpl implements FilteredList{
    private List<Student> list = new ArrayList<>();

    public List<Student> getList() {
        return list;
    }

    public void setList(Student... students) {
        for (Student student : students) {
            list.add(student);
        }
    }

    public List<Student> filterByFaculty(Faculty faculty) {
        List<Student> filteredList = new ArrayList<>();
        for (Student st : list) {
            if (st.getUniversityData().getFaculty() == faculty) {
                filteredList.add(st);
            }
        }
        return filteredList;
    }

    public void filterByFacultyAndCourse() {
        for (Faculty f : Faculty.values()) {
            List<Student> filterByFaculty = filterByFaculty(f);
            filterByFaculty.sort(Comparator.comparing(student -> student.getUniversityData().getCourse().getNumber()));

            System.out.println("\nStudents of " + f + " faculty, sorted by courses: ");
            showFilteredList(filterByFaculty);
        }
    }

    public void showFilteredList(List<Student> filteredList) {
        for (int i = 0; i < filteredList.size(); i++) {
            System.out.println(filteredList.get(i).toString());
        }
    }

    public void whoWasBornAfterYear(int year) {
        List<Student> sorted = new ArrayList<>();
        for (Student st : list) {
            if (st.getbDate().getYear() > year) {
                sorted.add(st);
            }
        }
        System.out.println("\nThey were born after " + year + ":");
        showFilteredList(sorted);
    }

    public void showGroupList(Faculty f, Course course) {
        List<Student> sorted = new ArrayList<>();
        for (Student st : filterByFaculty(f)) {
            if (st.getUniversityData().getCourse().getNumber() == course.getNumber()) {
                if (st.getUniversityData().getCourse().getGroup() == course.getGroup()) {
                    sorted.add(st);
                }
            }
        }
        System.out.println("\nThere are students of " +
                f + " faculty, " +
                 " group № " + course.getGroup() +
                 " course № "  + course.getNumber() + ":");
        showFilteredList(sorted);

    }


}
