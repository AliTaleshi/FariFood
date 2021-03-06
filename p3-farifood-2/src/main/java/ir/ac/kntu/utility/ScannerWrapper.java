package ir.ac.kntu.utility;

import java.util.Scanner;

public class ScannerWrapper {

    private static ScannerWrapper instance = new ScannerWrapper();

    private Scanner scanner;

    private ScannerWrapper() {
        scanner = new Scanner(System.in);
    }

    public static ScannerWrapper getInstance() {
        return instance;
    }

    public Double nextDouble() {
        return scanner.nextDouble();
    }

    public Integer nextInt() {
        return scanner.nextInt();
    }

    public String nextLine() {
        return scanner.next();
    }

    public void close() {
        scanner.close();
    }
}