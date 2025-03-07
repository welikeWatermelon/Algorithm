package swea_0305;

import java.math.BigInteger;
import java.util.Scanner;

public class swea_5185 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            String str = sc.next();
            BigInteger decimal = new BigInteger(str, 16);  // 16진수를 10진수(BigInteger)로 변환
            String binary = decimal.toString(2);
            if (str.length() * 4 == binary.length()) {
                System.out.printf("#%d %s\n", t, binary);
            } else {
                int sub = str.length() * 4 - binary.length();
                String tmp = "";
                for(int i=0;i<sub; i++){
                    tmp+="0";
                }
                String answer = tmp+binary;
                System.out.printf("#%d %s\n",t,answer);
            }
        }
    }
}
