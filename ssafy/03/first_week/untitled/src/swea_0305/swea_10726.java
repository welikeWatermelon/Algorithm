package swea_0305;

import java.util.Scanner;

public class swea_10726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            String binary = Integer.toBinaryString(M); //문자열 처리

            boolean flag = true;


            if(binary.length()<N){
                System.out.printf("#%d %s\n",t,"OFF");
                continue;
            }

            for (int i = binary.length()-1; i >= binary.length()-N; i--) {
                if(binary.charAt(i)!='1'){
                    flag = false;
                    break;
                }
            }

            if (flag) {
                System.out.printf("#%d %s\n", t, "ON");
            } else {
                System.out.printf("#%d %s\n",t,"OFF");
            }
        }
    }
}
