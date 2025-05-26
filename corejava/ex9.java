import java.util.*;
public class ex9 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a mark:");
    int mark=sc.nextInt();
    if(mark >=90 && mark <=100){
      System.out.println("Grade A");
    }
    else if(mark>=80 && mark <=89){
      System.out.println("Grade B");
    }
    else if(mark>=70 && mark <=79){
      System.out.println("Grade C");
    }
    else if(mark>=60 && mark <=69){
      System.out.println("Grade D");
    }
    else if(mark>=50 && mark <=59){
      System.out.println("Grade E");
    }
    else if(mark>=0 && mark <=49){
      System.out.println("Grade F");
    }
    else{
      System.out.println("Invalid mark entered.");

    }
    sc.close();

    
  }
}
