package EnumTest;

public class Test1 {
    public static void main(String[] args){
        /*电商有六种状态
        1.待支付
        2.处理中
        3.已发货
        4.已送达
        5.已取消
         */
        /*可以先写JavaBean类再改成枚举类*/
        //所有枚举类前面都是public staticfinal修饰，所以直接用枚举类名.枚举值调用

        OrderState o1=OrderState.PROCESSING; //直接用enum举类名调用
        System.out.println(o1);//能直接打印o1,因为enum能自动写toString方法把o1地址转成名字
        System.out.println(o1.getName()); //使用getname导出o1的值

        //获取后就要匹配
        switch (o1) {
            case PAYMENT_PENDING -> System.out.println("待支付状态");
            case PROCESSING -> System.out.println("处理中状态");
            case SHIPPED -> System.out.println("已发货状态");
            case DELIVERED -> System.out.println("配送中状态");
            case CANCELED -> System.out.println("已送达状态");
            default -> System.out.println("无效状态");
        }
            OrderState1 o2=OrderState1.k1;
            System.out.println(o2);
            System.out.println(o2.getName());
    }
}
