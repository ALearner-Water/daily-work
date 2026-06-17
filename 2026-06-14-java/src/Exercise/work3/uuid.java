package Exercise.work3;

import java.util.UUID;

public class uuid {
    //可以使用uuid的静态方法来随机生成32位字符串,用来随机给文件命名
    public static void main(String[] args) {
        System.out.println(UUID.randomUUID());  //bdc2b7d0-1da5-4f39-9150-5b6767759a00
        //转成字符串然后再替换掉横杠
        System.out.println(UUID.randomUUID().toString().replace("-", ""));
       // 4957642571354635b3ed54ee64a63199
    }
}
