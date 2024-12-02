import java.util.*;

class Item {
    int weight;
    int value;
    int quantity;

    Item(int weight, int value, int quantity) {
        this.weight = weight;
        this.value = value;
        this.quantity = quantity;
    }
}

public class BoundedKnapsack {
    public static int boundedKnapsack(int capacity, Item[] items) {
        // Create a list to hold the expanded items
        List<Item> expandedItems = new ArrayList<>();

        // Break each item into multiple items based on its quantity limit
        for (Item item : items) {
            for (int i = 1; i <= item.quantity; i++) {
                expandedItems.add(new Item(item.weight, item.value, 1));
            }
        }

        // Apply 0/1 Knapsack on the expanded list
        int[] dp = new int[capacity + 1];

        for (Item item : expandedItems) {
            for (int w = capacity; w >= item.weight; w--) {
                dp[w] = Math.max(dp[w], dp[w - item.weight] + item.value);
            }
        }

        return dp[capacity];
    }

    public static void main(String[] args) {
        Item[] items = {
            new Item(1, 10, 2),  // weight=1, value=10, quantity=2
            new Item(3, 40, 3),  // weight=3, value=40, quantity=3
            new Item(4, 50, 1)   // weight=4, value=50, quantity=1
        };

        int capacity = 6;
        System.out.println("Maximum Value: " + boundedKnapsack(capacity, items)); // Output: 90
    }
}


------------------------------------------------------------------------------------
Number of Items: 1 ≤ 𝑁 ≤ 500

Maximum Weight Capacity (W): 1 ≤ W ≤ 10 * 9

Weight of Each Item (wt[i]): 1 ≤ wt[i] ≤ 10*9

Value of Each Item (value[i]): 1 ≤ value[i] ≤ 50


# Input
N = 500  # Number of items
W = 10**9  # Maximum weight
weights = [1, 10, 20, 30, 40]  # Example weights
values = [10, 20, 30, 40, 50]  # Example values

# Calculate the maximum value possible
max_value = N * 50

# Initialize dp array with "infinity"
dp = [float('inf')] * (max_value + 1)
dp[0] = 0  # Minimum weight to achieve value 0 is 0

# Dynamic programming (value-based approach)
for i in range(N):
    for v in range(max_value, values[i] - 1, -1):  # Iterate in reverse
        dp[v] = min(dp[v], dp[v - values[i]] + weights[i])

# Find the maximum value achievable within weight W
result = 0
for v in range(max_value + 1):
    if dp[v] <= W:
        result = v

print("Maximum value achievable within weight:", result)


