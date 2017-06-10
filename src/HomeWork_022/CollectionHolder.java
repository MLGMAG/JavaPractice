package HomeWork_022;

import java.util.ArrayList;
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
        Capacity = scan.nextInt();
        this.Capacity = Capacity;
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
}

