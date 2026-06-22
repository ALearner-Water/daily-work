
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请选择需要执行的操作: \n" + "(1)学生基本信息的录入。\n" +
                    "(2)学生基本信息的删除。\n" +
                    "(3)学生基本信息的修改。\n" +
                    "(4)学生基本信息的查询。\n" +
                    "(5)学生基本信息的统计。\n"
                    +"(6)退出系统。\n");
            //使用switch匹配各功能项
            int choose = sc.nextInt();
            switch (choose) {      //实现增删改查统计等功能
                case 1:
                    System.out.println("用户选择录入学生信息");
                    new Fuction(list).log();
                    break;
                case 2:
                    System.out.println("用户选择删除学生信息");
                    new Fuction(list).delete();
                    break;
                case 3:
                    System.out.println("用户选择修改学生信息");
                    break;
                case 4:
                    System.out.println("用户选择查询学生信息");   //查询类型有很多可以抽象成方法
                    SearchInformation(list);
                    break;
                case 5:
                    System.out.println("用户选择统计学生信息");   //统计类型有很多可以抽象成方法
                    Culculate(list);
                    break;
                case 6:
                    System.out.println("用户选择退出系统");
                    System.exit(0);
            }
        }
    }

    public static void SearchInformation(ArrayList<Student> list) {
/*     （a)查询所有学生信息；
       （b)按学号查询单个学生信息；
        (c)按姓名查询单个学生信息；
        (d)按性别查询学生信息；
        (e)按班号查询学生信息；*/
        Scanner sc = new Scanner(System.in);
        System.out.println("(a)查询所有学生信息；\n" +
                "(b)按学号查询单个学生信息；\n" +
                "(c)按姓名查询单个学生信息；\n" +
                "(d)按性别查询学生信息；\n" +
                "(e)按班号查询学生信息；");
        String choose = sc.next();
        switch (choose) {
            case "a":
                System.out.println("用户选择查询所有学生信息");
                break;
            case "b":
                System.out.println("用户选择按学号查询单个学生信息");
                break;
            case "c":
                System.out.println("用户选择按姓名查询单个学生信息");
                break;
            case "d":
                System.out.println("用户选择按性别查询学生信息");
                break;
            case "e":
                System.out.println("用户按班号查询学生信息");
                break;
        }
        new Fuction(list).search(choose);   //直接按选择的方式进行查询
    }

    public static void Culculate(ArrayList<Student> list) {
/*
        (a)按性别统计学生人数；
        (b)按班号统计学生人数；
        (c)按年龄统计学生人数；
        (d)按系别统计学生人数；
*/
        System.out.println("(a)按性别统计学生人数；\n" +
                "(b)按班号统计学生人数；\n" +
                "(c)按年龄统计学生人数；\n" +
                "(d)按系别统计学生人数；");
        Scanner sc = new Scanner(System.in);
        String choose = sc.next();
        switch (choose) {
            case "a":
                System.out.println("用户选择按性别统计学生人数");
                break;
            case "b":
                System.out.println("用户选择按班号统计学生人数");
                break;
            case "c":
                System.out.println("用户选择按年龄查询单个学生信息");
                break;
            case "d":
                System.out.println("用户选择按系别统计学生人数");
                break;
        }
        new Fuction(list).count(choose);
    }


}
