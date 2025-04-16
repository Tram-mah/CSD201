
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Slot_02 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(10);
        for(int i=0; i<100000; i++){
            list.add(i);
        }
        for(int i=0; i<10; i++){
            System.out.println(list.get(i));
            
        }
        list.remove(0);
            list.remove(list.size()-1); //Không cần remove first hay last, chỉ cần lấy size trừ ra
        System.out.println("Số lượng: " +list.size());
    }
}
