import java.util.*;
public class ex11 {
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter a number to find factorial:");
    int n=sc.nextInt();
    long fact=1;
    for(int i=1;i<=n;i++){
      fact=fact*i;
    }
    System.out.println("Factorial of " + n + " is: " + fact);
    sc.close();



  }
  
}
