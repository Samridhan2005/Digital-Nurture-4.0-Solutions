import java.util.*;
public class ex3 {
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter a number:");
    int n=sc.nextInt();
    if(n%2 ==0){
      System.out.println("The number is even.");
    } else {
      System.out.println("The number is odd.");
    }
    sc.close();

  }
}
