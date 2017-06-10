package HomeWork_031;

import HomeWork_022.CollectionHolder;

import java.util.Scanner;

public class ConsolHelper {

    Scanner scan = new Scanner(System.in);

    public void ConsolStart() {
        System.out.println("======================================================================");
        System.out.println("Hello,I'm ConsolHelper");
        System.out.println("Can I halp you:");
        System.out.println("Do you want change default capacity(16)of the list(Y/N):");
        Capacity();
        menu();
        System.out.println("======================================================================");
    }

    public void Capacity() {

        HomeWork_031.CollectionHolder CollectionHolder = new HomeWork_031.CollectionHolder();
        String a = scan.next();

        switch (a) {
            case "Y":
                CollectionHolder.ChangeDefaultCapacity();
                break;
            case "y":
                CollectionHolder.ChangeDefaultCapacity();
                break;
            case "N":
                break;
            case "n":
                break;
            default:
                System.out.println("Error,try again:");
                Capacity();
        }

    }

    public void menu() {

        HomeWork_031.CollectionHolder CollectionHolder = new HomeWork_031.CollectionHolder();

        System.out.println("Choose operation:");
        System.out.println("0.Exit;");
        System.out.println("1.View list;");
        System.out.println("2.Add element;");
        System.out.println("3.Menu;");

        while (true) {

            if (CollectionHolder.list.size() < CollectionHolder.GetCapacity()) {
                int a = CollectionHolder.GetFromScanner();
                switch (a) {
                    case 0:
                        System.out.println("Have a nice day");
                        System.exit(0);
                    case 1:
                        System.out.println("List:" + CollectionHolder.list);
                        C1();
                        break;
                    case 2:
                        System.out.println("Enter the object which will be added to the list:");
                        CollectionHolder.Add(CollectionHolder.GetFromScanner());
                        C1();
                        break;
                    case 3:
                        menu();
                        C1();
                        break;
                    default:
                        System.out.println("There is no such item in the Menu");
                }

            }

            if (CollectionHolder.list.size() == CollectionHolder.GetCapacity()) {
                int a = CollectionHolder.GetFromScanner();
                switch (a) {
                    case 0:
                        System.out.println("Have a nice day");
                        System.exit(0);
                    case 1:
                        System.out.println("List:" + CollectionHolder.list);
                        C1();
                        break;
                    case 2:
                        System.out.println("Enter the object which will be added to the list:");
                        CollectionHolder.AddInFulLCollection(CollectionHolder.GetFromScanner());
                        C1();
                        break;
                    case 3:
                        menu();
                        C1();
                        break;
                    default:
                        System.out.println("There is no such item in the Menu");
                }

            }

        }

    }

    public void C1() {
        System.out.println("Choose your next operation:");
    }

}
