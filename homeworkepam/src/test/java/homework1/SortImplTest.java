package homework1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SortImplTest {
    private SortImpl sort;

    @Before
    public void init(){
        sort = new SortImpl();
    }
    @Test
    public void isArraySortedByQuickSort() {
        int [] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int [] actual = new int[]{2,1,3,5,7,4,9,8,6};
        sort.quickSort(actual,0,actual.length-1);
        Assert.assertArrayEquals("Array is sorted! ", expected, actual);
    }

    @Test
    public void isArraySortedBySelectionSort() {
        int [] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int [] actual = new int[]{2,1,3,5,7,4,9,8,6};
        sort.selectionSort(actual);
        Assert.assertArrayEquals("Array is sorted! ", expected, actual);
    }
}