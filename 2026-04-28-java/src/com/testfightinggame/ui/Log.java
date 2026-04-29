package com.testfightinggame.ui;

import JavaBean.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Log {
    //此方法为程序登录的主页面
    public void start() {
        //创建完uesr类就可以创建集合
        ArrayList<User> list = new ArrayList<>(); //将该集合传递到下面的登录注册去,集合就是一个数据库,存放用户信息

        while (true) {
            System.out.println("欢迎来到测试战斗游戏~~~");
            System.out.println("╔════════════════════════════════╗");
            System.out.println("    🎮 欢迎来到文字格斗游戏 🎮   ");
            System.out.println("╚════════════════════════════════╝");
            System.out.println("请选择操作：1登录 2注册 3退出"); //第二步,先写注册,注册需要输入用户名和密码,则需要用集合存放
            //集合里面的<>需要一个user类,则需要先写一个user的bean类
            //需要输入数字然后再进行判断(switch)
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();

            //开始匹配
            switch (choose) {
                case "1" -> login(list);    //这里的各种登陆注册代码会很复杂需要再写几个方法包裹
                case "2" -> register(list);
                case "3" -> {
                    System.out.println("用户选择了退出操作"); //直接关闭虚拟机
                    System.exit(0);
                }
                default -> System.out.println("输入错误，请重新输入");
            }
        }
    }

    public static void login(ArrayList<User> list) {
        System.out.println("用户选择了登录操作");
    }

    public static void register(ArrayList<User> list) { //先写注册再写登录
        System.out.println("用户选择了注册操作");
        //注册需要先录入账户密码,然后再封装成user对象,最后添加到集合中 集合就是一个数据库,存放用户信息

        Scanner sc = new Scanner(System.in);
        String account = null;   //在外部创建变量才不会影响循环外部account的值,到后面才能进行封装


        //来循环判断输入的account是否符合要求
        while (true) {                            //先判断长度是否3~16位
            System.out.println("请输入用户名：");  //再要判断格式,只能是字母加数字,不能是纯数字
            account = sc.next();    //这里返回为true才能进行报错
            if (CheckUserNameLength(account, 3, 16)) {  //account.length()<3||account.length()>16这个判断需要反复调用,需要写成方法
                System.out.println("用户名长度必须在3~16位之间,请重新输入:");
                continue;   //跳过本次循环,继续下一次循环

            } else if (CheckUserName(account)) {     //来判断格式,再要判断格式,只能是字母加数字,不能是纯数字,也可以写成方法留给密码调用
                System.out.println("用户名只能是字母加数字,不能是纯数字和其他字符,请重新输入:");
                continue;   //跳过本次循环,继续下一次循环

            } else if (UserNameUnique(account, list)) {
                System.out.println("用户名不是唯一的,请重新输入:");
                continue;   //跳过本次循环,继续下一次循环

            }
            break;  //若三次判断都通过则跳出循环
        }


        //来循环判断输入的password是否符合要求
        String password2;    //在外部创建变量才不会影响循环外部password的值,到后面才能进行封装
        while (true) {
            System.out.println("请输入密码：");   //密码要输入两次,两次一样才能通过
            String password1 = sc.next();
                if (CheckUserNameLength(password1, 3, 8)) {
                    System.out.println("密码长度必须在3~8位之间,请重新输入:");
                    continue;
                } else if (PassWord(password1)) {  //只能是字母加数字的组合
                    System.out.println("密码只能是字母加数字的组合,请重新输入:");
                    continue;
                }


            System.out.println("请再次输入密码："); //在这之前就必须来判断密码格式问题
            password2 = sc.next();
            //判断两次密码是否一致
            if(!password1.equals(password2)){
                System.out.println("两次密码不一致,请重新输入:");
            }else {
                break;
            }
        }
        //都符合要求,进行封装和放入列表
        User u = new User(account, password2);  //封装
        list.add(u);//导入集合
        System.out.println("用户注册成功");
    }

    //写判断长度的方法
    public static boolean CheckUserNameLength(String str, int min, int max) {
        if (str.length() < min || str.length() > max) {
            return true;    //符合条件才能进入if判断
        }
        return false;
    }

    //写判断账户格式的方法
    public static boolean CheckUserName(String username) {
        //定义三个计数器来计算字符串里面的数字、字母、特殊字符
        int count[] = Count(username);  //取出返回的元素
        if (count[2] > 0 || count[1] == 0) {    //return new int[]{numCount, letterCount, ortherCount}
            return true;    //符合条件才能进入if判断
        }
        return false;
    }

    //写判断用户名是否唯一的方法
    public static boolean UserNameUnique(String userName, ArrayList<User> list) {
        for (int i = 0; i < list.size(); i++) {
            if (userName.equals(list.get(i).getAccount())) {   //如果存在相同的则需要报错,无法直接获得列表里面的值,需要用get方法
                return true;
            }
        }
        return false;
    }

    //写判断密码格式的方法
    public static boolean PassWord(String password){
        int count[] = Count(password);  //取出返回的元素
        if(count[1]==0||count[2]>0){
            return true;
        }
        return false;
    }

    //在写密码判断时发现判断密码格式和上面判断账户格式有一段雷同,所以可以封装成一个方法
    public static int[] Count(String str) {
        int numCount = 0;
        int letterCount = 0;
        int ortherCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') { //是字符类型应该是单引号''
                numCount++;
            } else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z' || str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                letterCount++;
            } else {
                ortherCount++;
            }
        }
        return new int[]{numCount, letterCount, ortherCount}; //因为需要返回多个值,所以需要用数组封装起来
    }
}
