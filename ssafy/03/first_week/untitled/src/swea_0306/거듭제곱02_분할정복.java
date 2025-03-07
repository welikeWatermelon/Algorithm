package swea_0306;

public class 거듭제곱02_분할정복 {
    public static void main(String[] args) {
        System.out.println(pow(2,1));
    }


    static int pow(int C, int N) {
        //기저 조건
        if (N == 0) {
            return 1;
        }

        //재귀 부분 ( 1. 홀수 2. 짝수 )
        // 1. 홀수
        if (N % 2 == 1) {
            return pow(C,(N-1)/2) * pow(C, (N - 1)/2) * C;
        } else {
            return pow(C, N / 2) * pow(C, N / 2);
        }
    }


    // C는 숫자
    // N은 반복
    static int pow2(int C, int N) {
        //기저 조건
        if (N == 0) {
            return 1;
        }

        //재귀 부분 ( 1. 홀수 2. 짝수 )
        // 1. 홀수
        if (N % 2 == 1) {
            int tmp = pow2(C, (N - 1) / 2);
            return tmp * tmp * C;
        } else {
            int tmp = pow(C, N / 2);
            return tmp * tmp;
        }
    }
}
