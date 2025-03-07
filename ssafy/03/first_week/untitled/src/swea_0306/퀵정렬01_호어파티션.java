package swea_0306;

public class 퀵정렬01_호어파티션 {
    static int[] arr = {7, 5, 6, 8, 1, 2, 3, 39};
    static int N = arr.length;


    public static void main(String[] args) {

    }

    //
    public static void quickSort(int start, int end){
        if (start < end) {
            int pivot = partition(start, end);
            quickSort(start, pivot - 1);
            quickSort(pivot + 1, end);
        }
    }

    public static int partition(int start, int end) {
        int pivot = arr[start]; //가장 왼쪽에 있는 요소를 피봇이라고 결정

        int L = start +1;
        int R = end;

        while (L <= R) {
            // L ; pivot 보다 큰 값을 찾을 때 까지 이동
            while(L<= R && arr[L] <=pivot) L++;

            // R : pivot 보다 작거나 같은 값을 찾을 때까지 이동
            while(arr[R]>pivot) R--;

            //아직 교차가 되지 않았다.
            if (L < R) {
                int tmp = arr[L];
                arr[L] = arr[R];
                arr[R] = tmp;
            }
        }

        //마지막에 R과 피봇의 위치를 교환
        int tmp = arr[start];
        arr[start] = arr[R];
        arr[R] = tmp;


        return R; //피봇 위치
    }
}
