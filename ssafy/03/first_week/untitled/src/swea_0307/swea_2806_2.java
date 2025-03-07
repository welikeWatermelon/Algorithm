//package swea_0307;
//
//import java.util.Scanner;
//
//public class swea_2806_2 {
//    public static int[][] track;
//    public static int N, cnt;
//    public static int[] queen;
//    public static boolean[] check;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        for (int t = 1; t <= T; t++) {
//            N = sc.nextInt();
//            queen = new int[N];
//            check = new boolean[N];
//
//            }
//        }
//
//
//    //8방향이 아니라 처음부터 시작해서 위의 세방향만 검사하면 됨 -> 다음에 풀어볼 것
//    //행으로 진행
//
//
//    public static void bt(int depth) {
//        //종료 조건
//        if (depth == N) {
//            return;
//        }
//
//        for(int i=0 ;i<N; i++){
//            if (!check[i]) {
//                queen[]
//                check[i] = true;
//                bt(depth + 1);
//                check[depth] = false;
//            }
//        }
//
//    }
//}
//
