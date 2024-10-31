package Task3;

import java.util.Random;

public class Generator {
    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";
    private static final Random random = new Random();

    public String generatePassword(int length) {
        String allCharacters = UPPER_CASE + LOWER_CASE + DIGITS + SPECIAL_CHARACTERS;
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(allCharacters.length());
            password.append(allCharacters.charAt(index));
        }

        return password.toString();
    }
}