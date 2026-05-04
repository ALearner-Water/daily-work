package com.testfightinggame.ui;

import JavaBean.EnemyCharacter;
import JavaBean.UserCharacter;

import java.util.Scanner;
import java.util.ArrayList;

public class FightingGame {
    //  启动游戏
    public void GameStart(String userName) {     //表示登录游戏的用户
        System.out.println("╔════════════════════════════════╗");
        System.out.println(" 🎮 " + "\"" + userName + "\"" + " 欢迎来到文字格斗游戏 🎮   ");
        System.out.println("╚════════════════════════════════╝");
        //  需要创建对象(包含属性分配和名字)   -----> 则需要使用方法
        UserCharacter player = CreateCharater(userName);    //使用相应的类型接收创建的对象
        System.out.println("角色创建成功！");
        //输出已创建好的属性和基本数据
        System.out.println("初始属性为: " + player.show());
        //输出拥有技能    可以在usercharacter里面再写一个类似的show方法然后再调用
        System.out.println("拥有技能: " + player.showSkills());

        //创建敌人的集合列表
        ArrayList<EnemyCharacter> enemyList = new ArrayList<>();
        enemyList.add(new EnemyCharacter(80, 15, 10, "初级战士", "猛击"));
        enemyList.add(new EnemyCharacter(60, 20, 5, "敏捷刺客", "快速攻击"));
        enemyList.add(new EnemyCharacter(120, 10, 20, "重装坦克", "防御姿态"));
        enemyList.add(new EnemyCharacter(70, 25, 8, "神秘法师", "火球术"));
    }

    //  1.需要传入用户名
    //  2.用usercharacter来接收
    public UserCharacter CreateCharater(String username) {
        System.out.println("创建您的角色:");
        System.out.println("您的角色名称为: " + username);
        System.out.println("请分配属性点,共20点");
        System.out.println("1. 生命值 (每点+10HP)");
        System.out.println("2. 攻击力 (每点+2ATK)");
        System.out.println("3. 防御力 (每点+1DEF)");
        //  开始分配属性(20点)
        int point = 20;

        //键盘录入属性分配
        Scanner sc = new Scanner(System.in);

        /*System.out.print("分配点数到 生命值 (剩余点数: "+point+"): ");
        int hppoint=sc.nextInt();
        if(hppoint<0){
            System.out.println("无效输入,默认0点");
            hppoint=0;
        }else if(hppoint>point){
            System.out.println("无效输入,默认"+point+"点");
            hppoint=point;
        }else {
            point-=hppoint;
        }*/     //这一段需要写很多遍,但是有细节不同,则要定义数组和集合把他们存起来然后直接遍历打印

        //定义数组将不同的提示语句存起来
        String attribute[] = {"生命值", "攻击力", "防御力"};
        //再定义一个数组储存分配的属性点,为了后面返回属性点做计算准备
        int value[] = new int[attribute.length];
        for (int i = 0; i < attribute.length; i++) {
            if (point == 0) {
                value[i] = 0;
                System.out.println("分配点数到 " + attribute[i] + ": 0点 (点数已用完)");
                continue;
            }

            //如果是最后一个属性，直接分配剩余所有点数
            if (i == attribute.length - 1) {
                value[i] = point;
                System.out.println("分配点数到 " + attribute[i] + ": " + point + "点 (剩余点数全部分配)");
                point = 0;
                continue;
            }

            System.out.print("分配点数到 " + attribute[i] + " (剩余点数: " + point + "): ");
            int point1 = sc.nextInt();
            if (point1 < 0) {
                System.out.println("无效输入,默认0点");
                point1 = 0;
            } else if (point1 > point) {
                System.out.println("无效输入,默认" + point + "点");
                point1 = point;
            }
            point -= point1;
            //储存属性点
            value[i] = point1;
        }
        //分配完属性点之后就要开始创建对象把属性点所加的数值计算进去
        UserCharacter uc = new UserCharacter(10 + 2 * value[1], 1 * value[2], 100 + 10 * value[0], username);

        //把要求的技能添加进去
        uc.getSkills().add("普通攻击");
        uc.getSkills().add("强力一击");
        uc.getSkills().add("生命汲取");
        return uc;      //把创建好的对象传出去
    }

}
