import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] B = new int[N + 1]; 
        int[] A = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            B[i] = sc.nextInt();
        }

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            A[i] = B[i] * i - sum;
            sum += A[i];
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(A[i] + " ");
        }
    }
}
