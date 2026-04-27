import java.util.ArrayList;

public class ArraysListTest1 {
    public static void main(String[] args){
        //定义集合添加数字进行遍历
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        //遍历(get+size)
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            if(i<list.size()-1) {
                System.out.print(list.get(i)+",");
            }else{
                System.out.print(list.get(i)+"]");
            }
        }
        System.out.println();
        System.out.println(list);
    }
}
