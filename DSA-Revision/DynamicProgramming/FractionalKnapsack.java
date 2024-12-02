import java.util.*;

class Item {
    int weight;
    int value;

    Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

class FractionalKnapsack {
    static class ItemValue {
        Double cost;
        int weight, value;

        // Constructor
        public ItemValue(int weight, int value) {
            this.weight = weight;
            this.value = value;
            this.cost = (double) value / weight; // value-to-weight ratio
        }
    }

    public static double getMaxValue(int capacity, Item[] items) {
        // Create a list of ItemValue objects
        ItemValue[] itemValues = new ItemValue[items.length];
        for (int i = 0; i < items.length; i++) {
            itemValues[i] = new ItemValue(items[i].weight, items[i].value);
        }

        // Sort items by cost in descending order
        Arrays.sort(itemValues, (a, b) -> b.cost.compareTo(a.cost));

        double totalValue = 0.0;

        for (ItemValue item : itemValues) {
            int currentWeight = item.weight;
            int currentValue = item.value;

            if (capacity >= currentWeight) {
                // If the item can fit entirely, take it
                capacity -= currentWeight;
                totalValue += currentValue;
            } else {
                // Take the fraction of the item that fits
                totalValue += item.cost * capacity;
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Item[] items = {
            new Item(10, 60),
            new Item(20, 100),
            new Item(30, 120)
        };
        int capacity = 50;

        double maxValue = getMaxValue(capacity, items);
        System.out.println("Maximum value we can obtain = " + maxValue);
    }
}
