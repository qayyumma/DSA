## Hash Table

A hash table is a data structure that stores key-value pairs and uses a hash function to compute an index (or hash code) into an array of buckets or slots, from which the desired value can be found. It allows for fast data retrieval, insertion, and deletion by minimizing the number of comparisons needed to find an element. If multiple keys hash to the same index, collisions are handled using techniques like chaining or open addressing.


### Hash Map and Hash Table mainly solve collision it occured when we store the data in key value formate to reduced the timing of insertion, deletion and searching.

In Data Structures and Algorithms (DSA), collisions primarily occur in hash tables, a common data structure used to store key-value pairs. A collision happens when two different keys hash to the same index in the hash table. Let's delve into how collisions are handled in Java.

### Collision Handling Techniques

**1. Chaining**

**2. Open Addressing**

### 1. Chaining

Chaining handles collisions by maintaining a list of all elements that hash to the same index. Each slot in the hash table points to a linked list (or another data structure) containing the collided elements.


```
import java.util.LinkedList;

class HashTable {
    // Array of linked lists to hold the key-value pairs
    private LinkedList<KeyValuePair>[] table;
    // Capacity of the hash table
    private int capacity;

    // Constructor to initialize the hash table with a given capacity
    public HashTable(int capacity) {
        this.capacity = capacity;
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Method to add a key-value pair to the hash table
    public void put(int key, String value) {
        int hash = key % capacity;
        LinkedList<KeyValuePair> chain = table[hash];
        for (KeyValuePair pair : chain) {
            if (pair.key == key) {
                pair.value = value; // Update value if key already exists
                return;
            }
        }
        chain.add(new KeyValuePair(key, value)); // Add new key-value pair
    }

    // Method to get the value associated with a key
    public String get(int key) {
        int hash = key % capacity;
        LinkedList<KeyValuePair> chain = table[hash];
        for (KeyValuePair pair : chain) {
            if (pair.key == key) {
                return pair.value; // Return value if key is found
            }
        }
        return null; // Return null if key is not found
    }

    // Inner class to represent a key-value pair
    private class KeyValuePair {
        int key;
        String value;

        KeyValuePair(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    // Main method for testing the hash table
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);

        // Adding key-value pairs
        hashTable.put(1, "One");
        hashTable.put(2, "Two");
        hashTable.put(11, "Eleven");

        // Retrieving values
        System.out.println(hashTable.get(1)); // Output: One
        System.out.println(hashTable.get(2)); // Output: Two
        System.out.println(hashTable.get(11)); // Output: Eleven
        System.out.println(hashTable.get(3)); // Output: null (not found)
    }
}

```


### 2. Open Addressing

Open addressing handles collisions by finding another open slot within the hash table when a collision occurs. The main methods of open addressing are:

**Linear Probing**

**Quadratic Probing**

**Double Hashing**


**Linear Probing**
Linear Probing is a collision resolution technique in hash tables where, upon encountering a collision (i.e., when two keys hash to the same index), the algorithm searches for the next available slot by checking the subsequent slots in a sequential manner (one by one) until an empty slot is found. This helps in finding an alternative location for the new key to be inserted.


### Implement Hash Table with Linear Probing - Insert

```
class HashTable {
    static final int SIZE = 5;
    int arr[] = new int[SIZE];

    public HashTable() 
    {
        int i;
        for(i = 0; i < SIZE; i++)
            arr[i] = -1;
    }

    int insert(int value)
    {
        int key = value % SIZE;
        int index = key;

        while(arr[index] != -1)
        {
            index = (index + 1) % SIZE;

            if(index == key)
            {
                System.out.println("Hash Table Full");
                return 0;
            }
        }

        arr[index] =  value;

        return 1;
    }
    
    public static void main(String[] args) {
        HashTable hash_table = new HashTable();                
     
        // INSERT
        if(hash_table.insert(10) == 1)
             System.out.println("10 is inserted");
             
        if(hash_table.insert(4) == 1)
             System.out.println("4 is inserted");
             
        if(hash_table.insert(2) == 1)
             System.out.println("2 is inserted");
             
        if(hash_table.insert(15) == 1)
             System.out.println("15 is inserted");
             
        if(hash_table.insert(5) == 1)
             System.out.println("5 is inserted");
             
        if(hash_table.insert(1) == 1)
             System.out.println("1 is inserted");
    }    
}
```

