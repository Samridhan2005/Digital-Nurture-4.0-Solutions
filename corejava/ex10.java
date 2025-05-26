import java.util.*;
public class ex10 {
  public static void main (String[] args){
    Scanner sc=new Scanner(System.in);
    Random rand = new Random();
    int number = rand.nextInt(100) + 1; // Random number between 1 and 100
    int guess = 0;
    int attempts = 0;
    while (guess != number) {
      System.out.println("Enter your guess:");
      guess = sc.nextInt();
      attempts++;
      if (guess < number) {
        System.out.println("Too low! Try again.");
      } else if (guess > number) {
        System.out.println("Too high! Try again.");
      } else {
        System.out.println("Congratulations! You've guessed the number " + number + " in " + attempts + " attempts.");
      }
    }
    sc.close();

  }
  
}
