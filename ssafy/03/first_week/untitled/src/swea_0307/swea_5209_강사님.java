package swea_0307;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_5209_강사님  {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트케이스 수 T
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            // 입력
            // 제품의 갯수 N
            int N = Integer.parseInt(br.readLine().trim());
            // N * N 의 이차원 생산 비용 c
            int[][] c = new int[N][N];
            for (int i = 0; i < N; i++) {
                String[] temp = br.readLine().trim().split(" ");
                for (int j = 0; j < N; j++) {
                    c[i][j] = Integer.parseInt(temp[j]);
                }
            }

            // 로직
            // 최소생산비용 mnCost
            mnCost = 1500;
            boolean[] visited = new boolean[N];
            // 하나의 공장에 대해서 하나의 제품을 매칭하는 순열(경우의 수) 생성하기!
            solve(c, N, visited, 0, 0);

            // 출력
            System.out.println("#" + tc + " " + mnCost);
        }

    }

    static int mnCost;

    /**
     * 하나의 공장에 대해서 하나의 제품을 생산하는 최소비용을 계산하는 함수(재귀)
     *
     * @param c         비용정보가 들어있는 N*N 이차원 배열
     * @param N         제품의 갯수(=공장의 갯수)
     * @param visited   해당 제품을 방문체크하기 위한 배열
     * @param depth     재귀호출을 몇번 하였는가(=현재 depth번에 있는 공장)
     * @param totalCost 현재까지의 제품 생산을 위한 비용
     */
    private static void solve(int[][] c, int N, boolean[] visited, int depth, int totalCost) {
        // 가지치기 조건
        // 더 이상 가망성이 없는 경우..!(=가능성 0%) 즉시 종료!
        // 현재까지의 비용(totalCost) > mnCost 가지치기...!
        if(totalCost > mnCost) {
            return;
        }

        // 기저조건 (종료조건)
        // 모든 공장이 해당되는 제품들을 모두 골랐다면..! -> 종료
        if(depth == N) {
            // 최소비용을 갱신! (update)
            if(mnCost > totalCost) {
                mnCost = totalCost;
            }
            return;
        }
        // i번 공장
        // 순열 생성 (경우의 수)
        // 현재의 depth번 공장에서 0 ~ N-1번의 제품을 선택 시도...!
        for (int i = 0; i < N; i++) {
            // 해당된 제품이 선택되지 않은 제품 확인!
            if(!visited[i]) {
                // 해당 제품 i를 체크
                visited[i] = true;
                // 유도 조건 (다음 공장에서 다음 제품 선택 진행!)
                // totalCost(현재까지 공장의 총 생산 비용) = 이전 공장들까지의 생산비용 + 해당 제품을 이 공장에서 생산 비용
                solve(c, N, visited, depth + 1, totalCost + c[depth][i]);
                // 해당 제품 i를 체크해제
                visited[i] = false;
            }
        }

    }

}


// for문을 돌 때, 로직이 이해안됨
//