class BCLL {

    public class Node {
        Double x;
        Double y;
        Node next = null;
        Node prev = null;

        Node(Double a, Double b) {
            this.x = a;
            this.y = b;
            this.next = this;
            this.prev = this;
        }
    }

    private int size = 0;
    Node head;

    /**
     * Appends a new 2D point to the end of the circular linked list.
     */
    public void append(Double x, Double y) {
        if (head == null) {
            head = new Node(x, y);
            size += 1;
        } else {
            Node last = head.prev;
            Node temp = new Node(x, y);
            last.next = temp;
            temp.next = head;
            head.prev = temp;
            temp.prev = last;
            size += 1;
        }
    }

    /**
     * Displays all 2D points in the list.
     */
    public void display() {
        if (head == null) {
            System.out.println("Empty list");
        } else {
            System.out.println("(" + head.x + "," + head.y + ")");
            if (head.next != head) {
                Node print = head.next;
                while (print != head) {
                    System.out.println("(" + print.x + "," + print.y + ")");
                    print = print.next;
                }
            }
        }
    }

    /**
     * Returns the number of points in the list.
     */
    public int size() {
        return this.size;
    }

    /**
     * Checks whether the list contains the given 2D point.
     */
    public boolean contains(Double a, Double b) {
        if (head == null) {
            System.out.println("Empty list");
            return false;
        }
        Node chk = head;
        if (chk.x.equals(a) && chk.y.equals(b)) {
            return true;
        }
        chk = chk.next;
        while (chk != head) {
            if (chk.x.equals(a) && chk.y.equals(b)) {
                return true;
            }
            chk = chk.next;
        }
        return false;
    }

    /**
     * Removes the first occurrence of the given 2D point from the list.
     */
    public void remove(Double a, Double b) {
        if (head == null) {
            System.out.println("Empty list");
            return;
        }

        // Check if head is the node to remove
        if (head.x.equals(a) && head.y.equals(b)) {
            if (size == 1) {
                // Only one element — clear the list
                head = null;
            } else {
                // Unlink head and advance it
                head.prev.next = head.next;
                head.next.prev = head.prev;
                head = head.next;
            }
            size--;
            return;
        }

        // Search the rest of the list
        Node chk = head.next;
        while (chk != head) {
            if (chk.x.equals(a) && chk.y.equals(b)) {
                chk.prev.next = chk.next;
                chk.next.prev = chk.prev;
                size--;
                return;
            }
            chk = chk.next;
        }
        System.out.println(a + " and " + b + " is not in list");
    }
}

class Main {
    public static void main(String[] args) {
        BCLL list = new BCLL();

        list.append(5.4, 6.7);
        list.append(2.0, 9.5);
        list.append(54.4, 67.7);
        list.append(23.0, 60.15);
        list.append(52.4, 6.7);
        list.append(21.0, 60.5);

        System.out.println("--- All points ---");
        list.display();
        System.out.println("Size: " + list.size());

        System.out.println("\nContains (23.0, 60.15)? " + list.contains(23.0, 60.15));
        System.out.println("Contains (23.9, 6500.6)? " + list.contains(23.9, 6500.6));

        System.out.println("\n--- After removing (23.0, 60.15) ---");
        list.remove(23.0, 60.15);
        list.display();
        System.out.println("Size: " + list.size());

        System.out.println("\n--- Attempting to remove non-existent point ---");
        list.remove(500.0, 50.6);
    }
}
