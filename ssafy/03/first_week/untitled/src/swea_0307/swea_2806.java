//package swea_0307;
//
//import java.util.Scanner;
//
//public class swea_2806 {
//    public static int[][] track;
//    public static int N, cnt;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        for (int t = 1; t <= T; t++) {
//            N = sc.nextInt();
//            track = new int[N][N];
//            for (int i = 0; i < N; i++) {
//                track[i][0] = 1;
//                bt(i, 0);
//            }
//        }
//    }
//
//    //8방향이 아니라 처음부터 시작해서 위의 세방향만 검사하면 됨 -> 다음에 풀어볼 것
//
//    // 한 자리에 체크하면 그 행, 그 열, 그 대각은 가지 못함
//    // 1는 q자리
//    // 2는 불가능한 자리
//    // 0은 탐색 가능한 자리
//
//    public static void bt(int i, int j) {
//        //종료 조건
//        if (cnt == N) {
//            return;
//        }
//
//        if (track[i][j] == 0) {
//            track[i][j] = 1;
//            cnt++;
//            makeTwo(i, j);
//        } else { //1과 2일때 즉, 갈 수 없는 곳일 때
//            if (i + 1 < N - 1) {
//                bt(i + 1, j);
//            } else if (i + 1 == N - 1) {
//                bt(i + 1, j + 1)
//            }//track = 2 이면 그냥 조건에 안넣으면 됨
//
//        }
//    }
//
//
//
//
//    public static void makeTwo(int i, int j) {
//        //행 탐색
//        int a = 0;
//        while (a < N) {
//            if (track[a][j] == 1) {
//                continue;
//            }
//            track[a][j] = 2;
//            a++;
//        }
//
//        //열 탐색
//        int b = 0;
//        while (b < N) {
//            if (track[i][b] == 1) {
//                continue;
//            }
//            track[i][b] = 2;
//            b++;
//        }
//
//        //대각 탐색 (우아)
//        a = 1;
//        while (i + a < N && j + a < N) {
//            track[i + a][j + a] = 2;
//            a++;
//        }
//
//        //대각 탐색 (좌위)
//        a = 1;
//        while (i - a >= 0 && j - a >= 0) {
//            track[i - a][j - a] = 2;
//            a++;
//        }
//
//        // 행 줄고 열 올라감 (우위)
//        a = 1;
//        while (i - a >= 0 && j + a < N) {
//            track[i - a][j + a] = 2;
//            a++;
//        }
//
//        // 행 늘고 열 내려감
//        a = 1;
//        while (j - a >= 0 && i + a < N) {
//            track[i + a][j - a] = 2;
//            a++;
//        }
//    }
//
//
//}
