
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
public class Slot_01 {

    //array
    public static void main(String[] args) {
        int n = 10;
        int[] array = new int[n];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            try {
                System.out.println("Input a[" + i + "]=");
                array[i] = sc.nextInt();
            } catch (Exception e) {

            }
        }
        System.out.println(array); //In ra địa chỉ của biến
//        System.out.println("\n----");
//        for (int i = 0; i < n; i++) {
//            array[i] = 1;
//        }
//        for (int i = 0; i < n; i++) {
//            System.out.print(array[i] + " ");
//        }

        System.out.println("\n----");
        for (int i : array) {
            i = 1;
        }
        for (int i : array) {
            System.out.print(i + " ");
        }

        System.out.println("Số lượng: " + array.length);

        String str = "Chao mung ban quay tro lai voi CSD201! :D";
        System.out.println(str.length());

    }
}