### Implement Hash Table with Linear Probing - Delete

```
class HashTable {
    static final int SIZE = 5;
    int arr[] = new int[SIZE];

    public HashTable() 
    {
        int i;
        for(i = 0; i < SIZE; i++)
            arr[i] = -1;
    }

    int insert(int value)
    {
        int key = value % SIZE;
        int index = key;

        while(arr[index] != -1)
        {
            index = (index + 1) % SIZE;

            if(index == key)
            {
                System.out.println("Hash Table Full");
                return 0;
            }
        }

        arr[index] =  value;

        return 1;
    }
    
    int del(int value) 
    {
        int key = value % SIZE;
        int index = key;
    
        while(arr[index] != value)
        {
            index = (index + 1) % SIZE;
    
            if(index == key)
                return 0;
        }
    
        arr[index] = -1;
    
        return 1;
    }
    
    public static void main(String[] args) {
        HashTable hash_table = new HashTable();                
     
        // INSERT
        hash_table.insert(10);
        hash_table.insert(4);
        hash_table.insert(2);
        hash_table.insert(15);
        hash_table.insert(5);
        
        System.out.println("Elements 10, 4, 2, 15 are inserted into the hash table");
        
        // DELETE
        if(hash_table.del(5) == 1)
             System.out.println("5 is deleted");
	if(hash_table.del(50) == 1)
             System.out.println("50 is deleted");      
    }    
}
```

### Implement Hash Table with Linear Probing - Search

```
class HashTable {
    static final int SIZE = 5;
    int arr[] = new int[SIZE];

    public HashTable() 
    {
        int i;
        for(i = 0; i < SIZE; i++)
            arr[i] = -1;
    }

    int insert(int value)
    {
        int key = value % SIZE;
        int index = key;

        while(arr[index] != -1)
        {
            index = (index + 1) % SIZE;

            if(index == key)
            {
                System.out.println("Hash Table Full");
                return 0;
            }
        }

        arr[index] =  value;

        return 1;
    }
    
    int del(int value) 
    {
        int key = value % SIZE;
        int index = key;
    
        while(arr[index] != value)
        {
            index = (index + 1) % SIZE;
    
            if(index == key)
                return 0;
        }
    
        arr[index] = -1;
    
        return 1;
    }
    
    int search(int value)
    {
        int key = value % SIZE;
        int index = key;
        
        while(arr[index] != value)
        {
            index = (index + 1) % SIZE;
            
            if(index == key)
                return 0;
        }
        
        return 1;
    }
    
    public static void main(String[] args) {
        HashTable hash_table = new HashTable();                
     
        // INSERT
        hash_table.insert(10);
        hash_table.insert(4);
        hash_table.insert(2);
        hash_table.insert(15);
        hash_table.insert(5);
        
        // DELETE
        hash_table.del(5);
        hash_table.del(50);
        
        System.out.println("Elements 10, 4, 2, 15 are present in the hash table");
        
        // SEARCH
        if(hash_table.search(4) == 1)
             System.out.println("4 - Search Found");
        else
             System.out.println("4 - Search Not Found");
             
        
        if(hash_table.search(12) == 1)
             System.out.println("12 - Search Found");
        else
             System.out.println("12 - Search Not Found");         
    }    
}

```


**Implement Hash Table with Quadratic Probing**

