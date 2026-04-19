package enumtest;

public enum OrderState1 {
    k1("你好"),
    k2("世界");
    private String name;

    OrderState1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
