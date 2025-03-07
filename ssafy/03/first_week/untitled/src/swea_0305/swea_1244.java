package swea_0305;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class swea_1244 {
    static int M;
    static int max;
    static int strNum;
    static Set<String> visited; // 중복 탐색 방지


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            visited = new HashSet<>();
            max = 0;
            int N = sc.nextInt();
            M = sc.nextInt();
            String str = Integer.toString(N);
            strNum = str.length();
            DFS(str, 0);
            System.out.printf("#%d %d\n",t,max);
        }
    }

    //자리수를 서로 바꾸는 함수
    public static String change(String str, int i, int j){
        String tmp = "";
        String first = Character.toString(str.charAt(i));
        String second = Character.toString(str.charAt(j));
        for (int k = 0; k < str.length(); k++) {
            if (k == i) {
                tmp += second;
            } else if (k == j) {
                tmp += first;
            } else {
                tmp += Character.toString(str.charAt(k));
            }
        }
        return tmp;
    }


    //DFS
    public static void DFS(String str, int cnt){
        //종료 조건
        if(cnt ==M){
            max = Math.max(max, Integer.parseInt(str));
            return;
        }

        //방문했다면 return
        if (visited.contains(str + cnt)) return;

        //재귀 조건
        for (int i = 0; i < strNum-1; i++) {
            for(int j=i+1; j<strNum; j++){
                DFS(change(str,i,j),cnt+1);
                visited.add(str + cnt);
            }
        }
    }
}
