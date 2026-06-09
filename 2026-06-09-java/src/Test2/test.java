package Test2;

public class test {
    public static void main(String[] args){
        Nember n1 = new Nember("线程1");
        Nember n2 = new Nember("线程2");
        n1.start();
        n2.start();
    }
}
