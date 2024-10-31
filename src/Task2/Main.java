package Task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Converter converter = new Converter();

        System.out.println("Введите сумму в рублях для конвертации:");
        double rubAmount = scanner.nextDouble();

        converter.convert(rubAmount);

        scanner.close();
    }
}

