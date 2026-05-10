public class NameFormatExcption extends RuntimeException{
    //写自定义异常类  空参和带参构造方法可自动生成

    public NameFormatExcption() {
    }

    public NameFormatExcption(String message) {
        super(message);
    }
}
