import java.util.*;

public class Main {
    static int K;
    static int[] a;
    static List<List<Integer>> lv;

    static void node(int dep, int l, int r) {
        if (l > r) return;
        int m = (l + r) / 2;
        lv.get(dep).add(a[m]);
        node(dep + 1, l, m - 1);
        node(dep + 1, m + 1, r);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        int n = (1 << K) - 1;
        a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        lv = new ArrayList<>();
        for (int i = 0; i < K; i++) lv.add(new ArrayList<>());
        node(0, 0, n - 1);
        for (List<Integer> row : lv) {
            for (int x : row) System.out.print(x + " ");
            System.out.println();
        }
    }
}
