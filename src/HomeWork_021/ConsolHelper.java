package HomeWork_021;

public class ConsolHelper {
    void start(){
        ArrayHolder AH = new ArrayHolder();
        System.out.println("Здравствуйте вас приветствует ConsolHelper");
        System.out.println("Что я могу для вас сделать:");
        System.out.println("1.Создать массив;");
        AH.getA();
        if(AH.getA()==1){
            AH.MassEnter();
            AH.MassCheck();
        }
        while (AH.getA()>0){
            System.out.println("Что я могу еще для вас сделать:");
            System.out.println("0.Выход;");
            System.out.println("1.Пересоздать массив;");
            System.out.println("2.Отсортировать текущий массив;");
            System.out.println("3.Показать текущий массив;");
            System.out.println("4.Найти елемент в текущем массиве;");
            AH.getA();    //мы вводим значение
            if (AH.getA()==0){
                System.out.println("Всего хорошего!");
            }
            if (AH.getA()==1){
                AH.MassEnter();
                AH.MassCheck();
            }
            if (AH.getA()==2){
                AH.MassSort();
            }
            if (AH.getA()==3){
                AH.MassCheck();
            }
            if (AH.getA()==4){
                AH.MassSearch();
            }
        }
        }
    }
