import java.util.*;

public class Main {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        int[][] arr = new int[N][M];
        boolean[][] visited = new boolean[N][M]; // 방문 여부 체크

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(N, M, arr));
    }

    public static int bfs(int N, int M, int[][] arr) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1}); // {x좌표, y좌표, 현재까지 거리}
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0], y = now[1], dist = now[2];

            // 도착지점 도달하면 최단 거리 반환
            if (x == N - 1 && y == M - 1) {
                return dist;
            }

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (arr[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.add(new int[]{nx, ny, dist + 1});
                        visited[nx][ny] = true; // 방문 표시
                    }
                }
            }
        }

        return -1; // 도달 불가능한 경우
    }
}
