import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Tickets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int candidate = sc.nextInt();
            String[] name = new String[candidate];
            HashMap<String,Integer> a = new HashMap<String,Integer>();
            for (int i = 0;i < candidate;i++) {
                String person = sc.next();
                a.put(person,0);
                name[i] = person;
            }
            int voteNumber = sc.nextInt();
            Set<String> keys = a.keySet();
            int sum = 0;
            for (int i = 0;i < voteNumber;i++) {
                String ticket = sc.next();
                if (keys.contains(ticket)) {
                    a.put(ticket,a.get(ticket) + 1);
                }else {
                    sum++;
                }
            }
            for (int i = 0;i < candidate;i++) {
                System.out.println(name[i] + " : " + a.get(name[i]));
            }
            System.out.println("Invalid : " + sum);
        }
        sc.close();
    }
}
