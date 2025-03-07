package swea_0306;

public class 우리강사님_분할정복 {
    public static void main(String[] args) {
        //반복 형태 x n 제곱
        int x = 2;
        int n = 10;

        pow1(n, x);

        // 분할정복 (재귀함수)
        
    }

    private static void pow1(int n, int x) {
        int result = 1;
        // n 번 만큼 반복해서 x를 곱하겠다.
        for (int i = 0; i < n; i++) {
            result *= x;
        }
    }


    // 재귀를 통한 거듭제곱 O(n)
    private static int pow2(int x, int n) {
        //기저 조건(종료 조건)
        if (n == 0) {
            return 1;
        }
        
        // 재귀함수를 통해서 점화식
        // f(x^n) = f(x^(n-1)) * x;
        return pow2(x,n-1) * x; //유도 조건
    }

    
    // 재귀를 통한 거듭제곱 O(logN)
    // 분할 정복을 통해 최적화
    // 점화식 C ^ n
    // n 이 짝수 : C ^ (n/2) * C ^ (n/2) 
    // n 이 홀수 : C ^ ((n-1)/2) * C ^ ((n-1)/2) * C
    private static int pow3(int x, int n) {
        //기저 조건(종료 조건)
        if (n == 0) {
            return 1;
        }

        if (n % 2 == 0) { //짝수이면
            int tmp = pow3(x,n/2);
            return tmp * tmp;
        } else {
            int tmp = pow3(x, (n - 1) / 2);
            return tmp * tmp * x;
        }
    }
}
