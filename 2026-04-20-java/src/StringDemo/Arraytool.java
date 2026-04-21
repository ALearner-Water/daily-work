package StringDemo;

public class Arraytool {
    private Arraytool(){};
    public static void array(int arr[]) {
        String str = "[";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i];
            if (i < arr.length - 1) {
                str += ",";
            } else {
                str += "]";
            }
        }
        System.out.println(str);
    }
}
