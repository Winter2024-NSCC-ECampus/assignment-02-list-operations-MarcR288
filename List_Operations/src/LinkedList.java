public class LinkedList {

    static class Node {
        int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    Node head;

    public LinkedList() {
        head = null;
    }

    //merge Sort function to sort the linked list
    public void mergeSort() {
        head = mergeSortRec(head);
    }

    //helper function for Merge Sort (recursive)
    private Node mergeSortRec(Node node) {
        if (node == null || node.next == null) {
            return node; // Base case: if the list is empty or has only one node
        }

        //split the list into two halves
        Node middle = getMiddle(node);
        Node nextOfMiddle = middle.next;
        middle.next = null; // Split the list into two halves

        //recursively sort each half
        Node left = mergeSortRec(node);
        Node right = mergeSortRec(nextOfMiddle);

        //merge the sorted halves
        return merge(left, right);
    }




    //function to find the middle of the list (slow and fast pointer technique)
    private Node getMiddle(Node node) {
        if (node == null) {
            return null;
        }

        Node slow = node;
        Node fast = node;

        //move fast pointer two steps and slow pointer one step
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    //A)Insertion at the beginning
    public void insertAtBeginning(int value) {
        mergeSort();
        //create a newNode
        Node newNode = new Node(value);
        //newNode.next is set to the current head
        newNode.next = head;
        //head is updated to point to the newNode
        head = newNode;
    }

    //A)Insertion at the end
    public void insertAtEnd(int value) {
        mergeSort();
        //create a newNode
        Node newNode = new Node(value);
        //Check if list is empty
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next; //move to the last node
        }
        //Set the last node's next to the new node and insert newNoden after the last node
        current.next = newNode;
    }

    //A) Insert a node at a given index
    public void insertAtIndex(int index, int value) {
        mergeSort();
        //if list is empty, insert at beginning
        if (head == null) {
            insertAtBeginning(value);
            return;
        }
        Node current = head;
        int currentIndex = 0;
        while (currentIndex < index - 1 && current != null) {
            current = current.next;
            currentIndex++;
        }
        //If the index is out of bounds
        if (current == null) {
            System.out.println("Index out of bounds");
            return;
        }

        Node newNode = new Node(value);
        //newNode now points to node at the index
        newNode.next = current.next;
        //previous node now points to newNode
        current.next = newNode;
    }

    //B)Deletion of the first node.
    public void deleteFirst() {
        mergeSort();
        //if the list is already empty
        if (head == null) {
            System.out.println("List is already empty");
            return;
        }
        //head now points to the next node
        head = head.next;
    }

    //B)Deletion of the last node.
    public void deleteLast() {
        mergeSort();
        if (head == null) {
            System.out.println("List is already empty.");
            return;
        }
        //just one node in the list
        if (head.next == null) {
            head = null;
            return;
        }
        Node secondLast = head;
        while (secondLast.next != null && secondLast.next.next != null) {
            secondLast = secondLast.next;
        }
        secondLast.next = null; // Remove last node
    }

    //B)Deletion of given item index from sorted list
    public void deleteAtIndex(int index) {
        mergeSort();
        if (head == null) {
            System.out.println("List is already empty");
            return;
        }

        Node current = head;
        int currentIndex = 0;
        //traverse the list until the node to be deleted is found
        while (current != null && currentIndex < index - 1) {
            current = current.next;
            currentIndex++;
        }

        //if the index is out of bounds
        if (current == null || current.next == null) {
            System.out.println("Index out of bounds.");
            return;
        }

        //remove the node by bypassing it
        //(in java it will eventually be garbage collected if no references to it exist)
        current.next = current.next.next;
    }

    // C) Splitting the list into 2 sublists and returning them as LinkedList objects
    public LinkedList[] twoSublistSplit() {
        mergeSort();
        //array to hold the two sublists
        LinkedList[] output = new LinkedList[2];
        output[0] = new LinkedList(); // front list
        output[1] = new LinkedList(); // back list

        if (head == null || head.next == null) {
            System.out.println("List is empty or only has one element");
            return output;
        }

        //find the middle of the list using the slow and fast pointer technique (Tortoise and Hare)
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split the list into two halves
        Node secondHalf = slow.next; // The second half starts from the node after slow
        slow.next = null; // End the first half

        // Fill the output[0] (front) with the first half
        output[0].head = head;

        // Fill the output[1] (back) with the second half
        output[1].head = secondHalf;

        return output;
    }



    //D)Method to merge two sorted linked lists A and B
    public LinkedList mergeLists(LinkedList listA, LinkedList listB) {
        // Sort both lists using merge sort
        listA.mergeSort();
        listB.mergeSort();

        LinkedList mergedList = new LinkedList();
        //placeholder node to simply merging
        Node placeHolder = new Node(0);
        //initialize current pointer to point to the placeholder
        Node current = placeHolder;

        Node a = listA.head;
        Node b = listB.head;

        // Merge two sorted lists
        while (a != null && b != null) {
            if (a.value <= b.value) {
                current.next = a;
                a = a.next;
            } else {
                current.next = b;
                b = b.next;
            }
            current = current.next;
        }

        //if there are remaining nodes in list A or B, attach them
        if (a != null) {
            current.next = a;
        } else {
            current.next = b;
        }

        //set the head of the mergedlist to the fist node of the mergedlist
        mergedList.head = placeHolder.next; // Set the merged list's head
        return mergedList;
    }

    //D)function to merge two sorted linked lists
    private Node merge(Node left, Node right) {
        //create a dummy node to build the merged list
        Node dummyNode = new Node(0);
        Node current = dummyNode;

        //merge the two sorted lists
        while (left != null && right != null) {
            if (left.value <= right.value) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        //attach the remaining nodes if any
        if (left != null) {
            current.next = left;
        } else {
            current.next = right;
        }

        return dummyNode.next; // Return the sorted list
    }

    //method to print the list from any given node
    private void printListFromNode(Node node) {
        Node current = node;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("Null");
    }


    //method to print the linked list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " --> ");
            current = current.next;
        }
        System.out.println("Null");
    }
}
