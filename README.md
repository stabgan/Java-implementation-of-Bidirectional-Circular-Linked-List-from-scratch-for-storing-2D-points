# Java Bidirectional Circular Linked List for 2D Points

A from-scratch implementation of a bidirectional circular linked list data structure optimized for storing and manipulating 2D coordinate points, perfect for polygon operations and geometric computations.

## What It Does

This implementation provides a circular doubly-linked list where each node stores a 2D point (x, y coordinates). The circular nature means the last node points back to the first, making it ideal for representing closed shapes like polygons where you need to traverse vertices in both directions seamlessly.

### Key Features
- **Bidirectional traversal**: Navigate forward and backward through points
- **Circular structure**: Last node connects back to first for seamless polygon operations  
- **Dynamic sizing**: Add/remove points without pre-allocation
- **Point operations**: Check containment, remove specific coordinates
- **Memory efficient**: Only stores essential coordinate data

## 🛠 Tech Stack

| Component | Technology |
|-----------|------------|
| Language | ☕ Java |
| Data Structure | 🔄 Circular Doubly Linked List |
| Use Case | 📐 2D Geometry & Polygons |

## Usage

### Basic Operations

```java
BCLL pointList = new BCLL();

// Add points to form a polygon
pointList.append(5.4, 6.7);
pointList.append(2.0, 9.5);
pointList.append(54.4, 67.7);

// Display all points
pointList.display();

// Check if point exists
boolean exists = pointList.contains(5.4, 6.7); // returns true

// Remove a specific point
pointList.remove(2.0, 9.5);

// Get current size
int size = pointList.size();
```

### Running the Code

```bash
# Compile
javac Main.java

# Run the demo
java Main
```

## Architecture

The implementation consists of two main classes:

- **`BCLL`**: The main circular linked list class with all operations
- **`Node`**: Inner class representing individual 2D points with bidirectional links

Each node maintains:
- `x, y`: Double precision coordinates
- `next`: Reference to next node (clockwise)
- `prev`: Reference to previous node (counter-clockwise)

## Example Output

```
(5.4,6.7)
(2.0,9.5)
(54.4,67.7)
(23.0,60.15)
(52.4,6.7)
(21.0,60.5)
6
true
false
(5.4,6.7)
(2.0,9.5)
(54.4,67.7)
(52.4,6.7)
(21.0,60.5)
500.0 and 50.6 is not in list
```

## License

Licensed under the Apache License 2.0. See [LICENSE](LICENSE) for details.