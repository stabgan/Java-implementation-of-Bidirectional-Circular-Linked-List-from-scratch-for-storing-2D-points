class BCLL {

  public class Node {
    Double x;
    Double y;
    Node next = null;
    Node prev = null;

    Node(Double a,Double b) {
      this.x = a;
      this.y = b;
      this.next = this;
      this.prev = this;
    }
  }
  public int size = 0;
  Node head;

  public void append(Double x, Double y){
    if(head == null) {
      head = new Node(x,y);
      size += 1;
    }
    else {
      Node last = head.prev;
      Node temp = new Node(x,y);
      last.next = temp;
      temp.next = head;
      head.prev = temp;
      temp.prev = last;
      size += 1;
    }
  }

  public void display() {
    if (head == null){
      System.out.println("Empty list");
    }
    else {
      System.out.println("("+Double.toString(head.x)+ ","+ Double.toString(head.y)+")");
      if (head.next != null){
        Node print = head.next;
        while(print != head){
          System.out.println("("+Double.toString(print.x)+ ","+ Double.toString(print.y)+")");
          print = print.next;
        }
      }
    }
  }

  public int size(){
    return this.size;
  }

  public boolean contains(Double a, Double b){
    Node chk = head;
    if (head == null){
      System.out.println("Empty list");
      return false;
    }
    else {
      if (chk.x.equals(a) && chk.y.equals(b)){
        return true;
      }
      else {
        chk = chk.next;
        while(chk != head){
          if (chk.x.equals(a) && chk.y.equals(b)){
              return true;
            }
          chk = chk.next;
          }
        return false;
        }
      }
    }

  public void remove(Double a, Double b){
    Node chk = head;
    if (head == null){
      System.out.println("Empty list");
    }
    else {
      if (chk.x.equals(a) && chk.y.equals(b)){
        chk.prev.next = chk.next;
        chk.next.prev = chk.prev;
        return;
      }
      else {
        chk = chk.next;
        while(chk != head){
          if (chk.x.equals(a) && chk.y.equals(b)){
              chk.prev.next = chk.next;
              chk.next.prev = chk.prev;
              return;
            }
          chk = chk.next;
          }
        System.out.println(Double.toString(a) +" and "+ Double.toString(b)+" is not in list");
        }
      }
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
