public class Throw {
     public static void main(String[] args){
         int arr[]={};
         System.out.println(getmax(arr));
     }
     public static int getmax (int arr[]){
         //保持代码健壮性需要写异常处理
         if(arr.length==0){
             throw new RuntimeException("数组不能为空");  //使用throw抛出异常,再来进行下一步操作
         }
         if(arr.equals( null)){
             throw new RuntimeException("数组不能为空");
         }
         int max=arr[0];
         for (int i = 0; i < arr.length; i++) {
             if(arr[i]>max){
                 max=arr[i];
             }
         }
         return max;
     }
}
