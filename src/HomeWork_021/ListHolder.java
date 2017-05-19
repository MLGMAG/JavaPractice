package HomeWork_021;

import java.util.*;

public class ListHolder {
    public Scanner scan = new Scanner(System.in);
    List<Integer> list = new ArrayList<>();

    void add() {
        System.out.println("Enter element which will be added in List:");
        int a = scan.nextInt();
        list.add(a);
        for (int i = 0; i <list.size()-1 ; i++) {
            list.set(i,list.get(i)+a);
        }
        System.out.println("======================================================================");
    }


    void remove() {
        System.out.println("Enter INDEX of element which will be removed:");
        int a = scan.nextInt();
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) - list.get(a));
        }
        list.remove(a);
        System.out.println("Element was removed");
        System.out.println("======================================================================");
    }

    void much() {
        System.out.println("List objects:" + list.size());
        System.out.println("======================================================================");
    }

    void SearchByValue() {
            System.out.println("Enter value of element:");
            int a = scan.nextInt();
            boolean b=true;
            for (int i = 0; i <list.size() ; i++) {
                if (list.get(i)==a){
                    b=true;
                }else{
                    b=false;
                }
            }
            if (b==true){
                System.out.println("List contains that value");
            }
            if (b==false){
                System.out.println("List not contains that value");
            }
            System.out.println("======================================================================");
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