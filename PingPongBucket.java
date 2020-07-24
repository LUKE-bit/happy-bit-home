import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PingPongBucket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            boolean flag = false;
            char[] arr1 = sc.next().toCharArray();
            char[] arr2 = sc.next().toCharArray();
            Map<Character,Integer> map1 = new HashMap<>();
            Map<Character,Integer> map2 = new HashMap<>();
            for (int i = 0;i < arr1.length;i++) {
                if (!map1.containsKey(arr1[i])) {
                    map1.put(arr1[i],1);
                }else map1.put(arr1[i],map1.get(arr1[i]) + 1);
            }
            for (int i = 0; i < arr2.length;i++) {
                if (!map2.containsKey(arr2[i])) {
                    map2.put(arr2[i],1);
                }else map2.put(arr2[i],map2.get(arr2[i]) + 1);
            }
            for (int i = 0;i < arr2.length;i++) {
                if (map1.containsKey(arr2[i]) && map2.get(arr2[i]) <= map1.get(arr2[i])) {
                    flag = true;
                }else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("Yes");
            }else System.out.println("No");
        }
    }
}
