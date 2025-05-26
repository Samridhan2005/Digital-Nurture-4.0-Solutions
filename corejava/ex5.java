import java.util.Scanner;
public class ex5 {
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter a number:");
    int n=sc.nextInt();
    for(int i=1;i<=10;i++){
      System.out.println(i+ "*"+n+"="+(i*n));
    }sc.close();

  }
}
