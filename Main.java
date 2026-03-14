/**
 * Bidirectional Circular Linked List implementation for storing 2D points.
 * This data structure maintains a circular doubly-linked list where each node
 * contains x,y coordinates representing a 2D point.
 */
class BCLL {

  /**
   * Node class representing a single point in 2D space
   */
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
  private Node head;

  /**
   * Adds a new point to the end of the circular list
   * @param x X-coordinate of the point
   * @param y Y-coordinate of the point
   */
  public void append(Double x, Double y){
    if(head == null) {
      head = new Node(x, y);
      size++;
    }
    else {
      Node last = head.prev;
      Node temp = new Node(x, y);
      last.next = temp;
      temp.next = head;
      head.prev = temp;
      temp.prev = last;
      size++;
    }
  }

  /**
   * Displays all points in the circular list
   */

  public void display() {
    if (head == null){
      System.out.println("Empty list");
      return;
    }
    
    System.out.println("("+Double.toString(head.x)+ ","+ Double.toString(head.y)+")");
    Node print = head.next;
    while(print != head){
      System.out.println("("+Double.toString(print.x)+ ","+ Double.toString(print.y)+")");
      print = print.next;
    }
  }

  /**
   * Returns the number of points in the list
   * @return size of the list
   */
  public int size(){
    return this.size;
  }

  /**
   * Checks if a point exists in the list
   * @param a X-coordinate to search for
   * @param b Y-coordinate to search for
   * @return true if point exists, false otherwise
   */

  public boolean contains(Double a, Double b){
    if (head == null){
      return false;
    }
    
    Node chk = head;
    if (chk.x.equals(a) && chk.y.equals(b)){
      return true;
    }
    
    chk = chk.next;
    while(chk != head){
      if (chk.x.equals(a) && chk.y.equals(b)){
        return true;
      }
      chk = chk.next;
    }
    return false;
  }

  /**
   * Removes a point from the list if it exists
   * @param a X-coordinate of point to remove
   * @param b Y-coordinate of point to remove
   */

  public void remove(Double a, Double b){
    Node chk = head;
    if (head == null){
      System.out.println("Empty list");
      return;
    }
    
    // Check if removing the head node
    if (chk.x.equals(a) && chk.y.equals(b)){
      // If only one node in the list
      if (size == 1) {
        head = null;
      } else {
        // Update head to next node and fix links
        head = chk.next;
        chk.prev.next = chk.next;
        chk.next.prev = chk.prev;
      }
      size--;
      return;
    }
    
    // Search for the node to remove
    chk = chk.next;
    while(chk != head){
      if (chk.x.equals(a) && chk.y.equals(b)){
        chk.prev.next = chk.next;
        chk.next.prev = chk.prev;
        size--;
        return;
      }
      chk = chk.next;
    }
    System.out.println(Double.toString(a) +" and "+ Double.toString(b)+" is not in list");
  }
}

class Main {
  public static void main(String[] a){
    BCLL test = new BCLL();
    test.append(5.4d,6.7d);
    test.append(2.0d,9.5d);
    test.append(54.4d,67.7d);
    test.append(23.0d,60.15d);
    test.append(52.4d,6.7d);
    test.append(21.0d,60.5d);
    test.display();
    System.out.println(test.size());
    System.out.println(test.contains(23.0,60.15));
    System.out.println(test.contains(23.9,6500.6));
    test.remove(23.0, 60.15);
    test.display();
    test.remove(500.0,50.6);

  }
}
