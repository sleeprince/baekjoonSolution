package _MyDataStructure;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

class MyTree<T extends Comparable<T>> {

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

        //생성자
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
        //확인용 콘솔 출력 문구
        public String[] toStringArray(){
            String[] str = new String[8];
            str[0] = "┏━━━━━━━━━━━━━━━━┓";
            str[1] = String.format("┃ 키  값: %-7s┃", this.key);
            if(this.parent != null)
            str[2] = String.format("┃ 부  모: %-7s┃", this.parent.key);
            else
            str[2] = String.format("┃ 부  모: %-7s┃", "null");
            if(this.left != null)
            str[3] = String.format("┃ 왼  쪽: %-7s┃", this.left.key);
            else
            str[3] = String.format("┃ 왼  쪽: %-7s┃", "null");
            if(this.right != null)
            str[4] = String.format("┃ 오른쪽: %-7s┃", this.right.key);
            else
            str[4] = String.format("┃ 오른쪽: %-7s┃", "null");
            str[5] = String.format("┃ 높  이: %-7s┃", this.height);
            str[6] = String.format("┃ 인덱스: %-7s┃", this.index);
            str[7] = "┗━━━━━━━━━━━━━━━━┛";
            return str;
        }
    }

    public MyTree(){
        this.root = null;
        this.begin = null;
        this.end = null;
    }

    public MyTree(T _key){
        Leaf<T> leaf = new Leaf(_key);
        this.root = leaf;
        this.begin = leaf;
        this.end = leaf;
    }

    public boolean add(T _key){    
        Leaf<T> leaf = new Leaf(_key);    
        if(this.root == null){
            this.root = leaf;   
            this.begin = leaf;
            this.end = leaf;             
            return true;
        }else if(addNext(this.root, leaf)){
            if(leaf.leftmost)
            this.begin = leaf;
            if(leaf.rightmost)
            this.end = leaf;
            return true;
        }else{
            return false;   
        }
    }

    public boolean addAll(Collection<? super T> c){
        boolean isSuccessful = true;
        for(Object obj : c){
            if(!add((T)obj))
                isSuccessful = false;
        }
        return isSuccessful;
    }
    
    private boolean addNext(Leaf<T> now, Leaf<T> _leaf){            
        if(!this.contains(_leaf.key)){
            if(now.key.compareTo(_leaf.key) < 0){
                //오른쪽으로
                _leaf.leftmost = false;
                if(now.right == null){
                    now.right = _leaf;
                    _leaf.parent = now;
                    update_height(now);
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
                    update_height(now);
                    return true;
                }else{
                    return addNext(now.left, _leaf);
                }
            }
        }
        return false;        
    }

    private int skew(Leaf<T> _leaf){
        int right_h = (_leaf.right == null)? 0:_leaf.right.height;
        int left_h = (_leaf.left == null)? 0:_leaf.left.height;
        return right_h - left_h;
    }
    
    private void update_height(Leaf<T> _leaf){
        if(_leaf != null){
            int right_h = (_leaf.right == null)? 0:_leaf.right.height;
            int left_h = (_leaf.left == null)? 0:_leaf.left.height;
            int max_h = (right_h > left_h)? right_h:left_h;
            if(_leaf.height != max_h + 1){
                _leaf.height = max_h + 1;
                rebalance(_leaf);
                update_height(_leaf.parent);
            }            
        }
    }
    
    private void rebalance(Leaf<T> _leaf){
        if(skew(_leaf) > 1){
            if(skew(_leaf.right) == -1)
                rotate_right(_leaf.right);
            rotate_left(_leaf);
        }else if(skew(_leaf) < -1){
            if(skew(_leaf.left) == 1)
                rotate_left(_leaf.left);
            rotate_right(_leaf);
        }
    }
    
    private void rotate_right(Leaf<T> _leaf){
        Leaf<T> new_leaf = _leaf.left;
        if(this.root == _leaf)
            this.root = new_leaf;

        //뿌리 교환
        new_leaf.parent = _leaf.parent;
        if(_leaf.parent != null){
            if(_leaf.parent.left == _leaf)
                _leaf.parent.left = new_leaf;
            else
                _leaf.parent.right = new_leaf; 
        }
        _leaf.parent = new_leaf;
        
        //잎사귀 교환
        _leaf.left = new_leaf.right;
        new_leaf.right = _leaf;

        //height 조정
        int right_h = (_leaf.right == null)? 1:_leaf.right.height + 1;
        int left_h = (_leaf.left == null)? 1:_leaf.left.height + 1;
        _leaf.height = (right_h > left_h)? right_h:left_h;        

        //index 조정
        _leaf.index = (_leaf.left == null)? 0:_leaf.left.index + 1;
    }
    
    private void rotate_left(Leaf<T> _leaf){
        Leaf<T> new_leaf = _leaf.right;
        if(this.root == _leaf)
            this.root = new_leaf;

        //뿌리 교환
        new_leaf.parent = _leaf.parent;
        if(_leaf.parent != null){
            if(_leaf.parent.left == _leaf)
                _leaf.parent.left = new_leaf;
            else
                _leaf.parent.right = new_leaf; 
        }
        _leaf.parent = new_leaf;
        
        //잎사귀 교환
        _leaf.right = new_leaf.left;
        new_leaf.left = _leaf;

        //height 조정
        int right_h = (_leaf.right == null)? 1:_leaf.right.height + 1;
        int left_h = (_leaf.left == null)? 1:_leaf.left.height + 1;
        _leaf.height = (right_h > left_h)? right_h:left_h;

        //index 조정
        new_leaf.index = _leaf.index + 1;
    }

    public boolean contains(T _key){
        return contains(this.root, _key);
    }

    private boolean contains(Leaf<T> _leaf, T _key){
        if(_leaf.key.compareTo(_key) == 0){
            return true;
        }else if(_leaf.key.compareTo(_key) < 0){
            if(_leaf.right == null)
                return false;
            else
                return contains(_leaf.right, _key);
        }else if(_leaf.key.compareTo(_key) > 0){
            if(_leaf.left == null)
                return false;
            else
                return contains(_leaf.left, _key);
        }
        return false;
    }

    public boolean containsAll(Collection<? super T> c){
        boolean flag = true;
        for(Object obj : c){
            if(!contains((T)obj))
                flag = false;
        }
        return flag;
    }

    public T first(){
        return begin.key;
    }

    public T last(){
        return end.key;
    }

    public T higher(T _key){
        return higher(root, _key);
    }

    // private T higher(Leaf<T> _leaf, T _key){
    //     if(_leaf.key.compareTo(_key) < 0){
    //         if(_leaf.right == null)
    //             return null;
    //         else
    //             return higher(_leaf.right, _key);
    //     }else if(_leaf.key.compareTo(_key) > 0){

    //     }
    // }
    // public T lower(T a){}
    
    
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

    // public boolean isEmpty(){}

    // public T pollFirst(){}
    // public T pollLast(){}
    // public boolean remove(T a){}
    // public boolean retainAll(Collection<? super T> c){}
    // public void clear(){}

    // public T[] toArray(){
    //     Object arr[] = new Object[this.end.getIndex() + 1];
    //     return (T[]) arr;
    // }
    
    // public int size(){
    // }    
    
    //확인용 출력 메소드
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
    // private class MyIter implements Iterator<T>{
        
    //     public boolean hasNext(){
    //         return false;
    //     }

    //     public 
    // }   
    
}
