public class ArrayCombine {
    public static void arraycombine(int arr[]) {
        System.out.print("拼接后的字符串为: ");
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 1) {
                sb.append(arr[i] + ",");
            } else {
                sb.append(arr[i] + "]");
            }
        }
        System.out.println(sb.toString());
    }
}
