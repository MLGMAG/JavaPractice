package HomeWork_021;

public class ConsolHelper {
    void start(){
        ArrayHolder AH = new ArrayHolder();
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
            AH.setTest();    //мы вводим значение
            switch (AH.getTest()){
                case 0:
                    System.out.println("Всего хорошего!");
                    break;
                case 1:
                    AH.MassEnter();
                    AH.MassCheck();
                    break;
                case 2:
                    AH.MassSort();
                    break;
                case 3:
                    AH.MassCheck();
                    break;
                case 4:
                    AH.MassSearch();
                    break;
                default:
                    System.out.println("Ошибка введите заново:");
            }
        }
    }
}