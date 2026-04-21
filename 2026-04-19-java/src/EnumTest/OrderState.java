package EnumTest;
//按JavaBean写可以在外部创建对象，但我们只需要在内部创建即可，所以使用enum

public enum OrderState {
    //在第一行把对象罗列出来 第一行必须是枚举类名
    PAYMENT_PENDING("待支付"),//变量名加赋值名
    PROCESSING("处理中"),
    SHIPPED("已发货"),
    DELIVERED("已送达"),
    CANCELED("已取消");;

    private String name;    //只有六种状态。

    //是默认的private，可省略不写
    private OrderState(String name){this.name =name;}   //必须是private，不能是其他，因为不需要外部修改变量

    public String getName() { return name; }    //只需要getname,因为不用修改数据
}
