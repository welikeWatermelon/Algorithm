import java.util.*;

public class Main {
    static int[] pre;
    static int n;
    static int idx = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }
        sc.close();

        n = list.size();
        pre = new int[n];
        for (int i = 0; i < n; i++) pre[i] = list.get(i);

        dfs(Long.MIN_VALUE, Long.MAX_VALUE);
        System.out.print(sb.toString());
    }

    static void dfs(long low, long high) {
        if (idx >= n) return;
        int val = pre[idx];
        if (val <= low || val >= high) return;
        idx++;
        dfs(low, val);
        dfs(val, high);
        sb.append(val).append('\n');
    }
}
