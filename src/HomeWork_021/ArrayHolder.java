package HomeWork_021;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayHolder {

    private int Test;

    public int getTest(){
        return Test;
    }
    public int setTest() {
        Scanner scan = new Scanner(System.in);
        Test = scan.nextInt();
        this.Test = Test;
        return Test;
    }

    private int MasSize;
    public int getMasSize() {
        return MasSize;
    }
    public int setMasSize(){
        Scanner scan = new Scanner(System.in);
        MasSize = scan.nextInt();
        this.MasSize=MasSize;
        return MasSize;
    }

    public int imas[];

    void MassEnter() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите размер массива:");
        setMasSize();
        imas = new int[getMasSize()];
        for (int i = 0; i < imas.length; i++) {
            int a;
            a = 0;
            a = i + 1;
            System.out.println("Введите елемент под номером " + a);
            imas[i] = scan.nextInt();
        }
        System.out.println("=================================================");
    }
    void MassCheck(){
        System.out.println("Ваш текущий массив:");
        System.out.print("{");
        for (int i = 0; i <imas.length ; i++) {
            if (i==imas.length-1){
                System.out.print(imas[i]);
                break;
            }
            System.out.print(imas[i]+",");
        }
        System.out.println("}");
        System.out.println("=================================================");
    }
    void MassSort(){
        Arrays.sort(imas);
        System.out.println("Ваш массив(сортированный):");
        System.out.print("{");
        for (int i = 0; i <imas.length ; i++) {
            if (i==imas.length-1){
                System.out.print(imas[i]);
                break;
            }
            System.out.print(imas[i]+",");
        }
        System.out.println("}");
        System.out.println("=================================================");
    }
    void MassSearch(){
        System.out.println("Введите елемент который хотите найти:");
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        for (int i = 0; i <imas.length ; i++) {
            if (a==imas[i]){
                System.out.println("Данный елемент присутствует в массиве,его номер:");
                System.out.println(i);
            }
        }
        System.out.println("Данный елемент не присутствует в массиве(");
        System.out.println("=================================================");
    }
}

