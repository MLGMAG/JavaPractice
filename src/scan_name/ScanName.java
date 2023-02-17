package scan_name;
import java.util.Scanner;

public class ScanName {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = scan.next();
        System.out.println("Hello,"+name);
    }
}
