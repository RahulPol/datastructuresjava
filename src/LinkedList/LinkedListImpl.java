package LinkedList;

/**
 * This class depicts single Node of linked list.
 */
class Node {
    // data of Node
    int data;
    // pointer of next node for this node
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

}

/**
 * This interface depicts linked list adt
 */
interface LinkedListADT {
    /**
     * Inserts node in singly linked list at given position
     * 
     * @param n   Node to be inserted
     * @param pos Position at which node to be inserted
     * @return success or failure
     */
    boolean Insert(Node n, int pos);

    /**
     * Deletes node from singly linked list at givn position
     * 
     * @param pos position
     * @return success or failure
     */
    boolean Delete(int pos);

}

/**
 * This class depicts single linked list and ensures LinkedList ADT is
 * implemented
 */
class LinkedList implements LinkedListADT {
    // Root pointer of singly linked list
    Node root;

    // Instantiate empty linked list
    LinkedList() {
        this.root = null;
    }

    // Prints all nodes in linked list
    public void Print() {
        Node t = this.root;

        while (t != null) {
            System.out.print(t.data + " -> ");
            t = t.next;
        }
        System.out.println("Null");
    }

    /**
     * Get count of elements in linked list
     * 
     * @return
     */
    private int Count() {
        Node t = this.root;
        int count = 0;
        if (t == null) {
            return count;
        }

        while (t != null) {
            count++;
            t = t.next;
        }

        return count;
    }

    /**
     * Inserts a node in singly linked list at given position.
     * 
     * Steps 1: If LL is empty then the position must be 0. If yes then insert else
     * return failure
     * 
     * Step 2: If the position is 1 then handle insert at beginning
     * 
     * Step 3: Traverse at given position and insert node at that position
     */
    @Override
    public boolean Insert(Node n, int pos) {
        // This means linked listi is empty
        if (this.root == null) {
            // So, the position must be 0 else return failure.
            if (pos == 0) {
                this.root = n;
                return true;
            } else {
                return false;
            }
        }

        // Check if linked list has enough nodes to enter new node at given position.
        // this.Count() + 1 ensure we can insert at end of linked list
        if (this.Count() + 1 >= pos) {
            Node t = this.root;
            Node prev = this.root;
            int index = 1;

            // Insert at beginning
            if (pos == 1) {
                this.root = n;
                n.next = t;
                return true;
            }

            // loop through linked list untile the position is found or linked list empty.
            while (t != null && index != pos) {
                prev = t;
                t = t.next;
                index++;
            }

            // Insert at position
            prev.next = n;
            n.next = t;
            return true;
        }
        return false;

    }

    /**
     * 
     */
    @Override
    public boolean Delete(int pos) {
        return false;
    }

}

/**
 * This class depicts singly linked list implementation
 */
public class LinkedListImpl {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.Print(); // Null. Print empty linked list
        l1.Insert(new Node(10), 0); // 10 -> Null. Insert at root postion

        if (l1.Insert(new Node(234), 5)) {
            l1.Print(); // this statement will never execute
        }

        l1.Insert(new Node(30), 2); // 10 -> 30 -> Null.
        l1.Insert(new Node(40), 3); // 10 -> 30 -> 40 -> Null.
        l1.Insert(new Node(50), 4); // 10 -> 30 -> 40 -> 50 -> Null.
        l1.Insert(new Node(20), 2); // 10 -> 20 -> 30 -> 40 -> 50 -> Null.
        l1.Insert(new Node(1), 1); // 1 -> 10 -> 20 -> 30 -> 40 -> 50 -> Null.
        l1.Print();
    }
}