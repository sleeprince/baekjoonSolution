package _MyDataStructure;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        MyTree<Integer> myTree = new MyTree<>();    
        while(true){
            String[] arr = sc.nextLine().split(" ");
            for(String num : arr)
                myTree.add(Integer.parseInt(num));             
            myTree.print();
            System.out.println("가장 작은 수:" + myTree.first());
            System.out.println("가장 큰 수:" + myTree.last());
            System.out.println(myTree.contains(12));
        }        
    }
}
