import java.io.RandomAccessFile;

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
    
    public boolean isEmpty(){
        return this.size == 0;
    }
    
    void traverse(){
        Node p = head;
        while (p!=null){
            System.out.println(p.info);
            p = p.next;
        }
    }
    
    //Ghi dữ liệu ra
    void ftraverse(RandomAccessFile f) throws Exception{
        Node p = head;
        while (p!=null){
            f.writeBytes(p.info + " ");
            p = p.next;
        }
        f.writeBytes("\r\n");
        // khi \n thì nó sẽ tiếp ngay đó và xuống dòng
        // a b c d e f [\n]
        //              g
        
        // khi \r\n thì nó sẽ về ngay đầu dòng và xuống dòng
        // a b c d e f [\r\n]
        // g
    }
    
    void loadData(int k){ // k: là dòng thứ k trong file đó
        String a[] = Lib.readLineToStrArray("data.txt", k);
        int n = a.length;
        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(a[i]);
            
        }
    }
    
}