package package1;

import java.util.Stack;

public class LinkedList {
    Node head;
    int size;
    class Node{
        int val;
        Node next;

        public Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    public LinkedList() {
        this.head = null;
        this.size=0;
    }

    public void addAtIndex(int index, int val) {
        if(index<0){
            return;
        }
        Node newNode=new Node(val);
        if(index==0){
            newNode.next=head;
            head = newNode;
            size++;
            return;
        }
        Node current=head;
        for (int i = 0; i < index - 1; i++) {
            if(current.next==null){
                return;
            }
            current=current.next;
        }
        newNode.next=current.next;
        current.next = newNode;
        size++;
    }
    public void print(){
        Node current=head;
        while (current !=null){
            System.out.print(current.val+"->");
            current=current.next;
        }
    }
    public void printReverse(){
        Stack<Integer> stack=new Stack<>();
        Node current=this.head;
        while(current !=null){
            stack.push(current.val);
            current=current.next;
        }
        while (!stack.empty()) {
            System.out.print(stack.pop() + "->");
        }
        


    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        Node temp = null;
        while (current.next != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        head = prev;
    }
    
    public void remove(int val){
        Node current=head;
        if(current.val==val){
            head=current.next;
            size--;
            return;
        }
        while (current.next !=null){
            if(current.next.val==val){
                current.next=current.next.next;
                size--;
                return;
            }
            current=current.next;
        }
    }

}
