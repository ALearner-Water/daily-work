package com.testfightinggame.ui;
import java.util.Scanner;

public class Log {
    //此方法为程序登录的主页面
    public void start(){
        while (true) {
            System.out.println("欢迎来到测试战斗游戏~~~");
            System.out.println("╔════════════════════════════════╗");
            System.out.println("    🎮 欢迎来到文字格斗游戏 🎮   ");
            System.out.println("╚════════════════════════════════╝");
            System.out.println("请选择操作：1登录 2注册 3退出");

            //需要输入数字然后再进行判断(switch)
            Scanner sc=new Scanner(System.in);
            String choose=sc.next();

            //开始匹配
            switch (choose){
                case "1" -> login();    //这里的各种登陆注册代码会很复杂需要再写几个方法包裹
                case "2" -> register();
                case "3" -> {
                   System.out.println("用户选择了退出操作"); //直接关闭虚拟机
                    System.exit(0);
                }
                default -> System.out.println("输入错误，请重新输入");
            }
        }
    }
    public static void login(){
        System.out.println("用户选择了登录操作");
    }
    public static void  register(){
        System.out.println("用户选择了注册操作");
    }
}
