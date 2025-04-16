import java.util.Random;
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

    Node head;

    public MyList() {
        this.head = null;

    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void clear() {
        this.head = null;
    }

    public void traverse() {
        Node p = head;
        while (p != null) {
            System.out.print(p.info);
            System.out.print(" ");
            p = p.next;
        }
    }

//    Thêm node vào đầu
    public void addFirst(int n) {
        Node newNode = new Node(n);

        //  ADD FIRST
        newNode.next = head;
        head = newNode;
    }

//    Thêm node vào cuối
    public void addLast(int n) {
        Node newNode = new Node(n);
        //  ADD LAST
        //Case 1: nếu list là rỗng thì cho new node bằng head
        if (head == null) {
            head = newNode;
            return;
        }
        //Case 2: nếu list không là rỗng
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        //thêm new node ở điểm cuối
        last.next = newNode;

    }

    void loadData(int k) {
        Random generator = new Random();
        for (int i = 0; i < 10; i++) {
            int num = generator.nextInt(1000) + 1;
            //Thêm vào list
            addFirst(num);
        }
    }

    // Phuonư thức f1: sẽ in ra các node trong Linked list đấy
    void f1() {
        System.out.println("Linked List: ");
        this.traverse();
        System.out.println(" ");
    }

    //Phương thức f2: nhập dữ liệu 1 con số từ bàn phím => addLast
    void f2() {
        System.out.println(" ");
        System.out.println("Before: ");
        this.traverse();

        Scanner sc = new Scanner(System.in);
        System.out.println(" ");
        System.out.print("Enter value to add: ");
        int x = sc.nextInt();
        addLast(x);

        System.out.println(" ");
        System.out.println("After: ");
        this.traverse();
    }

    //Phương thức f3: hàm addPos => thêm node vào vị trí thứ k, trong đó new node
    //và chỉ số k được nhập từ bàn phím
    void f3() {
        System.out.println(" ");
        System.out.println("Before: ");
        this.traverse();

        Scanner sc = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Enter value to add: ");
        int x = sc.nextInt();
        System.out.println(" ");
        System.out.println("Enter poison k (0-based index): ");
        int k = sc.nextInt();

        //Special case for head
        if (k == 0) {
            addFirst(x);
            return;
        }

        //Tìm node ở tại vị trí trước k => k-1
        Node current = head;
        int currentIndex = 0;
        while (currentIndex < k - 1 && current != null) {
            current = current.next;
            currentIndex ++ ;
        }
        //Insert the new node
        Node newNode = new Node (x);
        newNode.next = current.next;
        current.next = newNode;
        
        System.out.println(" ");
        System.out.println("After: ");
        this.traverse();
    }
    
    //Phương thức f4: removeFirst 
    void f4(){
         System.out.println(" ");
        System.out.println("Before: ");
        this.traverse();
        
        if(head != null){
            head = head.next;
        }
        
        System.out.println(" ");
        System.out.println("After: ");
        this.traverse();
    } 
    
    //Phương thức f5: removeLast
    void f5(){
        System.out.println(" ");
        System.out.println("Before: ");
        this.traverse();
        
        if (head != null) {
            // If there is only one element
            if (head.next == null) {
                head = null;
            } else {
                // find the second last node
                Node secondLast = head;
                while (secondLast.next.next != null) {
                    secondLast = secondLast.next;
                }
                // remove last node
                secondLast.next = null;
            }
        }
        
        System.out.println(" ");
        System.out.println("After: ");
        this.traverse();
    }
    
    
    
}