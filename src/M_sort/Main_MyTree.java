package M_sort;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_MyTree {

    static class MyTree<T extends Comparable<T>> {

        private Leaf<T> begin;
        private Leaf<T> end;
        private Leaf<T> root;        
        private class Leaf<T>{
            public T key;
            public Leaf<T> right;
            public Leaf<T> left;
            public Leaf<T> parent;
            public int height;
            public int index;
            public boolean leftmost;
            public boolean rightmost;
    
            public Leaf(T _key){           
                this.key = _key;
                this.right = null;
                this.left = null;
                this.parent = null;
                this.index = 0;
                this.height = 1;
                this.leftmost = true;
                this.rightmost = true;              
            }            

            public String[] toStringArray(){
                String[] str = new String[8];
                str[0] = "┏━━━━━━━━━━━━━━━━┓";
                str[1] = String.format("┃ 인덱스: %-7s┃", this.index);
                str[2] = String.format("┃ 키  값: %-7s┃", this.key);
                if(this.parent != null)
                    str[3] = String.format("┃ 부  모: %-7s┃", this.parent.key);
                else
                    str[3] = String.format("┃ 부  모: %-7s┃", "null");
                if(this.left != null)
                    str[4] = String.format("┃ 왼  쪽: %-7s┃", this.left.key);
                else
                    str[4] = String.format("┃ 왼  쪽: %-7s┃", "null");
                if(this.right != null)
                    str[5] = String.format("┃ 오른쪽: %-7s┃", this.right.key);
                else
                    str[5] = String.format("┃ 오른쪽: %-7s┃", "null");
                str[6] = String.format("┃ 높  이: %-7s┃", this.height);
                str[7] = "┗━━━━━━━━━━━━━━━━┛";
                return str;
            }
        }

        public MyTree(){
            this.root = null;
        }
    
        public MyTree(T _key){
            Leaf<T> leaf = new Leaf(_key);
            this.root = leaf;
        }    
    
        public int add(T _key){    
            Leaf<T> leaf = new Leaf(_key);    
            if(this.root == null){
                this.root = leaf;   
                this.begin = leaf;
                this.end = leaf;             
                return leaf.index;
            }else if(addNext(this.root, leaf)){
                if(leaf.leftmost)
                    this.begin = leaf;
                if(leaf.rightmost)
                    this.end = leaf;
                return leaf.index;
            }else{
                return -1;   
            }
        }
    
        private boolean addNext(Leaf<T> now, Leaf<T> _leaf){            
            
            if(now.key.compareTo(_leaf.key) < 0){
                //오른쪽으로
                _leaf.leftmost = false;
                if(now.right == null){
                    now.right = _leaf;
                    _leaf.parent = now;
                    // update_height(now);
                    return true;
                }else{
                    return addNext(now.right, _leaf);
                }
            }else if(now.key.compareTo(_leaf.key) > 0){
                //왼쪽으로
                _leaf.rightmost = false;
                now.index++;
                if(now.left == null){
                    now.left = _leaf;
                    _leaf.parent = now;
                    // update_height(now);
                    return true;
                }else{
                    return addNext(now.left, _leaf);
                }
            }else{
                return false;
            }
        }

        public void print(){
            printTree(root);
        }

        private void printTree(Leaf<T> _root){
            Queue<Leaf> que = new LinkedList<>();
            que.add(_root);
            while(!que.isEmpty()){
                int size = que.size();
                String[][] str = new String[size][8];                
                for(int i = 0; i < size; i++){
                    Leaf<T> leaf = que.poll();
                    if(leaf.left != null)
                        que.add(leaf.left);                    
                    if(leaf.right != null)
                        que.add(leaf.right);                    
                    str[i] = leaf.toStringArray();
                }
                for(int i = 0; i < 8; i++){
                    for(int j = 0; j < size; j++){
                        System.out.print(str[j][i]);
                    }
                    System.out.println();
                }                                      
            }   
        }       

        // private void update_height(Leaf<T> _leaf){
        //     if(_leaf != null){
        //         if(_leaf.left == null){
        //             _leaf.height = _leaf.right.height + 1;
        //         }else if(_leaf.right == null){
        //             _leaf.height = _leaf.left.height + 1;
        //         }else if(_leaf.height + 1 < _leaf.left.height || _leaf.height + 1 < _leaf.right.height){
        //             _leaf.height = (_leaf.right.height > _leaf.left.height)? _leaf.right.height + 1 : _leaf.left.height + 1;
        //         }
        //         rebalance(_leaf);
        //         update_height(_leaf.parent);
        //     }
        // }
    
        // private void rebalance(Leaf<T> _leaf){
        //     if(_leaf.left.height - _leaf.right.height > 1){
        //         rotate_right(_leaf);
        //     }else if(_leaf.right.height - _leaf.left.height > 1){
        //         rotate_left(_leaf);
        //     }
        // }

        // private void rotate_right(Leaf<T> _leaf){
        //     Leaf<T> new_leaf = _leaf.left;
        //     //부모 교환
        //     new_leaf.parent = _leaf.parent;
        //     if(_leaf.parent == null){}
        //     else if(_leaf.parent.left == _leaf)
        //         _leaf.parent.left = new_leaf;
        //     else if(_leaf.parent.right == _leaf)
        //         _leaf.parent.right = new_leaf; 
        //     _leaf.parent = new_leaf;
            
        //     //자식 교환
        //     _leaf.left = new_leaf.right;
        //     new_leaf.right = _leaf;
        //     //height 조정
                                
        // }
        
        // private void rotate_left(Leaf<T> _leaf){

        // }
        
        // private class MyIter implements Iterator<T>{

        //     public boolean hasNext(){
        //         return false;
        //     }

        //     public 
        // }

        // public int getIndexOf(T _key){
        //     return getIndexOf(root, _key);
        // }
    
        // private int getIndexOf(Leaf<T> leaf, T _key){
        //     T key = leaf.getKey();
        //     if(key.compareTo(_key) == 0)
        //         return leaf.getIndex();
        //     else if(key.compareTo(_key) < 0)
        //         return getIndexOf(leaf.getRight(), _key);
        //     else if(key.compareTo(_key) > 0)
        //         return getIndexOf(leaf.getLeft(), _key);
        //     else
        //         return -1;
        // }
    
        // public T getKeyOf(int _index){
        //     if(_index < 0 || _index > end.getIndex())
        //         return null;
        //     else
        //         return getKeyOf(root, _index);
        // }
    
        // private T getKeyOf(Leaf<T> leaf, int _index){
        //     int index = leaf.getIndex();
        //     if(index == _index)
        //         return leaf.getKey();
        //     else if(index < _index)
        //         return getKeyOf(leaf.getRight(), _index);
        //     else if(index > _index)
        //         return getKeyOf(leaf.getLeft(), _index);
        //     else
        //         return null;
        // }
    
        // public T getFirst(){
        //     return begin.getKey();
        // }
    
        // public T getLast(){
        //     return end.getKey();
        // }
    
        // public T[] toArray(){
        //     Object arr[] = new Object[this.end.getIndex() + 1];
        //     return (T[]) arr;
        // }
        
        // public int size(){
        //     return end.getIndex() + 1;
        // }
    }

    // static class MyQueue<T>{

    //     public T poll(){
            
    //     }
    // }
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        MyTree<Integer> myTree = new MyTree<>();
        while(true){            
            myTree.add(sc.nextInt());
            myTree.print(); 
        }
    }
}
