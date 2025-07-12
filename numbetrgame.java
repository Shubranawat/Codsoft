
//Nuber game in java (codsoft internship)

import java.util.*;
public class numbetrgame {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int score = 0;
        boolean playagain = true;
        System.out.println("Welcome to the number guessing game");
        while (playagain){
            int numbertoguess = rand.nextInt(100)+1;  // number from 1 to 100
            int attempts = 0;
            int maxattempts = 7;
            boolean hasguessed = false;

            System.out.println("Guess a number between 1 and 100 (you have" + maxattempts + " attempts):");
            while (attempts<maxattempts){
                System.out.println("enter your guess");
                int userguess = sc.nextInt();
                attempts++;
                if (userguess == numbertoguess){
                    System.out.println("correct you guessed the numberin " + attempts + "attempts");
                    score++;
                    hasguessed = true;

                } else if (userguess<numbertoguess) {
                    System.out.println("Too low! try again");

                }else {
                    System.out.println("Too high! Try again");
                }
            }
            if (hasguessed){
                System.out.println("You're used all attemps , the correct number was" + numbertoguess);
            }
            System.out.println("/nDo you want to play again?(yes/no)");
            String response = sc.next();
            if (response.equalsIgnoreCase("yes")){
                playagain = false;
            }
        }
        System.out.println("\n Game over! final score" + score);
        sc.close();
    }
}
