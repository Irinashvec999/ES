package homework6.userSort;

import java.util.Comparator;

public class User implements Comparable<User> {
    static final Comparator<User> comparingBySurname = (user1, user2) -> user1.getSurname().compareTo(user2.getSurname());
    static final Comparator<User> comparingByName = (user1,user2)->user1.getName().compareTo(user2.getName());
    static final Comparator<User> comparingByAge = (o1,o2)->o1.getAge()-o2.getAge();
    SortUserImpl sortUser = new SortUserImpl();

    private String name;
    private String surname;
    private int age;

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public int compareTo(User other) {
        return sortUser.compare(this, other);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return surname + " " + name + " " + age;
    }

}
