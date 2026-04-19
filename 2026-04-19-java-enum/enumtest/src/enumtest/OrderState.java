package enumtest;
//按JavaBean写可以在外部创建对象，但我们只需要在内部创建即可，所以使用enum

public enum OrderState {
    //在第一行把对象罗列出来
    PAYMENT_PENDING("待付款"), //变量名加赋值名
    PROCESSING("处理中"),
    SHIPPIED("已发货"),
    OUT_FOR_DELIVERY("配送中"),
    DELIVERED("已送达"),
    CANCELED("已取消");

    private String name;    //只有六种状态

    private OrderState(String name) {    //因为enum本质不允许外部创建变量，所以修饰要用private
        this.name = name;
    }

    public String getName() {   //不需要外部修改变量，所以不用setname
        return name;
    }
}
