package HomeWork_022;

import java.util.Scanner;

public class ConsolHelper {

    CollectionHolder CollectionH = new CollectionHolder();
    Scanner scan = new Scanner(System.in);

    public void ConsolStart(){
        System.out.println("======================================================================");
        System.out.println("Hello,I'm ConsolHelper");
        System.out.println("Can I halp you:");
        System.out.println("Do you want change default capacity(16)of the list(Y/N):");
        Capacity();
        menu();
        System.out.println("======================================================================");
    }

    public void menu(){

        System.out.println("Choose operation:");
        System.out.println("0.Exit;");
        System.out.println("1.View list;");
        System.out.println("2.Add element;");
        System.out.println("3.Menu;");

        while (true){

            if (CollectionH.list.size() < CollectionH.GetCapacity()){
                String a = scan.next();
                switch (a){
                    case "0":
                        System.out.println("Have a nice day");
                        System.exit(0);
                    case "1":
                        System.out.println("List:"+CollectionH.list);
                        C1();
                        break;
                    case "2":
                        System.out.println("Enter the object which will be added to the list:");
                        CollectionH.Add(scan.nextInt());
                        C1();
                        break;
                    case "3":
                        menu();
                        C1();
                        break;
                }

            }

            if (CollectionH.list.size() == CollectionH.GetCapacity()){
                String a = scan.next();
                switch (a){
                    case "0":
                        System.out.println("Have a nice day");
                        System.exit(0);
                    case "1":
                        System.out.println("List:"+CollectionH.list);
                        C1();
                        break;
                    case "2":
                        System.out.println("Enter the object which will be added to the list:");
                        CollectionH.AddInFulLCollection(scan.nextInt());
                        C1();
                        break;
                    case "3":
                        menu();
                        C1();
                        break;
                }

            }

        }

    }



    public void Capacity(){

        String a = scan.next();

        switch (a){
            case "Y":
                CollectionH.ChangeDefaultCapacity();
                break;
            case "y":
                CollectionH.ChangeDefaultCapacity();
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

    public void C1(){
        System.out.println("Choose your next operation:");
    }

}
