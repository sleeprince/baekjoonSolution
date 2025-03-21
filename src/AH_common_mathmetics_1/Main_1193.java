package AH_common_mathmetics_1;
// 무한히 큰 배열에 다음과 같이 분수들이 적혀있다.
// 1/1	1/2	1/3	1/4	1/5	…
// 2/1	2/2	2/3	2/4	…	…
// 3/1	3/2	3/3	…	…	…
// 4/1	4/2	…	…	…	…
// 5/1	…	…	…	…	…
// …	…	…	…	…	…
// 이와 같이 나열된 분수들을 1/1 → 1/2 → 2/1 → 3/1 → 2/2 → … 과 같은 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.

// X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.

public class Main_1193 {
    private static int inputInt() throws Exception{
        int result = 0;
        int tmp;
        while(true){
            tmp = System.in.read();
            if(tmp < '0' || tmp > '9') return result;
            result *= 10;
            result += tmp - '0';
        }
    }
    public static void main(String[] args) throws Exception{
        int num = inputInt();
        int nth = 1;
        int total = 1;
        while(num > total){
            total += ++nth;            
        }
        total -= nth;
        if(nth%2 == 0){
            System.out.print((num - total) + "/" + (nth - num + total + 1));
        }else{
            System.out.print((nth - num + total + 1) + "/" + (num - total));
        }        
        
    }
}
