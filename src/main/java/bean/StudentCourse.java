package bean;

public class StudentCourse {

    private int id;
    private String studentNo;
    private String courseNo;
    private int grade;

    public StudentCourse() {
    }

    public StudentCourse(String studentNo, String courseNo, int grade) {
        this.studentNo = studentNo;
        this.courseNo = courseNo;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "SC{" +
                "id=" + id +
                ", studentNo='" + studentNo + '\'' +
                ", courseNo='" + courseNo + '\'' +
                ", grade=" + grade +
                '}';
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
