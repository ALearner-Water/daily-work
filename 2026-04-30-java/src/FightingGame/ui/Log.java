package FightingGame.ui;

import JavaBean.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Log {
    //写一个游戏的登录界面
    //使用方法先写初步
    public static void start() {
        //先写注册,注册完才登录,注册需要有数据库放置用户数据,
        ArrayList<User> list = new ArrayList();   //存放用户数据,只需存入账户和密码,那就要把账户和密码先封装成username类
        while (true) {
            System.out.println("欢迎来到测试战斗游戏~~~");
            System.out.println("╔════════════════════════════════╗");
            System.out.println("    🎮 欢迎来到文字格斗游戏 🎮   ");
            System.out.println("╚════════════════════════════════╝");
            System.out.println("请选择操作：1登录 2注册 3退出");
            //选择之后就要做判断switch
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();
            switch (choose) {
                case "1" -> Login(list); //登录注册业务复杂,需要写方法包裹
                case "2" -> Register(list); //先写注册,注册完才登录,注册需要有数据库放置用户数据,
                case "3" -> {
                    System.out.println("选择退出");
                    System.exit(0);
                }
            }
        }
    }

    public static void Login(ArrayList<User> list) { //登录也要传入集合
        System.out.println("选择登录");
        System.out.println("请输入用户名");
        //  1.判断是否存在账户(去集合里面找,之前已经写过)  2.判断密码  3.密码里面还有验证码
        Scanner sc = new Scanner(System.in);
        String username = sc.next();
        if (!IsUnique(username, list)) {
            System.out.println("用户名不存在,请先注册");
            return; //直接返回选择页面
        }
        //这个获取用户索引之后找数据的这一句会反复使用,直接给一个变量储存他会更方便
        int userindex =FindIndex(username, list);
        if (!list.get(userindex).isState()) {  //判断用户是否被锁定 //用方法找到该用户名的索引进行判断,在密码匹配时也会用到
            System.out.println("用户已被锁定,请重新注册或者联系客服");
            return;
        }
        //密码判断和验证码判断(3次机会)
        for (int i = 1; i <= 3; i++) {
            System.out.println("请输入密码:");
            String password = sc.next();
            //输完密码就要跳出验证码并进行判断
            for (int j = 1; j <= 3; j++) {
                String code = CreateCode();
                System.out.println("验证码为:" + code);
                System.out.println("请输入验证码:");
                String usercode = sc.next();
                if (!code.equalsIgnoreCase(usercode)) {
                    if (j == 3) {
                        System.out.println("验证码多次输入错误,请重新登录:");
                        return;
                    }
                    System.out.println("验证码输入错误,还有" + (3 - j) + "次机会,请重新输入:");
                    continue;
                }
                break;
            }
            //判断密码
            if (list.get(userindex).getPassword().equals(password)) {
                System.out.println("登录成功,欢迎回来");
                break;
            } else {
                if (i == 3) {
                    list.get(userindex).setState(false);
                    System.out.println("用户已被锁定,请重新注册或者联系客服");
                    return;
                }
                System.out.println("密码输入错误,还有" + (3 - i) + "次机会,请重新输入:");
            }
        }
    }

    public static void Register(ArrayList<User> list) {    //要判断就要传入集合不然下面用不了
        Scanner sc = new Scanner(System.in);
        String username;  //在循环外面可以后面一起存进仓库
        System.out.println("选择注册"); //注册需要用户名和密码

        while (true) {
            System.out.println("请输入用户名:");
            username = sc.next();
            //需要有三个判断,使用if,而且失败就要一直重新输入
            // 1.先判断长度(在判断密码时也需要再使用,所以写成方法,然后使用方法即可)
            // 2.再判断格式(在判断密码时也需要再使用,所以也可写成方法,然后使用方法即可)
            // 3.再判断是否重复
            if (!StringLong(username, 3, 16)) {         //不满足才输出
                System.out.println("用户名长度必须在3~16位之间,请重新输入:");
                continue;   //直接下一次循环
            } else if (!UserNameFormat(username)) {               //不满足才输出这句
                System.out.println("用户名只能是字母加数字,不能是纯数字和其他字符,请重新输入:");
                continue;
            } else if (IsUnique(username, list)) {       //满足相等就输出
                System.out.println("用户名不是唯一的,请重新输入:");
                continue;
            }
            //若通过三次判断则要跳出循环
            break;
        }

        //写判断密码的创建同理也需要while和三个判断
        //  1.密码长度必须8~12位
        //  2.密码只能是字母加数字的组合
        //  3.两次密码是否一致
        String password2;   //同理,第二次正确即可存入集合,所以要放循环外面
        while (true) {
            System.out.println("请输入密码:");
            String password1 = sc.next();
            if (!StringLong(password1, 8, 12)) {
                System.out.println("密码长度必须在8~12位之间,请重新输入:");
                continue;
            } else if (!PassWordFormat(password1)) {  //这里判断密码格式方法需要再写一遍
                System.out.println("密码只能是字母加数字的组合,请重新输入:");
                continue;
            }
            while (true) {
                System.out.println("请再次输入密码:");
                password2 = sc.next();
                if (!password1.equals(password2)) {
                    System.out.println("两次密码不一致,请重新输入:");
                    continue;
                } else {
                    System.out.println("注册成功啦~~");
                    break;
                }
            }
            break;
        }
        //将数据封装
        User u = new User(username, password2);
        //传入集合
        list.add(u);
    }

    //判断长度  需要传入输入的字符串,然后传入限制长度的数据
    public static boolean StringLong(String username, int min, int max) {
        return min <= username.length() && username.length() <= max;  //符合条件返回true
    }

    //判断账户格式  需要传入输入的字符串,使用计数器的方法来判断里面的格式,又因为计数器中密码也需要使用,再抽取计数器方法
    public static boolean UserNameFormat(String username) {
        int arr[] = Cnt(username);    //需要有数组来接收返回值
        return (arr[0] > 0 && arr[1] > 0 && arr[2] == 0) || (arr[1] > 0 && arr[0] == 0 && arr[2] == 0);    //格式之前返回true
    }

    //计数器方法,因为需要返回很多值,所以需要使用数组返回,后面在具体取出数组的值即可
    public static int[] Cnt(String username) {   //传入字符串才能统计,需要判断字母,数字,其他
        int cntnumber = 0;
        int cntletter = 0;
        int cntother = 0;
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if (c >= '0' && c <= '9') {
                cntnumber++;
            } else if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                cntletter++;
            } else {
                cntother++;
            }
        }
        return new int[]{cntnumber, cntletter, cntother}; //需要使用数组返回,后面在具体取出数组的值即可
    }

    //判断用户名是否唯一,需要传入集合和username才能判断
    public static boolean IsUnique(String username, ArrayList<User> list) {
        //遍历集合看有无重复,注意!!!这个集合的泛型因为没有重写tostring()方法所以取值需要用get取
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    //判断密码格式
    public static boolean PassWordFormat(String password) { //一样传入密码字符串
        int arr[] = Cnt(password);    //需要有数组来接收返回值
        return arr[0] > 0 && arr[1] > 0 && arr[2] == 0;    //格式之前返回true
    }

    //生成验证码
    public static String CreateCode() {      //要使用stringbuilder拼接字符串 先生成4个字母再随机插入数字
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        ArrayList<Character> list = new ArrayList<>();    //创建集合存放大小写字母然后再随机取出
        for (int i = 0; i < 26; i++) { //存放大小写字母
            list.add((char) ('a' + i));
            list.add((char) ('A' + i));
        }
        for (int i = 0; i < 4; i++) {
            sb.append(list.get(r.nextInt(list.size())));
        }
        sb.insert(r.nextInt(sb.length()+1), r.nextInt(10));    //插入应该是sb的长度,不应该是list的长度
        return sb.toString();
    }

    //寻找密码索引
    public static int FindIndex(String username, ArrayList<User> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername().equals(username)) {
                return i;
            }
        }
        return -1;
    }
}
