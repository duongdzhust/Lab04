package hust.soict.dsai.garbage;

import java.util.ArrayList;

public class GarbageCreator {
    public static void main(String[] args) {
        // Create a large number of strings using the "+" operator
        ArrayList<String> garbage = new ArrayList<>();
        
        for (int i = 0; i < 1000000; i++) {
            String str = "test" + i;
            garbage.add(str);
        }

        // Observing memory usage and performance
        System.out.println("Garbage created: " + garbage.size() + " strings.");
    }
}
