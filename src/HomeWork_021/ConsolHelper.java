package HomeWork_021;
import java.util.Scanner;

public class ConsolHelper {
    void start(){
        ArrayHolder AH = new ArrayHolder();
        Scanner scan = new Scanner(System.in);
        System.out.println("Здравствуйте вас приветствует ConsolHelper");
        System.out.println("Что я могу для вас сделать:");
        System.out.println("1.Создать массив;");
        AH.setTest();
        if(AH.getTest()==1){
            AH.MassEnter();
            AH.MassCheck();
        }
        while (AH.getTest()>0){
            System.out.println("Что я могу еще для вас сделать:");
            System.out.println("0.Выход;");
            System.out.println("1.Пересоздать массив;");
            System.out.println("2.Отсортировать текущий массив;");
            System.out.println("3.Показать текущий массив;");
            System.out.println("4.Найти елемент в текущем массиве;");
            AH.setTest();
            if (AH.getTest()==0){
                System.out.println("Всего хорошего!");
            }
            if (AH.getTest()==1){
                AH.MassEnter();
                AH.MassCheck();
            }
            if (AH.getTest()==2){
                AH.MassSort();
            }
            if (AH.getTest()==3){
                AH.MassCheck();
            }
            if (AH.getTest()==4){
                AH.MassSearch();
            }
        }
        }
    }
