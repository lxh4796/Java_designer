package view;

import bean.Course;
import bean.Student;
import dao.CourseDao;
import dao.StudentDao;

import java.util.List;
import java.util.Scanner;

public class CourseManage {
    public void menu() {
        //1.打印菜单
        //2.输入菜单
        //3.switch菜单选择
        int choose;
        do {
            System.out.println("******************************");
            System.out.println("=======欢迎进入课程信息管理系统=======");
            System.out.println("1.新增课程");
            System.out.println("2.修改课程");
            System.out.println("3.删除课程");
            System.out.println("4.查询课程");
            System.out.println("5.退出该系统");
            System.out.println("请选择（1-5）：");

            Scanner scanner = new Scanner(System.in);
            choose = scanner.nextInt();
            System.out.println("******************************");
            switch (choose) {
                case 1:
                    myCreate(); //菜单选择1，是新增课程
                    break;
                case 2:
                    myUpdate();  //菜单选择2，是修改课程
                    break;
                case 3:
                    myDelete();  //菜单选择3，是删除课程
                    break;
                case 4:
                    myRetrieve();  //菜单选择4，是查询课程
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
            String name;
            int id, preId, credit;
            System.out.println("====新增课程====");
            System.out.println("课号：");
            id = s.nextInt();
            System.out.println("名称：");
            name = s.next();
            System.out.println("先修课号：");
            preId = s.nextInt();
            System.out.println("学分：");
            credit = s.nextInt();

            Course course = new Course(id, name, preId, credit);
            CourseDao dao = new CourseDao();
            boolean ok = dao.create(course);
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
        System.out.println("====删除课程====");
        System.out.println("请输入要删除的课程课号：");
        id = s.nextInt();
        System.out.println("该课程的信息如下：");

        CourseDao courseDao = new CourseDao();
        System.out.println("课程课号：" + courseDao.retrieveById(id).getId());
        System.out.println("课程名称：" + courseDao.retrieveById(id).getName());
        System.out.println("课程先修课号：" + courseDao.retrieveById(id).getPreId());
        System.out.println("课程学分：" + courseDao.retrieveById(id).getCredit());

        System.out.println("是否真的删除(y/n)：");
        Scanner scanner3 = new Scanner(System.in);
        String x = scanner3.next();
        if (x.equals("y")) {
            Course course = new Course(id, null, 0, 0);
            CourseDao dao = new CourseDao();
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
        System.out.println("====修改课程====");
        System.out.println("请输入要修改的课程课号：");
        id = s.nextInt();
        System.out.println("该课程的信息如下：");
        CourseDao courseDao = new CourseDao();
        System.out.println("课程课号：" + courseDao.retrieveById(id).getId());
        System.out.println("课程名称：" + courseDao.retrieveById(id).getName());
        System.out.println("课程先修课号：" + courseDao.retrieveById(id).getPreId());
        System.out.println("课程学分：" + courseDao.retrieveById(id).getCredit());

        System.out.println("请输入新的课程信息：");
        Scanner courseUp = new Scanner(System.in);
        String name;
        int preId, credit;
        System.out.println("课程名称：");
        name = courseUp.next();
        System.out.println("课程先修课号：");
        preId = courseUp.nextInt();
        System.out.println("课程学分：");
        credit = courseUp.nextInt();
        Course course = new Course(id, name, preId, credit);
        CourseDao dao = new CourseDao();
        boolean ok = dao.update(course);
        if (ok) {
            System.out.println("保存成功！");
        } else {
            System.out.println("保存失败！");
        }
    }

    //查询学生信息
    public void myRetrieve() {
        System.out.println("************************");
        System.out.println("====查询课程====");
        System.out.println("该课程的信息如下：");
        System.out.println("课号\t名称\t先修课号\t学分");
        CourseDao courseDao = new CourseDao();
        List<Course> list = courseDao.retrieve();
        for (Course courseList : list) { //循环打印出查询结果
            System.out.println(courseList.getId() + "\t" + courseList.getName() + "\t" + courseList.getPreId() + "\t" + courseList.getCredit());
        }
        System.out.println("************************");
    }
}
