
import java.io.*;
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
        String strID;       //存储用户录入的id
        String strSex;      //存储用户录入的性别
        String Age;         //存储用户录入的年龄
        String strClass;    //存储用户录入的班级
        //判断学号格式
        while (true) {
            System.out.println("请输入学号:");
            strID = sc.next();
            if (strID.length() != 11 || !strID.matches("[0-9]+")) {     //长度不足11或者有非数字  +表示可以出现多次
                System.out.println("学号格式错误，请重新输入(只能为长度11位的数字)");
                continue;       //跳过当前循环
            }
            boolean logging = false;   //用boolean来重复判断学号是否存在
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getID().equals(strID)) {
                    System.out.println("学号已存在，请重新输入");
                    logging = true;
                    break;
                }
            }
            if (logging) {      //如果学号已存在则跳过当前循环
                continue;
            }
            stu.setID(strID);   //录入学号
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
            stu.setName(strName);   //录入姓名
            break;
        }
        //判断性别格式
        stu.setSex(search_sex());   //抽象成方法(因为后面还需要重复使用判断)
        //判断年龄格式
        while (true) {
            System.out.println("请输入年龄");
            Age = sc.next();
            if (!Age.matches("[0-9]+")) {
                System.out.println("年龄必须全部为数字，请重新输入");  //转换异常处理使String安全转成int类型
                continue;
            }
            int i = Integer.parseInt(Age);      //转换为int类型,处理了转换异常(Integer自动拆箱)
            if (i < 10 || i > 80) {
                System.out.println("年龄格式错误(必须大于10小于80)，请重新输入");
                continue;
            }
            stu.setAge(i);  //录入年龄
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
        //判断专业格式
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
        //判断系别格式
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
        list.add(stu);  //将信息录入
        list.sort((s1, s2) -> s1.getID().compareTo(s2.getID()));       //默认使用学号升序进行排序
        System.out.println("信息录入成功~");
    }

    public void delete() throws InterruptedException {  //实现删除功能   前提是输入的学号存在
        boolean breakchoose = false;    //用来判断是否找到该学号
        System.out.println("请输入要删除的学生的学号:");
        String str = sc.next();
        boolean seek = seek(str);   //将模糊查询抽象成方法
        if (seek) {     //如果模糊查询找到多个结果则提示用户输入准确学号，若没有找到则继续执行下面的操作
            System.out.println("请输入准确学号来删除学生信息:");
            str = sc.next();
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getID().equals(str)) {      //找到该学号
                list.remove(i);
                System.out.println("删除成功");
                breakchoose = true;
                break;
            }
        }
        if (!breakchoose) {
            System.out.println("没有该学号的学生");
            //给用户提供选择
            prompt();   //抽象成方法,处理没有找到之后的操作,可以返回主菜单或者退出
        }
    }

    public void update() throws InterruptedException {
        boolean breakchoose = false;    //用来判断是否找到该学号
        System.out.println("请输入要修改的学生的学号:");
        String str = sc.next();
        boolean seek = seek(str);       //将模糊查询抽象成方法
        if (seek) {      //如果模糊查询找到多个结果则提示用户输入准确学号，若没有找到则继续执行下面的操作
            System.out.println("请输入准确学号来修改学生信息:");
            str = sc.next();
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getID().equals(str)) {
                list.remove(i);     //先删除再重新录入
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
            case "a" -> {       //遍历打印所有学生信息
                decideSort();   //抽象各种排序方式
                if (list.size() == 0) {
                    System.out.println("没有学生信息");
                    prompt();       //给用户提供选择
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        print(list.get(i));
                    }
                }
            }
            case "b" -> {       //提供学号查询学生信息
                System.out.println("请输入要查询学生的学号:");
                str = sc.next();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getID().contains(str)) {
                        System.out.println("查询到的学生有:");
                        print(list.get(i));
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("没有该学号的学生");
                    prompt();    //给用户提供选择
                }
            }
            case "c" -> {       //提供姓名查询学生信息
                System.out.println("请输入要查询学生的姓名:");
                str = sc.next();
                decideSort();   //抽象各种排序方式
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getName().contains(str)) {
                        System.out.println("查询到的学生有:");
                        print(list.get(i));
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("没有该姓名的学生");
                    prompt();       //给用户提供选择
                }
            }
            case "d" -> {       //提供性别查询学生信息
                str = search_sex();     //抽象成方法判断性别
                decideSort();   //抽象各种排序方式
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
            case "e" -> {       //提供班级查询学生信息
                System.out.println("请输入要查询学生的班级:");
                str = sc.next();
                decideSort();   //抽象各种排序方式
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getClassNumber().contains(str)) {
                        print(list.get(i));
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("未找到该班级");
                    prompt();       //给用户提供选择
                }
            }
            default -> {
                System.out.println("输入错误");
                prompt();
            }
        }
    }

    //实现统计功能
    public void count(String choose) throws InterruptedException {
        int count_sex = 0;    //按性别统计的人数
        int count_class = 0;  //按班号统计的人数
        int count_age = 0;    //按年龄统计的人数
        int count_department = 0;  //按系别统计的人数
        switch (choose) {
            case "a" -> {       //按性别统计
                System.out.println("请输入要统计的性别:");
                String str = sc.next();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getSex().equals(str)) {
                        count_sex++;
                    }
                }
                System.out.println("性别为" + str + "的学生的数量为:" + count_sex);
            }
            case "b" -> {       //按班级统计
                System.out.println("请输入要统计的班级:");
                String str = sc.next();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getClassNumber().contains(str)) {
                        count_class++;
                    }
                }
                System.out.println("班级为" + str + "的学生的数量为:" + count_class);
            }
            case "c" -> {       //按年龄统计
                System.out.println("请输入要统计的年龄:");
                String str = sc.next();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getAge() == Integer.parseInt(str)) {
                        count_age++;
                    }
                }
                System.out.println("年龄为" + str + "的学生的数量为:" + count_age);
            }
            case "d" -> {      //按系别统计
                System.out.println("请输入要统计的系别:");
                String str = sc.next();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getDepartment().contains(str)) {
                        count_department++;
                    }
                }
                System.out.println("系别为" + str + "的学生的数量为:" + count_department);
            }
            default -> {
                System.out.println("输入错误");
                prompt();
            }
        }
    }
    //从这里开始的方法是从上面抽取出来的

    //当用户在删除查询时输入的学生不存在时需要提示
    public void prompt() throws InterruptedException {
        //供用户选择下一步要做什么
        System.out.println("请选择下一步需要执行的操作:“按1回到主页,按其他任意键退出系统”");
        String doing = sc.next();
        switch (doing) {
            case "1" -> {
                System.out.println();   //先换行会更美观
                Menu.main(null);
            }
            default -> {
                System.out.println("已退出系统~");
                SaveTofile();   //保存数据
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

    //对集合进行排序使得输出时更加简洁美观
    public void Sort(String ChooseSort) {
        switch (ChooseSort) {
            case "1" -> list.sort((s1, s2) -> s1.getID().compareTo(s2.getID()));   //使用lambda表达式对学号进行升序排序;
            case "2" -> list.sort((s1, s2) -> s2.getID().compareTo(s1.getID()));  //使用lambda表达式对学号进行降序排序;
            case "3" -> list.sort((s1, s2) -> Integer.compare(s1.getAge(), s2.getAge()));//使用lambda表达式对年龄进行升序排序;
            case "4" -> list.sort((s1, s2) -> Integer.compare(s2.getAge(), s1.getAge()));//使用lambda表达式对年龄进行降序排序;
            default -> System.out.println("使用默认排序");
        }
    }

    //将模糊查询抽取出来做方法
    public boolean seek(String str) {
        boolean found = false;
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j).getID().contains(str)) {        //实现模糊查询
                System.out.println("找到以下学生信息:");
                print(list.get(j));     //需要多次打印学生信息,所以抽象成方法
                found = true;
            }
        }
        return found;   //返回一个布尔值用来后续判断
    }

    //将决定排序抽取成方法
    public void decideSort() {
        System.out.println("请选择查询后的输出排序方式:\n" +
                "1. 按学号升序打印\n" +
                "2. 按学号降序打印\n" +
                "3. 按年龄升序打印\n" +
                "4. 按年龄降序打印\n" +
                "(其他按键) 按默认排序\n");
        String ChooseSort = sc.next();
        Sort(ChooseSort);     //调用方法进行排序
    }

    //保存数据到文件
    public void SaveTofile() {
        String fileName = "students.txt";   //用.txt文件存储数据
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {    //使用缓冲流创建对象
            // 写入学生数量
            writer.write(String.valueOf(list.size()));
            writer.newLine();   //方便读取数据
            // 写入每个学生的信息
            for (Student stu : list) {
                writer.write(stu.getID());      //写入学号
                writer.newLine();     //读完一种数据换一行,方便后续读取数据时不会出错
                writer.write(stu.getName());   //写入姓名
                writer.newLine();     //读完一种数据换一行,方便后续读取数据时不会出错
                writer.write(stu.getSex());    //写入性别
                writer.newLine();     //读完一种数据换一行,方便后续读取数据时不会出错
                writer.write(String.valueOf(stu.getAge()));    //写入年龄
                writer.newLine();    //读完一种数据换一行,方便后续读取数据时不会出错
                writer.write(stu.getClassNumber());            //写入班级
                writer.newLine();    //读完一种数据换一行,方便后续读取数据时不会出错
                writer.write(stu.getMajor());                  //写入专业
                writer.newLine();    //读完一种数据换一行,方便后续读取数据时不会出错
                writer.write(stu.getDepartment());             //写入系别
                writer.newLine();   //读完一种数据换一行,方便后续读取数据时不会出错
            }

            System.out.println("数据已成功保存到 " + fileName);
        } catch (IOException e) {
            System.out.println("保存数据时出错: " + e.getMessage());   //处理异常
        }
    }

    //从文件加载数据
    public void LoadFromfile() {
        String fileName = "students.txt";   //用.txt文件存储学生信息
        File file = new File(fileName);     //创建一个File对象
        // 如果文件不存在，直接返回
        if (!file.exists()) {
            System.out.println("未找到历史数据文件，将创建新的数据");
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {    //使用缓冲流读取数据
            String countStr = reader.readLine();    //读取学生数量
            if (countStr == null) {                 //如果文件为空，直接返回
                return;
            }
            int count = Integer.parseInt(countStr); // 转换为int类型
            // 清空当前列表
            list.clear();
            // 读取每个学生的信息
            for (int i = 0; i < count; i++) {
                Student stu = new Student();        //创建一个Student对象
                String id = reader.readLine();      //读取学生学号
                String name = reader.readLine();    //读取学生姓名
                String sex = reader.readLine();     //读取学生性别
                String age = reader.readLine();     //读取学生年龄
                String classNumber = reader.readLine(); //读取学生班级
                String major = reader.readLine();       //读取学生专业
                String department = reader.readLine();  //读取学生系别
                // 设置学生信息
                stu.setID(id);      //设置学生学号
                stu.setName(name);  //设置学生姓名
                stu.setSex(sex);    //设置学生性别
                stu.setAge(Integer.parseInt(age));  //设置学生年龄
                stu.setClassNumber(classNumber);    //设置学生班级
                stu.setMajor(major);                //设置学生专业
                stu.setDepartment(department);      //设置学生系别
                list.add(stu);      //添加学生信息到集合中
            }

            System.out.println("成功加载 " + count + " 条学生数据");
        } catch (IOException e) {
            System.out.println("加载数据时出错: " + e.getMessage());   //处理IO异常
        } catch (NumberFormatException e) {
            System.out.println("数据格式错误: " + e.getMessage());     //处理数字格式异常
        }
    }
}

