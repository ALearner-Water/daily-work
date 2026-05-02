package JavaBean;

import java.util.Random;

public class User {
    //属性: id，账号，密码，状态(是否登陆成功)
    private String id;  //用户无法直接设置,系统自动生成,所以就要写一个方法来自动生成idheima+5个随机数(stringbuilder)
    private String account;
    private String password;
    private boolean isLogin;    //默认值是false（所以需要修改成true才能使程序进行）

    public User() {
        //空参里面也需要修改
        id=createId();
        //修改islogin状态
        isLogin=true;
    }
    public User(String account, String password) {
        this.account = account;
        id=createId();     //直接生成,set get方法也不需要
        //this.isLogin = isLogin;   这里面也不需要构造
        isLogin=true;   //直接修改  需要get set方法
        this.password = password;
    }
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogin() {  //布尔的get方法是is开头的
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    //随机生成id
    public static String createId(){
        StringBuilder sb=new StringBuilder("idheima");
        //生成随机数
        Random r=new Random();
        for (int i=0;i<5;i++) {
            int num=r.nextInt(10);  //0~9之间
            sb.append(num);
        }
        return sb.toString();
    }
}
