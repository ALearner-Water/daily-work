package JavaBean;

import java.util.Random;

public class User {
    private String id;  //id随机分配不需要构造,不需要set get方法
    private String username;    //所以最后只需写两个变量即可,
    private String password;
    private boolean state;  //同理,不需要外部输入状态,需要set get方法

    public User(){
        id=CreateId();
        state=true;//在空参这里也需要提前把id值赋好
    }
    public User( String username,  String password) {
        id=CreateId();
        this.password = password;
        state=true;
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    //写方法随机创建id
    public static String CreateId(){
        Random r=new Random();
        //需要使用stringbuilder来拼接字符串返回
        StringBuilder sb=new StringBuilder("hyh");
        for (int i=0;i<7;i++) { //再拼7个数字
            int random=r.nextInt(10);
            sb.append(random);
        }
        return sb.toString();
    }

}
