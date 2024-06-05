package K_time_complexity;
// 오늘도 서준이는 점근적 표기 수업 조교를 하고 있다. 아빠가 수업한 내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.
// 알고리즘의 소요 시간을 나타내는 O-표기법(빅-오)을 다음과 같이 정의하자.
// O(g(n)) = {f(n) | 모든 n ≥ n0에 대하여 f(n) ≤ c × g(n)인 양의 상수 c와 n0가 존재한다}
// 이 정의는 실제 O-표기법(https://en.wikipedia.org/wiki/Big_O_notation)과 다를 수 있다.
// 함수 f(n) = a1n + a0, 양의 정수 c, n0가 주어질 경우 O(n) 정의를 만족하는지 알아보자.

// 첫째 줄에 함수 f(n)을 나타내는 정수 a1, a0가 주어진다. (0 ≤ |ai| ≤ 100)
// 다음 줄에 양의 정수 c가 주어진다. (1 ≤ c ≤ 100)
// 다음 줄에 양의 정수 n0가 주어진다. (1 ≤ n0 ≤ 100)

// f(n), c, n0가 O(n) 정의를 만족하면 1, 아니면 0을 출력한다.
public class Main_24313 {
    private static int inputInt() throws Exception{
        int tmp;
        int neg = 1;
        int result = 0;
        while(true){
            tmp = System.in.read();
            if(tmp == '-'){
                neg = -1;
                continue;
            }else if(tmp > '9' || tmp < '0'){
                return result*neg;
            }
            result *= 10;
            result += tmp - '0';
        }
    }
    public static void main(String[] args) throws Exception{
        int a = inputInt();
        int b = inputInt();
        int c = inputInt();
        int n = inputInt();
        if(c >= a){
            if(c*n >= a*n + b){
                System.out.print(1);
            }else{
                System.out.print(0);
            }
        }else{
            System.out.print(0);
        }
    }
}
