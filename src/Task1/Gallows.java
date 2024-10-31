package Task1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Gallows {
    private static final String[] WORDS = {"программист", "компьютер", "интерфейс", "разработка", "алгоритм"};
    private static final int MAX_LIVES = 6;

    private static final String[][] LARGE_HANGMAN_STAGES = {
            {
                    " +---+   ",
                    " |   |   ",
                    "     |    ",
                    "     |    ",
                    "     |    ",
                    "     |    ",
                    "=========="
            },
            {
                    " +---+   ",
                    " |   |   ",
                    " O   |   ",
                    "     |    ",
                    "     |    ",
                    "     |    ",
                    "========="
            },
            {
                    " +---+   ",
                    " |   |   ",
                    " O   |    ",
                    " |   |    ",
                    "     |    ",
                    "     |    ",
                    "=========="
            },
            {
                    " +---+   ",
                    " |   |   ",
                    " O   |    ",
                    "/|   |    ",
                    "     |    ",
                    "     |    ",
                    "========="
            },
            {
                    " +---+   ",
                    " |   |   ",
                    " O   |   ",
                    "/|   |   ",
                    "/    |    ",
                    "     |    ",
                    "=========="
            },
            {
                    " +---+   ",
                    " |   |   ",
                    " O   |    ",
                    "/|\\  |   ",
                    "/    |    ",
                    "     |    ",
                    "========="
            },
            {
                    " +---+   ",
                    " |   |   ",
                    " O   |   ",
                    "/|\\  |  ",
                    "/ \\  |   ",
                    "     |    ",
                    "========="
            }
    };

    private final String wordToGuess;
    private final char[] guessedWord;
    private int lives;
    private boolean isWordGuessed;

    public Gallows() {
        Random random = new Random();
        wordToGuess = WORDS[random.nextInt(WORDS.length)];
        guessedWord = new char[wordToGuess.length()];
        Arrays.fill(guessedWord, '_');
        lives = MAX_LIVES;
        isWordGuessed = false;
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в игру 'Виселица'!");

        while (lives > 0 && !isWordGuessed) {
            displayGameState();
            System.out.print("Введите букву: ");
            char guessedLetter = scanner.next().toLowerCase().charAt(0);

            boolean isGuessCorrect = false;

            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guessedLetter) {
                    guessedWord[i] = guessedLetter;
                    isGuessCorrect = true;
                }
            }

            if (!isGuessCorrect) {
                lives--;
                System.out.println("Неправильный ответ.");
            } else {
                System.out.println("Правильно!");
            }

            isWordGuessed = String.valueOf(guessedWord).equals(wordToGuess);
        }

        displayEndGameMessage();
        scanner.close();
    }

    private void displayGameState() {
        System.out.println("Данное слово: " + String.valueOf(guessedWord));
        System.out.println("У вас осталось " + lives + " жизней.");
        printLargeHangmanStage();
    }

    private void displayEndGameMessage() {
        if (isWordGuessed) {
            System.out.println("Поздравляем! Вы угадали слово: " + wordToGuess);
        } else {
            printLargeHangmanStage(); // Показываем окончательное состояние виселицы
            System.out.println("Вы проиграли! Загаданное слово: " + wordToGuess);
        }
    }

    private void printLargeHangmanStage() {
        String[] stage = LARGE_HANGMAN_STAGES[MAX_LIVES - lives];
        for (String line : stage) {
            System.out.println(line);
        }
    }
}
