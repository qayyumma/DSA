import java.util.Arrays;
import java.util.Comparator;

class Cake {
    int happiness, weight;

    // Constructor
    public Cake(int happiness, int weight) {
        this.happiness = happiness;
        this.weight = weight;
    }
}

public class FractionalCakesAndHappiness {
    public static double maximizeHappiness(int W, Cake[] cakes) {
        // Sort cakes by happiness-to-weight ratio in descending order
        Arrays.sort(cakes, new Comparator<Cake>() {
            @Override
            public int compare(Cake a, Cake b) {
                double r1 = (double) a.happiness / a.weight;
                double r2 = (double) b.happiness / b.weight;
                return Double.compare(r2, r1); // Descending order
            }
        });

        double totalHappiness = 0.0;

        for (Cake cake : cakes) {
            if (W == 0) break; // Stop if the knapsack is full

            if (cake.weight <= W) {
                // If the whole cake can be added
                W -= cake.weight;
                totalHappiness += cake.happiness;
            } else {
                // If only a fraction of the cake can be added
                totalHappiness += cake.happiness * ((double) W / cake.weight);
                W = 0; // Knapsack is now full
            }
        }

        return totalHappiness;
    }

    public static void main(String[] args) {
        int W = 50; // Maximum weight capacity
        Cake[] cakes = { new Cake(60, 10), new Cake(100, 20), new Cake(120, 30) };

        System.out.println("Maximum happiness we can obtain = " + maximizeHappiness(W, cakes));
    }
}