Quadratic probing resolves collisions by checking slots at intervals that grow quadratically. This reduces clustering compared to linear probing.
```
class HashTable {
    static final int SIZE = 5;
    int arr[] = new int[SIZE];

    public HashTable() 
    {
        int i;
        for(i = 0; i < SIZE; i++)
            arr[i] = -1;
    }

    int insert(int value)
    {
        int key = value % SIZE;
        int index = key;
        int i = 1;

        while(arr[index] != -1)
        {
            index = (key + i * i) % SIZE;
            i++;
            if(i == SIZE)
            {
                System.out.println("Hash Table Full");
                return 0;
            }
        }

        arr[index] =  value;
        return 1;
    }
    
    int search(int value)
    {
        int key = value % SIZE;
        int index = key;
        int i = 1;

        while(arr[index] != value)
        {
            index = (key + i * i) % SIZE;
            i++;
            if(i == SIZE)
                return 0;
        }

        return 1;
    }
    
    int del(int value) 
    {
        int key = value % SIZE;
        int index = key;
        int i = 1;

        while(arr[index] != value)
        {
            index = (key + i * i) % SIZE;
            i++;
            if(i == SIZE)
                return 0;
        }

        arr[index] = -1;
        return 1;
    }

    public static void main(String[] args) {
        HashTable hash_table = new HashTable();

        // INSERT
        hash_table.insert(10);
        hash_table.insert(4);
        hash_table.insert(2);
        hash_table.insert(15);
        hash_table.insert(5);

        // DELETE
        hash_table.del(5);
        hash_table.del(50);

        System.out.println("Elements 10, 4, 2, 15 are present in the hash table");

        // SEARCH
        if(hash_table.search(4) == 1)
            System.out.println("4 - Search Found");
        else
            System.out.println("4 - Search Not Found");

        if(hash_table.search(12) == 1)
            System.out.println("12 - Search Found");
        else
            System.out.println("12 - Search Not Found");
    }
}

```
**Implement Hash Table with Double Hashing**

Double hashing uses a secondary hash function to determine the interval between probes. This reduces clustering and provides a better distribution of keys.

```
class HashTable {
    static final int SIZE = 5;
    int arr[] = new int[SIZE];

    public HashTable() 
    {
        int i;
        for(i = 0; i < SIZE; i++)
            arr[i] = -1;
    }

    int hash2(int value) {
        return 3 - (value % 3);
    }

    int insert(int value)
    {
        int key = value % SIZE;
        int index = key;
        int i = 1;

        while(arr[index] != -1)
        {
            index = (key + i * hash2(value)) % SIZE;
            i++;
            if(i == SIZE)
            {
                System.out.println("Hash Table Full");
                return 0;
            }
        }

        arr[index] =  value;
        return 1;
    }
    
    int search(int value)
    {
        int key = value % SIZE;
        int index = key;
        int i = 1;

        while(arr[index] != value)
        {
            index = (key + i * hash2(value)) % SIZE;
            i++;
            if(i == SIZE)
                return 0;
        }

        return 1;
    }
    
    int del(int value) 
    {
        int key = value % SIZE;
        int index = key;
        int i = 1;

        while(arr[index] != value)
        {
            index = (key + i * hash2(value)) % SIZE;
            i++;
            if(i == SIZE)
                return 0;
        }

        arr[index] = -1;
        return 1;
    }

    public static void main(String[] args) {
        HashTable hash_table = new HashTable();

        // INSERT
        hash_table.insert(10);
        hash_table.insert(4);
        hash_table.insert(2);
        hash_table.insert(15);
        hash_table.insert(5);

        // DELETE
        hash_table.del(5);
        hash_table.del(50);

        System.out.println("Elements 10, 4, 2, 15 are present in the hash table");

        // SEARCH
        if(hash_table.search(4) == 1)
            System.out.println("4 - Search Found");
        else
            System.out.println("4 - Search Not Found");

        if(hash_table.search(12) == 1)
            System.out.println("12 - Search Found");
        else
            System.out.println("12 - Search Not Found");
    }
}

```
