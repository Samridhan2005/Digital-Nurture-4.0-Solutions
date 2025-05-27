import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ex22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string to write to file: ");
        String input = sc.nextLine();
        try (FileWriter fw = new FileWriter("output.txt")) {
            fw.write(input + System.lineSeparator());
            System.out.println("Data written to output.txt");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
        sc.close();
    }
}