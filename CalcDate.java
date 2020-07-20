import java.util.Scanner;

public class CalcDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();
            System.out.println(dayOut(year,month,day));
        }
    }

    private static int dayOut(int year, int month, int day) {
        int[] days = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        int sum = 0;
        if (year <= 0 || month > 12 || month <= 0 || day <= 0 || day > days[month - 1]) return -1;
        if (year % 400 == 0 || (year % 4 ==0 && year % 100 != 0)) {
            days[1] = 29;
        }
        for (int i = 0;i < month - 1;i++) {
            sum += days[i];
        }
        return sum + day;
    }
}
