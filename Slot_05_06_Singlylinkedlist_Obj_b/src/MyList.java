
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

    void addFirst(String n, int p) {
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        Phone newPhone = new Phone (n,p);
        Node q = new Node (newPhone);
        head = q;
        if(isEmpty()){
            head = tail = q;
        }else{
            q.next = head; 
            head = q;
        }
        size++;
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
    }

    void addLast(String n, int p) {
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        Phone newphone = new Phone(n, p);
        Node q = new Node(newphone);
        if (isEmpty()) {
            head = tail = q;
        } else {
            tail.next = q;
            tail = q;
        }
        size++;
        
        //Giả sử không có tail và size
        /*
        if(isEmpty()){
            head = newNode;
        }else{
            Node p1 = head;
            while (p1.next!=null){
                p1 = p1.next;
            }
            p1.next = newNode;
        }
        */

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
    }

    // f1: hàm này sẽ gọi hàm addLast nhiều lần
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
        ftraverse(f);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your phone: ");
        String phone = sc.nextLine();
        System.out.print("Enter price of phone: ");
        int price = sc.nextInt();
        addFirst(phone, price);
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // f3: hàm computeSum => tính tổng giá trị của tất cả các Phone có trong list
    void f3() throws Exception {
        clear();
        loadData(0);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        int sum = 0;
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        // 8 + 3 + 5 + 9 + 9 + 2 + 1
        //computeSum = 37
        Node p = head;
        while (p != null) {
            sum += p.info.price;
            p = p.next;
        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        f.writeBytes("Total price = " + sum + "\r\n");
        f.close();
    }

    // f4: remove the most expensive Phone
    void f4() throws Exception {
        clear();
        loadData(0);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        /* 
        if (isEmpty()) {
            return;
        }
        Node p = head, prev = null, maxNode = head, prevMax = null;
        while (p != null) {
            if (p.info.price > maxNode.info.price) {
                maxNode = p;
                prevMax = prev;
            }
            prev = p;
            p = p.next;
        }

        // Xóa maxNode
        if (maxNode == head) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            prevMax.next = maxNode.next;
            if (maxNode == tail) {
                tail = prevMax;
            }
        }
        size--;
        */
        
        if(isEmpty()){
            f.writeBytes("The list is empty \r\n");
            
        }else{
            //Tìm giá đắt nhất
            Node p = head;
            int maxPrice = p.info.price;
            
            while(p!=null){
                if(p.info.price>maxPrice){
                    maxPrice = p.info.price;
                }
                p=p.next;
            }
            //Xóa Max node đi
            if(head.info.price == maxPrice){
                head = head.next;
                if(head==null){
                    tail = null; 
                }
            }else{
                Node prev = head;
                Node p1 = head.next;
                while(p1!=null && p1.info.price != maxPrice){
                    prev = p1;
                    p1 = p1.next;
                }
                if(p1!=null){
                    prev.next = p1.next;// thay thế cái P thành prev
                    if(p1 == tail){
                        tail = prev; //prev trước p sẽ trở thành tail
                    }
                }
            }
        }
        
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // f5: discount all Phone 'S' with 10%
    void f5() throws Exception {
        clear();
        loadData(0);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        Node p = head;
        while (p != null) {
            if (p.info.name.contains("S")) {
                //double newPrice = p.info.price * 0.9; //10%
                //p.info.price = (int) newPrice;
                //có cách ghi ngắn hơn cũng dễ hiểu hơn
                p.info.price = (int) (p.info.price * 0.9);
            }
            p = p.next;
        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
