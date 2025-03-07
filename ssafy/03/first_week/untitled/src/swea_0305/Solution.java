package swea_0305;

import java.util.Scanner;

public class Solution {

    // n 의 k 제곱
    public static int pow(int n, int k){
        // k == 0 이었을 때 1 반환
        if(k == 0){
            return 1;
        }
        if(k % 2 == 0)
        // k 짝수 였을 때 (n*n) ^ (k/2)
            return pow(n * n, k / 2);
        else
            // k 홀수 였을 때 (n*n) ^ ((k-1)/2) * n
            return pow(n * n , (k - 1) / 2) * n;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int answer = 0;
            //이진수로 표현
            int i = 0;
            while(M!=0){
                answer += M%2 * pow(10,i);
                M/=2;
                i++;
            }

            // 뒤의 N 자리에서 0이 있는지 판단
            boolean flag = true;
            for(i=0; i<N; i++){
                if(answer %10==0){
                    flag = false;
                    break;
                }
                answer/=10;
            }

            if (flag) {
                System.out.printf("#%d %s\n", t, "ON");
            } else {
                System.out.printf("#%d %s\n",t,"OFF");
            }
        }
    }
}
