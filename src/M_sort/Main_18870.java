package M_sort;
// 수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.
// Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표 Xj의 개수와 같아야 한다.
// X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.

// 첫째 줄에 N이 주어진다.
// 둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다.

// 첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력한다.

import java.util.Scanner;

class MyTree<T> {

    private int cnt;
    class Leaf<T>{
        private int key;
        private Leaf<T> right;
        private Leaf<T> left;
        private int sum;
        private T cont;

        private Leaf(){
            this.key = cnt;
            cnt++;
        }
    }   
    
    public MyTree(){
        cnt = 0;
    }

    public MyTree(T _cont){
        cnt = 0;
        add(_cont);
    }

    public int add(T _cont){
        Leaf<T> leaf = new Leaf();

        return this.cnt - 1;
    }
    
    
}

public class Main_18870 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] coor = new int[cnt];
        for(int i = 0; i < cnt; i++){
            int tmp = sc.nextInt();
            coor[i] = tmp;
        }
        sc.close();
    }
}
