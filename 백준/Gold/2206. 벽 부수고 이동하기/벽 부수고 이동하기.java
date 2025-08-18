import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited; // [x][y][벽을 부쉈는지 여부]
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M][2]; // 0: 안 부숨, 1: 부쉈음

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 1, 0}); // x, y, 이동횟수, 벽부순횟수
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dist = cur[2], broken = cur[3];

            if (x == N - 1 && y == M - 1) {
                return dist;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 벽이 아니고 방문 안 했을 때
                // 벽 만나면 알아서 돌아감
                if (map[nx][ny] == 0 && !visited[nx][ny][broken]) {
                    visited[nx][ny][broken] = true;
                    q.offer(new int[]{nx, ny, dist + 1, broken});
                }

                // 벽인데 아직 안 부쉈을 때
                // 벽을 부쉈을때랑, 부시지 않았을 때를 다르게 생각하고 행동
                if (map[nx][ny] == 1 && broken == 0 && !visited[nx][ny][1]) {
                    visited[nx][ny][1] = true;
                    q.offer(new int[]{nx, ny, dist + 1, 1});
                }
            }
        }

        return -1;
    }
}
