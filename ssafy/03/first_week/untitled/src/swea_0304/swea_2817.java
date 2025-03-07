package swea_0304;

import java.util.Scanner;

public class swea_2817 {
    public static int answer,sum,N,K;

    public static void DFS(int i,int sum, int[] arr) {
        if (sum == K) {
            answer++;
            return ;
        }
        if (i >= N) {
            return ;
        } else {
            DFS(i+1,sum+arr[i],arr); //넣는거
            DFS(i + 1, sum,arr);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            answer=0;
            sum=0;
            N = sc.nextInt();
            int K = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            DFS(0,0,arr);
            System.out.println(answer);
        }
    }
}
