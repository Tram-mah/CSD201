/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class MyQueue {

    Node head, tail;

    public MyQueue() {
        this.head = this.tail = null;
    }
    
    public boolean isEmpty(){
        return this.head == null;
    }
    
    void enqueue(int key){
        Node newNode = new Node(key);
        
        if(isEmpty()){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
    }
    
    public int dequeue(){
        if(isEmpty()){
            head = tail = null;
        }else{
            head = head.next;
        }
        return 0;
    }
    
    public int front(){
        return 0;
    }
}
