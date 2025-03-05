package AR_advanced_2;
// 수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 단, N은 홀수라고 가정하자.

// 산술평균 : N개의 수들의 합을 N으로 나눈 값
// 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
// 최빈값 : N개의 수들 중 가장 많이 나타나는 값
// 범위 : N개의 수들 중 최댓값과 최솟값의 차이
// N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.

// 첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 단, N은 홀수이다. 그 다음 N개의 줄에는 정수들이 주어진다. 입력되는 정수의 절댓값은 4,000을 넘지 않는다.
// 첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
// 둘째 줄에는 중앙값을 출력한다.
// 셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
// 넷째 줄에는 범위를 출력한다.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_2108 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        int[] arr = new int[8001];
        long sum = 0;
        int max = -4001;
        int min = 4001;
        int mid = 0;
        int mode = 4001;
        int freq = 0;
        int input;
        for(int i = 0; i < cnt; i++){
            input = Integer.parseInt(br.readLine());
            //합계
            sum += (long)input;
            //최빈값
            arr[input + 4000]++;
            if(arr[input + 4000] > freq)
                freq = arr[input + 4000];    
            // 최대 최소
            if(input > max) max = input;
            if(input < min) min = input;
            
        }
        // 중앙값
        for(int i = min + 4000; i < max + 4001; i++){
            mid += arr[i];
            if(mid >= (cnt + 1)/2){
                mid = i - 4000;
                break;
            }
        }
        // 최빈값
        for(int i = min + 4000; i < max + 4001; i++){
            if(arr[i] == freq)
                if(mode == 4001) mode = i - 4000;
                else{mode = i - 4000; break;}
        }
        //평균
        int average = (int)(10*sum/cnt);
        int sign = (average >= 0)? 1 : -1; 
        average = (average%10 > 4 || average%10 < -4)? average/10 + sign : average/10;
        bw.write(average + "\n");
        bw.write(mid + "\n");
        bw.write(mode + "\n");
        bw.write((max - min) + "\n");
        bw.flush();
        bw.close();
    }
}
