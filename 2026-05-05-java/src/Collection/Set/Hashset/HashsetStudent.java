package Collection.Set.Hashset;

import java.util.Objects;

public class HashsetStudent {
    private int age;
    private String name;

    public HashsetStudent() {

    }

    public HashsetStudent(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        HashsetStudent that = (HashsetStudent) o;
        return age == that.age && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    @Override
    public String toString() {
        return "HashsetStudent{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
