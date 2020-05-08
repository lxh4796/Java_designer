package bean;

public class Course {

    private int id;
    private String name;
    private int preId;
    private int credit;

    public Course() {
    }

    public Course(int id, String name, int preId, int credit) {
        this.id = id;
        this.name = name;
        this.preId = preId;
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", preId=" + preId +
                ", credit=" + credit +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPreId() {
        return preId;
    }

    public void setPreId(int preId) {
        this.preId = preId;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}
