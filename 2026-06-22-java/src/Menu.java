
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Student> list = new ArrayList<>();        //使用集合来存储用户信息
        // 程序启动时加载历史数据
        Function func = new Function(list);
        func.LoadFromfile();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请选择需要执行的操作: \n" + "(1)学生基本信息的录入。\n" +
                    "(2)学生基本信息的删除。\n" +
                    "(3)学生基本信息的修改。\n" +
                    "(4)学生基本信息的查询。\n" +
                    "(5)学生基本信息的统计。\n"
                    +"(其他)退出系统。");
            //使用switch匹配各功能项
            String choose = sc.next();
            switch (choose) {      //实现增删改查统计等功能
                case "1":
                    System.out.println("用户选择录入学生信息");
                    func.log();
                    //录入完毕之后将集合按照学号进行排序
                    Thread.sleep(1000);     //休眠1s，让控制台跳转更加友好
                    break;
                case "2":
                    System.out.println("用户选择删除学生信息");
                    func.delete();
                    Thread.sleep(1000);     //休眠1s，让控制台跳转更加友好
                    break;
                case "3":
                    System.out.println("用户选择修改学生信息");
                    func.update();
                    Thread.sleep(1000);     //休眠1s，让控制台跳转更加友好
                    break;
                case "4":
                    System.out.println("用户选择查询学生信息");   //查询类型有很多可以抽象成方法
                    SearchInformation(func);
                    Thread.sleep(1000);     //休眠1s，让控制台跳转更加友好
                    break;
                case "5":
                    System.out.println("用户选择统计学生信息");   //统计类型有很多可以抽象成方法
                    Culculate(func);
                    Thread.sleep(1000);     //休眠1s，让控制台跳转更加友好
                    break;
                default:
                    System.out.println("用户选择退出系统");
                    func.SaveTofile();  //保存数据
                    System.exit(0);
            }
        }
    }

    public static void SearchInformation(Function  func) throws InterruptedException {
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
        func.search(choose);   //直接按选择的方式进行查询
    }

    public static void Culculate(Function func) throws InterruptedException {
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
        func.count(choose);   //调用统计方法
    }


}
