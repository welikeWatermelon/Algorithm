package swea_0306;

import java.util.Scanner;

public class swea_1217 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int t = 1; t <= 10; t++) {
            int T = sc.nextInt();
            int N = sc.nextInt();
            int M = sc.nextInt();


            System.out.printf("#%d %d\n",t,DFS(N,M));
        }
    }

    public static int DFS(int N, int M) {
        if (0 == M) {
            return 1;
        }
        if (M % 2 == 0) {
            int tmp = DFS(N, M / 2);
            return tmp * tmp;
        } else {
            int tmp = DFS(N, (M - 1) / 2);
            return tmp * tmp * N;
        }
    }
}
