
import java.util.ArrayList;
import java.util.Scanner;

public class Function {
    public ArrayList<Student> list;
    Scanner sc = new Scanner(System.in);

    public Function(ArrayList<Student> list) {
        this.list = list;

    }

    //实现增删改查统计等功能
    //在录入的时候要限制输入的格式  学号(11位)、姓名、性别(男或女)、年龄(>=0)、班号(5位必须包含计科或者某某某)、专业名称(三个里面选)、系别(包含学院)
    public void log() throws InterruptedException {         //实现录入功能
        Student stu = new Student();    //创建新的对象否则log方法中无法存入新的对象
        String strID;
        String strSex;
        String Age;
        String strClass;
        //判断学号格式
        while (true) {
            System.out.println("请输入学号:");
            strID = sc.next();
            if (strID.length() != 11 || !strID.matches("[0-9]+")) {     //长度不足11或者有非数字  +表示可以出现多次
                System.out.println("学号格式错误，请重新输入(只能为长度11位的数字)");
                continue;
            }
            boolean logging = false;   //用boolean来重复判断学号是否存在
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getID().equals(strID)) {
                    System.out.println("学号已存在，请重新输入");
                    logging = true;
                    break;
                }
            }
            if (logging) {
                continue;
            }
            stu.setID(strID);
            break;
        }
        //判断姓名格式
        while (true) {
            System.out.println("请输入姓名");
            String strName = sc.next();
            if (strName.matches("[0-9]+") || strName.length() < 2) {
                System.out.println("姓名格式错误，请重新输入(不能为数字)且名字需要一个字以上");
                continue;
            }
            stu.setName(strName);
            break;
        }
        //判断性别格式
        stu.setSex(search_sex());   //抽象成方法
        //判断年龄格式
        while (true) {
            System.out.println("请输入年龄");
            Age = sc.next();
            if (!Age.matches("[0-9]+")) {
                System.out.println("年龄必须全部为数字，请重新输入");
                continue;
            }
            int i = Integer.parseInt(Age);
            if (i < 10 || i > 80) {
                System.out.println("年龄格式错误(必须大于10小于80)，请重新输入");
                continue;
            }
            stu.setAge(i);
            break;
        }
        //判断班级格式
        while (true) {
            System.out.println("请输入班级(例: 计科251)");
            strClass = sc.next();
            if (strClass.length() == 5 && (strClass.startsWith("计科") || strClass.startsWith("软件") || strClass.startsWith("网络"))) {
                stu.setClassNumber(strClass);
                break;
            }
            System.out.println("班级格式错误，请重新输入");
            continue;
        }
        while (true) {
            System.out.println("请输入专业(例: 计算机科学与技术)");
            String strMajor = sc.next();
            if (strMajor.equals("软件工程") || strMajor.equals("网络工程") || strMajor.equals("计算机科学与技术")) {
                stu.setMajor(strMajor);
                break;
            } else {
                System.out.println("专业格式错误，请重新输入");
            }
        }
        while (true) {
            System.out.println("请输入系别(例: 某某学院)");
            String strDepartment = sc.next();
            if (strDepartment.contains("学院")) {
                stu.setDepartment(strDepartment);
                break;
            } else {
                System.out.println("系别格式错误，请重新输入");
            }
        }
        list.add(stu);
        System.out.println("信息录入成功~");
    }

    public void delete() throws InterruptedException { //实现删除功能   前提是输入的学号存在
        boolean breakchoose = false;
        System.out.println("请输入要删除的学生的学号:");
        String str = sc.next();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getID().contains(str)) {        //实现模糊查询
                System.out.println("找到以下学生信息:");
                print(list.get(i));
                continue;
            }
            System.out.println("请输入准确学号来删除学生信息:");
            str = sc.next();
            if (list.get(i).getID().equals(str)) {
                list.remove(i);
                System.out.println("删除成功");
                breakchoose = true;
                break;
            }
        }
        if (!breakchoose) {
            System.out.println("没有该学号的学生");
            //给用户提供选择
            prompt();
        }
    }

    public void update() throws InterruptedException {
        boolean breakchoose = false;
        System.out.println("请输入要修改的学生的学号:");
        String str = sc.next();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getID().contains(str)) {        //实现模糊查询
                System.out.println("找到以下学生信息:");
                print(list.get(i));
                continue;
            }
            System.out.println("请输入准确学号来删除学生信息:");
            str = sc.next();
            if (list.get(i).getID().equals(str)) {
                list.remove(i);
                log();
                System.out.println("修改成功");
                breakchoose = true;
                break;
            }
        }
        if (!breakchoose) {
            System.out.println("没有该学号的学生");
            //给用户提供选择
            prompt();
        }
    }

    //实现查询功能
    public void search(String choose) throws InterruptedException {
        boolean found = false;        //判断是否找到相关信息
        String str;
        switch (choose) {
            case "a" -> {
                for (int i = 0; i < list.size(); i++) {
                    print(list.get(i));
                }
            }
            case "b" -> {
                System.out.println("请输入要查询学生的学号:");
                str = sc.next();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getID().contains(str)) {
                        System.out.println("查询到的学生有:");
                        print(list.get(i));
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("没有该学号的学生");
                    prompt();
                }
            }
            case "c" -> {
                System.out.println("请输入要查询学生的姓名:");
                str = sc.next();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getName().contains(str)) {
                        System.out.println("查询到的学生有:");
                        print(list.get(i));
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("没有该姓名的学生");
                    prompt();
                }
            }
            case "d" -> {
                str = search_sex();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getSex().equals(str)) {
                        print(list.get(i));
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("没有该性别的学生");
                    prompt();
                }
            }
            case "e" -> {
                System.out.println("请输入要查询学生的班级:");
                str = sc.next();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getClassNumber().contains(str)) {
                        print(list.get(i));
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("未找到该班级");
                    prompt();
                }
            }
        }
    }

    //实现统计功能
    public void count(String choose) {
        int count_sex = 0;    //按性别统计的人数
        int count_class = 0;  //按班号统计的人数
        int count_age = 0;    //按年龄统计的人数
        int count_department = 0;  //按系别统计的人数
        switch (choose) {
            case "a" -> {
                System.out.println("请输入要统计的性别:");
                String str = sc.next();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getSex().equals(str)) {
                        count_sex++;
                    }
                }
                System.out.println("性别为" + str + "的学生的数量为:" + count_sex);
            }
            case "b" -> {
                System.out.println("请输入要统计的班级:");
                String str = sc.next();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getClassNumber().contains(str)) {
                        count_class++;
                    }
                }
                System.out.println("班级为" + str + "的学生的数量为:" + count_class);
            }
            case "c" -> {
                System.out.println("请输入要统计的年龄:");
                String str = sc.next();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getAge() == Integer.parseInt(str)) {
                        count_age++;
                    }
                }
                System.out.println("年龄为" + str + "的学生的数量为:" + count_age);
            }
            case "d" -> {
                System.out.println("请输入要统计的系别:");
                String str = sc.next();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getDepartment().contains(str)) {
                        count_department++;
                    }
                }
                System.out.println("系别为" + str + "的学生的数量为:" + count_department);
            }
        }
    }

    //当用户在删除查询时输入的学生不存在时需要提示
    public void prompt() throws InterruptedException {
        //供用户选择下一步要做什么
        System.out.println("请选择下一步需要执行的操作:“按1回到主页,按其他任意键退出系统”");
        String doing = sc.next();
        switch (doing) {
            case "1" -> Menu.main(null);
            default -> {
                System.out.println("已退出系统~");
                System.exit(0);
            }
        }
    }

    //可以将查询性别抽象成方法
    public String search_sex() {
        String strSex;
        while (true) {
            System.out.println("请输入性别");
            strSex = sc.next();
            if (!strSex.equals("男") && !strSex.equals("女")) {
                System.out.println("性别格式错误，请重新输入(只能为男或女)");
                continue;
            }
            break;
        }
        return strSex;
    }

    //提取打印学生信息的方法
    public void print(Student student) {
        System.out.println("学号: " + student.getID() + "\t" + "  姓名: " + student.getName() + "\t" + "  性别: " + student.getSex() + "\t" +
                "  年龄: " + student.getAge() + "\t" + "  班级: " + student.getClassNumber() + "\t" + "  专业: " + student.getMajor() + "\t\t   " +
                "  系别: " + student.getDepartment());
    }
}
