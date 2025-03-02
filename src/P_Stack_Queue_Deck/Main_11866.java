package P_Stack_Queue_Deck;
// 요세푸스 문제는 다음과 같다
// 1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 이제 순서대로 K번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
// N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.

// 첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 1,000)
// 예제와 같이 요세푸스 순열을 출력한다.

import java.util.Scanner;
// LinkedList로 구현
class MyLinkedCyclicList{
    private int size;
    private Node head;
    private class Node{
        int content;
        Node prev;
        Node next;
        Node(int _content){
            this.content = _content;
            this.prev = null;
            this.next = null;
        }
    }
    public MyLinkedCyclicList(){
        this.size = 0;
        this.head = null;
    }
    public void push(int _content){
        Node node = new Node(_content);
        if(this.size == 0){
            this.head = node;
            this.head.prev = head;
            this.head.next = head;
        }else{
            node.prev = this.head;
            node.next = this.head.next;
            this.head.next.prev = node;
            this.head.next = node;
            this.head = node;
        }
        size++;
    }
    public int pop(){
        if(this.size == 0){
            return -1;
        }else{
            Node tmp = this.head;
            this.head.prev.next = this.head.next;
            this.head.next.prev = this.head.prev;
            this.head = this.head.prev;
            tmp.next = null;
            tmp.prev = null;
            size--;
            return tmp.content;
        }
    }
    public int peek(){
        return (this.size == 0)? -1 : this.head.content;
    }
    public int size(){
        return this.size;
    }
    public boolean isEmpty(){
        return (this.size == 0)? true : false;
    }
    public int next(){
        if(this.size == 0) return -1;
        this.head = this.head.next;
        return this.head.content;
    }
    public int prev(){
        if(this.size == 0) return -1;
        this.head = this.head.prev;
        return this.head.content;
    }
    public int[] toArray(){
        int[] arr = new int[this.size];
        for(int i = 0; i < arr.length; i++) arr[i] = this.next();
        return arr;
    }
}
public class Main_11866 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        MyLinkedCyclicList nums = new MyLinkedCyclicList();
        for(int i = 1; i < n + 1; i++) nums.push(i);
        MyLinkedCyclicList josephus = new MyLinkedCyclicList();
        while(!nums.isEmpty()){
            for(int i = 0; i < k; i++) nums.next();
            josephus.push(nums.pop());
        }
        String str = "<";
        for(int i = 0; i < josephus.size(); i++)
            str += (i < josephus.size() - 1)? josephus.next() + ", " : josephus.next() + ">";            
        System.out.println(str);        
        sc.close();
    }
}
