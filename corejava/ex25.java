import java.util.HashMap;
import java.util.Scanner;

public class ex25 {
    public static void main(String[] args) {
        HashMap<Integer, String> students = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student ID and name (type -1 to stop):");
        while (true) {
            System.out.print("ID: ");
            int id = sc.nextInt();
            if (id == -1) break;
            sc.nextLine(); // consume newline
            System.out.print("Name: ");
            String name = sc.nextLine();
            students.put(id, name);
        }
        System.out.print("Enter ID to search: ");
        int searchId = sc.nextInt();
        String result = students.get(searchId);
        if (result != null) {
            System.out.println("Name: " + result);
        } else {
            System.out.println("ID not found.");
        }
        sc.close();
    }
}