package swea_0305;

import java.util.Scanner;

public class swea_5186 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            double num = sc.nextDouble();
            int i =1;
            double answer = 0;

            while(true){
                if(i==13){
                    System.out.printf("#%d %s\n",t,"overflow");
                    break;
                }

                num*=2;
                answer+=(int)(num/1)/Math.pow(10,i);


                i++;
            }
//            System.out.printf("%d",(int)(num/1));
        }
    }
}
