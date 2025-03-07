package swea_0306;
import java.util.Arrays;

public class 우리강사님_퀵정렬 {
    public static void main(String[] args) {
        int[] arr = { 11, 45, 23, 81, 28, 34 };

        // 퀵정렬 구현하여 정렬 실행
        quick_sort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    // 분할-정복 기법을 사용하는 대표적인 정렬 방법
    // 파티셔닝: 피봇(pivot) 왼쪽은 작은 값, 오른쪽 큰 값
    // 분할 : 피봇(pivot)을 중심으로 왼쪽과 오른쪽 리스트를 정렬 진행
    private static void quick_sort(int[] arr, int left, int right) {
        if(left >= right) {
            return;
        }
        // 파티셔닝
        int p = partition(arr, left, right);

        // 분할 : 왼쪽 리스트와 오른쪽 배열의 정렬 재차 진행
        quick_sort(arr, left, p - 1);
        quick_sort(arr, p + 1, right);
    }

    // 피봇(pivot) 중간값을 중심으로 해서 왼쪽은 작은 값 / 오른쪽 오른쪽은 큰 값
    private static int partition(int[] arr, int left, int right) {
        // 피봇을 왼쪽 끝의 원소 설정...
        int pivot = arr[left];

        int i = left + 1; // 왼쪽 ->
        int j = right; // <- 오른쪽

        // 서로 교차할 때까지 이동
        while (i <= j) {
            // 왼쪽 i 인덱스는 피벗보다 큰 값을 발견할 때까지 이동...
            while (i <= j && arr[i] <= pivot)
                i++;
            // 오른쪽 j 인덱스는 피벗보다 큰 값을 발견할 때까지 이동...
            while (i <= j && arr[j] >= pivot)
                j--;
            // arr[i] <-> arr[j] 값을 서로 교환
            if (i < j)
                swap(arr, i, j);
        }
        // 피봇의 값을 j와 교환
        // arr[left] <-> arr[j]
        swap(arr, left, j);

        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
