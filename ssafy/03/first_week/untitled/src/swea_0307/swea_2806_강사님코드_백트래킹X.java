package swea_0307;

public class swea_2806_강사님코드_백트래킹X {

    public static void main(String[] args) {
        int N = 4;

        // 4-Queen 배치를 진행해서 경우의 수를 카운트...!
        cnt = 0;
        int[] board = new int[N];
        nQueenProblemSolve(board, N, 0);
    }

    static int cnt;

    // 모든 경우의 수를 체크하여서 N퀸 배치가 가능한지...!
    private static void nQueenProblemSolve(int[] board, int N, int depth) {
        // 기저조건 (종료조건)
        // N개의 퀸을 배치하고 난 이후 종료!
        if (N == depth) {
            // 퀸의 배치가 영역이 서로 겹치는지를 확인...!
            // 퀸의 배치가 세로 영역에 대해서 겹치는지...
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (board[i] == board[j]) {
                        // 영역이 겹치는 케이스!
                        return;
                    }
                }

                // // 퀸의 배치가 정대각선 ↘
//			for(int i = 0; i < N; i++) {
//			for(int j = i + 1; j < N; j++) {
//				// (i, board[i]), (j, board[j])
//				if(j - i == board[j] - board[i])
//					// 영역이 겹치는 케이스!
//					return;
//				}
//			}
//		}
//
//		// 퀸의 배치가 역대각선 ↙
//		for(int i = 0; i < N; i++) {
//			for(int j = i + 1; j < N; j++) {
//				// (i, board[i]), (j, board[j])
//				if(i - j == board[j] - board[i])
//					// 영역이 겹치는 케이스!
//					return;
//				}
//			}
                // 퀸이 대각선 배치가 되어 있다...!
                for (i = 0; i < N; i++) {
                    for (int j = i + 1; j < N; j++) {
                        // (i, board[i]), (j, board[j])
                        if (Math.abs(i - j) == Math.abs(board[j] - board[i]))
                            // 영역이 겹치는 케이스!
                            return;
                    }
                }
            }
            // 모든 퀸이 영역이 겹치지 않는 경우...!
            cnt++;

            return;
        }

        // 현재 depth줄에서 퀸을 배치 시도...!
        // board[depth] = 0~N-1; // (depth, 0~N-1)
        for (int i = 0; i < N; i++) {
            board[depth] = i; // 하나의 퀸을 (depth, i) 배치
            nQueenProblemSolve(board, N, depth + 1);
        }
    }
}

// 최적화를 생각해보자
// 이거 다음이 백트래킹