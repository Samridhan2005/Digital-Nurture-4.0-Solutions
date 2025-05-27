public class ex17 {
    static class Car {
        String make, model;
        int year;
        Car(String make, String model, int year) {
            this.make = make;
            this.model = model;
            this.year = year;
        }
        void displayDetails() {
            System.out.println("Car: " + make + " " + model + " (" + year + ")");
        }
    }
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Corolla", 2020);
        Car car2 = new Car("Honda", "Civic", 2022);
        car1.displayDetails();
        car2.displayDetails();
    }
}
