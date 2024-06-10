package M_sort;
// 2022 연세대학교 미래캠퍼스 슬기로운 코딩생활에 $N$명의 학생들이 응시했다.
// 이들 중 점수가 가장 높은 $k$명은 상을 받을 것이다. 이때, 상을 받는 커트라인이 몇 점인지 구하라.
// 커트라인이란 상을 받는 사람들 중 점수가 가장 가장 낮은 사람의 점수를 말한다.

// 첫째 줄에는 응시자의 수 $N$과 상을 받는 사람의 수 $k$가 공백을 사이에 두고 주어진다.
// 둘째 줄에는 각 학생의 점수 $x$가 공백을 사이에 두고 주어진다.

// 상을 받는 커트라인을 출력하라.

public class Main_25305_2 {
    private static int inputInt() throws Exception{
        int tmp;
        int result = 0;
        int neg = 1;
        while(true){
            tmp = System.in.read();
            if(tmp == '-'){
                neg = -1;
                continue;
            }else if(tmp < '0' || tmp > '9')
                return result*neg;
            result *= 10;
            result += tmp - '0';
        }
    }
    private static int[] mergeSort(int[] arr){
        if(arr.length > 1){
            int[] fArray = new int[arr.length/2];
            int[] bArray = new int[arr.length - arr.length/2];
            for(int i = 0; i < fArray.length; i++)
                fArray[i] = arr[i];
            for(int j = 0; j < bArray.length; j++)
                bArray[j] = arr[fArray.length + j];
            fArray = mergeSort(fArray);
            bArray = mergeSort(bArray);
            arr = mergeArray(fArray, bArray);
        }
        return arr;
    }
    private static int[] mergeArray(int[] arr1, int[] arr2){
        int pos1 = 0;
        int pos2 = 0;
        int[] arr = new int[arr1.length + arr2.length];
        for(int i = 0; i < arr.length; i++){
            if(pos1 == arr1.length){
                arr[i] = arr2[pos2];
                pos2++;
            }else if(pos2 == arr2.length){
                arr[i] = arr1[pos1];
                pos1++;
            }else if(arr1[pos1] < arr2[pos2]){
                arr[i] = arr1[pos1];
                pos1++;
            }else{
                arr[i] = arr2[pos2];
                pos2++;
            }                
        }
        return arr;
    }
    public static void main(String[] args) throws Exception{
        int n = inputInt();
        int k = inputInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = inputInt();
        arr = mergeSort(arr);
        System.out.print(arr[n - k]);
    }
}
