package sort_array;

import java.util.Arrays;
import java.util.Scanner;

public class SortArray {
    public static void main(String[] args) {
        int imas[] = new int[5];
        Scanner scan=new Scanner(System.in);
        for (int i=0;i<imas.length;i++){
            int a=i+1;
            System.out.println("Enter number "+a+":");
            imas[i]=scan.nextInt();
        }
        System.out.print("Initial array: ");
        for (int i=0;i<imas.length;i++){
            if (i == imas.length - 1) {
                System.out.println(imas[i]);
                break;
            }
            System.out.print(imas[i]+",");
        }
        System.out.print("Sorted array: ");
        Arrays.sort(imas);
        for (int i=0;i<imas.length;i++){
            if (i == imas.length - 1) {
                System.out.println(imas[i]);
                break;
            }
            System.out.print(imas[i]+",");
        }
    }
}
