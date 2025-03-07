import java.util.Scanner;

public class swea_5656 {
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static int answer = 0;

    public static void DFSbricks(int nx, int ny, int[][] arr) {
        if (nx >= 0 && arr[nx][ny] != 0) {
            arr[nx + 1][ny] = arr[nx][ny];
            arr[nx][ny] = 0;
            DFSbricks(nx - 1, ny, arr);
        } else {
            return;
        }
    }

    public static void DFS(int x, int y,int n, int[][] arr) {
        int step = arr[x][y];
        for(int i=0; i<4; i++){
            for(int j=0; j<step; j++){
                for(int s=1; s<step; s++){
                    int nx = x + dx[i]*step;
                    int ny = x + dx[i]*step;
                    if (nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx][ny] != 0) {
                        answer++;
                        DFS(nx, ny, n, arr);
                        arr[nx][ny] = 0;
                        DFSbricks(nx - 1, ny, arr);
                    } else {
                        return;
                    }
                }
            }

        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            answer=0;
            int N = sc.nextInt();
            int W = sc.nextInt();
            int H = sc.nextInt();
            int[][] arr = new int[H][W];

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            for (int n = 0; n < N; n++) { //총 N번 진행
                for (int i = 0; i < W; i++) {
                    for (int j = 0; j < H; j++) {
                        if (arr[j][i] != 0) {
                            DFS(i, j, N,arr);
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
}

//1번 수헹이 끝날때마다 max값을 갱신해줘야하는데 못하는중
