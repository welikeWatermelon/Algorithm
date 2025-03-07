package swea_0304;

import java.util.Scanner;

public class swea_1949 {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int longRoad, height,N,K,maxTrail,mx;
    public static int[][] map;
    public static boolean[][] knockknock;


    public static void DFS(int x, int y,int height, int longRoad, int cnt){
        maxTrail = Math.max(longRoad, maxTrail);
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || knockknock[nx][ny]) { //종료 조건
                continue;
            }
            if (height > map[nx][ny]) { //작으면 진행
                knockknock[nx][ny] = true;
                DFS(nx, ny, map[nx][ny], longRoad + 1, cnt);
                knockknock[nx][ny] = false;
            } else if(cnt == 0 && height> map[nx][ny]-K){ // 큰데, 깎을만 하면 진행
                int original = map[nx][ny];
                map[nx][ny] = height-1;
                knockknock[nx][ny] = true;
                DFS(nx, ny, height - 1, longRoad + 1, 1);
                knockknock[nx][ny] = false;
                map[nx][ny] = original;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt(); // 한변의 길이
            K = sc.nextInt(); // 최대 공사 가능 깊이
            // 지형은 1보다 작게도 가능함 (-도 가능)

            //높은 지형에서 낮은 지역으로 가야함

            map = new int[N][N];
            knockknock = new boolean[N][N];
            longRoad = 0;
            height = 0;

            mx = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                    mx = Math.max(map[i][j], mx);
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j]==mx){ //이제부터 DFS 시작
                        knockknock[i][j] = true;
                        DFS(i,j,mx,1,0);
                        knockknock[i][j] = false;

                    }
                }
            }

            System.out.println(maxTrail);

        }
    }
}
