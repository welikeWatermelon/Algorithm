package swea_0306;

public class 이진검색연습 {
    static int cnt =0;
    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 9, 11, 19, 23};
        int K = 7;
        System.out.println(BS(arr,0,arr.length-1,K));
        System.out.println(cnt);

    }

    //K : 찾는 값

    public static int BS(int[] arr, int start, int end, int K) {
        int mid = start + (end - start) / 2; //오버플로우 방지
        if(start>end) return -1;
        if (arr[mid] == K) {
            cnt++;
            return mid;
        } else if (arr[mid] < K) {
            cnt++;
            return BS(arr, mid + 1, end, K);
        } else {
            cnt++;
            return BS(arr, start, mid - 1, K);
        }
    }
}
