package org.example.dsaquestions;

public class Queue {

    Node head;
    Node tail;
    int length = 0;

    class Node {
        int value;
        Node next;
        public Node(int value){
            this.value = value;
        }
    }
    public Queue(int value){
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    public void enqueElement(int value){
        Node newNode = new Node(value);
        if(length >=1) {
            tail.next = newNode;
            this.tail = newNode;
            length++;
        } else {
            this.head = newNode;
            this.tail = newNode;
            this.length = 1;
        }
    }

    public Node deQueue(){
        if(length == 0) {
            return null;
        }
        Node element = head;
        if(length == 1){
            head = null;
            tail = null;
            return element;
        }
        head = head.next;
        length--;
        return element;
    }

    public int getFirst(){
        return head.value;
    }

    public int getLast(){
        return tail.value;
    }

    public int getLength(){
        return this.length;
    }

    public static void main(String[] args) {
        Queue q = new Queue(2);
        //System.out.println(q.getFirst());
       // System.out.println(q.getLast());
        q.enqueElement(4);
        q.enqueElement(6);
        q.enqueElement(8);
        System.out.println(q.getFirst());
        System.out.println(q.getLast());
        System.out.println(q.getLength());//2,4,6,8
        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
        System.out.println(q.getFirst());
        System.out.println(q.getLast());
        System.out.println(q.getLength());
    }
}
