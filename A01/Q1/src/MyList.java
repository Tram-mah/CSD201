
import java.util.*;
import java.io.*;

public class MyList {

    Node head, tail;
    int size;

    MyList() {
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

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            f.writeBytes(p.info.name + "-" + p.info.price + "     "); // write data in the node p to the file f
            p = p.next;
        }

        f.writeBytes("\r\n");
    }

    void loadData(int k) {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        String[] b = Lib.readLineToStrArray("data.txt", k + 1);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(b[i]);

            addLast(a[i], p);
        }
    }

    // Luu y: doc ky dieu kien trong de bai
    void addLast(String n, float p) {
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        Phone newPhone = new Phone(n, p);
        Node newNode = new Node(newPhone);

        if (newPhone.price <= 0) {
            return;
        }
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
    }

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

    void f2() throws Exception {
        clear();
        loadData(0);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        Phone t = new Phone("FPT_Phone", 100);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        if (isEmpty()) {
            System.out.println("Empty");
        } else {
            Node p = head;
            Node maxNode = head;

            // Tìm node có price lớn nhất
            while (p != null) {
                if (p.info.price > maxNode.info.price) {
                    maxNode = p;
                }
                p = p.next;
            }

            Node newn = new Node(t);

            // Chèn newn vào sau maxNode
            newn.next = maxNode.next;
            maxNode.next = newn;

            // Cập nhật lại tail
            if (maxNode == tail) {
                tail = newn;
            }

            size++;
        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void f3() throws Exception {
        clear();
        loadData(0);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        float avg_S = 0;
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        float sum = 0;
        int count = 0;
        Node p = head;
        while (p != null) {
            if (p.info.name.equals("S")) {
                sum += p.info.price;
                count++;
            }
            p = p.next;
            count = (count == 0) ? 1 : count;
            avg_S = sum / count;
        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        f.writeBytes(avg_S + "\n"); // write data
        ftraverse(f);
        f.close();
    }

    void f4() throws Exception {
        clear();
        loadData(0);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        for (int i = 0; i < 3; i++) {
            if (head == null) {
                return;
            }
            head = head.next;
            size--;
        }
        if (head == null) {
            tail = null;
        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void f5() throws Exception {
        clear();
        loadData(0);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
