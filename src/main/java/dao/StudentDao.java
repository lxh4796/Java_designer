package dao;

import bean.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public boolean create(Student stu) {
        String sql = "INSERT INTO student(no, name, sex, age, dept) VALUES(?, ?, ?, ?, ?)";
        try {
            con = JDBCUtils.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, stu.getNo());
            pstmt.setString(2, stu.getName());
            pstmt.setInt(3, stu.getSex());
            pstmt.setInt(4, stu.getAge());
            pstmt.setString(5, stu.getDept());
            pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            JDBCUtils.close(con, pstmt, rs);
        }
        return true;
    }

    //查看学生列表（1所有）
    public List<Student> retrieve() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM student";
        try {
            con = JDBCUtils.getCon();
            pstmt = con.prepareStatement(sql);
//pstmt.executeUpdate();//用于增删改
            rs = pstmt.executeQuery();//用于查询
            while (rs.next()) {
                //上行写法亦可为：
                Student stu = new Student(rs.getString("no"), rs.getString("name"), rs.getInt("sex"), rs.getInt("age"), rs.getString("dept"));
                list.add(stu);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, pstmt, rs);
        }
        return list;
    }

    //查看学生列表（2根据学生学号显示学生信息）
    public Student retrieveById(String no) {
        Student stu = null;
        String sql = "SELECT * FROM student WHERE no = ?";
        try {
            con = JDBCUtils.getCon();
            pstmt = con.prepareStatement(sql);
//pstmt.executeUpdate();//用于增删改
            pstmt.setString(1, no);
            rs = pstmt.executeQuery();//用于查询
            while (rs.next()) {
//Stustu=new Stu(rs.getString("stu_no"),rs.getString("stu_name"),rs.getString("phone"));
                //上行写法亦可为：
                stu = new Student(rs.getString("no"), rs.getString("name"), rs.getInt("sex"), rs.getInt("age"), rs.getString("dept"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, pstmt, rs);
        }
        return stu;
    }

    //修改学生信息
    public boolean update(Student stu) {
        String sql = "UPDATE student SET name = ?, sex = ?, age = ?, dept = ? WHERE no=?";
        try {
            con = JDBCUtils.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(5, stu.getNo());
            pstmt.setString(1, stu.getName());
            pstmt.setInt(2, stu.getSex());
            pstmt.setInt(3, stu.getAge());
            pstmt.setString(4, stu.getDept());
            pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            JDBCUtils.close(con, pstmt, rs);
        }
        return true;
    }

    //删除学生信息
    public boolean deleteById(String id) {
        String sql = "DELETE FROM student WHERE no=?";
        try {
            con = JDBCUtils.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            JDBCUtils.close(con, pstmt, rs);
        }
        return true;
    }
}
