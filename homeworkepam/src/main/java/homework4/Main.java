package homework4;

public class Main {
    public static void main(String[] args) {
        FilteredListImpl filteredListImpl = new FilteredListImpl();
        filteredListImpl.setList(
                (Student.builder()
                        .withId(1)
                        .withName("Oleg")
                        .withSecondName("Olegovich")
                        .withSurname("Ivanov")
                        .withBDate(14, 11, 2001)
                        .withAddress(new Address(11, "Kudryashova", "Kyiv"))
                        .withUniversityData(new UniversityData(Faculty.MANAGEMENT, new Course(3,2)))
                        .build()),
                (Student.builder()
                        .withId(2)
                        .withName("Anna")
                        .withSecondName("Ivanovna")
                        .withSurname("Smirnova")
                        .withBDate(29, 11, 1999)
                        .withAddress(new Address(5, "Gnata", "Kyiv"))
                        .withUniversityData(new UniversityData(Faculty.MECHANICAL, new Course(5,2)))
                        .build()),
                (Student.builder()
                        .withId(3)
                        .withName("Yuryi")
                        .withSecondName("Dmytrievich")
                        .withSurname("Dashko")
                        .withBDate(1, 5, 1999)
                        .withAddress(new Address(2, "Stolychnaya", "Kyiv"))
                        .withUniversityData(new UniversityData(Faculty.MATHEMATICS, new Course(5,1)))
                        .build()),
                (Student.builder()
                        .withId(4)
                        .withName("Dmytriy")
                        .withSecondName("Alekseevich")
                        .withSurname("Yarosh")
                        .withBDate(12, 3, 2002)
                        .withAddress(new Address(15, "Odesskaya", "Kyiv"))
                        .withUniversityData(new UniversityData(Faculty.MECHANICAL, new Course(2,2)))
                        .build())
        );

        filteredListImpl.showFilteredList(filteredListImpl.filterByFaculty(Faculty.MANAGEMENT));
        filteredListImpl.filterByFacultyAndCourse();
        filteredListImpl.whoWasBornAfterYear(2000);
        filteredListImpl.showGroupList(Faculty.MECHANICAL,new Course(2,2));
    }

}
