
import java.util.ArrayList;
import java.util.Scanner;

public class Fuction extends Student {
    public ArrayList<Student> list;
    private Student stu = new Student();
    Scanner sc = new Scanner(System.in);
    static int count_sex = 0;    //按性别统计的人数
    static int count_class = 0;  //按班号统计的人数
    static int count_age = 0;    //按年龄统计的人数
    static int count_department = 0;  //按系别统计的人数

    public Fuction(ArrayList<Student> list) {
        this.list = list;

    }

    //实现增删改查统计等功能
    //在录入的时候要限制输入的格式  学号(11位)、姓名、性别(男或女)、年龄(>=0)、班号(5位必须包含计科或者某某某)、专业名称(三个里面选)、系别(包含学院)
    public void log() {         //实现录入功能
        String strID;
        String strSex;
        int Age;
        String strClass;
        //判断学号格式
        while (true) {
            System.out.println("请输入学号:");
            strID = sc.next();
            if (strID.length() != 11 || !strID.matches("[0-9]+")) {     //长度不足11或者有非数字  +表示可以出现多次
                System.out.println("学号格式错误，请重新输入(只能为长度11位的数字)");
                continue;
            }
            stu.setID(strID);
            break;
        }
        System.out.println("请输入姓名");
        stu.setName(sc.next());
        //判断性别格式
        while (true) {
            System.out.println("请输入性别");
            strSex = sc.next();
            if (!strSex.equals("男") && !strSex.equals("女")) {
                System.out.println("性别格式错误，请重新输入(只能为男或女)");
                continue;
            }
            stu.setSex(strSex);
            break;
        }
        //判断年龄格式
        while (true) {
            System.out.println("请输入年龄");
            Age = sc.nextInt();
            if (Age < 10 || Age > 100) {
                System.out.println("年龄格式错误，请重新输入");
                continue;
            }
            stu.setAge(Age);
            break;
        }
        while (true) {
            System.out.println("请输入班级(例: 计科251)");
            strClass = sc.next();
            if ( !strClass.contains("计科") && !strClass.contains("软件") && !strClass.contains("网络")) {
                if(strClass.length() != 5)
                System.out.println("班级格式错误，请重新输入");
            }
            stu.setClassNumber(strClass);
            break;
        }
        System.out.println("请输入专业");
        stu.setMajor(sc.next());
        System.out.println("请输入系别");
        stu.setDepartment(sc.next());
        list.add(stu);
        System.out.println("录入成功");
    }

    public void delete() {      //实现删除功能
        System.out.println("请输入要删除的学生的学号:");
        String str = sc.next();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getID().equals(str)) {
                list.remove(i);
                System.out.println("删除成功");
                break;
            }
        }
    }

    public void update() {
        System.out.println("请输入要修改的学生的学号:");
        String str = sc.next();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getID().equals(str)) {
                log();
                list.remove(i);
                System.out.println("修改成功");
                break;
            }
        }
    }

    public void search(String choose) {
        String str;
        switch (choose) {
            case "a" -> {
                for (int i = 0; i < list.size(); i++) {
                    System.out.println("学号: " + list.get(i).getID() + "  姓名: " + list.get(i).getName() + "  性别: " + list.get(i).getSex() +
                            "  年龄: " + list.get(i).getAge() + "  班级: " + list.get(i).getClassNumber() + "  专业: " + list.get(i).getMajor() +
                            "  系别: " + list.get(i).getDepartment());
                }
            }
            case "b" -> {
                System.out.println("请输入要查询学生的学号:");
                str = sc.next();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getID().contains(str)) {
                        System.out.println("学号: " + list.get(i).getID() + "  姓名: " + list.get(i).getName() + "  性别: " + list.get(i).getSex() +
                                "  年龄: " + list.get(i).getAge() + "  班级: " + list.get(i).getClassNumber() + "  专业: " + list.get(i).getMajor() +
                                "  系别: " + list.get(i).getDepartment());
                        break;
                    }
                }
            }
            case "c" -> {
                System.out.println("请输入要查询学生的姓名:");
                str = sc.next();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getName().contains(str)) {
                        System.out.println("学号: " + list.get(i).getID() + "  姓名: " + list.get(i).getName() + "  性别: " + list.get(i).getSex() +
                                "  年龄: " + list.get(i).getAge() + "  班级: " + list.get(i).getClassNumber() + "  专业: " + list.get(i).getMajor() +
                                "  系别: " + list.get(i).getDepartment());
                    }
                }
            }
            case "d" -> {
                System.out.println("请输入要查询学生的性别:");
                str = sc.next();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getSex().equals(str)) {
                        System.out.println("学号: " + list.get(i).getID() + "  姓名: " + list.get(i).getName() + "  性别: " + list.get(i).getSex() +
                                "  年龄: " + list.get(i).getAge() + "  班级: " + list.get(i).getClassNumber() + "  专业: " + list.get(i).getMajor() +
                                "  系别: " + list.get(i).getDepartment());
                    }
                }
            }
            case "e" -> {
                System.out.println("请输入要查询学生的班级:");
                str = sc.next();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getClassNumber().contains(str)) {
                        System.out.println("学号: " + list.get(i).getID() + "  姓名: " + list.get(i).getName() + "  性别: " + list.get(i).getSex() +
                                "  年龄: " + list.get(i).getAge() + "  班级: " + list.get(i).getClassNumber() + "  专业: " + list.get(i).getMajor() +
                                "  系别: " + list.get(i).getDepartment());
                    }
                }
            }
        }
    }

    public void count(String choose) {
        String str = sc.next();
        switch (choose) {
            case "a" -> {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getSex().equals(str)) {
                        count_sex++;
                    }
                }
                System.out.println("性别为" + str + "的学生的数量为:" + count_sex);
            }
            case "b" -> {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getClassNumber().contains(str)) {
                        count_class++;
                    }
                }
                System.out.println("班级为" + str + "的学生的数量为:" + count_class);
            }
            case "c" -> {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getAge() == Integer.parseInt(str)) {
                        count_age++;
                    }
                }
                System.out.println("年龄为" + str + "的学生的数量为:" + count_age);
            }
            case "d" -> {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getDepartment().contains(str)) {
                        count_department++;
                    }
                }
                System.out.println("系别为" + str + "的学生的数量为:" + count_department);
            }
        }
    }

}
