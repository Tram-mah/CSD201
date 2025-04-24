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

    Student info;
    Node left, right;

    public Node() {
        this.info = null;
        this.left = this.right = null;
    }

    public Node(Student info, Node left, Node right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

    public Node(Student info) {
        this(info, null, null);
    }

}
