package try_catch_practice;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CollectionHolder {
    Scanner scan = new Scanner(System.in);

    private int Capacity = 16;

    public int GetCapacity() {
        return Capacity;
    }

    public void ChangeDefaultCapacity() {
        System.out.println("Enter capacity:");
        try {
            Capacity = GetFromScanner();
            this.Capacity = Capacity;
        } catch (InputMismatchException e) {
            System.out.println(e);
            scan.next();
            ChangeDefaultCapacity();
        }

    }

    List<Integer> list = new ArrayList<>(Capacity);

    public void Add(int a) {
        list.add(a);
        System.out.println("Element was added;");
    }

    public void AddInFulLCollection(int a) {
        list.remove(0);
        list.add(a);
    }
    public int GetFromScanner(){
        while (true) {
            int a;
            try {
                a = scan.nextInt();
                return a;
            } catch (InputMismatchException e) {
                System.out.println(e);
                System.out.println("Enter another one:");
                scan.next();
            }
        }

    }
}

