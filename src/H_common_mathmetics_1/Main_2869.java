package H_common_mathmetics_1;
// 땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.
// 달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 또, 정상에 올라간 후에는 미끄러지지 않는다.
// 달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.

// 첫째 줄에 세 정수 A, B, V가 공백으로 구분되어서 주어진다. (1 ≤ B < A ≤ V ≤ 1,000,000,000)

public class Main_2869 {
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
        int a = inputInt();
        int b = inputInt();
        int v = inputInt();
        
        if(v < a){
            System.out.print(1);
        }else if( (v - a)%(a - b) == 0){
            System.out.print((v - a)/(a - b) + 1);
        }else{
            System.out.print((v - a)/(a - b) + 2);
        }
    }
}
