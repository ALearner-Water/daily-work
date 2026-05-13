import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;

public class FileDemo4 {
    public static void main(String[] args) {
        //获取并便利
        File f = new File("D:\\53507\\daily-work\\2026-05-12");
        File[] files = f.listFiles();   //用数组来存储子文件夹里面的路径
        for (File file : files) {
            System.out.println(file);
        }
        //获取盘符  是一个静态方法
        File[] files1 = File.listRoots();   //获取电脑上有的硬盘
        System.out.println(Arrays.toString(files1));    //将数组转成字符串

    }
}
