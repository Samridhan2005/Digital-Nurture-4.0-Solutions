import java.util.*;

public class ex27 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Sam", "Alex", "John", "Bob"));
        Collections.sort(names, (a, b) -> a.compareToIgnoreCase(b));
        System.out.println("Sorted names: " + names);
    }
}
