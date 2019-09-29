

class A {
    public static void main(String[] args) {

    }

    void reverse(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            int temp = a[a.length - 1 - i];
            a[a.length - 1 - i] = a[i];
            a[i] = temp;
        }
    }
}
