package dao;

import bean.Course;
import bean.StudentCourse;
import dao.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentCourseDao {

    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public boolean create(StudentCourse studentCourse) {
        String sql = "INSERT INTO student_course(id, student_id, course_id, grade) VALUES(?, ?, ?, ?)";
        try {
            con = JDBCUtils.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, studentCourse.getId());
            pstmt.setInt(2, studentCourse.getStudentId());
            pstmt.setInt(3, studentCourse.getCourseId());
            pstmt.setInt(4, studentCourse.getGrade());
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
    public List<StudentCourse> retrieve() {
        List<StudentCourse> list = new ArrayList<>();
        String sql = "SELECT * FROM student_course";
        try {
            con = JDBCUtils.getCon();
            pstmt = con.prepareStatement(sql);
//pstmt.executeUpdate();//用于增删改
            rs = pstmt.executeQuery();//用于查询
            while (rs.next()) {
                //上行写法亦可为：
                StudentCourse studentCourse = new StudentCourse(rs.getInt("id"), rs.getInt("student_id"), rs.getInt("course_id"), rs.getInt("grade"));
                list.add(studentCourse);
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
    public StudentCourse retrieveById(int id) {
        StudentCourse studentCourse = null;
        String sql = "SELECT * FROM student_course WHERE id = ?";
        try {
            con = JDBCUtils.getCon();
            pstmt = con.prepareStatement(sql);
//pstmt.executeUpdate();//用于增删改
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();//用于查询
            while (rs.next()) {
//Stustu=new Stu(rs.getString("stu_no"),rs.getString("stu_name"),rs.getString("phone"));
                //上行写法亦可为：
                studentCourse = new StudentCourse(rs.getInt("id"), rs.getInt("student_id"), rs.getInt("course_id"), rs.getInt("grade"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, pstmt, rs);
        }
        return studentCourse;
    }

    //修改学生信息
    public boolean update(StudentCourse studentCourse) {
        String sql = "UPDATE student_course SET student_id = ?, course_id = ?, grade = ? WHERE id=?";
        try {
            con = JDBCUtils.getCon();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(4, studentCourse.getId());
            pstmt.setInt(1, studentCourse.getStudentId());
            pstmt.setInt(2, studentCourse.getCourseId());
            pstmt.setInt(3, studentCourse.getGrade());
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
        String sql = "DELETE FROM student_course WHERE id=?";
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
