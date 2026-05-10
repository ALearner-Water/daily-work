public class TryCatch {
    public static void main(String[] args) {
        /*try{
        写可能异常的代码
        }
        catch(Exception e){
        捕获异常的代码,并进行下一步操作
        }
         */
        int arr[] = {1, 2, 3, 4, 5};
        try {
            System.out.println(arr[0]);
            System.out.println(arr[10]);                                    //此处出现异常,则会在此处创建ArrayIndexOutOfBoundsException对象
            System.out.println(arr[4]);     //这里会直接跳转,不会执行这里的代码     //new ArrayIndexOutOfBoundsException();
                                            //再与catch里面的类型进行对比,匹配成功则执行catch里面的代码
                                            //执行完catch里面的代码,还可以接着执行下面的代码
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());;    //有返回值
            System.out.println(e.toString());       //有返回值
            e.printStackTrace();                    //无返回值
        }
        System.out.println("程序结束");
    }
}
