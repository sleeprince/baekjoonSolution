package AS_recursive;
// 오늘도 서준이는 병합 정렬 수업 조교를 하고 있다. 아빠가 수업한 내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.
// N개의 서로 다른 양의 정수가 저장된 배열 A가 있다. 병합 정렬로 배열 A를 오름차순 정렬할 경우 배열 A에 K 번째 저장되는 수를 구해서 우리 서준이를 도와주자.
// 크기가 N인 배열에 대한 병합 정렬 의사 코드는 다음과 같다.

// 첫째 줄에 배열 A의 크기 N(5 ≤ N ≤ 500,000), 저장 횟수 K(1 ≤ K ≤ 108)가 주어진다.
// 다음 줄에 서로 다른 배열 A의 원소 A1, A2, ..., AN이 주어진다. (1 ≤ Ai ≤ 109)
// 배열 A에 K 번째 저장 되는 수를 출력한다. 저장 횟수가 K 보다 작으면 -1을 출력한다.
import java.util.Scanner;

public class Main_24060 {
    private static int k = 0;
    private static int kth = -1;
    private static int cnt = 0;
    private static void merge_sort(int[] arr, int start, int end){
        if(start < end){
            int mid = (start + end)/2;
            merge_sort(arr, start, mid);
            merge_sort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }
    private static void merge(int[] arr, int start, int mid, int end){
        int p = start;
        int q = mid + 1;
        int r = 0;
        int[] tmp = new int[end - start + 1];
        while(r < tmp.length){
            if(p <= mid && (q > end || arr[p] <= arr[q])) tmp[r++] = arr[p++];
            else tmp[r++] = arr[q++];
        }
        p = start; r = 0;
        while(r < tmp.length){
            if(++cnt == k) kth = tmp[r];
            arr[p++] = tmp[r++];
        }
    }
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        k = sc.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++) arr[i] = sc.nextInt();
        merge_sort(arr, 0, size - 1);
        System.out.println(kth);
        sc.close();
    }
}
