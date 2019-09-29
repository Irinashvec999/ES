package homework1;

public class SortImpl {

    static void quickSort(int[] array, int startIndex, int endIndex) {
        int pivot = array [endIndex-1];
        int currentStartIndex = startIndex;
        int currentEndIndex = endIndex;

        while (currentStartIndex < currentEndIndex) {
            while (array[currentStartIndex] < pivot) {
                currentStartIndex++;
            }
            while ((array[currentEndIndex] > pivot) && (currentEndIndex > currentStartIndex)) {
                currentEndIndex--;
            }
            if (currentStartIndex < currentEndIndex) {
                swap(array, currentStartIndex, currentEndIndex);
                if (currentEndIndex - currentStartIndex > 1) {
                    currentStartIndex++;
                    currentEndIndex--;
                } else {
                    break;
                }
            }
        }
        if ((currentStartIndex > startIndex) && (currentStartIndex - startIndex > 1))
            quickSort(array,startIndex,currentStartIndex);
        if ((endIndex > currentEndIndex) && (endIndex - currentEndIndex > 1))
            quickSort(array,currentEndIndex,endIndex);
    }

    public static void selectionSort(int[] arr) {
        int minIndex;
        for (int i = 0; i < arr.length; i++) {
            minIndex = i;
            for (int j = minIndex + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, minIndex, i);
        }
    }

    public static void swap(int[] a, int ind1, int ind2) {
        int old = a[ind1];
        a[ind1] = a[ind2];
        a[ind2] = old;
    }
}
