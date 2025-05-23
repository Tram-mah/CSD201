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

    public boolean isEmpty() {
        return this.head == null;
    }

    public void enqueue(int key) {
        Node newNode = new Node(key);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    //lấy ra và xóa
    public int dequeue() {
        if (!isEmpty()) {
            int x = head.info;
            head = head.next;

            if (head == null) {
                tail = null;
            }
            return x;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    // chỉ lấy ra không xóa
    public int front() {
        if (!isEmpty()) {
            int x = head.info;
            return x;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public void display() {
        Node p = head;
        while (p != null) {
            System.out.println(p.info+" ");
            p = p.next;
        }

    }
}
