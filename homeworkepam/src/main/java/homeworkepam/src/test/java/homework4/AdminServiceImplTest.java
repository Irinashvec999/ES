package homework4;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsArrayContainingInAnyOrder;
import org.hamcrest.core.AllOf;
import org.hamcrest.core.Every;
import org.hamcrest.core.IsCollectionContaining;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AdminServiceImplTest {
    FilteredListImpl filteredList;

    @Before
    public void init() {
        filteredList = new FilteredListImpl();
        filteredList.setList(
                (Student.builder()
                        .withId(1)
                        .withName("Oleg")
                        .withSecondName("Olegovich")
                        .withSurname("Ivanov")
                        .withBDate(14, 11, 2001)
                        .withAddress(new Address(11, "Kudryashova", "Kyiv"))
                        .withUniversityData(new UniversityData(Faculty.MANAGEMENT, new Course(3, 2)))
                        .build())
        );
    }

    @Test
    public void checkReturnedTypeOfFilteredDataByFaculty() {
        Faculty expected = Faculty.MANAGEMENT;
        filteredList.filterByFaculty(expected);
        Faculty actual = filteredList.getList().iterator().next().getUniversityData().getFaculty();
        assertEquals(expected, actual);
    }

    @Test
    public void IsArrayOfFilteredListContainsFacultyValues() {
        Faculty[] expected = Faculty.values();
        Faculty[] actual = new Faculty[filteredList.getList().size()];
        filteredList.filterByFacultyAndCourse();
        for (int i = 0; i < filteredList.getList().size(); i++) {
            actual[i] = filteredList.getList().get(i).getUniversityData().getFaculty();
        }
        IsArrayContainingInAnyOrder.arrayContainingInAnyOrder(actual, expected);

    }

    @Test
    public void isStudentsYearOfBirthBiggerThanIncomeValue() {
        int incomeValue = 2000;
        filteredList.whoWasBornAfterYear(incomeValue);
        CoreMatchers.is(filteredList.getList().iterator().next().getbDate().getYear() > incomeValue);
    }

    @Test
    public void isGroupValueAfterFilterMatchExpectedValue() {
        filteredList.showGroupList(Faculty.MANAGEMENT, new Course(2,2));
        CoreMatchers.is(filteredList.getList().iterator().next().getUniversityData().getCourse().getGroup())
                .matches(2);
    }
}