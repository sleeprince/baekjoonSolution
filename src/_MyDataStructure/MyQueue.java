package _MyDataStructure;

public class MyQueue<T> {

    private Node<T> head;

    private class Node<T>{
        public T item;
        public Node<T> pre;
        public Node<T> next;
        public Node(){
            item = null;
            pre = null;
            next = null;
        }
        public Node(T _item){
            this.item = _item;
            pre = null;
            next = null;
        } 
    }

    public MyQueue(){
        this.head = null;
    }

    public MyQueue(T _item){
        Node node = new Node<>(_item);
        this.head = node;
    }

    public boolean add(T _item){

    }
    public boolean offer(T _item){}
    public T remove(){}
    public boolean remove(T item){}
    public T poll(){
        
    }
    public T element(){}
    public T peek(){}
    public void clear(){}
    public int size(){}
    public boolean contains(){}
    public boolean isEmpty(){}
}
