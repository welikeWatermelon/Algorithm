package swea_0307;

import java.util.Arrays;

public class day11_부분집합조합순열정리 {
    /*
     * 부분집합(powerset) : 집합A에 대해서 모든 가능한 하위 집합. 원소를 포함하거나(1), 포함하지 않거나(0)...!
     * 조합(combination) : 순서에 상관없이 집합A의 일부분을 선택. n개 원소 중에서 r개를 순서 없이 선택 == nCr
     * 순열(permutation) : 순서 있게 집합A의 일부분을 선택. n개의 원소 중에서 r개를 순서 있이 선택 == nPr
     */

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        int N = arr.length;
        // 부분집합 생성
        System.out.println();
        System.out.println();
        int[] bits = new int[N];
        System.out.println("=================부분집합=================");
        System.out.println();
        powerset(arr, bits, N, 0);

//        // 조합의 경우의 생성
//        // 조합의 결과 result
//        // 조합에 다음 선택 인덱스 s
//        System.out.println();
//        System.out.println();
//        System.out.println("=================조합의 경우=================");
//        System.out.println();
//        int[] result = new int[N];
//        nCr(arr, N, result, 2, 0); // 2개를 선택하는 조합의 경우
//
//        // 순열을 경우의 수를 생성
//        System.out.println();
//        System.out.println();
//        System.out.println("=================순열의 경우=================");
//        System.out.println();
//        boolean[] visited = new boolean[N];
//        nPr(arr, N, visited, result, 2, 0);
    }

    /**
     * 순열(permutation)을 생성하는 함수
     *
     * @param arr     원본 배열
     * @param N       원본 배열의 요소 갯수
     * @param visited 방문체크를 하기 위한 배열
     * @param result  순열 결과를 저장할 배열
     * @param r       선택할 원소의 갯수
     * @param depth   현재 재귀호출을 한 횟수(=현재 해당 원소 depth를 위치 인덱스)
     */
    private static void nPr(int[] arr, int N, boolean[] visited, int[] result, int r, int depth) {
        // 기저조건(종료조건)
        // r개 만큼의 원소를 뽑았을 때 종료...!
        if(depth == r) {
            // nPr 만큼 경우의 수를 이 안에서 테스트 가능
            System.out.println(Arrays.toString(result));
            return;
        }
        // 사용할 수 있는 모든 원소에 대해서 선택 시도
        for (int i = 0; i < N; i++) {
            // 해당 원소가 아직 사용되었는지 되지않았는지 체크 (방문체크)
            if (!visited[i]) { // 해당 i번째 원소가 사용되었는지 체크
                visited[i] = true; // 현재 i번째 원소를 사용으로 표시! (결정)
                result[depth] = arr[i]; // 현재 위치에 있는 요소의 값을 저장
                nPr(arr, N, visited, result, r, depth + 1);
                visited[i] = false; // || 해제! (복구)
            }
        }
    }

    /**
     * 조합을 생성하는 함수
     *
     * @param arr    선택할 원본 배열
     * @param N      원본 배열의 원소 갯수
     * @param result 조합의 결과를 저장할 배열
     * @param r      선택할 원소의 갯수
     * @param s      선택의 시작 인덱스
     */
    private static void nCr(int[] arr, int N, int[] result, int r, int s) {
        // 기저조건 (종료조건)
        // r개의 원소를 선택했을 때 종료...!
        if (r == 0) {
            System.out.println(Arrays.toString(result));
            return;
        }
        // 현재 위치 s -> N-1 선택 가능한 원소를 한번씩 선택하면서 다음 선택...!
        for (int i = s; i < N; i++) {
            result[r - 1] = arr[i]; // 현재 위치의 원소를 선택!
            nCr(arr, N, result, r - 1, i + 1); // 다음 위치 선택
        }
    }

    /**
     * 부분집합 (powerset)을 생성하는 함수 - 재귀방식
     *
     * @param arr
     * @param bits  해당 원소를 포함하는지 유무 (1 - 포함, 0 - x)
     * @param N
     * @param depth
     */
    private static void powerset(int[] arr, int[] bits, int N, int depth) {
        // 기저조건(종료조건)
        // 모든 원소를 선택하였을 때(=N개 만큼 선택을 완료하면) 종료...!
        if (depth == N) {
            // 현재 부분집합 출력
            // bits 값이 1인 원소들을 출력...!
            for (int i = 0; i < N; i++) {
                if (bits[i] == 1) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }
        // 현재 원소 depth를 포함하는 경우
        bits[depth] = 1;
        powerset(arr, bits, N, depth + 1);

        // 현재 원소 depth를 포함하지 않는 경우
        bits[depth] = 0;
        powerset(arr, bits, N, depth + 1);
    }
}
