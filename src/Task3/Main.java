package Task3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Generator generator = new Generator();

        System.out.println("Введите длину пароля (от 8 до 12 символов): ");
        int passwordLength = scanner.nextInt();

        while (passwordLength < 8 || passwordLength > 12) {
            System.out.println("Недопустимая длина. Пожалуйста, выберите длину от 8 до 12.");
            passwordLength = scanner.nextInt();
        }

        String password = generator.generatePassword(passwordLength);
        System.out.println("Сгенерированный пароль: " + password);

        scanner.close();
    }
}
