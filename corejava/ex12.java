public class ex12 {
    // Method to add two integers
    public static int add(int a, int b) {
        return a + b;
    }
    // Method to add two doubles
    public static double add(double a, double b) {
        return a + b;
    }
    // Method to add three integers
    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        int sum1 = add(5, 10);
        double sum2 = add(3.5, 2.7);
        int sum3 = add(1, 2, 3);
        System.out.println("Sum of 5 and 10: " + sum1);
        System.out.println("Sum of 3.5 and 2.7: " + sum2);
        System.out.println("Sum of 1, 2 and 3: " + sum3);
    }
}
