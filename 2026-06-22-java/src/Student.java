public class Student {
    /*    设计一个程序，对学生的学籍信息进行管理。通过该系统实现对学生基本信息的录入、保存、删除、修改、查询等操作。查询等操作*/
    /*        学生基本信息包括：学号、姓名、性别、年龄、班号、专业名称、系别等。*/

    //创建一个学生类，方便后续存储
    private String ID;
    private String name;
    private String sex;
    private int age;
    private String classNumber;
    private String major;
    private String department;

    public Student() {
    }

    public Student(int age, String classNumber, String department, String major, String name, String number, String sex) {
        this.age = age;
        this.classNumber = classNumber;
        this.department = department;
        this.major = major;
        this.name = name;
        this.ID = number;
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String number) {
        this.ID = number;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
