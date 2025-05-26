import java.util.Scanner;
public class ex4 {
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter a Leap year:");
    int num=sc.nextInt();
    if((num%4 ==0 && num%100 !=0) || num%400 ==0){
      System.out.println(num + " is a Leap year.");
    } else {
      System.out.println(num + " is not a Leap year.");
    }
    sc.close();




 }
  
}
