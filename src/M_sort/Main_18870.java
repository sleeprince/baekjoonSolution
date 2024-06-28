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
    private class Leaf<T>{
        private T key;
        private Leaf<T> right;
        private Leaf<T> left;
        private int index;
        private boolean leftmost;
        private boolean rightmost;

        public Leaf(T _key){           
            this.key = _key;
            this.right = null;
            this.left = null;
            this.index = 0;
            this.leftmost = true;
            this.rightmost = true;
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

        public void setLeftmost(boolean _type){
            this.leftmost = _type;
        }

        public void setRightmost(boolean _type){
            this.rightmost = _type;
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

        public boolean getLeftmost(){
            return this.leftmost;
        }

        public boolean getRightmost(){
            return this.rightmost;
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

        Leaf<T> leaf = new Leaf(_key);

        if(this.root == null){
            this.begin = leaf;
            this.end = leaf;
            this.root = leaf;
            return leaf.getIndex();
        }else if(addNext(this.root, leaf)){;
            if(leaf.getLeftmost())
                this.begin = leaf;
            if(leaf.getRightmost())
                this.end = leaf;
            return leaf.getIndex();
        }else{
            return -1;   
        }
    }

    private boolean addNext(Leaf<T> now, Leaf<T> _leaf){
        T key_now = now.getKey();
        Leaf<T> left_now = now.getLeft();
        Leaf<T> right_now = now.getRight();
        T key_leaf = _leaf.getKey();
        
        if(key_now.compareTo(key_leaf) < 0){
            //오른쪽으로
            _leaf.setLeftmost(false);
            if(right_now == null){
                now.setRight(_leaf);
                _leaf.setIndex(now.getIndex() + 1);
                return true;            
            }else{
                return addNext(right_now, _leaf);
            }
        }else if(key_now.compareTo(key_leaf) > 0){
            //왼쪽으로
            _leaf.setRightmost(false);
            now.setIndex(now.getIndex() + 1);
            if(left_now == null){
                now.setLeft(_leaf);
                return true;
            }else{
                return addNext(left_now, _leaf);
            }
        }else{
            return false;
        }
    }

    private void rebalance(Leaf<T> _root){
        
    }


    public int getIndexOf(T _key){
        return getIndexOf(root, _key);
    }

    private int getIndexOf(Leaf<T> leaf, T _key){
        T key = leaf.getKey();
        if(key.compareTo(_key) == 0)
            return leaf.getIndex();
        else if(key.compareTo(_key) < 0)
            return getIndexOf(leaf.getRight(), _key);
        else if(key.compareTo(_key) > 0)
            return getIndexOf(leaf.getLeft(), _key);
        else
            return -1;
    }

    public T getKeyOf(int _index){
        if(_index < 0 || _index > end.getIndex())
            return null;
        else
            return getKeyOf(root, _index);
    }

    private T getKeyOf(Leaf<T> leaf, int _index){
        int index = leaf.getIndex();
        if(index == _index)
            return leaf.getKey();
        else if(index < _index)
            return getKeyOf(leaf.getRight(), _index);
        else if(index > _index)
            return getKeyOf(leaf.getLeft(), _index);
        else
            return null;
    }

    public T getFirst(){
        return begin.getKey();
    }

    public T getLast(){
        return end.getKey();
    }

    public T[] toArray(){
        Object arr[] = new Object[this.end.getIndex() + 1];
        return (T[]) arr;
    }
    
    public int size(){
        return end.getIndex() + 1;
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
