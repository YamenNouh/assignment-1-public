import java.util.Scanner;

public class HangmanGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // First player inputs the secret word
        System.out.print("Enter the secret word: ");
        String secretWord = scanner.nextLine().toLowerCase();

        // Store the secret word letter by letter in an array
        char[] secretWordArray = secretWord.toCharArray();

        // Array to keep track of guessed letters
        char[] guessedLetters = new char[secretWord.length()];
        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = '_';
        }

        int wrongGuesses = 6;

        while (wrongGuesses > 0) {
            System.out.println("\nCurrent progress: ");
            displayWord(guessedLetters);
            System.out.println("You have " + wrongGuesses + " wrong guesses left.");

            // Second player guesses a letter
            System.out.print("Guess a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            boolean found = false;
            for (int i = 0; i < secretWordArray.length; i++) {
                if (secretWordArray[i] == guess) {
                    guessedLetters[i] = guess;
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Wrong guess!");
                wrongGuesses--;
            }

            // Check if the word is fully guessed
            if (isWordGuessed(guessedLetters)) {
                System.out.println("Congratulations! You've guessed the word: " + secretWord);
                return;
            }
        }

        System.out.println("Game over! The word was: " + secretWord);
    }

    // Method to display the current progress of the word
    private static void displayWord(char[] word) {
        for (char letter : word) {
            System.out.print(letter + " ");
        }
        System.out.println();
    }

    // Method to check if the word is fully guessed
    private static boolean isWordGuessed(char[] word) {
        for (char letter : word) {
            if (letter == '_') {
                return false;
            }
        }
        return true;
    }
}

