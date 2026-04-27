import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArraysListTest2 {
    public static void main(String[] args){
        //创建集合
        ArrayList<Student> list=new ArrayList<>();  //集合的类型是学生
        //添加元素
        Student s1=new Student("32409100017","hyh",19);
        Student s2=new Student("32409100018","hh",12);
        Student s3=new Student("32409100019","hhy",13);
        Student s4=new Student("32409100020","hhh",14);
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        //遍历集合
        for (int i = 0; i < list.size(); i++) {
            System.out.println("年龄: "+list.get(i).getAge()+" id: "+list.get(i).getId()+" 姓名: "+list.get(i).getName());
        }
        Scanner sc=new Scanner(System.in);
        System.out.print("请输入要查找的学号: ");
        String id = sc.next();
        System.out.println(searchid(id,list));
    }
    //定义方法查找学生信息
    public static int searchid(String id, ArrayList<Student> list){ //需要传入id和集合,负责里面没有集合无法判断
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
}
