
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
public class Main {

    public static void main(String[] args) {

        MyList list = new MyList();
        Scanner sc = new Scanner(System.in);
        System.out.print("Size of list: ");
        int size = sc.nextInt();
        System.out.println(" ");

        list.loadData(size);
        
//        //test f1
//        list.f1();
//        
//        //test f2
//        list.f2();
//        
//        //test f3
//        list.f3();

        printMenu();

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 0:
                return;
            case 1:
                list.f1();
                break;
            case 2:
                list.f2();
                break;
            case 3:
                list.f3();
                break;
            case 4:
                list.f4();
                break;
            case 5:
                list.f5();
                break;

            default:
                System.out.println("Invalid choice");
        }

        System.out.println();
    }

    private static void printMenu() {
        System.out.println("=============MENU=============");
        System.out.println("1. Test f1 ");
        System.out.println("2. Test f2 ");
        System.out.println("3. Test f3 ");
        System.out.println("4. Test f4 ");
        System.out.println("5. Test f5 ");
        System.out.println("0. Exit");
        System.out.println("==============================");
        System.out.print("Enter your choice [0 --> 5]: ");
    }
    
}
