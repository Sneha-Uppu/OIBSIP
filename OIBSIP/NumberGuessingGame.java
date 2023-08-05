import java.util.Scanner;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int attempt = 10;
        int i = 1;
        int score;
        int roundno = 1;
        int total = 0, avg = 0;
        System.out.println("\nNUMBER GUESSING GAME");
        while (roundno <= 3) {
            score = 100;
            System.out.print("\n");
            System.out.println("========Welcome to Round " + (roundno) + "========");
            Random rand = new Random();
            int randomNumber = rand.nextInt(100) + 1;
            while (i <= attempt) {
                JFrame frame = new JFrame();
                String input = JOptionPane.showInputDialog(frame, "Enter your guess (range: 1 - 100)");
                int guess = Integer.parseInt(input);
                if (guess == randomNumber) {
                    System.out.println("\n" + guess + " is Correct Guess");
                    System.out.println("\nNo of Attempts Taken for guessing the number: " + i);
                    System.out.println("\nYour score for this round=" + score);
                    break;
                } else if (guess > 100) {
                    System.out.println("\nOut of range");

                } else if (randomNumber > guess) {
                    System.out.println(guess + " is smaller than Generated Random number, Please try again.");
                    score -= 5;
                    i++;
                } else {
                    System.out.println(guess + " is greater than Generated Random number, Please try again.");
                    score -= 5;
                    i++;
                }
            }
            roundno += 1;
            i--;
            if (i == attempt) {
                score = 0;
                System.out.println("\nYou have taken all the attempts for this round. The game is over.");
                break;
            }
            i = 1;
            total += score;
            avg = total / 3;
        }
        System.out.println("\n\nYour average score for three rounds=" + avg);
        sc.close();
    }
}
