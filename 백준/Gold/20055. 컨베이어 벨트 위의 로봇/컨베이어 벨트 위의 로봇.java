import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static Deque<Space> conveyorBeltUp = new LinkedList<>();
    static Deque<Space> conveyorBeltDown = new LinkedList<>();

    public static class Space{
        boolean robotExist;
        int durability;

        public Space(boolean robotExist, int durability) {
            this.robotExist = robotExist;
            this.durability = durability;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int zeroCnt = 0;
        int rotateCnt = 0;

        for (int i = 0; i < N; i++) {
            conveyorBeltUp.add(new Space(false, sc.nextInt()));
        }

        for (int i = 0; i < N; i++) {
            conveyorBeltDown.addFirst(new Space(false, sc.nextInt()));
        }

        while (true) {
            rotateCnt ++;

            // 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
            rotation();

            // 내려
            if (conveyorBeltUp.getLast().robotExist) {
                conveyorBeltUp.getLast().robotExist = false;
            }

            // 2. 로봇 이동
            for (int i = N-2; i >=0; i--) {
                if (((LinkedList<Space>) conveyorBeltUp).get(i).robotExist
                        && !((LinkedList<Space>) conveyorBeltUp).get(i + 1).robotExist
                        && ((LinkedList<Space>) conveyorBeltUp).get(i + 1).durability != 0 ) {

                    ((LinkedList<Space>) conveyorBeltUp).get(i).robotExist = false;
                    ((LinkedList<Space>) conveyorBeltUp).get(i + 1).robotExist = true;
                    ((LinkedList<Space>) conveyorBeltUp).get(i + 1).durability --;
                    if (((LinkedList<Space>) conveyorBeltUp).get(i + 1).durability == 0) {
                        zeroCnt++;
                    }
                }
            }

            // 내리기
            if (conveyorBeltUp.getLast().robotExist) {
                conveyorBeltUp.getLast().robotExist = false;
            }
            // 내리는거 필요함

            // 3. 로봇 올리기
            if (conveyorBeltUp.getFirst().durability != 0) {
                conveyorBeltUp.getFirst().durability--;
                if (conveyorBeltUp.getFirst().durability == 0) {
                    zeroCnt++;
                }
                conveyorBeltUp.getFirst().robotExist=true;
            }

            // 4. 내구도 검사
            if (K <= zeroCnt) {
                break;
            }

        }

        System.out.println(rotateCnt);

    }

    // 컨베이어 벨트 1회 회전
    public static void rotation(){
        conveyorBeltDown.addLast(conveyorBeltUp.pollLast());
        conveyorBeltUp.addFirst(conveyorBeltDown.pollFirst());
    }
}
