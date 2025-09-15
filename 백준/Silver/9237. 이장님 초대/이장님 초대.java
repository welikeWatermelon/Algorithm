import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine().trim());
        st = new StringTokenizer(br.readLine());
        long[] t = new long[N];
        for (int i = 0; i < N; i++) {
            t[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(t); // 오름차순

        long maxDays = 0;
        for (int i = 0; i < N; i++) {
            long growTime = t[N - 1 - i];
            long dayToMature = growTime + (i + 1);  
            if (dayToMature > maxDays) {
                maxDays = dayToMature;
            }
        }

        long result = maxDays + 1;
        System.out.println(result);
    }
}
