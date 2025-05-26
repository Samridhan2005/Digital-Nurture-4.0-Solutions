import java.util.*;
public class ex2{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter first number:");
    int num1=sc.nextInt();
    System.out.println("Enter second number:");
    int num2=sc.nextInt();
    System.out.println("choose an operation: +, -, *, /");
    char operation=sc.next().charAt(0);
    int result = 0;
    switch(operation){
      case '+':
        result=num1 +num2;
        break;
      case '-':
        result=num1-num2;
        break;
      case '*':
        result=num1*num2;
        break;
      case '/':
        result=num1/num2;
        break;

    }
    System.out.println("The result is: " + result);
    sc.close();






  }
}