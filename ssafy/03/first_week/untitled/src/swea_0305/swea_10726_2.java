package swea_0305;

import java.util.Scanner;

public class swea_10726_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int tmp = (1<<N)-1;

            if ((M&tmp)==tmp) {
                System.out.printf("#%d %s\n", t, "ON");
            } else {
                System.out.printf("#%d %s\n",t,"OFF");
            }
        }
    }
}
