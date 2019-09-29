package homework2;

class Main {
    public static void main(String[] args) {
        User a = new User("Ann", "Ann", 22, true);
        User s = new User("Ann", "Ann", 22, true);
        System.out.println(a.equals(s) + " " + a.hashCode() + " " + s.hashCode());
    }
}
