import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] next = new int[N];
        for (int i = 0; i < N; i++) {
            next[i] = sc.nextInt();
        }

        boolean[] visited = new boolean[N];
        int cur = 0;
        int steps = 0;

        while (!visited[cur]) {
            if (cur == K) {
                System.out.println(steps);
                return;
            }
            visited[cur] = true;
            cur = next[cur];
            steps++;
        }

        System.out.println(-1);
    }
}
