import bean.Student;
import dao.StudentDao;

import java.util.List;
import java.util.Scanner;

public class StuManage {
    public void menu() {
        //1.打印菜单
        //2.输入菜单
        //3.switch菜单选择
        int choose;
        do {
            System.out.println("******************************");
            System.out.println("=======欢迎进入学生信息管理系统=======");
            System.out.println("1.新增学生");
            System.out.println("2.修改学生");
            System.out.println("3.删除学生");
            System.out.println("4.查询学生");
            System.out.println("5.退出该系统");
            System.out.println("请选择（1-5）：");

            Scanner scanner = new Scanner(System.in);
            choose = scanner.nextInt();
            System.out.println("******************************");
            switch (choose) {
                case 1:
                    myCreate(); //菜单选择1，是新增学生
                    break;
                case 2:
                    myUpdate();  //菜单选择2，是修改学生
                    break;
                case 3:
                    myDelete();  //菜单选择3，是删除学生
                    break;
                case 4:
                    myRetrieve();  //菜单选择4，是查询学生
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
            String name, dept;
            int id, sex, age;
            System.out.println("====新增学生====");
            System.out.println("学号：");
            id = s.nextInt();
            System.out.println("姓名：");
            name = s.next();
            System.out.println("性别：");
            sex = s.nextInt();
            System.out.println("年龄：");
            age = s.nextInt();
            System.out.println("系别：");
            dept = s.next();

            Student stu = new Student(id, name, sex, age, dept);
            StudentDao dao = new StudentDao();
            boolean ok = dao.create(stu);
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
        System.out.println("====删除学生====");
        System.out.println("请输入要删除的学生学号：");
        id = s.nextInt();
        System.out.println("该学生的信息如下：");

        StudentDao stuDao = new StudentDao();
        System.out.println("学生学号：" + stuDao.retrieveById(id).getId());
        System.out.println("学生姓名：" + stuDao.retrieveById(id).getName());
        System.out.println("学生性别：" + stuDao.retrieveById(id).getSex());
        System.out.println("学生年龄：" + stuDao.retrieveById(id).getAge());
        System.out.println("学生系别：" + stuDao.retrieveById(id).getDept());

        System.out.println("是否真的删除(y/n)：");
        Scanner scanner3 = new Scanner(System.in);
        String x = scanner3.next();
        if (x.equals("y")) {
            Student stu = new Student(id, null, 0, 0, null);
            StudentDao dao = new StudentDao();
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
        System.out.println("====修改学生====");
        System.out.println("请输入要修改的学生学号：");
        id = s.nextInt();
        System.out.println("该学生的信息如下：");
        StudentDao stuDao = new StudentDao();
        System.out.println("学生学号：" + stuDao.retrieveById(id).getId());
        System.out.println("学生姓名：" + stuDao.retrieveById(id).getName());
        System.out.println("学生性别：" + stuDao.retrieveById(id).getSex());
        System.out.println("学生年龄：" + stuDao.retrieveById(id).getAge());
        System.out.println("学生系别：" + stuDao.retrieveById(id).getDept());

        System.out.println("请输入新的学生信息：");
        Scanner stuUp = new Scanner(System.in);
        String name, dept;
        int sex, age;
        System.out.println("学生姓名：");
        name = stuUp.next();
        System.out.println("学生性别：");
        sex = stuUp.nextInt();
        System.out.println("学生年龄：");
        age = stuUp.nextInt();
        System.out.println("学生系别：");
        dept = stuUp.next();
        Student stu = new Student(id, name, sex, age, dept);
        StudentDao dao = new StudentDao();
        boolean ok = dao.update(stu);
        if (ok) {
            System.out.println("保存成功！");
        } else {
            System.out.println("保存失败！");
        }
    }

    //查询学生信息
    public void myRetrieve() {
        System.out.println("************************");
        System.out.println("====查询学生====");
        System.out.println("该学生的信息如下：");
        System.out.println("学号\t姓名\t性别\t年龄\t系别");
        StudentDao stuDao = new StudentDao();
        List<Student> list = stuDao.retrieve();
        for (Student stuList : list) { //循环打印出查询结果
            System.out.println(stuList.getId() + "\t" + stuList.getName() + "\t" + stuList.getSex() + "\t" + stuList.getAge() + "\t" + stuList.getDept());
        }
        System.out.println("************************");
    }
}
