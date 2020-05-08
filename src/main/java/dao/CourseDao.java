package dao;

import bean.Course;
import dao.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDao {

    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public boolean create(Course course) {
        String sql = "INSERT INTO course(id, name, pre_id, credit) VALUES(?, ?, ?, ?)";
        try {
            con = JDBCUtils.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, course.getId());
            pstmt.setString(2, course.getName());
            pstmt.setInt(3, course.getPreId());
            pstmt.setInt(4, course.getCredit());
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
    public List<Course> retrieve() {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT * FROM course";
        try {
            con = JDBCUtils.getCon();
            pstmt = con.prepareStatement(sql);
//pstmt.executeUpdate();//用于增删改
            rs = pstmt.executeQuery();//用于查询
            while (rs.next()) {
                //上行写法亦可为：
                Course course = new Course(rs.getInt("id"), rs.getString("name"), rs.getInt("pre_id"), rs.getInt("credit"));
                list.add(course);
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
    public Course retrieveById(int id) {
        Course course = null;
        String sql = "SELECT * FROM course WHERE id = ?";
        try {
            con = JDBCUtils.getCon();
            pstmt = con.prepareStatement(sql);
//pstmt.executeUpdate();//用于增删改
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();//用于查询
            while (rs.next()) {
//Stustu=new Stu(rs.getString("stu_no"),rs.getString("stu_name"),rs.getString("phone"));
                //上行写法亦可为：
                course = new Course(rs.getInt("id"), rs.getString("name"), rs.getInt("pre_id"), rs.getInt("credit"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, pstmt, rs);
        }
        return course;
    }

    //修改学生信息
    public boolean update(Course course) {
        String sql = "UPDATE course SET name = ?, pre_id = ?, credit = ? WHERE id=?";
        try {
            con = JDBCUtils.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(4, course.getId());
            pstmt.setString(1, course.getName());
            pstmt.setInt(2, course.getPreId());
            pstmt.setInt(3, course.getCredit());
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
    public boolean deleteById(int id) {
        String sql = "DELETE FROM course WHERE id=?";
        try {
            con = JDBCUtils.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
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
