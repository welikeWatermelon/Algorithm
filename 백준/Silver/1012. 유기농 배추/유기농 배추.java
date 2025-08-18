import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static int[][] arr;
    public static boolean[][] checked;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            M = sc.nextInt();
            int K = sc.nextInt();

            arr = new int[N][M];
            checked = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                int cal = sc.nextInt();
                int row = sc.nextInt();
                arr[cal][row] = 1;
            }

            int cnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == 1 && !checked[i][j]) {
                        DFS(i, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    //연결된 배추 찾기
    public static void DFS(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && ny>=0 && nx<N && ny<M
                    && arr[nx][ny]==1 && !checked[nx][ny]){
                checked[nx][ny] = true;
                DFS(nx, ny);
            }
        }
    }
}
