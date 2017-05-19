package GoJava_Offline;

import java.util.Scanner;

public class Exercise_3 {

    public String Test;

    private int Price;

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    String sMassProducts[] = {"Абркос","Ананас","Алыча","Айва","Вишня","Хурма","Яблоко"};
    int iMassPrice[] = {25,40,10,50,25,15,8};

    void Start() {
        Scanner scan = new Scanner(System.in);
        Exercise_3 E3 = new Exercise_3();
        System.out.println("Вас приветствует ConsolHelper");
        E3.menu();

        while (true) {
            E3.Test = scan.next();
            switch (E3.Test) {
                case "0":
                    System.exit(0);
                case "1":
                    E3.menu();
                    break;
                case "2":
                    E3.SearchByPrice();
                    break;
                case "3":
                    E3.SearchByPriceRage();
                    break;
                case "4":
                    E3.SearchByName();
                    break;
                default:
                    System.out.println("Ошибка введите заново: ");
                    break;
            }
        }
    }

    void SearchByPrice() {

        // Два цыкла:
        // Один ищет сколько товаров по заданой цене;
        // Второй выводит название этих товаров;

        Scanner scan = new Scanner(System.in);

        System.out.println("Введите точную цену товара:");

        setPrice(scan.nextInt());

        int a = 0;

        for (int i = 0; i < iMassPrice.length; i++) {
            if (getPrice() == iMassPrice[i]) {
                a++;
            }
        }

        if (a == 0) {
            System.out.println("Товаров по заданой цене не найдено(");

        } else {
            System.out.println("Товаров по заданой цене: " + a);
            System.out.println("Это:");

            for (int i = 0; i < iMassPrice.length; i++) {
                if (getPrice() == iMassPrice[i]) {
                    System.out.println(sMassProducts[i]+" "+iMassPrice[i]+" грн/кг");
                }
            }
        }
        System.out.println("==================================");
    }

    void SearchByPriceRage() {

        // Два цыкла:
        // Один ищет сколько товаров по заданой цене;
        // Второй выводит название этих товаров;

        Scanner scan = new Scanner(System.in);

        int a = 0;
        int StartingPrice;
        int FinalPrice;

        System.out.println("Введите диапазон цены:");

        System.out.println("От:");
        StartingPrice = scan.nextInt();
        System.out.println("До:");
        FinalPrice = scan.nextInt();

        for (int i = 0; i < iMassPrice.length; i++) {
            if ((iMassPrice[i] >= StartingPrice) && (iMassPrice[i] <= FinalPrice)) {
                a++;
            }
        }

        if (a == 0) {
            System.out.println("Товаров по заданому диапазону не найдено(");
        } else {
            System.out.println("Товаров по заданому диапазону: " + a);
            System.out.println("Это:");

            for (int i = 0; i < iMassPrice.length; i++) {
                if ((iMassPrice[i] >= StartingPrice) && (iMassPrice[i] <= FinalPrice)) {
                    System.out.println(sMassProducts[i]+" "+iMassPrice[i]+" грн/кг");
                }
            }
        }
        System.out.println("==================================");
    }

    void SearchByName(){
        Scanner scan = new Scanner(System.in);

        boolean a = false;
        String m;

        System.out.println("Введите точное имя товара:");
        m = scan.next();

        for (int i = 0; i <sMassProducts.length ; i++) {
            if (m.equals(sMassProducts[i])){
                a = true;
                System.out.println("Найденные товары:");
                System.out.println(sMassProducts[i]+" "+iMassPrice[i]+" грн/кг");
            }
        }

        if (a == false){
            System.out.println("Данный товар не найден(");
        }
        System.out.println("==================================");
    }
    void menu(){
        System.out.println("                 Menu                 ");
        System.out.println("Выберите действие:");
        System.out.println("0.Выход;");
        System.out.println("1.Меню;");
        System.out.println("2.Поиск товаров по точной цене;");
        System.out.println("3.Поиск товаров по заданому диапазону;");
        System.out.println("4.Поиск по точному названию;");
    }

    void SearchByLetter(){

    }

    public static void main(String[] args) {
        Exercise_3 E3 = new Exercise_3();
        E3.Start();
    }
}