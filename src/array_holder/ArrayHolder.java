package array_holder;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayHolder {

    public String Test;

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

    public void MassEnter() {
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
    public void MassCheck(){
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
    public void MassSort(){
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
    public void MassSearch(){
        System.out.println("Введите елемент который хотите найти:");
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        boolean b = false;
        int c = 0;
        for (int i = 0; i <imas.length ; i++) {
            if (a==imas[i]){
                b=true;
                c=i+1;
                break;
            }
        }
        if (!b){
            System.out.println("Данный елемент не присутствует в массиве(");
        }
        if (b){
            System.out.println("Данный елемент присутствует в массиве,его номе: "+c);
        }
        System.out.println("=================================================");
    }
    public void Menu(){
        System.out.println("                 Меню             ");
        System.out.println("Выберите дейтсвие:");
        System.out.println("0.Выход;");
        System.out.println("1.Меню;");
        System.out.println("2.Пересоздать массив;");
        System.out.println("3.Отсортировать текущий массив;");
        System.out.println("4.Показать текущий массив;");
        System.out.println("5.Найти елемент в текущем массиве;");
    }
}
