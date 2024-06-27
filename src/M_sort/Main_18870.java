package M_sort;
// 수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.
// Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표 Xj의 개수와 같아야 한다.
// X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.

// 첫째 줄에 N이 주어진다.
// 둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다.

// 첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력한다.

import java.util.Scanner;

class MyTree<T extends Comparable<T>> {

    private Leaf<T> begin;
    private Leaf<T> end;
    private Leaf<T> root;
    class Leaf<T>{
        private T key;
        private Leaf<T> right;
        private Leaf<T> left;
        private int index;

        public Leaf(T _key){           
            this.key = _key;
            this.right = null;
            this.left = null;
            this.index = 0;
        }
        
        public void setKey(T _key){
            this.key = _key;
        }

        public void setRight(Leaf<T> _right){
            this.right = _right;
        }

        public void setLeft(Leaf<T> _left){
            this.left = _left;
        }

        public void setIndex(int _index){
            this.index = _index;
        }

        public T getKey(){
            return this.key;
        }

        public Leaf<T> getRight(){
            return this.right;
        }

        public Leaf<T> getLeft(){
            return this.left;
        }

        public int getIndex(){
            return this.index;
        }
    }
    
    public MyTree(){
        this.root = null;
        this.begin = null;
        this.end = null;
    }

    public MyTree(T _key){
        Leaf<T> leaf = new Leaf(_key);
        this.begin = leaf;
        this.end = leaf;
        this.root = leaf;
    }    

    public int add(T _key){
        if(this.root == null){
            Leaf<T> leaf = new Leaf(_key);
            this.begin = leaf;
            this.end = leaf;
            this.root = leaf;

        }else{
            Leaf<T> leaf = new Leaf(_key)            

        }       

        return 1; //인덱스를 내보내자
    }
    
    private boolean addLeft(Leaf<T> now, Leaf<T> _leaf){
        T key_now = now.getKey();
        Leaf<T> left_now = now.getLeft();
        Leaf<T> right_now = now.getRight();
        T key_leaf = _leaf.getKey();
        Leaf<T> left_leaf = _leaf.getLeft();
        Leaf<T> right_leaf = _leaf.getRight();
        
        if(key_leaf.compareTo(key_now) > 0){
            //오른쪽으로
            if(right_now == null){
                right_now = _leaf;
                return true;            
            }else{
                return addRight(right_now, _leaf);
            }
        }else if(key_leaf.compareTo(key_now) < 0){
            //왼쪽으로
            if(left_now == null){
                left_now = _leaf;
                return true;
            }else{
                return addLeft(left_now, _leaf);
            }
        }else{
            return false;
        }
                
    }

    private boolean addRight(Leaf<T> now, Leaf<T> _leaf){

    }



    public int getIndexOf(T _key){
        return 1;
    }

    public void getKeyOf(int _index){
        
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
