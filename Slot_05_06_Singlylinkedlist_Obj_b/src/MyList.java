
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class MyList {

    Node head, tail;
    int size;

    public MyList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    void traverse() {
        Node p = head;
        while (p != null) {
            System.out.print(p.info);
            p = p.next;
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            f.writeBytes(p.info + " ");
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) { // k: là dòng thứ k trong file
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(a[i]);
            addLast(number);
        }
    }

    void addFirst(int n) {
        Node newNode = new Node(n);
        if (head == null) {
//            head = newNode;
//            tail = newNode;
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    void addLast(int n) {
        Node newNode = new Node(n);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }

    // f1: hàm này sẽ gọi hàm addlast nhiều lần
    void f1() throws Exception {
        clear();
        loadData(0);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

    // f2: hàm addFirst => dữ liệu nhập từ bàn phím
    void f2() throws Exception {
        clear();
        loadData(0);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your value: ");
        int x = sc.nextInt();
        addFirst(x);
        ftraverse(f);
        f.close();
    }

    // f3: hàm addPos 
    // => thêm node vào vị trí thứ k, trong đó new node va chỉ số k được nhập từ
    // bàn phím
    void f3() throws Exception {
        clear();
        loadData(0);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your value: ");
        int x = sc.nextInt();
        System.out.println("Enter poison k to add(0 to " + size + "): ");
        int k = sc.nextInt();

        if (k == 0) {
            addFirst(x);
        } else if (k == size) {
            addLast(x);
        } else {
            Node newNode = new Node(x);
            Node p = head;
            //Tranverse to the node before position k
            for (int i = 0; i < k - 1; i++) {
                p = p.next;
            }
            //Insert 
            newNode.next = p.next;
            p.next = newNode;
            size++;
        }

        ftraverse(f);
        f.close();
    }

    // f4: removeFirst
    void f4() throws Exception {
        clear();
        loadData(0);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");

        if (!isEmpty()) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            //vì có thêm thằng size nên phải giải quyết size giảm đi như nào
            size--;
        }

        ftraverse(f);
        f.close();
    }

    // f5: removeLast
    void f5() throws Exception {
        clear();
        loadData(0);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");

        if (!isEmpty()) {
            if (size == 1) {
                head = tail = null;
                size = 0;
            }else{
                Node p = head;
                for (int i = 0; i < size - 2; i++) {
                    p=p.next;
                }
                System.out.println(p.info);
//                System.out.println(size);
                tail = p;
                p.next = null;
                size--;
            }

            ftraverse(f);
            f.close();
        }
    }
}
