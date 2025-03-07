package swea_0305;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class swea_5201 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt(); //컨테이너
            int M = sc.nextInt(); //트럭
            ArrayList<Integer> containers = new ArrayList<>();
            ArrayList<Integer> trucks = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                containers.add(sc.nextInt());
            }

            for (int i = 0; i < M; i++) {
                trucks.add(sc.nextInt());
            }

            Collections.sort(containers, Collections.reverseOrder());
            Collections.sort(trucks, Collections.reverseOrder());


            //로직
            //컨티이너 크기 순, 트럭 크기 순
            //0번째 트럭이 제일 크기가 큰 컨테이너 옮기고 container에서 삭제
            //1번째 트럭이 두번째로 크기가 큰 컨테이너 옮기고 container에서 삭제
            // 만약, 남은 i번째 트럭이 가장 큰 컨테이너를 옮길 때, 컨테이너 값이 더 크다면 다음 컨테이너로 옮김


            int answer = 0;
            int i =0;
            while(i!=containers.size()) {
                for (int j = 0; j < M; j++) {
                    if (containers.get(i) <= trucks.get(j)) {
                        answer += containers.get(i);
                        containers.remove(i);
                        trucks.remove(j);
                        break;
                    } else {
                        i++;
                    }
                }
            }

            System.out.printf("#%d %d\n",t,answer);



        }
    }
}
