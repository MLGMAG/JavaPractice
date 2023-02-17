package array_list_practice;

import java.util.Scanner;

public class ConsolHelper {
    ListHolder LH = new ListHolder();
    Scanner scan = new Scanner(System.in);
    String a;

    void ConsolStart(){
        System.out.println("======================================================================");
        System.out.println("Hello,I'm ConsolHelper");
        System.out.println("Can I halp you:");
        Menu();
        C1();
        System.out.println("======================================================================");
        while (true) {
            a = scan.next();
            switch (a) {
                case "0":
                    System.out.println("Have a nice day)");
                    System.exit(0);
                case "1":
                    LH.view();
                    break;
                case "2":
                    LH.much();
                    C0();
                    break;
                case "3":
                    LH.add();
                    C0();
                    break;
                case "4":
                    LH.remove();
                    C0();
                    break;
                case "5":
                    LH.SearchByValue();
                    C0();
                    break;
                case "6":
                    LH.SearchByIndex();
                    C0();
                    break;
                case "7":
                    LH.SearchMaxNumber();
                    C0();
                    break;
                case "8":
                    LH.SearchMinNumber();
                    C0();
                    break;
                case "9":
                    LH.SearchAverageNumber();
                    C0();
                    break;
                case "10":
                    Menu();
                    C0();
                    break;
                default:
                    System.out.println("Error,enter again:");
            }
        }
    }



    void Menu(){
        System.out.println("0.Exit;");
        System.out.println("1.View list;");
        System.out.println("2.Number of all element;");
        System.out.println("3.Add value;");
        System.out.println("4.Remove value;");
        System.out.println("5.Search by element value;");
        System.out.println("6.Search by index;");
        System.out.println("7.Search max value;");
        System.out.println("8.Search min value;");
        System.out.println("9.Search average value;");
        System.out.println("10.Menu");
        System.out.println("======================================================================");
    }
    void C0(){
        System.out.println("Another operation:");
    }
    void C1(){
        System.out.println("WARNING:It's very specific list because when you add element number that number adds to all element ");
    }
}
