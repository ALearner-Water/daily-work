public class Test2 {
    public static void main(String[] args) {
        //调用
        goSwimming(new Swim() {
            @Override
            public void swim() {
                System.out.println("youyong");
            }
        });
        Student s = new Student() {
            @Override
            public void swim() {
                System.out.println("youyong");
            }
        };
            goSwimming(s);

            Swim s1 = new Swim() {
                @Override
                public void swim() {       //还可以直接使用swim接口写内部类，就可以少定义一个stuent类
                    System.out.println("youyong");
                }
            };
            goSwimming(s1);
        }
        public static void goSwimming(Swim s) { s.swim(); }
}
