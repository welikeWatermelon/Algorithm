import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 시각(0~23)
        int S = sc.nextInt(); // 술 여부(0: 안 마심, 1: 마심)

        int result = (T >= 12 && T <= 16 && S == 0) ? 320 : 280;
        System.out.println(result);

        sc.close();
    }
}