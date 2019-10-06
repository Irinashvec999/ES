package homework4_mvc.domain;

public class UniversityData {
    private Faculty faculty;
    private Course course;
    private int group;

    public UniversityData(Faculty faculty, Course course) {
        this.faculty = faculty;
        this.course = course;
        this.group = course.getGroup();
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public Course getCourse() {
        return course;
    }
}
