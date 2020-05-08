package bean;

public class StudentCourse {

    private int id;
    private int studentId;
    private int courseId;
    private int grade;

    public StudentCourse() {
    }

    public StudentCourse(int id, int studentId, int courseId, int grade) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "StudentCourse{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                ", grade=" + grade +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
