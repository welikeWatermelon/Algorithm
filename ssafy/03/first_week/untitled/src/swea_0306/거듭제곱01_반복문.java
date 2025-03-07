package swea_0306;

public class 거듭제곱01_반복문 {
    public static void main(String[] args) {

    }





    // C :
    // N :
    // 음수승은 구할 수 없음
    static int pow(int C, int N) {
        int result = 1;
        for (int i = 1; i <= N; i++) {
            result *= C;
        }
        return result;
    }

    static int pow2(int C, int N) {
        if (N == 1) {
            return C;
        }
        return C * pow2(C, N - 1);
    }
}
