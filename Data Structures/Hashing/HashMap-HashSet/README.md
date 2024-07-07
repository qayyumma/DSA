## HashMap

A HashMap is a part of the Java Collections Framework and is used to store data in key-value pairs. It is based on a hashing mechanism to provide efficient insertion, deletion, and lookup operations. The HashMap allows one null key and multiple null values.

**Features:**

**Key-Value Storage:** Stores elements in key-value pairs.

**No Duplicate Keys:** Each key in the HashMap must be unique.

**Allows Null Values:** It allows one null key and multiple null values.

**Unordered:** Does not maintain any order for its entries.

**Not Synchronized:** It is not thread-safe. For concurrent access, use ConcurrentHashMap or other synchronized collections.


### Example Usage:

```
import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        // Creating a HashMap
        HashMap<Integer, String> map = new HashMap<>();

        // Adding key-value pairs
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        // Accessing a value
        String value = map.get(2);
        System.out.println("Value for key 2: " + value);

        // Iterating over the HashMap
        for (HashMap.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
```

### HashSet

A HashSet is a part of the Java Collections Framework and is used to store unique elements. It is backed by a HashMap and uses a hashing mechanism to provide efficient insertion, deletion, and lookup operations. The HashSet does not allow duplicate elements.


**Features:**

**Unique Elements:** Stores only unique elements, no duplicates allowed.

**No Null Elements:** Allows one null element.

**Unordered:** Does not maintain any order for its elements.

**Not Synchronized:** It is not thread-safe. For concurrent access, use ConcurrentHashMap or other synchronized collections.

**Example Usage:**
```
import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        // Creating a HashSet
        HashSet<String> set = new HashSet<>();

        // Adding elements
        set.add("One");
        set.add("Two");
        set.add("Three");
        set.add("Two"); // Duplicate element, will not be added

        // Checking if an element exists
        boolean contains = set.contains("Two");
        System.out.println("Set contains 'Two': " + contains);

        // Iterating over the HashSet
        for (String element : set) {
            System.out.println("Element: " + element);
        }
    }
}
```

**Key Differences Between HashMap and HashSet**

**Storage Mechanism:**

HashMap stores key-value pairs.

HashSet stores only unique elements.

**Null Handling:**

HashMap allows one null key and multiple null values.

HashSet allows one null element.

**Underlying Implementation:**

HashMap uses a hashing mechanism and stores keys in a HashMap.

HashSet is backed by a HashMap where the elements are stored as keys and a constant value is used for all keys.

**Usage:**

Use HashMap when you need to associate keys with values.

Use HashSet when you need to store unique elements without any association.

Both HashMap and HashSet are part of the Java Collections Framework and provide efficient ways to handle data through hashing.
