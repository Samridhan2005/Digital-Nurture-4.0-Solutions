import java.util.ArrayList;
import java.util.Scanner;

public class ex24 {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String name;
        System.out.println("Enter student names (type 'end' to finish):");
        while (true) {
            name = sc.nextLine();
            if (name.equalsIgnoreCase("end")) break;
            students.add(name);
        }
        System.out.println("Student names:");
        for (String s : students) {
            System.out.println(s);
        }
        sc.close();
    }
}