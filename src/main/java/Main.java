import view.CourseManage;
import view.StudentCourseManage;
import view.StudentManage;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StudentManage s = new StudentManage();
        CourseManage c = new CourseManage();
        StudentCourseManage sc = new StudentCourseManage();
        int choose;
        do {
            System.out.println("******************************");
            System.out.println("=======欢迎进入信息管理系统=======");
            System.out.println("1.学生信息管理系统");
            System.out.println("2.课程信息管理系统");
            System.out.println("3.学生选课信息管理系统");
            System.out.println("4.退出该系统");
            System.out.println("请选择（1-4）：");
            Scanner scanner = new Scanner(System.in);
            choose = scanner.nextInt();
            System.out.println("******************************");
            switch (choose) {
                case 1:
                    s.menu(); //菜单选择1，是新增选课
                    break;
                case 2:
                    c.menu();  //菜单选择2，是修改选课
                    break;
                case 3:
                    sc.menu();  //菜单选择3，是删除选课
                    break;
                case 4:     //菜单选择5，是退出该系统
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
        } while (choose != 4);
    }

}
