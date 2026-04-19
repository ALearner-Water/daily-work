import java.sql.SQLOutput;

public class Test {
    public static void main(String[] args){
        //要在测试类中调用goswimming方法
        //需要再创建一个类先实现接口，然后再创建对象然后再赋值
        //goSwimming(new Student());
        //但是只需要写一次时重写一个类太浪费了
        //匿名内部类就是可以少写一个类但是保留里面代码
        /*格式: new 类名/接口名(){
         重写方法}
         内部定义格式=没有名字的java类+继承/实现+重写方法+创建对象   其实是没有名字的java类的对象
         */

        /*没有名字的类 是大括号
        Swim是没有名字的类实现的接口
        new关键字作用是后面没有名字的java类,创建了它的对象


        整体: 创建了一个swim实现类对象，只不过没有名字
         */

        goSwimming(new Swim(){  //1:可以把内部类直接放在方法里面
            @Override
            public void swim() {
                System.out.println("学生A在游泳");
            }
        });


        Swim s=new Swim(){  //2:还可以直接赋值给swim变量
            @Override
            public void swim() {
                System.out.println("学生B在游泳");
            }
        };  //要加分号
        goSwimming(s);  //然后再赋给方法

    }
    public static void goSwimming(Swim s){
        s.swim();
    }
}
