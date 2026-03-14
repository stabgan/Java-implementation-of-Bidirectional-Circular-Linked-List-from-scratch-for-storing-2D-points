# Bidirectional Circular Linked List for 2D Points

A from-scratch Java implementation of a doubly-linked circular list designed to store 2D coordinate points — originally built for polygon vertex storage.

## What It Does

`BCLL` is a circular doubly-linked list where each node holds an `(x, y)` point. The last node links back to the first, and every node has both `next` and `prev` pointers, enabling efficient traversal in either direction.

Supported operations:

| Operation | Method | Time |
|-----------|--------|------|
| Append a point | `append(x, y)` | O(1) |
| Display all points | `display()` | O(n) |
| Check membership | `contains(x, y)` | O(n) |
| Remove first match | `remove(x, y)` | O(n) |
| Get size | `size()` | O(1) |

## Architecture

```
 ┌──────────────────────────────────────┐
 │                                      │
 ▼                                      │
[head] ⇄ [node1] ⇄ [node2] ⇄ ... ⇄ [last]
```

Each `Node` stores:
- `Double x` — x-coordinate
- `Double y` — y-coordinate
- `Node next` — pointer to the next node
- `Node prev` — pointer to the previous node

## 🛠 Tech Stack

| | Technology | Purpose |
|---|-----------|---------|
| ☕ | Java | Core language |

## Getting Started

Compile and run:

```bash
javac Main.java
java Main
```

No external dependencies required — just a JDK (8+).

## Example Output

```
--- All points ---
(5.4,6.7)
(2.0,9.5)
(54.4,67.7)
(23.0,60.15)
(52.4,6.7)
(21.0,60.5)
Size: 6

Contains (23.0, 60.15)? true
Contains (23.9, 6500.6)? false

--- After removing (23.0, 60.15) ---
(5.4,6.7)
(2.0,9.5)
(54.4,67.7)
(52.4,6.7)
(21.0,60.5)
Size: 5
```

## Bugs Fixed

- `remove()` now correctly updates `head` when the head node is removed
- `remove()` now decrements `size` on successful removal
- `remove()` now handles single-element list removal (sets `head` to `null`)
- `size` field made `private` to enforce encapsulation
- Circular-list guard in `display()` changed from `head.next != null` to `head.next != head`
- Added `.gitignore` for Java artifacts

## License

[MIT](LICENSE)
