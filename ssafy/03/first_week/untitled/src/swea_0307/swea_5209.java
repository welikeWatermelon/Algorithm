package swea_0307;

import sun.rmi.server.InactiveGroupException;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class swea_5209 {
    public static int mnCost;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            // 입력
            // 제품 갯수 N
            int N = Integer.parseInt(br.readLine().trim());
            // N * N의 이차원 생산 비용 c
            int[][] c = new int[N][N];

            for (int i = 0; i < N; i++) {
                String[] temp = br.readLine().trim().split(" ");
                for (int j = 0; j < N; j++) {
                    c[i][j] = Integer.parseInt(temp[i]);
                }
            }

            // 로직
            // 최소 생산 비용 mnCost
            mnCost = 0;
            // 하나의 공장에 대해서 하나의 제품을 매칭하는 순열(경우의 수) 생성
            solve(c,N,0);
        }
    }



    int min  = 0;

    public static void mini(int x, int y, int sum){
        if(min<=값){
            return;
        }

        for 0(int i = 0; i < N; i++) {

        }
    }
}
