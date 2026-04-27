public class Student {
    private String id;
    private String name;
    private int age;

    public Student() {
    }
    public Student(String id, String name, int age) {
        this.age = age;
        this.id = id;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
