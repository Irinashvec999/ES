package homework1;

import java.util.Arrays;

class Main{
    public static void main(String[] args) {//
        int[] arr = new int[]{2,1,3,5,7,4,9,8,6};
        SortImpl sort = new SortImpl();
        sort.quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

}
