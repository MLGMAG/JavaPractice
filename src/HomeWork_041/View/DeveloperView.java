package HomeWork_041.View;

import HomeWork_041.Controller.DeveloperController;
import HomeWork_041.DAO.DeveloperDAO;

import java.util.Scanner;

/**
 * Created by Magomed on 14.06.2017.
 */
public class DeveloperView {
    public void AppStarter() {
        Scanner scan = new Scanner(System.in);
        DeveloperController DevContrl = new DeveloperController();
        DeveloperDAO DDAO = new DeveloperDAO();
        DevContrl.ReadDocument();
        DevContrl.Parce();
        System.out.println("Hello,I am ConsolHelper,can I help you ?");
        menu();
        while (true) {
            String a = scan.next();
            switch (a) {
                case "0":
                    System.exit(0);
                    break;
                case "1":
                    DevContrl.CreateDeveloper();
                    menu();
                    break;
                case "2":
                    DevContrl.ChangeInfo();
                    menu();
                    break;
                case "3":
                    DevContrl.RemoveDeveloper();
                    menu();
                    break;
                case "4":
                    DevContrl.AllIds();
                    menu();
                    break;
                case "5":
                    System.out.println("All Ids:");
                    DevContrl.AllIds();
                    System.out.println("Enter Id:");
                    DevContrl.GetById();
                    menu();
                    break;
                case "6":
                    menu();
                    break;
                default:
                    System.out.println("There is no such item in menu");
                    System.out.println("Choose another one:");
            }
        }
    }

    public void menu() {
        System.out.println("Choose operation:");
        System.out.println("0.Exit;");
        System.out.println("1.Create Developer;");
        System.out.println("2.Change information about Developers;");
        System.out.println("3.Remove Developer;");
        System.out.println("4.View all developers id;");
        System.out.println("5.Search by Developer by id;");
        System.out.println("6.Menu;");
    }
}
