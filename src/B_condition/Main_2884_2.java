package B_condition;
// 상근이는 매일 아침 알람을 듣고 일어난다. 알람을 듣고 바로 일어나면 다행이겠지만, 항상 조금만 더 자려는 마음 때문에 매일 학교를 지각하고 있다.
// 상근이는 모든 방법을 동원해보았지만, 조금만 더 자려는 마음은 그 어떤 것도 없앨 수가 없었다.
// 이런 상근이를 불쌍하게 보던 창영이는 자신이 사용하는 방법을 추천해 주었다.
// 바로 "45분 일찍 알람 설정하기"이다.
// 이 방법은 단순하다. 원래 설정되어 있는 알람을 45분 앞서는 시간으로 바꾸는 것이다. 어차피 알람 소리를 들으면, 알람을 끄고 조금 더 잘 것이기 때문이다. 이 방법을 사용하면, 매일 아침 더 잤다는 기분을 느낄 수 있고, 학교도 지각하지 않게 된다.
// 현재 상근이가 설정한 알람 시각이 주어졌을 때, 창영이의 방법을 사용한다면, 이를 언제로 고쳐야 하는지 구하는 프로그램을 작성하시오.

//클래스로 일반적 문제 풀이
public class Main_2884_2 {
    
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
            if(a < '0' || a > '9') return result;
            result *= 10;
            result += a - '0';
        }
    }
    public static void main(String[] args) throws Exception {
        int a, b;
        a = input();
        b = input();
        Time t = new Time(a, b);
        t.addTime(0, -45);
        t.printTime();
    }
}
