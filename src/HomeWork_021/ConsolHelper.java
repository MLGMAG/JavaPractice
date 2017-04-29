package HomeWork_021;

import java.util.Scanner;

public class ConsolHelper {
    void start(){
        ArrayHolder AH = new ArrayHolder();
        System.out.println("Здравствуйте вас приветствует ConsolHelper");
        System.out.println("Выберите действие:");
        System.out.println("0.Выход");
        System.out.println("1.Создать массив;");
        Scanner scan = new Scanner(System.in);
        while (true) {
            AH.Test = scan.next();   //мы вводим значение
            switch (AH.Test){
                case"0":
                    System.out.println("Всего хорошего!");
                    System.exit(0);
                case "1":
                    AH.MassEnter();
                    AH.MassCheck();
                    break;
                default:
                    System.out.println("Ошибка,введите повторно:");
                    break;
            }
            if(new String("1").equals(AH.Test)){
                break;
            }
        }
         AH.Menu();
        while (true) {
            AH.Test = scan.next();    //мы вводим значение
            switch (AH.Test) {
                case "0":
                    System.out.println("Всего хорошего!");
                    System.exit(0);
                case "1":
                    AH.Menu();
                    break;
                case "2":
                    AH.MassEnter();
                    AH.MassCheck();
                    AH.Menu();
                    break;
                case "3":
                    AH.MassSort();
                    break;
                case "4":
                    AH.MassCheck();
                    break;
                case "5":
                    AH.MassSearch();
                    break;
                default:
                    System.out.println("Ошибка введите заново:");
                    break;
            }
        }
    }
}
