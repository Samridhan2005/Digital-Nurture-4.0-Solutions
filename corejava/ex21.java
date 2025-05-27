class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
public class ex21 {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        try {
            if (age < 18) {
                throw new InvalidAgeException("Age must be at least 18.");
            }
            System.out.println("Valid age: " + age);
        } catch (InvalidAgeException e) {
            System.out.println("InvalidAgeException: " + e.getMessage());
        }
        sc.close();
    }
}