package Test2;

public class Nember extends Thread {
    private static int number = 1;

    public Nember(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            synchronized (Nember.class) {
                if (number > 100) {
                    break;
                } else {
                    if (number % 2 != 0) {
                        System.out.println(getName() + "输出:" + number);
                    }
                    number++;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
