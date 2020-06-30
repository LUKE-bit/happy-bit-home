import java.util.Scanner;

public class TheGradesPoints {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]coursePoints = new int[n];
        int[]grades = new int[n];
        double[]gradesPoints = new double[n];
        double totalPoints = 0;
        double GPA = 0;
        double totalCoursePoints = 0;
        for (int i = 0;i < n;i++) {
            coursePoints[i] = sc.nextInt();
        }
        for (int i = 0;i < n;i++) {
            grades[i] = sc.nextInt();
        }
        for (int i = 0;i < n;i++) {
            if (grades[i] >= 90) gradesPoints[i] = 4.0;
            else if (grades[i] >=85 && grades[i] <= 89) gradesPoints[i] = 3.7;
            else if (grades[i] >= 82 && grades[i] <= 84) gradesPoints[i] = 3.3;
            else if (grades[i] >=78 && grades[i] <= 81) gradesPoints[i] = 3.0;
            else if (grades[i] >= 75 && grades[i] <=77) gradesPoints[i] = 2.7;
            else if (grades[i] >=72 && grades[i] <= 74) gradesPoints[i] = 2.3;
            else if (grades[i] >= 68 &&grades[i] <= 71) gradesPoints[i] = 2.0;
            else if (grades[i] >= 64 && grades[i] <= 67) gradesPoints[i] = 1.5;
            else if (grades[i] >= 60 && grades[i] <= 63) gradesPoints[i] = 1.0;
            else gradesPoints[i] = 0.0;
        }
        for (int i = 0;i < n;i++) {
            double plus = gradesPoints[i] * coursePoints[i];
            totalPoints += plus;
            totalCoursePoints += coursePoints[i];
        }
        GPA = totalPoints/totalCoursePoints;
        System.out.printf("%.2f",GPA);
    }
}
