package swea_0306;

import java.util.Scanner;

public class swea_2817 {
    public static int[] arr;
    public static int N,K,cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            K = sc.nextInt();
            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            cnt = 0;
            DFS(0, 0);

            System.out.printf("#%d %d\n",t,cnt);
        }
    }

    public static void DFS(int depth, int sum){
        //종료 조건
        if (depth == N) {
            if (sum == K) {
                cnt++;
            } return;
        }

        if(sum>K) return;


        DFS(depth + 1, sum + arr[depth]);
        DFS(depth + 1, sum);

    }
}
