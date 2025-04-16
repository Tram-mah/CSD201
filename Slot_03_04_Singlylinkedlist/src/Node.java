/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */

public class Node {
//    private
//    protected là liên quan lớp cha con
//    public
    
//    khai báo int như dưới thì chỉ chung package mới thấy
    int info;
    Node next;

//    Constructor default
    public Node() {
    }

//    Constructor for a typical node
    public Node(int info, Node next) {
        this.info = info;
        this.next = next;
    }

    
    public Node(int info) {
        this.info = info;
    }
    
    
}