import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> cnt = new HashMap<>(N * 2);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int q = Integer.parseInt(st.nextToken());
            sb.append(cnt.getOrDefault(q, 0)).append(' ');
        }

        System.out.println(sb.toString().trim());
    }
}
