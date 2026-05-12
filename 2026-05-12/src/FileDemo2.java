import java.io.File;

public class FileDemo2 {
    public static void main(String[] args) {
        File f1 = new File("D:\\53507");
        //file常见成员方法(判断相关)
        //1.判断文件夹是否存在   f1.isDirectory()
        //2.判断文件是否存在   f1.isFile()
        //3.判断文件是否存在   f1.exists()

        //是否为文件夹
        System.out.println(f1.isDirectory());//true
        //是否为文件
        System.out.println(f1.isFile());
        //是否存在
        System.out.println(f1.exists());

        File f2 = new File("D:\\53507\\a.txt");
        //file常见成员方法(获取相关)
        //1.获取文件长度  f2.length(),只能获取文件,不能获取文件夹
        System.out.println(f2.length());

        //2.获取文件绝对路径  f2.getAbsolutePath()
        System.out.println(f2.getAbsoluteFile());

        //3.获取文件名  f2.getName() 如果获取的是文件的名字,则有后缀名,如果获取的是文件夹的名字,则没有后缀名
        System.out.println(f2.getName());
        System.out.println(f1.getName());

        //4.获取最后修改时间  f2.lastModified()
        System.out.println(f2.lastModified());  //毫秒数


    }
}
