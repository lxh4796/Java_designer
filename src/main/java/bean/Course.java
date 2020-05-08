package bean;

public class Course {

    private int id;
    private String no;
    private String name;
    private String pNo;
    private int credit;

    public Course() {
    }

    public Course(String no, String name, String pNo, int credit) {
        this.no = no;
        this.name = name;
        this.pNo = pNo;
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", pNo='" + pNo + '\'' +
                ", credit=" + credit +
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

    public String getpNo() {
        return pNo;
    }

    public void setpNo(String pNo) {
        this.pNo = pNo;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}
