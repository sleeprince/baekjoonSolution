package B_condition;

// KOI 전자에서는 건강에 좋고 맛있는 훈제오리구이 요리를 간편하게 만드는 인공지능 오븐을 개발하려고 한다. 인공지능 오븐을 사용하는 방법은 적당한 양의 오리 훈제 재료를 인공지능 오븐에 넣으면 된다. 그러면 인공지능 오븐은 오븐구이가 끝나는 시간을 분 단위로 자동적으로 계산한다.
// 또한, KOI 전자의 인공지능 오븐 앞면에는 사용자에게 훈제오리구이 요리가 끝나는 시각을 알려 주는 디지털 시계가 있다.
// 훈제오리구이를 시작하는 시각과 오븐구이를 하는 데 필요한 시간이 분단위로 주어졌을 때, 오븐구이가 끝나는 시각을 계산하는 프로그램을 작성하시오.

// 첫째 줄에는 현재 시각이 나온다. 현재 시각은 시 A (0 ≤ A ≤ 23) 와 분 B (0 ≤ B ≤ 59)가 정수로 빈칸을 사이에 두고 순서대로 주어진다. 두 번째 줄에는 요리하는 데 필요한 시간 C (0 ≤ C ≤ 1,000)가 분 단위로 주어진다.

// 첫째 줄에 종료되는 시각의 시와 분을 공백을 사이에 두고 출력한다. (단, 시는 0부터 23까지의 정수, 분은 0부터 59까지의 정수이다. 디지털 시계는 23시 59분에서 1분이 지나면 0시 0분이 된다.)

//클래스로 일반적 문제 풀이
public class Main_2525_1 {

    static class Time{
        int h, m;
        //생성자
        public Time(){
            this.h = 0;
            this.m = 0;
        }
        public Time(int _h, int _m){
            if(_m >= 60){
                _h += _m/60;
                _m = _m%60;
            }
            if(_h >= 24){
                _h %= 24;
            }
            this.h = _h;
            this.m = _m;
        }
        //시간 형식으로 조정
        private void makeSense(int _h, int _m){        
            if(_m > 59){            
                _m %= 60;
                _h += _m/60;
            }
            while(_m < 0){
                _m += 60;
                _h--;
            }        
            if(_h >= 24){
                _h %= 24;
            }
            while(_h < 0){
               _h += 24;
            }        
            this.h = _h;
            this.m = _m;
        }
        //시간 덧셈
        public void addTime(int _h, int _m){
            this.h += _h;
            this.m += _m;
            this.makeSense(this.h, this.m);
        }
        //시간 출력
        public void printTime(){
            System.out.print(this.h + " " + this.m);
        }
    }

    //입력 받기
    private static int input() throws Exception{
        int a = 0;
        int result = 0;
        while(true){
            a = System.in.read();
            //if(a == 10) continue; 백준에서 줄을 넘길 때LF를 쓰지 않고 CR만 쓰는 듯
            if(a < '0' || a > '9') return result;
            result *= 10;
            result += a - '0';
        }
    }
    public static void main(String[] args) throws Exception {
        int a, b, c;
        a = input();
        b = input();
        c = input();
        Time t = new Time(a, b);
        t.addTime(0, c);
        t.printTime();
    }
}
