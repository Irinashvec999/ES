package homework4_mvc.domain;

public class Course {
    private int number;
    private int group;

    public Course(int number, int group) {
        this.number = number;
        this.group = group;
    }

    public int getNumber() {
        return number;
    }

    public int getGroup() {
        return group;
    }

}
