package AL_brute_force;
// 다음 연립방정식에서 $x$와 $y$의 값을 계산하시오.
 
// \[\begin{cases}ax+by=c\\dx+ey=f\end{cases}\] 
// 4차 산업혁명 시대에 숙제나 하고 앉아있는 것보다 버추얼 친구들을 만나러 가는 게 더 가치있는 일이라고 생각했던 수현이는 이런 연립방정식을 풀 시간이 없었다. 다행히도, 버추얼 강의의 숙제 제출은 인터넷 창의 빈 칸에 수들을 입력하는 식이다. 각 칸에는 $-999$ 이상 $999$ 이하의 정수만 입력할 수 있다. 수현이가 버추얼 친구들을 만나러 버추얼 세계로 떠날 수 있게 도와주자.

// 정수 $a$, $b$, $c$, $d$, $e$, $f$가 공백으로 구분되어 차례대로 주어진다. ($-999 \leq a,b,c,d,e,f \leq 999$)
// 문제에서 언급한 방정식을 만족하는 $\left(x,y\right)$가 유일하게 존재하고, 이 때 $x$와 $y$가 각각 $-999$ 이상 $999$ 이하의 정수인 경우만 입력으로 주어짐이 보장된다.

// 문제의 답인 $x$와 $y$를 공백으로 구분해 출력한다.

public class Main_19532 {
    private static int inputInt() throws Exception {
        int tmp;
        int result = 0;
        int neg = 1;
        while(true){
            tmp = System.in.read();
            if(tmp == '-'){
                neg = -1;
                continue;
            }else if(tmp > '9' || tmp < '0'){
                return neg*result;
            }
            result *= 10;
            result += tmp - '0';
        }
    }
    public static void main(String[] args) throws Exception{
        double[][] num = new double[2][3];
        int x, y;
        for(int i = 0; i < num.length; i++){
            for(int j = 0; j < num[i].length; j++){
                num[i][j] = (double)inputInt();
            }
        }
        x = (int)((num[0][2]*num[1][1] - num[0][1]*num[1][2])/(num[0][0]*num[1][1] - num[0][1]*num[1][0]));
        y = (int)((num[0][0]*num[1][2] - num[0][2]*num[1][0])/(num[0][0]*num[1][1] - num[0][1]*num[1][0]));
        System.out.print(x + " " + y);
    }
}
