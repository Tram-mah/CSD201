
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

    public static void main(String args[]) throws Exception {

        StudentStack t = new StudentStack();

        //Display the menu contains a list of possibble choices
        printMenu();

        Scanner sca = new Scanner(System.in);
        int choice = sca.nextInt();
        sca.nextLine();

        switch (choice) {
            case 0:
                return;
            case 1:
                t.f1();
                System.out.println("Your output:");
                Lib.viewFile("f1.txt");
                break;
            case 2:
                t.f2();
                System.out.println("Your output:");
                Lib.viewFile("f2.txt");
                break;
            case 3:
                t.f3();
                System.out.println("Your output:");
                Lib.viewFile("f3.txt");
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
