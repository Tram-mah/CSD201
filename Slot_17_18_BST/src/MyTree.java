/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class MyTree {

    Node root;

    public MyTree() {
        this.root = null;
    }

    public void load() {
        insert(20);
        insert(10);
        insert(30);
        insert(5);
        insert(15);
        insert(25);
        insert(35);
        insert(100);

    }

    void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node p, int value) {
        if (p == null) {
            p = new Node(value);
        } else if (value < p.info) {
            p.left = insertRec(p.left, value);
        } else if (value > p.info) {
            p.right = insertRec(p.right, value);
        }
        return p;
    }

    void visit(Node p) {
        System.out.println(p.info + " ");
    }

    void preOrder(Node p) {
        if (p == null) {
            return;
        } else {
            visit(p);
            preOrder(p.left);
            preOrder(p.right);
        }
    }

    void inOrder(Node p) {
        if (p == null) {
            return;
        } else {
            inOrder(p.left);
            visit(p);
            inOrder(p.right);
        }
    }

    void postOrder(Node p) {
        if (p == null) {
            return;
        } else {
            postOrder(p.left);
            postOrder(p.right);
            visit(p);
        }
    }

    int search(Node p, int x) {
        // 2TH nó sẽ ra
        if (p == null) {
            return 0; //Không tìm thấy
        }
        if (p.info == x) {
            return 1; //tìm thấy
        }

        //Đệ quy
        if (x < p.info) {
            return search(p.left, x);
        } else {
            return search(p.right, x);
        }

    }

    private int maxLevel(Node p) {
        if (p == null) {
            return 0;
        }
        int maxLeftLevel = maxLevel(p.left);
        int maxRightLevel = maxLevel(p.right);
        return Math.max(maxLeftLevel, maxRightLevel) + 1;
    }

    // 1. Test f1 - compute height
    public int f1() {
        return maxLevel(root) - 1;
    }

    private int countNode(Node p) {
        if (p == null) {
            return 0;
        }
        int x = ((p.info > 5) ? 1 : 0);
        return x + countNode(p.left) + countNode(p.right);
    }

    // 2. Test f2 - count nodes
    public int f2() {
        return countNode(root);
    }

    private int countLeafNode(Node p) {
        if (p == null) {
            return 0;
        }

        int x = ((p.left == null && p.right == null) ? 1 : 0);
        return x + countLeafNode(p.left) + countLeafNode(p.right);
    }

    // 3. Test f3 - count leaf nodes
    public int f3() {
        return countLeafNode(root);
    }

    private int sum(Node p) {
        if (p == null) {
            return 0;
        }
        return p.info + sum(p.left) + sum(p.right);
        //Tính tổng >5
        //int x = ((p.info >5)?p.info:0);
        //return x + sum(p.left)+sum(p.right);

    }

    // 4. Test f4 - compute sum of nodes 
    public int f4() {
        return sum(root);
    }

    // 5. Test f5 - Pre-Order 
    public void f5() {
        preOrder(root);
    }

    // 6. Test f6 - In-Order
    public void f6() {
        inOrder(root);
    }

    // 7. Test f7 - Post-Order
    public void f7() {
        postOrder(root);
    }

    // 8. Test f8 - Search
    public int f8(int x) {
        return search(root, x);
    }
}
