package J_geometry_rectangle_triangle;
// 한수는 지금 (x, y)에 있다. 직사각형은 각 변이 좌표축에 평행하고, 왼쪽 아래 꼭짓점은 (0, 0), 오른쪽 위 꼭짓점은 (w, h)에 있다. 직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램을 작성하시오.
// 첫째 줄에 x, y, w, h가 주어진다.
// 첫째 줄에 문제의 정답을 출력한다.
public class Main_1085 {
    private static int inputInt() throws Exception{
        int tmp;
        int result = 0;
        while(true){
            tmp = System.in.read();
            if(tmp > '9'|| tmp < '0') return result;
            result *= 10;
            result += tmp - '0';
        }
    }
    public static void main(String[] args) throws Exception {
        int x = inputInt();
        int y = inputInt();
        int h = inputInt() - x;
        int w = inputInt() - y;
        if(x > y) x = y;
        if(x > h) x = h;
        if(x > w) x = w;
        System.out.print(x);
    }
}
