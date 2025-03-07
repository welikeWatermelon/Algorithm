import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        //입력=================================================
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            char[][] arr = new char[N][M];
            for (int i = 0; i < N; i++) {
                String str = sc.next();
                for (int j = 0; j < M; j++) {
                    arr[i][j] = str.charAt(j);
                }
            }
            //===============================================

            // 경계선은 총 처음 경계선, 마지막 경계선 총 두개 이용
            // 첫 번째 경계선을 기준으로 마지막 경계선을 계속 바꿔가며 카운트 할 것
            // K는 첫번째 경계선
            // last는 마지막 경계선
            // K = 첫번째 경계선 -> last : N-2째 경계선
            //                 -> last : N-3째 경계선
            // ...
            // K = 첫번째 경계선 -> last : K
            int min = Integer.MAX_VALUE;
            for (int K = 1; K < N-1; K++) {
                int cnt = 0;
                //W 판별 (K 위까지)
                for (int i = 0; i < K; i++) {
                    for(int j=0; j<M; j++){
                        if(arr[i][j]!='W') cnt++;
                    }
                }
                int last = N-2;
                //B 판별 (K부터 last까지)
                while(last>=K){
                    int tmpCnt  = 0;
                    for (int i = K; i <= last; i++) {
                        for(int j=0; j<M; j++){
                            if(arr[i][j]!='B'){
                                tmpCnt++;
                            }
                        }
                    }

                    //Red (last 아래부터 N-1까지)
                    for (int i = last+1; i < N; i++) {
                        for (int j = 0; j < M; j++) {
                            if (arr[i][j] != 'R') {
                                tmpCnt++;
                            }
                        }
                    }
                    last--;
                    min = Math.min(min, cnt+tmpCnt);

                }
            }
            System.out.printf("#%d %d\n",t,min);
        }
    }
}