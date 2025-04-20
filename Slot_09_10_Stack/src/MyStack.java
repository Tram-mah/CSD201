/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class MyStack {

    Node top;

    public MyStack() {
    }

    public MyStack(Node top) {
        this.top = top;
    }

    //Thêm 1 phần tử và vị trí top đầu
    public void push(int x) {
        Node newNode = new Node(x);

        //New node đó điểm ngay node mà là top hiện tại
        newNode.next = top;

        // Cập nhật lại điểm top ở node mới
        top = newNode;
    }

    public void load() {
        this.push(10);
        this.push(14);
        this.push(7);
        this.push(7);
        this.push(3);
        this.push(2);
        this.push(15);
        this.push(9);
    }

    //Check stack có rỗng không
    public boolean isEmpty() {
        return top == null;
    }

    //Hàm peek: Hàm chỉ lấy ra giá trị nhưng không xóa 
    public int peek() {
        if (!isEmpty()) {
            return top.info;
        } else {
            System.out.println("Stack is empty!!");
            return -1; //-1: trả về giá trị mặc định nếu stack empty
        }
    }

    //Hàm pop: Hàm chỉ lấy ra giá trị nhưng xóa 
    public int pop() {
        if (!isEmpty()) {
            int x = top.info;   //Lưu trữ giá trị của top đó
            top = top.next;     //dòi top sang phần tử tiếp theo
            return x;           //trả về giá trị top
        } else {
            System.out.println("Stack is empty!!");
            return -1; //-1: trả về giá trị mặc định nếu stack empty
        }
    }

    public void display() {
        if (!isEmpty()) {
            Node p = top;
            System.out.println("Stack elements: ");
            while (p != null){
                System.out.println(p.info +" ");
                p=p.next;
            }
            System.out.println("");
        }else{
            System.out.println("Stack is empty!!");
        }
    }

}
