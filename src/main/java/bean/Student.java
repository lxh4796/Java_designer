package bean;

public class Student {

    private int id;
    private String no;
    private String name;
    private int sex;
    private int age;
    private String dept;

    public Student() {
    }

    public Student(String no, String name, int sex, int age, String dept) {
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", dept='" + dept + '\'' +
                '}';
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
