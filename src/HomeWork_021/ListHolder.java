package HomeWork_021;

import java.util.*;

public class ListHolder {
    public Scanner scan = new Scanner(System.in);
    List<Integer> list = new ArrayList<>();

    void add() {
        try {
            System.out.println("Enter element which will be added in List:");
            int a = scan.nextInt();
            list.add(a);
            System.out.println("======================================================================");
        } catch (Exception c) {
            System.out.println("Error");
            System.out.println("It's not String List ,so write only numbers ");
            System.out.println("======================================================================");
        }
    }

    void remove() {
        try {
            System.out.println("Enter element which will be removed:");
            int a = scan.nextInt();
            list.remove(a);
            System.out.println("======================================================================");
        }
        catch (Exception c){
            System.out.println("Error");
            System.out.println("It's not String List ,so write only numbers ");
            System.out.println("======================================================================");
        }
    }

    void much() {
        System.out.println("List objects:" + list.size());
        System.out.println("======================================================================");
    }

    void SearchByValue() {
        try {
            int a = scan.nextInt();
            list.contains(a);
            if (true) {
                System.out.println("List contains that object");
            } else {
                System.out.println("List not contains that object");
            }
            System.out.println("======================================================================");
        }
        catch (Exception c){
            System.out.println("Error");
            System.out.println("It's not String List ,so write only numbers ");
            System.out.println("======================================================================");
        }
    }

    void SearchByIndex() {
        int a;
        System.out.println("Enter index which want to search:");
        try {
            a = scan.nextInt();
            System.out.println(list.get(a));
        } catch (Exception e) {
            System.out.println("There are not numbers by that index");
        }
        System.out.println("======================================================================");
    }

    void SearchMaxNumber() {
        System.out.println("Element with max value is: " + Collections.max(list));
        System.out.println("======================================================================");
    }

    void SearchMinNumber() {
        System.out.println("Element with min value is: " + Collections.min(list));
        System.out.println("======================================================================");
    }
    void SearchAverageNumber() {
        System.out.print("Element with average value is: ");
        double a = 0;
        for (int i = 0; i <list.size() ; i++) {
            a+=list.get(i);
        }
        a/=list.size();
        a=(a/100)*100.00;
        System.out.println(a);
        System.out.println("======================================================================");
    }
    void view(){
        System.out.println(list);
        System.out.println("======================================================================");
    }
}