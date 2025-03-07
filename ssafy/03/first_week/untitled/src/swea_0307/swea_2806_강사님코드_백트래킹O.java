package swea_0307;

public class swea_2806_강사님코드_백트래킹O {

    public static void main(String[] args) {
        int N = 4;

        // 4-Queen 배치를 진행해서 경우의 수를 카운트...!
        cnt = 0;
        int[] board = new int[N];
        boolean[] visited = new boolean[N];
        nQueenProblemSolve2(board, N, visited, 0);
    }

    static int cnt;
    // 백트래킹 = 모든 조건을 확인하는 경우 + 가지치기(pruning)
    // *가지치기(pruning): 유망하지 않은 경우(0%확률로 떨어지는 경우)를 제외하면서 탐색하는 방법
    // N=4, 가지치기 (92가지)
    private static void nQueenProblemSolve2(int[] board, int N, boolean[] visited, int depth) {
        // 가지치기 조건 (대각선 영역에 기존 depth-1위치에 놓여져 있는 퀸이 대각선 영역을 서로 교차하는지)
        if (0 < depth) {
            // 가장 최근에 놓은 퀸의 위치 (depth-1, board[depth-1])
            // 이전까지 놓여져 있는 퀸들과의 위치 대각선으로 겹치는가...!
            for (int i = 0; i < depth - 1; i++) {
                if (Math.abs(i - (depth - 1)) == Math.abs(board[i] - board[depth - 1])) {
                    return;
                }
            }
        }
        // 기저조건 (종료조건)
        // N개의 퀸을 배치하고 난 이후 종료!
        if (N == depth) {
            // 모든 퀸이 영역이 겹치지 않는 경우...!
            cnt++;
            return;
        }

        // 현재 depth줄에서 퀸을 배치 시도...!
        // board[depth] = 0~N-1; // (depth, 0~N-1)
        for (int i = 0; i < N; i++) {
            // 방문체크를 진행
            if (!visited[i]) {
                visited[i] = true; // 방문 표시
                board[depth] = i; // 하나의 퀸을 (depth, i) 배치
                nQueenProblemSolve2(board, N, visited, depth + 1);
                visited[i] = false;
            }
        }
    }

    // 모든 경우의 수를 체크하여서 N퀸 배치가 가능한지...!
    // N=4, 4*4*4*4 = 256가지...! O(N^N)
    private static void nQueenProblemSolve1(int[] board, int N, int depth) {

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
//				for(int i = 0; i < N; i++) {
//				for(int j = i + 1; j < N; j++) {
//					// (i, board[i]), (j, board[j])
//					if(j - i == board[j] - board[i])
//						// 영역이 겹치는 케이스!
//						return;
//					}
//				}
//			}
                //
//			// 퀸의 배치가 역대각선 ↙
//			for(int i = 0; i < N; i++) {
//				for(int j = i + 1; j < N; j++) {
//					// (i, board[i]), (j, board[j])
//					if(i - j == board[j] - board[i])
//						// 영역이 겹치는 케이스!
//						return;
//					}
//				}
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
            nQueenProblemSolve1(board, N, depth + 1);
        }
    }

}
