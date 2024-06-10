package M_sort;
// 2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
// 첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.
// 첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.

import java.util.Scanner;

class Coord{
    int x, y;
    public Coord(){
        this.x = 0;
        this.y = 0;
    }
}
public class Main_11650 {
        private static Coord[] mergeSort(Coord[] arr, int k){
        if(arr.length > 1){
            Coord[] f_arr = new Coord[arr.length/2];
            Coord[] b_arr = new Coord[arr.length - f_arr.length];
            for(int i = 0; i < f_arr.length; i++)
                f_arr[i] = arr[i];
            for(int i = 0; i < b_arr.length; i++)
                b_arr[i] = arr[f_arr.length + i];
            f_arr = mergeSort(f_arr, k);
            b_arr = mergeSort(b_arr, k);
            arr = mergeArray(f_arr, b_arr, k);
        }
        return arr;
    }
    private static Coord[] mergeArray(Coord[] f_arr, Coord[] b_arr, int k){
        Coord[] arr = new Coord[f_arr.length + b_arr.length];
        int fps = 0;
        int bps = 0;
        for(int i = 0; i < arr.length; i++){
            if(fps == f_arr.length){
                arr[i] = b_arr[bps];
                bps++;
            }else if(bps == b_arr.length){
                arr[i] = f_arr[fps];
                fps++;
            }else if(k == 0){
                if(f_arr[fps].x <= b_arr[bps].x){
                    arr[i] = f_arr[fps];
                    fps++;
                }else{
                    arr[i] = b_arr[bps];
                    bps++;
                }
            }else if(k == 1){
                if(f_arr[fps].y <= b_arr[bps].y){
                    arr[i] = f_arr[fps];
                    fps++;
                }else{
                    arr[i] = b_arr[bps];
                    bps++;
                }
            }
        }
        return arr;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Coord[] crd = new Coord[n];
        for(int i = 0; i < n; i++){
            crd[i] = new Coord();
            crd[i].x = sc.nextInt();
            crd[i].y = sc.nextInt();
        }
        crd = mergeSort(crd, 1);
        crd = mergeSort(crd, 0);
        for(int i = 0; i < n; i++)
            System.out.println(crd[i].x + " " + crd[i].y);
        sc.close();
    }
}
