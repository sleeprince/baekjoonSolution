package AB_condition;
// 1에서부터 6까지의 눈을 가진 3개의 주사위를 던져서 다음과 같은 규칙에 따라 상금을 받는 게임이 있다.

// 같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다.
// 같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다.
// 모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.
// 예를 들어, 3개의 눈 3, 3, 6이 주어지면 상금은 1,000+3×100으로 계산되어 1,300원을 받게 된다. 또 3개의 눈이 2, 2, 2로 주어지면 10,000+2×1,000 으로 계산되어 12,000원을 받게 된다. 3개의 눈이 6, 2, 5로 주어지면 그중 가장 큰 값이 6이므로 6×100으로 계산되어 600원을 상금으로 받게 된다.

// 3개 주사위의 나온 눈이 주어질 때, 상금을 계산하는 프로그램을 작성 하시오.

//직접 조건문을 작성하여 풀이
public class Main_2480_1 {
    private static int input() throws Exception{
        int a = 0;
        int result = 0;
        while(true){
            a = System.in.read();
            if(a < '1' || a > '6') return result;
            result = a - '0';
        }
    }
    public static void main(String[] args) throws Exception{
        int a = input();
        int b = input();
        int c = input();
        int prize = 0;
        if(a==b && a==c){
            prize = 10000 + (a*1000);
        }else if(a == b){
            prize = 1000 + (a*100);
        }else if(a == c){
            prize = 1000 + (a*100);
        }else if(b == c){
            prize = 1000 + (b*100);
        }else if(b < a && c < a){
            prize = a*100;
        }else if(a < b && c < b){
            prize = b*100;
        }else if(a < c && b < c){
            prize = c*100;
        }
        System.out.print(prize);
    }
}
