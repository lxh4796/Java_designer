package view;

import bean.Course;
import bean.StudentCourse;
import dao.CourseDao;
import dao.StudentCourseDao;

import java.util.List;
import java.util.Scanner;

public class StudentCourseManage {
    public void menu() {
        //1.打印菜单
        //2.输入菜单
        //3.switch菜单选择
        int choose;
        do {
            System.out.println("******************************");
            System.out.println("=======欢迎进入选课信息管理系统=======");
            System.out.println("1.新增选课");
            System.out.println("2.修改选课");
            System.out.println("3.删除选课");
            System.out.println("4.查询选课");
            System.out.println("5.退出该系统");
            System.out.println("请选择（1-5）：");

            Scanner scanner = new Scanner(System.in);
            choose = scanner.nextInt();
            System.out.println("******************************");
            switch (choose) {
                case 1:
                    myCreate(); //菜单选择1，是新增选课
                    break;
                case 2:
                    myUpdate();  //菜单选择2，是修改选课
                    break;
                case 3:
                    myDelete();  //菜单选择3，是删除选课
                    break;
                case 4:
                    myRetrieve();  //菜单选择4，是查询选课
                    break;
                case 5:     //菜单选择5，是退出该系统
                    System.out.println("您选择了退出系统，确定要退出吗？(y/n)");
                    Scanner scan = new Scanner(System.in);
                    String scanExit = scan.next();
                    if (scanExit.equals("y")) {
                        System.exit(-1);
                        System.out.println("您已成功退出系统，欢迎您再次使用！");
                    }
                    break;
                default:
                    break;
            }
        } while (choose != 5);
    }

    //新增学生信息
    public void myCreate() {

        String continute;
        do {
            Scanner s = new Scanner(System.in);
            int id, studentId, courseId, grade;
            System.out.println("====新增选课====");
            System.out.println("序号：");
            id = s.nextInt();
            System.out.println("学生学号：");
            studentId = s.nextInt();
            System.out.println("课程课号：");
            courseId = s.nextInt();
            System.out.println("成绩：");
            grade = s.nextInt();

            StudentCourse studentCourse = new StudentCourse(id, studentId, courseId, grade);
            StudentCourseDao dao = new StudentCourseDao();
            boolean ok = dao.create(studentCourse);
            if (ok) {
                System.out.println("保存成功！");
            } else {
                System.out.println("保存失败！");
            }
            System.out.println("是否继续添加(y/n)：");
            Scanner scanner2 = new Scanner(System.in);
            continute = scanner2.next();
        } while (continute.equals("y"));
    }

    //删除学生信息
    public void myDelete() {
        Scanner s = new Scanner(System.in);
        int id;
        System.out.println("====删除选课====");
        System.out.println("请输入要删除的选课序号：");
        id = s.nextInt();
        System.out.println("该选课的信息如下：");

        StudentCourseDao studentCourseDao = new StudentCourseDao();
        System.out.println("选课课号：" + studentCourseDao.retrieveById(id).getId());
        System.out.println("学生学号：" + studentCourseDao.retrieveById(id).getStudentId());
        System.out.println("课程课号：" + studentCourseDao.retrieveById(id).getCourseId());
        System.out.println("成绩：" + studentCourseDao.retrieveById(id).getGrade());

        System.out.println("是否真的删除(y/n)：");
        Scanner scanner3 = new Scanner(System.in);
        String x = scanner3.next();
        if (x.equals("y")) {
            StudentCourse studentCourse = new StudentCourse(id, 0, 0, 0);
            StudentCourseDao dao = new StudentCourseDao();
            boolean ok = dao.deleteById(id);
            if (ok) {
                System.out.println("删除成功！");
            } else {
                System.out.println("删除失败！");
            }
        }
    }

    //修改学生信息
    public void myUpdate() {
        Scanner s = new Scanner(System.in);
        int id;
        System.out.println("====修改选课====");
        System.out.println("请输入要修改的选课序号：");
        id = s.nextInt();
        System.out.println("该选课的信息如下：");
        StudentCourseDao studentCourseDao = new StudentCourseDao();
        System.out.println("选课序号：" + studentCourseDao.retrieveById(id).getId());
        System.out.println("学生学号：" + studentCourseDao.retrieveById(id).getStudentId());
        System.out.println("选课课号：" + studentCourseDao.retrieveById(id).getCourseId());
        System.out.println("成绩：" + studentCourseDao.retrieveById(id).getGrade());

        System.out.println("请输入新的选课信息：");
        Scanner studentCourseUp = new Scanner(System.in);
        int studentId, courseId, grade;
        System.out.println("学生学号：");
        studentId = studentCourseUp.nextInt();
        System.out.println("课程课号：");
        courseId = studentCourseUp.nextInt();
        System.out.println("成绩：");
        grade = studentCourseUp.nextInt();
        StudentCourse studentCourse = new StudentCourse(id, studentId, courseId, grade);
        StudentCourseDao dao = new StudentCourseDao();
        boolean ok = dao.update(studentCourse);
        if (ok) {
            System.out.println("保存成功！");
        } else {
            System.out.println("保存失败！");
        }
    }

    //查询学生信息
    public void myRetrieve() {
        System.out.println("************************");
        System.out.println("====查询选课====");
        System.out.println("该选课的信息如下：");
        System.out.println("序号\t学生学号\t课程课号\t成绩");
        StudentCourseDao studentCourseDao = new StudentCourseDao();
        List<StudentCourse> list = studentCourseDao.retrieve();
        for (StudentCourse studentCourseList : list) { //循环打印出查询结果
            System.out.println(studentCourseList.getId() + "\t" + studentCourseList.getStudentId() + "\t" + studentCourseList.getCourseId() + "\t" + studentCourseList.getGrade());
        }
        System.out.println("************************");
    }
}
