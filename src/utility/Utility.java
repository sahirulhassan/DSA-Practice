package utility;

import java.util.Scanner;

public class Utility {
    public static String input(String msg, Scanner scanner) {
        System.out.print(msg);
        return scanner.nextLine();
    }
    public static String input(String msg) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(msg);
        String input = scanner.nextLine();
        scanner.close();
        return input;
    }
}
