
import java.util.LinkedList;

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

    public void enqueue(String id, String name, int age, double gpa) {
        Student newStudent = new Student(id, name, age, gpa);
        Node newNode = new Node(newStudent);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    //lấy ra và xóa
    public Student dequeue() {
        if (!isEmpty()) {
            Student x = head.info;
            head = head.next;

            if (head == null) {
                tail = null;
            }
            return x;
        } else {
            return null;
        }
    }

    // chỉ lấy ra không xóa
    public Student front() {
        if (!isEmpty()) {
            Student x = head.info;
            return x;
        } else {
            return null;
        }
    }

    public void display() {
        Node p = head;
        while (p != null) {
            System.out.println(p.info + " ");
            p = p.next;
        }

    }

    // Find student with highest GPA 
    public Student findHighestGPAStudent() {
        if (isEmpty()) {
            return null;
        }

        Node p = head;
        Student highest = p.info;

        while (p != null) {
            if (p.info.getGpa() > highest.getGpa()) {
                highest = p.info;
            }
            p = p.next;
        }

        return highest;
    }

}
