package AM_sort;
// 배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
// 첫째 줄에 정렬하려고 하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.
// 첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.

public class Main_1427 {
    public static void main(String[] args) throws Exception{
        int[] num = new int[10];
        int tmp;
        while(true){
            tmp = System.in.read();
            if(tmp < '0' || tmp > '9') break;
            num[tmp - '0']++;
        }
        for(int i = 9; i >= 0; i--){
            while(num[i] > 0){
                System.out.print(i);
                num[i]--;
            }
        }
    }
}
