package HomeWork_041;

import java.io.*;
import java.util.*;

/**
 * Created by Magomed on 14.06.2017.
 */

public class DeveloperDAO {
    Scanner scan = new Scanner(System.in);
    Map<Integer, Developer> DevMap = new HashMap<>();
    Map<Integer, String> DefaultMap = new HashMap<>();
    public static String Text;
    public static int Developers;

    public void ReadDocument() {
        try (BufferedReader BuffRead = new BufferedReader(new FileReader("D:\\Java\\IdeaProjects\\HomeWorks\\src\\HomeWork_041\\Developers"))) {
            String line;
            String a = null;
            while ((line = BuffRead.readLine()) != null) {
                if (a == null) {
                    a = line;
                }
                if (a != null) {
                    a += line;
                }
            }
            Text = a;
        } catch (IOException e) {
            System.out.println("Error:" + e);
        }
    }

    public void Parce() {

        String localtext = Text;
        String lines[] = localtext.split(";");
        Developers = lines.length;
        String words_1[];
        for (int i = 1; i < lines.length; i++) {
            words_1 = lines[i].split(",", 2);
            int id = new Integer(words_1[0]);
            DefaultMap.put(id, words_1[1]);
        }
        String words_2[];
        for (int i = 0; i < lines.length; i++) {
            words_2 = lines[i].split(",");
            int id = new Integer(words_2[0]);
            double sellery = new Double(words_2[4]);
            DevMap.put(id, new Developer(id, words_2[1], words_2[2], words_2[3], sellery));
        }
    }

    public void AllIds() {
        System.out.println("Ids:");
        for (Map.Entry<Integer, Developer> item : DevMap.entrySet()) {
            System.out.print(item.getValue().getId() + ";");
        }
        System.out.println();
    }

    public void GetById() {
        while (true) {
            try {
                int id = scan.nextInt();
                if ((DevMap.get(id).toString()) == null) {
                    System.out.println("Developer with that id does not exist");
                }
                if ((DevMap.get(id).toString()) != null) {
                    System.out.println(DevMap.get(id).toString());
                    break;
                }
            } catch (NullPointerException e) {
                System.out.println("Error:" + e);
                System.out.println("Try another:");
            } catch (InputMismatchException e) {
                System.out.println("Error:" + e);
                scan.next();
                System.out.println("Try another:");

            }
        }
    }

    public void CreateDeveloper() {
        Developers += 1;
        while (true) {
            try {
                int a[] = new int[Developers];
                int b = 0;
                System.out.println("What Id do you want to assign to this developer:");
                System.out.print("NOT:negative numbers and");
                for (Map.Entry<Integer, Developer> item : DevMap.entrySet()) {
                    System.out.print(item.getValue().getId() + ";");
                    a[b] = item.getValue().getId();
                    b++;
                }
                System.out.println();
                int id = scan.nextInt();
                System.out.println("What First Name do you want to assign to this developer:");
                scan.nextLine();
                String FirstName = scan.nextLine();
                System.out.println("What Last Name do you want to assign to this developer:");
                String LastName = scan.nextLine();
                System.out.println("What Job do you want to assign to this developer:");
                String job = scan.nextLine();
                System.out.println("What Sellery do you want to assign to this developer:");
                double selery = scan.nextDouble();
                DevMap.put(id, new Developer(id, FirstName, LastName, job, selery));
                System.out.println(DevMap.get(id).toString());
                WrightDocument_ADD(id);
                ReadDocument();
                Parce();
                scan.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error" + e);
                scan.next();
            }
        }
    }

    public void RemoveDeveloper() {
        System.out.println("Enter id of Developer which will be removed:");
        while (true) {
            try {
                int id = scan.nextInt();
                if (DevMap.get(id) == null) {
                    System.out.println("Error:developer with that id does not exist");
                    break;
                }
                DevMap.remove(id);
                DefaultMap.remove(id);
                WrightDocument_Remove();
                System.out.println("Successfully:developer was removed;");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error:" + e);
                scan.next();
                System.out.println("Try again:");
            }
        }
    }

    public void WrightDocument_Remove() {
        try (BufferedWriter BuffWrite = new BufferedWriter(new FileWriter("D:\\Java\\IdeaProjects\\HomeWorks\\src\\HomeWork_041\\Developers"))) {
            for (int i = 1; i < Developers; i++) {
                if (DefaultMap.get(i) != null) {
                    BuffWrite.write(i + "," + DefaultMap.get(i) + ";" + "\n");
                }
                if (DefaultMap.get(i) == null) {
                    DefaultMap.remove(i);
                    DevMap.remove(i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void WrightDocument_ADD(int id) {
        try (BufferedWriter BuffWrite = new BufferedWriter(new FileWriter("D:\\Java\\IdeaProjects\\HomeWorks\\src\\HomeWork_041\\Developers"))) {
            String s = id + "," + DevMap.get(id).getFirstName() + "," + DevMap.get(id).getLastName() + "," + DevMap.get(id).getJob() + "," + DevMap.get(id).getSellery() + ";";
            for (int i = 1; i < Developers; i++) {
                if (DefaultMap.get(i) != null) {
                    BuffWrite.write(i + "," + DefaultMap.get(i) + ";" + "\n");
                }
                if (DefaultMap.get(i) == null) {
                    DefaultMap.remove(i);
                    DevMap.remove(i);
                }
            }
            BuffWrite.write(s);
            String words[] = s.split(",", 2);
            int id_1 = new Integer(words[0]);
            DefaultMap.put(id_1, words[1]);
            System.out.println(DefaultMap.get(id_1));
            System.out.println(DefaultMap.get(id_1));
        } catch (IOException e) {
            System.out.println("Error:" + e);
        }
    }

    public void ChangeInfo() {
        while (true) {
            try {
                int id;
                System.out.println("Which id you want to change:");
                id = scan.nextInt();
                System.out.println("Which information you want change:");
                System.out.println("1.First name");
                System.out.println("2.Last name");
                System.out.println("3.Information about job");
                System.out.println("4.Sellery");
                String a = scan.next();
                switch (a) {
                    case "1":
                        System.out.println("Enter new first name:");
                        String FirstName = scan.next();
                        DevMap.get(id).setFirstName(FirstName);
                        System.out.println(DevMap.get(id).getFirstName());
                        DefaultMap.put(id, DevMap.get(id).Default());
                        System.out.println(DefaultMap.get(id));
                        break;
                    case "2":
                        System.out.println("Enter new last name:");
                        String LastName = scan.next();
                        DevMap.get(id).setLastName(LastName);
                        DefaultMap.put(id, DevMap.get(id).Default());
                        break;
                    case "3":
                        scan.nextLine();
                        System.out.println("Enter new job information:");
                        String job = scan.nextLine();
                        DevMap.get(id).setJob(job);
                        DefaultMap.put(id, DevMap.get(id).Default());
                        break;
                    case "4":
                        System.out.println("Enter new sellery:");
                        int sellery = scan.nextInt();
                        DevMap.get(id).setSellery(sellery);
                        DefaultMap.put(id, DevMap.get(id).Default());
                        break;
                    default:
                        System.out.println("There is no such item in menu");
                        System.out.println("Choose another one:");
                }
                WrightDocument_Remove();
            } catch (InputMismatchException e) {
                System.out.println("Error:" + e);
                System.out.println("Try another one:");
            }
            break;
        }
    }
}