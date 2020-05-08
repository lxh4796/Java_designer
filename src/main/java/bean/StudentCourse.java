package bean;

public class StudentCourse {

    private int id;
    private int studentNo;
    private int courseNo;
    private int grade;

    public StudentCourse() {
    }

    public StudentCourse(int id, int studentNo, int courseNo, int grade) {
        this.id = id;
        this.studentNo = studentNo;
        this.courseNo = courseNo;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "StudentCourse{" +
                "id=" + id +
                ", studentNo=" + studentNo +
                ", courseNo=" + courseNo +
                ", grade=" + grade +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }

    public int getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(int courseNo) {
        this.courseNo = courseNo;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
